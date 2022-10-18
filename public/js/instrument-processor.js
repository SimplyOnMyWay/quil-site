/**
 * @fileoverview audioworklet processor which makes sounds for my AB project "juxt" based on physical modelling of my early Gaelic harp
 * @author micheal@michealocathain.com (Mícheál Ó Catháin)
 */
goog.provide('sounds');

// filter class
/**
 * General IIR filter, also suitable for biquad
 * @param {Array.<Object>} bCoeffArray feedforward coeffs
 * @param {Array.<Object>} aCoeffArray feedback coeffs
 * @constructor
  */
sounds.Filter = function(bCoeffArray,aCoeffArray) {
    this.gain_ = 1.0;
    this.b_ = bCoeffArray;
    this.a_ = aCoeffArray;
    this.inputs_ = new Array(this.b_.length).fill(0);
    this.outputs_ = new Array(this.a_.length).fill(0);
  };
/**
 * return most recent sample from the filter
 * @return {number}
 */
sounds.Filter.prototype.lastOut = function(){
  return this.outputs_[0];
};
/** 
 * Compute the filter state and outputs for a given input
 * @param {number} input
 * @return {number}
 */
sounds.Filter.prototype.computeSample = function(input) {
  this.outputs_[0] = 0.0;
  this.inputs_[0] = this.gain_ * input;

  for (let i = this.b_.length - 1; i > 0; i--){
    this.outputs_[0] += this.b_[i] * this.inputs_[i];
    this.inputs_[i] = this.inputs_[i-1];
  }
  this.outputs_[0] += this.b_[0] * this.inputs_[0];

  for (let i = this.a_.length - 1; i > 0; i--){
    this.outputs_[0] += (-1)*this.a_[i] * this.outputs_[i];
    this.outputs_[i] = this.outputs_[i-1];
  }
  return this.outputs_[0];
}

// Interpolated delay line class
/**
 * Create instance of an interpolated delay line
 * for use in digital wave guides and reverbs
 * @param {number} delay delay in samples (not necc. an integer)
 * @param {number} maxDelay ideally a pow of 2 e.g., 4096
 * @constructor
 */
sounds.DelayA = function(delay, maxDelay) {
    this.inputs_ = new Array(maxDelay+1).fill(0);
    this.outputs_ = [0.0];
    this.inPoint_ = 0;
    this.setDelay(delay);
    this.apInput_ = 0.0;
    this.alpha_ = 0.0; //not sure it should be initialised!
    this.nextOutput_ = 0.0 //again not sure about this initialise!
    this.doNextOut_ = true;
  };
/**
 * set the delay, doing the interpolating magic!
 * @param {number} delay
 */
sounds.DelayA.prototype.setDelay = function(delay) {
    let outPointer;
    let length = this.inputs_.length;
    outPointer = this.inPoint_ - delay + 1.0;
    this.delay_ = delay;
    if (outPointer < 0) outPointer += length;
    this.outPoint_ = Math.round(outPointer);
    if (this.outPoint_ == length) this.outPoint_ = 0;
    this.alpha_ = 1.0 + this.outPoint_ - outPointer;
    if (this.alpha_ < 0.5){
      this.outPoint_ += 1;
      if (this.outPoint_ >= length) this.outPoint_ -= length;
      this.alpha_ += 1.0;
    }
    this.coeff_ = (1.0 - this.alpha_) / (1.0 + this.alpha_);
  }
/**
 * determine the next output of the delay line
 * @return {number}
 */
sounds.DelayA.prototype.nextOut = function() {
  if (this.doNextOut_){
    this.nextOutput_ = -this.coeff_ * this.outputs_[0];
    this.nextOutput_ += this.apInput_ + (this.coeff_ * this.inputs_[this.outPoint_]);
    this.doNextOut_ = false;
  }
  return this.nextOutput_;
}

/**
 * flick out the last output of the delay line
 * @return {number}
 */
sounds.DelayA.prototype.lastOut = function() {
  return this.outputs_[0];
};
/**
 * compute the state and output of the delay for the given input
 * @param {number} input
 * @return {number}
 */
sounds.DelayA.prototype.computeSample = function(input) {
  this.inputs_[this.inPoint_++] = input;
  if (this.inPoint_ == this.inputs_.length) this.inPoint_ = 0;
  this.outputs_[0] = this.nextOut();
  this.doNextOut_ = true;
  this.apInput_ = this.inputs_[this.outPoint_++];
  if (this.outPoint_ == this.inputs_.length) this.outPoint_ = 0;
  return this.outputs_[0];
}
  

/**
   Audio thread 
**/


/**
 * Main constructor for audio worklet
 * @constructor
 * @extends {AudioWorkletProcessor}
 */
sounds.InstrumentProcessor = class extends AudioWorkletProcessor {

  static get parameterDescriptors() {return []; }

  constructor(options) {
    super();


    // analysis stuff...
    this.analysisCounter = 0;
    this.analysisCounterTrigger = Math.floor(sampleRate / 6000); // changed 60 to 6000
    this.envelopeFollowerCoeff = Math.exp(Math.log(0.01)/(100 * sampleRate * 0.001)); // 10ms  //changed 10 to 100
    this.envelopes = [];
    
    // synthesis stuff...
    this.excitationReadIndices = [];
    const f0s = options.processorOptions["f0s_"];
    // RNG from hash !!!
    // this.R = options.processorOptions["RNG"];  get this working :)
    this.loopFilter = [];
    this.maxDelay = 1024;

    /** @const */
    this.DL = [];

    f0s.forEach(f0 => { this.createString(f0); });

    /** @const */
    this.bodyMode1 = new sounds.Filter([1,-1.9583,0.95958],[1,-1.9983,0.99915]);
    /** @const */
    this.bodyMode2 = new sounds.Filter([1,-1.7944,0.8077],[1,-1.9937,0.99715]);
    /** @const */
    this.bodyMode3 = new sounds.Filter([1,-1.9537,0.95903],[1,-1.9936,0.99858]);
    /** @const */
    this.noiseBurstFR = new sounds.Filter([2.6493,-0.34918,-1.3627,1.2731,-1.8866,0.40363,-0.28791,-0.48267,0.13639,-0.64097,0.53584],[1,-0.64514,0.49419,-0.13298,0.054118,-0.15693,0.15583,-0.18782,0.34938,-0.30862,0.29745]);

    let sustain = 9; // sustain duration in s;
    /** @const */
    this.dirac = new Array(sustain*sampleRate).fill(0); // 5 second dirac signal
    this.dirac[0] = 1.0;



    let excitationLength = sustain*sampleRate;
    let a = 50; //attack time in ms
    let d = 25; //decay time in ms
    let ia = Math.round(sampleRate*a/1000);
    let id = Math.round(sampleRate*d/1000);
    let aSlope = 1/ia;
    let dSlope = -1/id;
    let noiseBurstGain = 0.1;

    /** @const */
    this.envelope = new Array(excitationLength).fill(0);
    for (let i=0; i< ia - 1; i++){
      this.envelope[i] = aSlope * i;
    };
    for (let i = ia; i < (ia+id) - 1; i++){
      this.envelope[i] = dSlope * i;
    };

    /** @const */
    this.noise = new Array(excitationLength).fill(0);
    for (let i = 0; i < this.noise.length; i++){
      this.noise[i] = (Math.random() - 0.49999)*1.5;
    };

    //    this.noiseBurst = new Array(excitationLength);
    /** @const */
    this.excitation = new Array(excitationLength);
    for (let  i= 0; i < this.excitation.length; i++){
      let noiseBurst_ = noiseBurstGain * this.noise[i] * this.envelope[i];
      this.excitation[i] = this.bodyMode3.computeSample(this.bodyMode2.computeSample(this.bodyMode1.computeSample(this.noiseBurstFR.computeSample(noiseBurst_))));
    };

    // bidirectional comms with main global scope
    this.port.onmessage = this.handleMessage.bind(this);

  }
};


/**
 * generate a string instance! (just the delay line bit, body/excitation bits are added later)
 * @param {number} f0 fundamental freq for string
 */
sounds.InstrumentProcessor.prototype.createString = function(f0){
  let tuningFactor = 1;
  let N = sampleRate/f0 - tuningFactor;
  let B = [0.99002,0.53323,-0.059946,0.47646,0.6579,0.41096,0.10609,0.25464,0.1224,0.1032,0.23355,0.1154,0.027333,0.24254,0.11144,0.13616,0.29518,0.22837,0.20541,0.1811,0.23351,0.25601,0.18682,0.1572,0.12634,0.1038,0.10661,0.083271,0.077115,0.020829,0.01552];
  let A = [1,0.52874,-0.064736,0.48365,0.65922,0.40633,0.10369,0.25905,0.11832,0.10181,0.23729,0.11339,0.026769,0.24361,0.11236,0.13613,0.29448,0.22862,0.20701,0.17915,0.23339,0.2578,0.18605,0.15629,0.1266,0.10381,0.10485,0.084,0.0772,0.019029,0.016185]
  this.DL.push(new sounds.DelayA(N,this.maxDelay));
  this.loopFilter.push(new sounds.Filter(B,A));
  this.excitationReadIndices.push(this.maxDelay); // play with value of this.maxDelay....

  // envelope follower value
  this.envelopes.push(0);

  // string parameters for monitoring during dev
  let stringParams = {
    "orderFIR": B.length,
    "orderIIR": A.length
  }
  console.log("string parameters... ", stringParams);
}

sounds.InstrumentProcessor.prototype.handleMessage = function(event){
  if (event.data["type"] === "play"){
    this.excitationReadIndices[event.data["stringnum"]] = 0;
  }
}


/**
 * main process function called on my main thread every 128 audio samples
 * @param {Array.<Array<Float32Array>>} inputs
 * @param {Array.<Array<Float32Array>>} outputs
 * @param {Object.<string, Float32Array>} parameters type definition advised by google compiler!
 * @return {boolean} returns true to ensure process remains called by main script
 */
sounds.InstrumentProcessor.prototype.process = function(inputs, outputs, parameters) {
  const output = outputs[0];
  const outputChannel = output[0];
  outputChannel.fill(0.0);
  const loopGain = 0.99999;
  let gainHack = [1,1,0.5,0.5,0.5,1,1.5].map((val) => val * 0.2);

  for (let s = 0; s < this.DL.length; s++){
    for (let i = 0; i < outputChannel.length; i++) {

      const delayLineLength = this.maxDelay; //workaround, preferred is N, may create issues ;)
      const currentExcitation = this.excitationReadIndices[s] < delayLineLength
      ? this.excitation[this.excitationReadIndices[s]]
      : 0;

      //outputChannel[i] += this.DL[s].computeSample(this.loopFilter[s].computeSample(loopGain*this.DL[s].lastOut() + currentExcitation));
      const sum = this.DL[s].computeSample(this.loopFilter[s].computeSample(loopGain*this.DL[s].lastOut() + currentExcitation));

      const absSum = Math.abs(sum)*gainHack[s];
      this.envelopes[s] = this.envelopeFollowerCoeff * (this.envelopes[s] - absSum) + absSum;

      outputChannel[i] += sum * gainHack[s];

      this.excitationReadIndices[s]++;

    }
  }

  this.analysisCounter += outputChannel.length;

  if (this.analysisCounter >= this.analysisCounterTrigger){
    this.analysisCounter = this.analysisCounter % this.analysisCounterTrigger;

    for (let s = 0; s < this.envelopes.length; s++){
      const delayLineLength = this.maxDelay;
      const amplitude = this.envelopes[s];
      const vibration = (((this.excitationReadIndices[s] / 3) % delayLineLength) / delayLineLength);
      this.port.postMessage({
        "msg": "analysis",
        "amplitude": amplitude,
        "vibration": vibration,
        "stringno": s
      });
    }
  };

  return true;
}

/**
 *
 */
registerProcessor('instrument-processor', sounds.InstrumentProcessor);
