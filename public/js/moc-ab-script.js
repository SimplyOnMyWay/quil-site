goog.provide('sketch');

// ##################
// PRNG class and methods...

// random class based on sfc32 from AB 101
/**
 * Creates a new sfc32 function seeded by hash string
 * @param {string} uint128Hex
 * @constructor
 */
sketch.sfc32 = function (uint128Hex) {
      this.a = parseInt(uint128Hex.substr(0, 8), 16);
      this.b = parseInt(uint128Hex.substr(8, 8), 16);
      this.c = parseInt(uint128Hex.substr(16, 8), 16);
      this.d = parseInt(uint128Hex.substr(24, 8), 16);
    };

/**
 * Instance method to do the work of sfc32.
 * NOTE TO SELF! It may be better to implement this as a static method within the constructor
 * @return {number}
 */
sketch.sfc32.prototype.gett = function() {
  this.a |= 0; this.b |= 0; this.c |= 0; this.d |= 0;
  let t = (((this.a + this.b) | 0) + this.d) | 0;
  this.d = (this.d + 1) | 0;
  this.a = this.b ^ (this.b >>> 9);
  this.b = (this.c + (this.c << 3)) | 0;
  this.c = (this.c << 21) | (this.c >>> 11);
  this.c = (this.c + t) | 0;
  return (t >>> 0) / 4294967296;
};


let y2 = 0;
/**
 * Constructor function for random class
 * @constructor 
 */
sketch.random = function() {
   {
     /**
      * @type {boolean}
      * @private
      */
     this.useA = false;

     // seed prngA with first half of tokenData.hash
     /**
      * @type {Object}
      * @private
      */
     this.prngA = new sketch.sfc32(tokenData.hash.substr(2, 32));

     // seed prngB with second half of tokenData.hash
     /**
      * @type {Object}
      * @private
      */
     this.prngB = new sketch.sfc32(tokenData.hash.substr(34, 32));

     for (let i = 0; i < 1e6; i += 2) {
       this.prngA.gett();
       this.prngB.gett();
     }

     // set flag for gaussian method
     this._gaussian_previous = false;
  }
}

// random number between 0 (inclusive) and 1 (exclusive)
sketch.random.prototype.random_dec = function() {
  this.useA = !this.useA;
  return this.useA ? this.prngA.gett() : this.prngB.gett();
}
// random number between a (inclusive) and b (exclusive)
/** @return {number} */
sketch.random.prototype.random_num = function(a, b) {
  return a + (b - a) * this.random_dec();
}
// random integer between a (inclusive) and b (inclusive)
// requires a < b for proper probability distribution
/** @return {number} */
sketch.random.prototype.random_int = function(a, b) {
  return Math.floor(this.random_num(a, b + 1));
}

// random boolean with p as percent liklihood of true
/** @return {boolean} */
sketch.random.prototype.random_bool = function(p) {
  return this.random_dec() < p;
}
// random value in an array of items
/** @return {number} */
sketch.random.prototype.random_choice = function(list) {
  return list[this.random_int(0, list.length - 1)];
}
// gaussian random value
/**
 * @param {number} mean
 * @param {number=} sd Defaults to 1
 * @return {number}
 */
sketch.random.prototype.random_gaussian = function(mean, sd) {
  let y1, x1, x2, w;
  sd = goog.isNumber(sd) ? sd : 1;
  
  if (this._gaussian_previous) {
    y1 = y2;
    this._gaussian_previous = false;
  } else {
    do {
      x1 = this.random_num(0, 2) - 1;
      x2 = this.random_num(0, 2) - 1;
      w = x1 * x1 + x2 * x2;
    } while (w >= 1);
    w = Math.sqrt(-2 * Math.log(w) / w);
    y1 = x1 * w;
    y2 = x2 * w;
    this._gaussian_previous = true;
  }
  const m = mean || 0;
  return y1 * sd + m;
};
// Pareto bounded random value
/**
 * @param {number} L lower bound (scale param)
 * @param {number} H upper bound
 * @param {number} shape
 * @return {number} */
sketch.random.prototype.random_pareto_bounded = function(L, H, shape) {
  let u, num, denom;
  u = this.random_dec();
  num = -(u*Math.pow(H, shape) - u*Math.pow(L, shape) - Math.pow(H, shape));
  denom = Math.pow(H, shape) * Math.pow(L, shape);
  return Math.pow(num/denom, (-1/shape));
}

// where the random rubber hits the road!!!
var R = new sketch.random();




// #################
// audio

window.numStrings = 1; //R.random_int(7,17); //numStrings;
window.stringNum = 0;
window.stringAmplitudes = new Array(window.numStrings).fill(1);
window.stringVibrations = new Array(window.numStrings).fill(0);

let audioContext = null;
// mode palette
let sa = 351.2*7/8;
let f0s_ = [sa, sa*6/5, sa*3/2, sa*8/5, sa*9/5, sa*2, sa*12/5];

/**
 * @return AudioWorkletNode;
 */
sketch.createMyInstrumentProcessor = async function() {
  if (!audioContext) {
    try {
      audioContext = new AudioContext();
    } catch(e) {
      //console.log("** Error: Unable to create audio context");
      return null;
    }
  }
  var myInstrumentNode;
  try {
    myInstrumentNode = new AudioWorkletNode(
      audioContext,
      "instrument-processor",
      {
        processorOptions: {
          "f0s_": f0s_
        }
      }
    );
  } catch(e) {
    try {
      //console.log("adding instrument-processor...")
      await audioContext.audioWorklet.addModule("js/instrument-processor-compiled.js");
      myInstrumentNode = new AudioWorkletNode(
        audioContext,
        "instrument-processor",
        {
          processorOptions: {
            "f0s_": f0s_,
            "RNG": R
          }
        });
    } catch(e) {
      //console.log(`** Error: Unable to create myInstrumentNode worklet node: ${e}`);
      return null;
    }
  }
  await audioContext.resume();
  return myInstrumentNode;
}

sketch.audioDemoStart = async function() {
  var harpNode = await sketch.createMyInstrumentProcessor();
  if (!harpNode) {
    //console.log("** Error: unable to create delay processor");
    return;
  }  

  // Connect and start
    harpNode.connect(audioContext.destination);

  // comms from processor
  harpNode.port.onmessage = (event) => {
    window.stringAmplitudes[event.data["stringno"]] = event.data["amplitude"];
    window.stringNum = event.data["stringno"];
  };

  // comms to processor
  let pluck = function(stringnum){
    harpNode.port.postMessage({
      "type": "play",
      "stringnum": stringnum
    });
  }

  // simple loop
  let baseDelay = 500; // in milliseconds
  let loopDelays = new Array(f0s_.length);
  let initialDelays = [4000, 8100, 5600, 12600, 9200, 14100,3100];
  loopDelays = [19700, 17800, 21300, 22100, 18400, 20000, 17700].map( (val) => val * 1);
  for (let stringno = 0; stringno < f0s_.length; stringno++){
    setTimeout(() => pluck(stringno), initialDelays[stringno]);
  }
  for (let stringno = 0; stringno < f0s_.length; stringno++){
    setInterval(() => {
      setTimeout(() => pluck(stringno), R.random_num(1500,10000));
    }, loopDelays[stringno]);
  }
}

window.addEventListener("load", event => {
  document.getElementById("toggle").addEventListener("click", toggleSound);
});

/**
  */
var toggleSound = async function(event) {
  if (!audioContext) {
    
    sketch.audioDemoStart();
  } else {
    window.stringAmplitudes = new Array(window.numStrings).fill(1);
    await audioContext.close();
    audioContext = null;
  }
}


// #################
// visuals



// params used to decide canvas size
// as per AB 101
var DEFAULT_SIZE = 1000
var WIDTH = window.innerWidth
var HEIGHT = window.innerHeight
var DIM = Math.min(WIDTH, HEIGHT)
var M = DIM / DEFAULT_SIZE

// relative width function, relative to canvas width
var w = function(val) {
  return WIDTH*val;
}
// relative height function, relative to canvas height
var h = function(val) {
  return HEIGHT*val;
}
// combined relative height and width function
/**
 * @param {Array.<Object>} a 2d array of cartesian coordinates
 */
var wh = function(a) {
  return [w(a[0]), h(a[1])];
}

// define phi
var PHI = (1 + Math.sqrt(5))/2;

// define pi
var PI = Math.PI;


/**
 * log of y with base x
 * @param {number} x
 * @param {number} y
 * @return {number} 
 */
var logxy = function(x, y) {
  return Math.log(y) / Math.log(x);
}

// /**
//  * fibonacci series, reversed
//  * @param {number} N
//  * @return {Array.<Object>}
//  */
// var fib = function(N) {
//   if (N==1)
//     {
//       return [1,1];
//     }
//   else
//   {
//     let sum = fib(N-1);
//     sum.push(sum[sum.length - 1] + sum[sum.length - 2]);
//     return sum;
//   }
// }

/**
 * golden spiral
 * @param {number} theta
 * @param {number=} base Defaults to PHI
 * @return {number}
 */
var goldenSpiralr = function(theta, base) {
  base = goog.isNumber(base) ? base : PHI;
  return Math.pow(base, 2*theta/PI); 
}

/**
 * Construct spiralxyVec 
 * @param {number} base
 * @param {number} startAngle
 * @param {number} endAngle
 * @param {number} numberVertices
 * @return {Array.<Object>}
 */
var genSpiralxyVec = function(base, startAngle, endAngle, numberVertices) {
  let step = (endAngle - startAngle) / numberVertices;
  let res = 0.0001;

  //  let thetaVec = [startAngle];
  const cumsum = (sum => val => sum += val)(0);

//  let fibrev = fib(numberVertices-1).reverse(); // ratio of angles I want from startAngle to endAngle, based on reversed fibonacci series
  let fibrev = new Array(numberVertices).fill(1);
  let fibrevsum = fibrev.reduce((total,current)=>{return total + current},0)
  let fibrevnorm = fibrev.map((x)=>{return x / fibrevsum});
  let fibrevnormcum = fibrevnorm.map(cumsum);
  let thetaVec = fibrevnormcum.map((x)=>{return x * endAngle});
  
  let rVec = []; //[goldenSpiralr(0, base)];
  let spiralxyVec = []; // [[rVec[0]*Math.cos(thetaVec[0]),rVec[0]*Math.sin(thetaVec[0])]];
  //note <=, without this small numberVertices values result in endAngle not being quite reached 
  for (let i = 0; i <= numberVertices; i++) {
//    thetaVec[i] = startAngle + step*i;
    
//    thetaVec[i] = (w(res)/rVec[i-1]) + thetaVec[i-1];
    rVec[i] = goldenSpiralr(thetaVec[i], base);
    spiralxyVec[i] = [rVec[i]*Math.cos(thetaVec[i]),rVec[i]*Math.sin(thetaVec[i])];
  }
  return spiralxyVec;
}

/**
 * drawSpiral
 * @param {Array.<Object>} spiralxyVec
 * @param {number} vertexSd
 * @param {number} scale
 * @param {number=} xmean Default 0.5
 * @param {number=} ymean Default 0.5
 * @param {number=} xsd Default 0.0
 * @param {number=} ysd Default 0.0
 */
var drawSpiral = function(spiralxyVec, vertexSd, scale, xmean, ymean, xsd, ysd) {
  let xmean_ = goog.isNumber(xmean) ? xmean : 0.5;
  let ymean_ = goog.isNumber(ymean) ? ymean : 0.5;
  let xsd_ = goog.isNumber(xsd) ? xsd : 0.0;
  let ysd_ = goog.isNumber(ysd) ? ysd : 0.0;
  let x = xmean_ + R.random_gaussian(0.0, xsd_);
  let y = ymean_ + R.random_gaussian(0.0, ysd_);  
  translate(w(x),h(y));
  beginShape();
  for (let i = 0; i < spiralxyVec.length; i++){
    let s = spiralxyVec[i];
    let v = [R.random_gaussian(s[0], vertexSd)/scale, R.random_gaussian(s[1], vertexSd)/scale];
    vertex(w(v[0]), h(v[1]));
//    point(w(v[0]), h(v[1]));
  }
  endShape();
  translate(w(-x),h(-y));
}




var alpha = 1.0; //0.68;
var sColVec = [[48, 42, 27, 1.0],
               [208, 65, 74, alpha],
               [107, 60, 45, alpha],
               [79, 83, 74, alpha],
               [0, 76, 94, alpha]];

var bgCol = R.random_choice(sColVec);
//console.log("background colour = " bgCol);

var numVertices = 100;
var startAngle0 = 0;
var startAngleN = -5*PI;
var startAngleStep = -0.5*PI;
var startAngleIndMax = (startAngleN - startAngle0)/startAngleStep;
var endAngle0 = 1*PI;
var endAngleN = 3*PI;
var endAngleStep = 0.125*PI;
var endAngleIndMax = (endAngleN - endAngle0)/endAngleStep;
var noIter = window.numStrings; //R.random_int(3,7);
//console.log("noIter = ", noIter);
var startAngleVec = [0, 0, 0];
for (let i = 3; i < startAngleIndMax + 3; i++){
  startAngleVec[i] = startAngle0 + (i - 3)*startAngleStep;
}
var endAngleVec = [];
for (let i = 0; i < endAngleIndMax; i++){
  endAngleVec[i] = endAngle0 + i*endAngleStep;
}
var startAngle = new Array(noIter).fill(0);
var endAngle = new Array(noIter).fill(0);
var xmeanVec = new Array(18).fill(0); var xmean = new Array(noIter).fill(0);
var ymeanVec = new Array(18).fill(0); var ymean = new Array(noIter).fill(0);
var vertexSdVec = [0, R.random_num(0,0)]; // [0, R.random_pareto_bounded(0.001, 0.03, 0.1)];  VERY PECULIAR, CANT'T REPLACE WITH [0,0] or [0] seems to need the random call
var vertexSd = new Array(noIter).fill(0);
var spiralStepVec = [0.005, R.random_pareto_bounded(0.005, 0.1, 1.16)]; var spiralStep = new Array(noIter).fill(0);
var scaleVec = [10, R.random_pareto_bounded(10, 50, 1.16)]; var scale = [];//new Array(noIter).fill(0);
var sWeight = new Array(noIter).fill(0);
var colInd = [];
//let xsdVec = [0, R.random_pareto_bounded(0.01, 2, 0.1)];
var xsd = 0; //xsdVec[R.random_int(0, (xsdVec.length - 1))];
//let ysdVec = [0, xsd/10, xsd];
var ysd = 0; //ysdVec[R.random_int(0, (ysdVec.length - 1))];
var spiralxyVec = [];
var baseVec = [];
var baseStart = 1.0;
var baseEnd  = PHI;
var baseN = [];

for (let i = 0; i < 18; i++){xmeanVec[i] = 0.5}; //replace i < 6
//for (let i = 6; i < 12; i++){xmeanVec[i] = (1 / (1 + PHI))/(1 + PHI)}; //PHI -1};
//for (let i = 12; i < 18; i++){xmeanVec[i] = 1 - (1 / (1 + PHI))/(1 + PHI)}; //2 - PHI};

for (let i = 0; i < 18; i++){ymeanVec[i] = 0.5}; 
// for (let i = 0; i < 8; i++){ymeanVec[i] = (1 / (1 + PHI))/(1 + PHI)};
// for (let i = 8; i < 15; i++){ymeanVec[i] = 1 - (1 / (1 + PHI))/(1 + PHI)};    
// for (let i = 15; i < 16; i++){ymeanVec[i] = PHI -1};
// for (let i = 16; i < 18; i++){ymeanVec[i] = 2 - PHI};

for (let iterNo = 0; iterNo < noIter; iterNo++){
  startAngle[iterNo] = R.random_choice(startAngleVec); //startAngleVec[R.random_int(0, (startAngleVec.length - 1))];
  endAngle[iterNo] = endAngleVec[R.random_int(0, (endAngleVec.length - 1))];
  xmean[iterNo] = xmeanVec[R.random_int(0, (xmeanVec.length - 1))];
  ymean[iterNo] = ymeanVec[R.random_int(0, (ymeanVec.length - 1))];
  vertexSd[iterNo] = vertexSdVec[R.random_int(0, (vertexSdVec.length - 1))];
  scale[iterNo] = scaleVec[R.random_int(0, (scaleVec.length - 1))];
  spiralStep[iterNo] = spiralStepVec[R.random_int(0, (spiralStepVec.length - 1))];
  
  if (spiralStep[iterNo] <= 0.01 && vertexSd[iterNo] <= 0.01){
    sWeight[iterNo] = 0.0005} 
  else if ((spiralStep[iterNo] > 0.01 && spiralStep[iterNo] < 0.05) && vertexSd[iterNo] <= 0.01){
    sWeight[iterNo] = 0.001}
  else {sWeight[iterNo] = 0.0005};  //changed from 0.00005
  colInd[iterNo] = R.random_int(0, sColVec.length -1);

  baseN[iterNo] = (baseEnd - baseStart)/spiralStep[iterNo];
  let spiralxyVec_ = [];
  for (let baseNo = 0; baseNo < baseN[iterNo]; baseNo++){
    baseVec[baseNo] = baseStart + baseNo * spiralStep[iterNo];
    spiralxyVec_[baseNo] = genSpiralxyVec(baseVec[baseNo], startAngle[iterNo], endAngle[iterNo], numVertices);
  }
  spiralxyVec[iterNo] = spiralxyVec_;
}


setup = function() {
  createCanvas(DIM, DIM);
  colorMode(HSB, 360, 100, 100, 1);
  frameRate(60);
}

var amplitudeAmplifier = function(amp,exponent){
  let ampedAmp = Math.pow(50*amp, exponent);
  let out;
  if (ampedAmp > 1.0)
    out = 1.0
  else out = ampedAmp;
  return out;
}

draw = function() {

  background(bgCol[0],bgCol[1],bgCol[2],bgCol[3]);
  noFill();
  for (let i = 0; i < noIter; i++)
  {
    stroke(sColVec[colInd[i]][0], sColVec[colInd[i]][1], sColVec[colInd[i]][2], amplitudeAmplifier(window.stringAmplitudes[i],3));
    strokeWeight(w(sWeight[i]));
  for (let baseNo = 0; baseNo < baseN[i]; baseNo++){
      drawSpiral(spiralxyVec[i][baseNo], vertexSd[i], scale[i]*5, xmean[i], ymean[i], xsd[i], ysd[i]);
    }
  }    
}
