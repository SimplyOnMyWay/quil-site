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


// Delay line class
/**
 * Create instance of a delay line
 * for use in digital wave guides and reverbs
 * @param {number} delay delay in samples (not necc. an integer)
 * @param {number} maxDelay ideally a pow of 2 e.g., 4096
 * @constructor
 */
sounds.Delay = function(delay, maxDelay) {
    this.inputs_ = new Array(maxDelay+1).fill(0);
    this.outputs_ = [0.0];
    this.inPoint_ = 0;
    this.setDelay(delay);
  //    this.outPoint_ = 0;
  //    this.delay_ = 0;
  //    this.apInput_ = 0.0;
  //    this.alpha_ = 0.0; //not sure it should be initialised!
  // this.nextOutput_ = 0.0 //again not sure about this initialise!
  // this.doNextOut_ = true;
  };
/**
 * set the delay
 * @param {number} delay
 */
sounds.Delay.prototype.setDelay = function(delay) {
  if ( delay > this.inputs_.length - 1 ){
    console.log("Delay.setDelay: argument ", delay, "too big ... setting to maximum!... ", this.inputs_.length);
    this.outPoint_ = this.inPoint_ + 1;
    if ( this.outPoint_ == this.inputs_.length )
      this.outPoint_ = 0;
    this.delay_ = this.inputs_.length - 1;
  }
  else if ( delay < 0 ){
    console.log("whutttt?!");
    this.outPoint_ = this.inPoint_;
    this.delay_ = 0;
  }
  else {
    if ( this.inPoint_ >= delay )
      this.outPoint_ = this.inPoint_ - delay;
    else
      this.outPoint_ = this.inPoint_ + this.inputs_.length - delay;
    this.delay_ = delay;
  }
};
/**
 * compute the state and output of the delay for the given input
 * @param {number} input
 * @return {number}
 */
sounds.Delay.prototype.computeSample = function(input) {
  this.inputs_[this.inPoint_++] = input;
  if (this.inPoint_ == this.inputs_.length)
    this.inPoint_ = 0;
  this.outputs_[0] = this.inputs_[this.outPoint_++];
  if (this.outPoint_ == this.inputs_.length)
    this.outPoint_ = 0;
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

// Rev class
/**
 * Two-multiply lattice ladder filter
 * @param {number} M delay length
 * @param {number} g gain
 * @constructor
  */
sounds.Rev = function(M,g) {
  this.gain_ = g;
  this.delay_ = M - 1;
  this.delayLine = new sounds.Delay(this.delay_, this.delay_);
  this.inputs_ = [0,0];  //initialise elements of inputs_ array to zero
  this.outputs_ = [0,0]; //initialise elements of outputs_ array to zero
  };
/** 
 * Compute the lattice ladder allpass filter state and outputs for a given input (sample)
 * @param {number} sample
 * @return {number}
 */
sounds.Rev.prototype.computeSample = function(sample) {
  this.inputs_[0] = sample;
  this.inputs_[1] = this.inputs_[0] - this.gain_*this.outputs_[1];
  this.outputs_[0] = this.gain_*this.inputs_[1] + this.outputs_[1];
  this.outputs_[1] = this.delayLine.computeSample(this.inputs_[1]);
  return this.outputs_[0];
}


// JCRev class
/**
 * Implementation of John Chownings Schroeder reverberator
 * @constructor
  */
sounds.JCRev = function() {
  this.allpassM_ = [1051,337,113];
  this.combM_ = [4799, 4999, 5399, 5801];
  this.allpassGain_ = 0.7;
  this.leftM = 0.046*sampleRate;
  this.rightM = 0.057*sampleRate;
  this.allpass = [];
  this.combDelayLine = [];
  for(let i=0;i<3;i++){
    this.allpass.push(new sounds.Rev(this.allpassM_[i], this.allpassGain_));
  }
  for(let i=0;i<4;i++){
    this.combDelayLine.push(new sounds.Delay(this.combM_[i], this.combM_[i]));
  }
  this.outLeftDelay = new sounds.Delay(this.leftM,this.leftM);
  this.outRightDelay = new sounds.Delay(this.rightM,this.rightM);
  this.outputs_ = [0]; // output after applying mixing filters (output delays)

};

/** 
 * Compute the JCRev state and outputs for a given input (sample)
 * @param {number} sample
 * @return {number}
 */
sounds.JCRev.prototype.computeSample = function(sample) {

  let x1,x2,x3,x4,y1;
  
  // AP section
  x1 = sample;
  x2 = this.allpass[0].computeSample(x1);
  x3 = this.allpass[1].computeSample(x2);
  x4 = this.allpass[2].computeSample(x3);
  // FFCF section

  y1 =  0.742*x4 + this.combDelayLine[0].computeSample(x4)
    + 0.733*x4 + this.combDelayLine[1].computeSample(x4)
    + 0.715*x4 + this.combDelayLine[2].computeSample(x4)
    + 0.697*x4 + this.combDelayLine[3].computeSample(x4);
  
  this.outputs_[0] = this.outLeftDelay.computeSample(y1);
  this.outputs_[1] = this.outRightDelay.computeSample(y1);

  return (this.outputs_[0] + this.outputs_[1]) * 0.5;
}

// Freeverb class
/**
 * Implementation of Freeverb by Jezar at Dreampoint
 * @constructor
  */
sounds.Freeverb = function() {
  this.allpasstuningL = [556,441,341,225].map(this.adaptSR);
  this.combtuningL = [1116,1118,1277,1356,1422,1491,1557,1617].map(this.adaptSR);
}
sounds.Freeverb.prototype.adaptSR = function(val) {
  let origSR = 44100;
  return Math.round(val*sampleRate/origSR);
  }
sounds.Freeverb.prototype.computeSample = function(sample) {
  }

// Helper functions for envelopes
sounds.tau2pole = function(tau){
  return Math.exp(-1.0 / (tau * sampleRate ));
}
let fRec0 = [0,0]; //state variable updated in smooth function
sounds.smooth = function(s,x){
  let y = []; //output variable 
  for (let  i= 0; i < x.length; i++){
    fRec0[0] = (1 - s)*x[i] + s*fRec0[1];
    y[i] = fRec0[0];
    fRec0[1] = fRec0[0]
  }
  return y;
}


// ASRFE envelope class
/**
 * Implementation of Faust ASRFE envelope, parent of ARFE & ARE envelopes
 * @constructor
  */
sounds.ASRFE = function(attT60,susLvl,relT60,finLvl) {
  this.attT60_ = attT60;
  this.susLvl_ = susLvl;
  this.relT60_ = relT60;
  this.finLvl_ = finLvl;

}
sounds.ASRFE.prototype.computeSample = function(gate) {
  this.ugate = (gate == 0);
  if (this.ugate == true){
    this.target = this.finLvl_;
    this.t60 = this.relT60_;
  }
  else {
    this.target = this.susLvl_;
    this.t60 = this.attT60_;
  }
  this.pole = sounds.tau2pole(this.t60/6.91);
  return sounds.smooth(this.pole,this.target);
}



/**
   Audio thread 
**/


/**
 * Main constructor for audio worklet
 * @constructor
 * @extends {AudioWorkletProcessor}
//    * @type {?sounds.InstrumentProcessor}   
 */
sounds.InstrumentProcessor = class extends AudioWorkletProcessor {

  static get parameterDescriptors() {return []; }

  constructor(options) {
    super();

    // ~~~~~~~~~~~~~
    // REFACTOR MOVED TO TOP OF CONSTRUCTOR
    // IMPORTANT!!!
    // bidirectional comms with main global scope
    this.port.onmessage = this.handleMessage.bind(this);
    // ~~~~~~~~~~~~~
    
    // analysis stuff...
    this.analysisCounter = 0;
    this.analysisCounterTrigger = Math.floor(sampleRate / 6000); // changed 60 to 6000
    this.envelopeFollowerCoeff = Math.exp(Math.log(0.01)/(100 * sampleRate * 0.001)); // 10ms  //changed 10 to 100
    this.envelopes = [];

    // synthesis stuff...


    // ~~~~~~~~
    // REFACTOR
    // ~~~~~~~~

    // set up instrument parameters which are subject randomness, may be static for the full composition, or change dynamically. Governed by the main script via MessagePort
    this.noise = [];
    this.AREenv = []; // Exponential attack release envelope, array holding such an AREenv for each string
    this.excitation = [];
    this.adsr = [];
    this.adsrGain = [];    
    
    // set up instrument parameters which are static for the full composition,
    // via options
    // consider if this can be sent via messagePort should freq of string change - e.g. for vibrato etc!
    // seems like a whole new string not necessary, moreso dynamic change of length... though probably retaining original as a baseline to deviate from... TO EXPLORE LATER!
    const f0s = options.processorOptions["f0s_"];    

    // other declarations
    this.excitationReadIndices = [];
    this.loopFilter = [];
    this.maxDelay = 1024;

    // ~~~~~~~~

    
    this.JCRevBank = [];

    /** @const */
    this.DL = [];

    

    // ####################
    // STRING INSTANTIATION
    // create string for each of the frequencies passed fro main script
    f0s.forEach(f0 => { this.createString(f0); });


    // ####################
    // BODY INSTANTIATION
    
    /** @const */
    this.bodyMode1 = new sounds.Filter([1,-1.9583,0.95958],[1,-1.9983,0.99915]);
    /** @const */
    this.bodyMode2 = new sounds.Filter([1,-1.7944,0.8077],[1,-1.9937,0.99715]);
    /** @const */
    this.bodyMode3 = new sounds.Filter([1,-1.9537,0.95903],[1,-1.9936,0.99858]);


    // ####################    
    // PLUCK INSTANTIATION

    // instantiate pluck here starting with time-series response shaped by ADSR, from Octave analysis of my actual pluck of my McLIag!
    // --INSERT--
    
    // Freq Response of Pluck - from Octave analysis of my actual pluck of my McLiag!
    /** @const */
    this.noiseBurstFR = new sounds.Filter([2.6493,-0.34918,-1.3627,1.2731,-1.8866,0.40363,-0.28791,-0.48267,0.13639,-0.64097,0.53584],[1,-0.64514,0.49419,-0.13298,0.054118,-0.15693,0.15583,-0.18782,0.34938,-0.30862,0.29745]);

    // let sustain = 9; // sustain duration in s;
    // /** @const */
    // this.dirac = new Array(sustain*sampleRate).fill(0); // 5 second dirac signal
    // this.dirac[0] = 1.0;



    // let excitationLength = sustain*sampleRate;
    // let a = 50; //attack time in ms
    // let d = 25; //decay time in ms
    // let ia = Math.round(sampleRate*a/1000);
    // let id = Math.round(sampleRate*d/1000);
    // let aSlope = 1/ia;
    // let dSlope = -1/id;
    // let noiseBurstGain = 0.1;

    // /** @const */
    // this.envelope = new Array(excitationLength).fill(0);
    // for (let i=0; i< ia - 1; i++){
    //   this.envelope[i] = aSlope * i;
    // };
    // for (let i = ia; i < (ia+id) - 1; i++){
    //   this.envelope[i] = dSlope * i;
    // };

    // /** @const */
    // this.noise = new Array(excitationLength).fill(0);
    // for (let i = 0; i < this.noise.length; i++){
    //   this.noise[i] = (Math.random() - 0.49999)*1.5;
    // };

    // //    this.noiseBurst = new Array(excitationLength);
    // /** @const */
    // this.excitation = new Array(excitationLength);
    // for (let  i= 0; i < this.excitation.length; i++){
    //   let noiseBurst_ = noiseBurstGain * this.noise[i] * this.envelope[i];
    //   this.excitation[i] = this.bodyMode3.computeSample(this.bodyMode2.computeSample(this.bodyMode1.computeSample(this.noiseBurstFR.computeSample(noiseBurst_))));
    // };



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
  this.JCRevBank.push(new sounds.JCRev); //Schroeder reverb for each string!

  // envelope follower value
  this.envelopes.push(0);

  // string parameters for monitoring during dev
  let stringParams = {
    "orderFIR": B.length,
    "orderIIR": A.length
  }

  //  console.log("string parameters... ", stringParams);


  // ~~~~~~~~
  // REFACTOR
  // ~~~~~~~~

  // create array placeholders
  this.AREenv.push([]);
  this.excitation.push([]);

  
}


/**
 * generate body/excitation -
 // ~~~~~~~~~~
 // REFACTOR TO DO: separate out envelope fn (potentially different envelopes per Faust envelope library!
 // ~~~~~~~~~~
 * @param {number} s string number
 */
sounds.InstrumentProcessor.prototype.generateExcitation = function(s){
  let a = this.adsr[s][0]//50; //attack time in ms
  let d = this.adsr[s][1];//25; //decay time in ms
  let ia = Math.round(sampleRate*a/1000);
  let id = Math.round(sampleRate*d/1000);
  let aSlope = 1/ia;
  let dSlope = -1/id;
  let excitationLength = ia+id;

  //this.envelope[s] = [];
  // for (let i=0; i < ia; i++){
  //   this.AREenv[s][i] = aSlope * i;
  // };
  // for (let i = 0; i < id; i++){
  //   this.AREenv[s][ia + i] = 1 + dSlope * i;
  // };
  this.AREenv[s] = new sounds.ASRFE(0.005,1.0,0.17,0.0);
  let gate = [];
//  this.excitation[s] = [];
  for (let  i= 0; i < excitationLength; i++){
    if (i < 0.005*sampleRate)
      gate[i] = 1.0;
    else
      gate[i] = 0.0;
    const noiseBurst_ = this.adsrGain[s] * this.noise[s][i] * this.AREenv[s].computeSample(gate[i]);
    this.excitation[s][i] = this.bodyMode3.computeSample(this.bodyMode2.computeSample(this.bodyMode1.computeSample(this.noiseBurstFR.computeSample(noiseBurst_))));
  };
}

sounds.InstrumentProcessor.prototype.handleMessage = function(event){
  if (event.data["type"] === "play"){
    this.excitationReadIndices[event.data["stringnum"]] = 0;
    this.noise[event.data["stringnum"]] = event.data["noise"];
    this.adsr[event.data["stringnum"]] = event.data["adsr"];
    this.adsrGain[event.data["stringnum"]] = event.data["adsrGain"];
    this.generateExcitation(event.data["stringnum"]); // only needed once I'd have thought, unless I change the excitation, which is a great idea! but ensure computational load is OK!
//    this.excitationReadIndices[event.data["stringnum"]] = 0; CORRECT TO COMMENT OUT, OR IS FIRST ONE REDUNDANT?
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
  const loopGain = 0.999999;//0.99999;
  let gainHack = [1,1,0.5,0.5,0.5,1,1.5].map((val) => val * 0.2);


  
  for (let s = 0; s < this.DL.length; s++){
    for (let i = 0; i < outputChannel.length; i++) {

      const delayLineLength = this.maxDelay; //workaround, preferred is N, may create issues ;)
      const currentExcitation = this.excitationReadIndices[s] < delayLineLength
      //      ? this.dirac[this.excitationReadIndices[s]]
            ? this.excitation[s][this.excitationReadIndices[s]]
            : 0;

      //outputChannel[i] += this.DL[s].computeSample(this.loopFilter[s].computeSample(loopGain*this.DL[s].lastOut() + currentExcitation));

//      const sum = this.JCRevBank[s].computeSample(this.DL[s].computeSample(this.loopFilter[s].computeSample(loopGain*this.DL[s].lastOut() + currentExcitation)));

      const sum = this.DL[s].computeSample(this.loopFilter[s].computeSample(loopGain*this.DL[s].lastOut() + currentExcitation));




      // dirac test
      //  const sum = this.JCRevBank[s].computeSample(currentExcitation);

      //don't think gainHacks are needed??
       const absSum = Math.abs(sum);
//      const absSum = Math.abs(sum);//*gainHack[s];

      this.envelopes[s] = this.envelopeFollowerCoeff * (this.envelopes[s] - absSum) + absSum;

      outputChannel[i] += sum; //* gainHack[s];



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
