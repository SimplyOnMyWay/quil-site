goog.provide('sketch');

// bug list.....

// window.stringAmplitudes as global seems non-idomatic and prone to problems - investigate and move inside p5 instance if poss

// roadtest curveVertex some more ... thoroughly, fingers crossed!  goal: reduce no of vertices by order of 10 or so 
// also change factor for circles from 5 upwards to about 10 or 20


// 14.01.2023:  GUI mode working, and most of relevant code replicated for MINT mode, but it doesn#t make any sense to call juxtParameters["whatever..."] before declared ... reason it out :)


// 16.01.2023: window.blah global variables are probably unnecessary.  These globals are not accesssible by the audioWorklet scope anyway and even if it was it would be dodgy practice for production code!  Declaring global variables at top of main script using let is probably better, though also worth a check with an expert at some point.  Don't want any part of my code which can be messed with from the console or similar!

// 16.01.2023: change two for(iterNo < maxNoSpirals....) loops in setupJuxtParams() into one

// 16.01.2023: page VERY slow to load (ca 5 - 10 sec), also about 1 s to respond to toggle sound on / off button; also throwing error on FIREFOX!

// 17.01.2023: consider using perlin noise rather than gaussian noise when generating spirals - will need to build my own! perhaps it exists on some kind AB artist's GitHub!?

// 17.01.2023: USE MODE WITH vertex (will be slower so increase lpos0 and lneg0 a lot!!!, or use a factor), when juxtoposing spirals - can get quads and triangles etc!!

// 09.01.2023:  TRAWL THROUGH UNCAUGHT PARAMS SET BY GUI BUT NOT MAKING THEIR WAY TO MINT-MODE!
//              HOPEFULLY CATCH WHY SO SLOW TO LOAD ALSO!!!


// messagePort messages keep getting received by AW processor even after button toggled off
// map too severe! fix edge artifacts!
// "wheel input events" - seem to slow down the page --- "p5.js stacktrace:  ...consider making event passive"


// to try!!
// multi res working, not just browser width / height - esp for strokeWeight!
// if scale > ca 10, remove inner spirals, or do something smart with the lPosSlope!
// refine spiral vertex distribution now that inner and outer spirals working, to optimise/minimise vertexCount - DONE!
// bigger inner circles!!
// reduce gain of pluck so less dense sustains...
// improve composition algo so notes can change on the fly not pre-ordained once using setTimeout
// remove vertices outside canvas from spiralxyVecPos and ...Neg.  Will cause discontinuity in how length of spirals change with amplitude but may not be perceptable or ugly, and may well be worth the performance trade-off even if it is noticeable!



// DONE - set params on a batch versus individual per spiral basis





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
// random value in an array of numbers
/** @return {number} */
sketch.random.prototype.random_choice = function(list) {
  return list[this.random_int(0, list.length - 1)];
}
// random value in an array of strings
/** @return {string} */
sketch.random.prototype.random_choice_string = function(list) {
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


// ##################
// SET UP AUDIO NECESSARY TO SET UP VISUALS - MAINLY SETTING OF MODE
// RATIONALISE AUDIO CODE AS MUCH AS POSSIBLE - CURRENTLY SPLIT BETWEEN HERE AND BOTTOM (WITH ONE LINE IN DRAW() FN RE. PCT I THINK...

// ////////////////////////////////////////////////////////////

// gui mode on or off!
let guiMode = false;

// mode palette
let sa = 264;
let pa = sa*3/2;
let ma = sa*4/3;
let tma = sa*45/32; // The Augmented Fourth: Tivra Ma, 45:32, p 39 & 26 Allaudin (double check ratio!)
let re = sa*9/8;
let kre = sa*16/15; // The Minor Second: Komal Re, 16:15, p 59 Allaudin
let ga = sa*5/4; 
let kga = sa*6/5; // the Minor Third: Komal Gha 6:5, p 54 Allaudin
let dha = sa*5/3; // The Major Sixth: Dha, 5:3, p52 Allaudin
let kdha = sa*8/5;
let ni = sa*5/4*3/2; // seventh
let kni = sa*9/5; // minor seventh komal Ni 9:5, p 57 Allaudin

//form mixed modes (ref p 87 Harmonic Experience, Allaudin Mathieu)
// upper 4 tetrachords
let MA = [pa,dha,ni,sa*2];// upper MA tetrachord
let MIX = [pa,dha,kni,sa*2];// upper MIX tetrachord
let HarMI = [pa,kdha,ni,sa*2];// upper HarMI tetrachord
let MI = [pa,kdha,kni,sa*2];// upper MI tetrachord
let upperTetraChords = [MA,MIX,HarMI,MI];

// lower 8 tetrachords
let MA_ = [sa,re,ga,ma]; // lower MA tetrachord
let MI_ = [sa,re,kga,ma]; // lower MI tetrachord
let PhyrgMA_ = [sa,kre,ga,ma]; // lower PHRYG.MA tetrachord
let PHYRG_ = [sa,kre,kga,ma]; // lower PHRYGIAN tetrachord
let LYD_ = [sa,re,ga,tma]; // lower LYDIAN tetrachord
let MiLYD_ = [sa,re,kga,tma]; // lower MI.LYD tetrachord
let PhyrgMaLYD_ = [sa,kre,ga,tma]; // lower PHYRG.MA.LYD tetrachord
let PhyrgLYD_ = [sa,kre,kga,tma]; // lower PHYRG.LYD tetrachord
let lowerTetraChords = [MA_,MI_,PhyrgMA_,PHYRG_,LYD_,MiLYD_,PhyrgMaLYD_,PhyrgLYD_];

let MIXEDMODES = [];
let mmIndex = 0;
for (let ui = 0; ui < 4; ui++){
  for (let li = 0; li < 8; li++){
    MIXEDMODES[mmIndex] = lowerTetraChords[li].concat(upperTetraChords[ui]);
    mmIndex++;
  }
}
let modeNoSelected = R.random_int(0,MIXEDMODES.length-1);
console.log("modeNoSelected = ", modeNoSelected);

let f0s_full = MIXEDMODES[modeNoSelected]; //[sa,re,ga,ma].concat([pa,kdha,ni,sa*2]); //[sa, sa*6/5, sa*3/2, sa*8/5, sa*9/5, sa*2, sa*12/5];
let f0s_ = [];  // set within p5 draw fn
let noNonStringSpirals = 0; // in case want it to be more than number of strings, ie f0s_full.length; noting I'll need to address code which this impacts!!!!!
let maxNoSpirals = f0s_full.length + noNonStringSpirals; 

// globals
window.stringAmplitudes = new Array(f0s_full.length).fill(1); //dubious again - circular????
window.stringVibrations = new Array(f0s_full.length).fill(0);

// ################




// #################
// visuals

// define phi
var PHI = (1 + Math.sqrt(5))/2;

// define pi
var PI = Math.PI;

// params used to decide canvas size
// as per AB 101
var DEFAULT_SIZE = 1000
var WIDTH = window.innerWidth
var HEIGHT = window.innerHeight
var DIM = Math.min(WIDTH, HEIGHT)/PHI
var M = DIM / DEFAULT_SIZE

//counter for total number of vertices, for dev
var vertCounter = 0;

// relative width function, relative to canvas width
var w = function(val) {
  //return WIDTH*val; //only makes sense for non-square aspect ratio of artwork, unless it can be set to the canvas rather than window dims
  return DIM*val;
}
// relative height function, relative to canvas height
var h = function(val) {
  //return HEIGHT*val; //only makes sense for non-square aspect ratio of artwork, unless set to canvas rather than window dim
  return DIM*val;
}
// relative height function, relative to canvas height - for testing aspect ratio!
var h_ = function(val) {
  return HEIGHT*val; //only makes sense for non-square aspect ratio of artwork, unless set to canvas rather than window dim
}
// combined relative height and width function
/**
 * @param {Array.<Object>} a 2d array of cartesian coordinates
 */
var wh = function(a) {
  return [w(a[0]), h(a[1])];
}


/**
 * log of y with base x
 * @param {number} x
 * @param {number} y
 * @return {number} 
 */
var logxy = function(x, y) {
  return Math.log(y) / Math.log(x);
}

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
 * Construct genThetaVec
 * @param {number} b base
 * @param {number} s startAngle
 * @param {number} e endAngle
 * @param {number} sc scale
 * @return {Array.<number>}
 */
var genThetaVec = function(b,s,e,sc){
  let thetaVecPos = [0]; 
  let thetaVecNeg = [0]; // to be reversed later... theta = 0 will then be last value in array
  let r0 = goldenSpiralr(0,b); 
  let rs = goldenSpiralr(s,b);
  let re = goldenSpiralr(e,b);

  // ///////////
  // pos angles
  // //////////
  let dpos = 2*r0;
  let Dpos = 2*re;
  let npos = e / (2*PI); //number of revolutions in positive dir
  let LPos = PI*npos*(Dpos+dpos)/2; //length of pos spiral 

  // //SUCH AN IMÞORTANT PARAMETER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  let lpos0 = w(0.00001); // 0.0001 // set to 0.0003 seems max value before inner straight lines are clearly evident
  let lposSlope = lpos0/20; //w(0.00003);

  let ipos = 1;
  let lpos = [lpos0];
  while(thetaVecPos[ipos-1] < e){
    lpos[ipos] = lpos0 + lposSlope*ipos;
    thetaVecPos[ipos] = thetaVecPos[ipos-1] + (lpos[ipos] / goldenSpiralr(thetaVecPos[ipos-1],b));
    ipos++;
    vertCounter++;
  }
  thetaVecPos.pop(); // remove last element as it will be > e
  thetaVecPos.push(e); // append e as final vertex, hopefully not too much of a noticeable gap!(



  // //////////
  // neg angles
  // //////////
  let dneg = 2*rs;
  let Dneg = 2*r0;
  let nneg = Math.abs(s) / (2*PI); // num revs in neg dir
  let LNeg = PI*nneg*(Dneg+dneg)/2

  // important two params for neg theta values!!!
  let lneg0 = lpos0;
  let lnegSlope = 0.1*lposSlope;  //better resolution toward center of spiral, tending to be piecewise otherwise

  let ineg = 1;
  let lneg = [lneg0];
  while(thetaVecNeg[ineg-1] > s){
    lneg[ineg] = lneg0 + lnegSlope*ineg;
    thetaVecNeg[ineg] = thetaVecNeg[ineg-1] - (lneg[ineg] / goldenSpiralr(thetaVecNeg[ineg-1],b));
    ineg++;
    vertCounter++;
  }
  thetaVecNeg.pop(); // remove last element as it will be > e
  thetaVecNeg.push(s); // append e as final vertex, hopefully not too much of a noticeable gap!(
  thetaVecNeg = thetaVecNeg.reverse();


  //combine into thetaVec
  //consider returning both as sub arrays - more control!
  let theta_Vec = thetaVecNeg.concat(thetaVecPos);
  return theta_Vec;
}

/**
 * Construct genThetaPosVec
 * @param {number} b base
 * @param {number} s startAngle
 * @param {number} e endAngle
 * @param {number} sc scale
 * @param {number} lpos0 initial spacing of positive spiral vertices
 * @param {number} lposSlope slope of spacing positive spiral vertices, as fn of vertex number i
 * @return {Array.<number>}
 */
var genThetaPosVec = function(b,s,e,sc,lpos0,lposSlope){
  let thetaVecPos = [0]; 
  let r0 = goldenSpiralr(0,b); 
  let rs = goldenSpiralr(s,b);
  let re = goldenSpiralr(e,b);

  // ///////////
  // pos angles
  // //////////
  let dpos = 2*r0;
  let Dpos = 2*re;
  let npos = e / (2*PI); //number of revolutions in positive dir
  let LPos = PI*npos*(Dpos+dpos)/2; //length of pos spiral 

  // //SUCH AN IMÞORTANT PARAMETER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  // let lpos0 = w(0.00001); // 0.0001 // set to 0.0003 seems max value before inner straight lines are clearly evident
  // let lposSlope = lpos0/20; //w(0.00003);

  let ipos = 1;
  let lpos = [lpos0];
  while(thetaVecPos[ipos-1] < e){
    lpos[ipos] = lpos0 + ipos*lposSlope/(b*b); ///b experimental
    thetaVecPos[ipos] = thetaVecPos[ipos-1] + (lpos[ipos] / goldenSpiralr(thetaVecPos[ipos-1],b));
    ipos++;
    vertCounter++;
  }
  thetaVecPos.pop(); // remove last element as it will be > e
  thetaVecPos.push(e); // append e as final vertex, hopefully not too much of a noticeable gap!(
  let curveGuideDelta = 0.01;  // DUNNO IF THIS IS DOING ANYTHING, BUT COULD BE WORTH EXPLORING HOW TO GUIDE THE END AND START OF THE CURVES...
  thetaVecPos.push(R.random_num(e - curveGuideDelta, e + curveGuideDelta)); // append e as ANOTHER final vertex, to fool curveVertex, hopefully!
  thetaVecPos.unshift(0); //prepend another 0 again to fool curveVertex (it uses first and last vertices as guides)

  return thetaVecPos;
}


/**
 * Construct genThetaNegVec
 * @param {number} b base
 * @param {number} s startAngle
 * @param {number} e endAngle
 * @param {number} sc scale
 * @param {number} lneg0 initial spacing of neg spiral vertices
 * @param {number} lnegSlope slope of spacing neg spiral vertices, as fn of vertex number i
 * @param {number=} r DEFAULT 0 reverse
 * @return {Array.<number>}
 */
var genThetaNegVec = function(b,s,e,sc,lneg0,lnegSlope,r){
  let thetaVecNeg = [0]; // to be reversed later... theta = 0 will then be last value in array
  let r0 = goldenSpiralr(0,b); 
  let rs = goldenSpiralr(s,b);
  let re = goldenSpiralr(e,b);

  // //////////
  // neg angles
  // //////////
  let dneg = 2*rs;
  let Dneg = 2*r0;
  let nneg = Math.abs(s) / (2*PI); // num revs in neg dir
  let LNeg = PI*nneg*(Dneg+dneg)/2

  // // important two params for neg theta values!!!
  // let lneg0 = w(0.00001);
  // let lnegSlope = lneg0*0.01;  //better resolution toward center of spiral, tending to be piecewise otherwise

  let ineg = 1;
  let lneg = [lneg0];
  while(thetaVecNeg[ineg-1] > s){
    lneg[ineg] = lneg0 + ineg*lnegSlope/(b*b);  // /b experimental
    thetaVecNeg[ineg] = thetaVecNeg[ineg-1] - (lneg[ineg] / goldenSpiralr(thetaVecNeg[ineg-1],b));
    ineg++;
    vertCounter++;
  }
  thetaVecNeg.pop(); // remove last element as it will be > e
  thetaVecNeg.push(s); // append e as final vertex, hopefully not too much of a noticeable gap!(
  thetaVecNeg.push(s); // append e as ANOTHER final vertex, to fool curveVertex, hopefully!
  thetaVecNeg.unshift(0); //prepend another 0 again to fool curveVertex (it uses first and last vertices as guides)
  if(r)
    thetaVecNeg = thetaVecNeg.reverse();

  return thetaVecNeg;
}



/**
 * Construct spiralxyVec 
 * @param {number} base
 * @param {number} startAngle
 * @param {number} endAngle
 * @param {number} scale
// * @param {number} lpos0 initial spacing of positive spiral vertices
// * @param {number} lposSlope slope of spacing positive spiral vertices, as fn of vertex number i
 * @param {number} vertexSd
// * @param {number} numberVertices
 * @return {Array.<Object>}
 */
var genSpiralxyVec = function(base, startAngle, endAngle, scale, vertexSd) {
  let thetaVec = genThetaVec(base,startAngle,endAngle,scale);
  let rVec = []; 
  let spiralxyVec = [];
  //note <=, without this small numberVertices values result in endAngle not being quite reached 
  for (let i = 0; i < thetaVec.length; i++) {
    rVec[i] = goldenSpiralr(thetaVec[i], base);

    //note division by scale, moved out of drawSpiral function to here, where it was unnecessarily slowing down the draw fn
    let s = [rVec[i]*Math.cos(thetaVec[i]),rVec[i]*Math.sin(thetaVec[i])];
    spiralxyVec[i] = [R.random_gaussian(s[0], vertexSd)/scale, R.random_gaussian(s[1], vertexSd)/scale]
  }
  return spiralxyVec;
}


/**
 * Construct spiralxyVecPos
 * @param {number} base
 * @param {number} startAngle
 * @param {number} endAngle
 * @param {number} scale
 * @param {number} lpos0 initial spacing of positive spiral vertices
 * @param {number} lposSlope slope of spacing positive spiral vertices, as fn of vertex number i 
 * @param {number} vertexSd
// * @param {number} numberVertices
 * @return {Array.<Object>}
 */
var genSpiralxyVecPos = function(base, startAngle, endAngle, scale, lpos0, lposSlope,vertexSd) {
  let thetaVecPos = genThetaPosVec(base,startAngle,endAngle,scale,lpos0,lposSlope);
  let rVecPos = []; 
  let spiralxyVecPos = [];
  //note <=, without this small numberVertices values result in endAngle not being quite reached 
  for (let i = 0; i < thetaVecPos.length; i++) {
    rVecPos[i] = goldenSpiralr(thetaVecPos[i], base);

    //note division by scale, moved out of drawSpiral function to here, where it was unnecessarily slowing down the draw fn
    let s = [rVecPos[i]*Math.cos(thetaVecPos[i]),rVecPos[i]*Math.sin(thetaVecPos[i])];
    spiralxyVecPos[i] = [R.random_gaussian(s[0], vertexSd)/scale, R.random_gaussian(s[1], vertexSd)/scale]
  }
  return spiralxyVecPos;
}

/**
 * Construct spiralxyVecNeg
 * @param {number} base
 * @param {number} startAngle
 * @param {number} endAngle
 * @param {number} scale
 * @param {number} vertexSd
 * @param {number} lneg0 initial spacing of neg spiral vertices
 * @param {number} lnegSlope slope of spacing neg spiral vertices, as fn of vertex number i
 * @param {number=} r DEFAULT 0 reverse
// * @param {number} numberVertices
 * 
 * @return {Array.<Object>}
 */
var genSpiralxyVecNeg = function(base, startAngle, endAngle, scale, lneg0,lnegSlope,vertexSd, r) {
  let thetaVecNeg = genThetaNegVec(base,startAngle,endAngle,scale,lneg0,lnegSlope,r);
  let rVecNeg = []; 
  let spiralxyVecNeg = [];
  //note <=, without this small numberVertices values result in endAngle not being quite reached 
  for (let i = 0; i < thetaVecNeg.length; i++) {
    rVecNeg[i] = goldenSpiralr(thetaVecNeg[i], base);

    //note division by scale, moved out of drawSpiral function to here, where it was unnecessarily slowing down the draw fn
    let s = [rVecNeg[i]*Math.cos(thetaVecNeg[i]),rVecNeg[i]*Math.sin(thetaVecNeg[i])];
    spiralxyVecNeg[i] = [R.random_gaussian(s[0], vertexSd)/scale, R.random_gaussian(s[1], vertexSd)/scale]
  }
  return spiralxyVecNeg;
}

var amplitudeAmplifier = function(amp,exponent){
  let ampedAmp = Math.pow(50*amp, exponent);
  let out;
  if (ampedAmp > 1.0)
    out = 1.0
  else out = ampedAmp;
  return out;  
}



// ////////////////////////////////////////
// use p5.gui.js format... instantiate mode
// ////////////////////////////////////////
let juxtSketch = function(p){


  // set up arrays for drawStringAmps()
  // only for debugging - REMOVE FROM PROD CODE!!!
  p.stringAmps = [];
  p.ampWindowLength = 60; //REVIEW THIS! //assume SR = 48000, window then 2 sec long
  for (let s = 0; s < maxNoSpirals; s++){
    p.stringAmps[s] = new Array(p.ampWindowLength).fill(0);
  }


  
  // ############
  // refactored
  // declaring all p. parameters whether arrays or values. Belt and braces - runs fine in browser if some not declared but not got time now to weed through so declaring all!

  // NOTE - this top "contructor"-type section declares and instantiates vectors and values WITHOUT using any R.random method calls!!!
  // TO ENSURE ALL RANDOMNESS IS FULLY TRACEABLE AND REPRODUCABLE BASED ON tokenData, ALL PARAMETERS ARE SET USING EITHER:
 // 1. setupJuxtParameters(): called once during "setup", i.e., once [TBC if called ahead of or within p.setup()], and then the "juxtParams" hash-map is called every frame within p.draw()
  // 2.
  // 2a. setupJuxtParametersGuiMode(): set once during "setup" above - setupJuxtParametersGuiMOde function sets up all params - both GUI-based and R.random based
  // 2b. updateJuxtParametersGuiMode(): R.random based are not touched and "juxtParameters" hash-map is updated from the live GUI values.  Exception is the call to genSpiralxyVec which implicitly calls R.random - hard to avoid!


  // save first frame, flag is set to zero after first call to saveThumb()
  p.saveFlag = 1;
  
  //shuffleVec is used to in the creation/setup of all other vectors with random values
  p.shuffleVec = new Array(maxNoSpirals).fill(0); 

  // instantiate spiralxyVec,  IMPORTANT!!!
  p.spiralxyVecPos = [];
  p.spiralxyVecNeg = [];

  p.reverseSpiralVec = [];
  
  p.vertexSdVec = [];

  p.spiralStepVec = [];

  p.scaleVec = [];

  p.baseStart = 1.0; // DESIGN-FROZED PARAM VALUE!
  p.baseEnd  = PHI; // DESIGN-FROZED PARAM VALUE!
  p.baseVec = [];
  p.baseN = [];

  p.sWeightVec = [];

  p.strokeMin = 0; // declare to zero for now, assigned properly below    
  
  p.pct = new Array(maxNoSpirals).fill(1.0); //percentage of each spiral visible, driven by string amplitude - IMPORTANT INITIALISATION TO SEE ALL SPIRALS!!!!!!!!!

  // centre of spirals!!
  p.xmeanVec = [];
  p.xmeanLatticeVec = [];   // to hold lattice "vertices" x components
  p.xmean = [];
  p.xmean_all = 0; // declare to zero for now, assigned properly below    
  p.xvec = [];
  p.xvec_latticeConfig = []; // spiral centers laid out in Allaudin's lattice, per mode selected
  p.xvec_overlayConfig = []; // spirals overlaid all with same center
  p.ymeanVec = [];
  p.xmeanLatticeVec = [];  // to hold lattice "vertices" y components
  p.ymean = [];
  p.ymean_all = 0; // declare to zero for now, assigned properly below    
  p.yvec = [];
  p.yvec_latticeConfig = []; // spiral centers laid out in Allaudin's lattice, per mode selected
  p.yvec_overlayConfig = []; // spirals overlaid all with same center
  
  // SPIRAL PARAMS
  p.startAngle0 = -PI; // DESIGN-FROZED PARAM VALUE!
  p.startAngleN = -5.5*PI; // DESIGN-FROZED PARAM VALUE!
  p.startAngleStep = -0.25*PI; // DESIGN-FROZED PARAM VALUE!
  p.startAngleIndMax = (p.startAngleN - p.startAngle0)/p.startAngleStep;
  p.endAngle0 = 1.5*PI; // DESIGN-FROZED PARAM VALUE!
  p.endAngleN = 4*PI; // DESIGN-FROZED PARAM VALUE!
  p.endAngleStep = 0.125*PI; // DESIGN-FROZED PARAM VALUE!
  p.endAngleIndMax = (p.endAngleN - p.endAngle0)/p.endAngleStep;
  p.startAngleVec = [0, p.startAngle0, p.startAngle0];  //hand-pick some of the startAngleVec values so they are more likely
  for (let i = 3; i < p.startAngleIndMax + 3; i++){
    p.startAngleVec[i] = p.startAngle0 + (i - 3)*p.startAngleStep;
  }
  p.endAngleVec = [];
  for (let i = 0; i < p.endAngleIndMax; i++){
    p.endAngleVec[i] = p.endAngle0 + i*p.endAngleStep;
  }
  p.startAngle = []; 
  p.endAngle = []; 

  p.lpos0 = [];
  p.lneg0 = [];
  p.lposSlope = [];
  p.lnegSlope = [];

  p.lpos0CircleFactor = 5; // DESIGN-FROZED PARAM VALUE!
  p.lneg0CircleFactor = 5; // DESIGN-FROZED PARAM VALUE!

  p.outerCircleDiaVec = [];
  p.outerCircleDiaSlopeVec = [];
  p.innerCircleDiaVec = [];
  p.innerCircleDiaSlopeVec = [];

  

  // ~~~~~~~~~~~~~~~~~
  // "feature" vectors
  // ~~~~~~~~~~~~~~~~~

  p.spiralConfigVec = []; //whether or not a given spiral sits centered - all or nothing for now (all random or all centered), to optimise later.  Needs to be considered in context of MODES!!!
  /** @type {?string} */
  p.spiralConfigFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"

  p.innerSpiralCloseVec = [];
  /** @type {?string} */
  p.innerSpiralCloseFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"
  p.outerSpiralCloseVec = [];
  /** @type {?string} */
  p.outerSpiralCloseFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"

  p.innerCirclesVec = [];
  /** @type {?string} */
  p.innerCirclesFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"
  p.outerCirclesVec = [];
  /** @type {?string} */
  p.outerCirclesFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"

  p.innerSpiralFillVec = [];
  /** @type {?string} */
  p.innerSpiralFillFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"
  p.outerSpiralFillVec = [];
  /** @type {?string} */
  p.outerSpiralFillFeature = ""; //instatiate to empty string for now - to be assigned with the top level feature option, an "enum"

  
  // ############


  // ############
  // colour palette - copied for now, still to optimise into a map
  // COLOUR PALETTES - LOTS TO DO!!!!!
  var alpha = 1.0;
  p.sColVec_selected = [];
  p.col = [];
  p.bgColVec = [];
  p.sColVecPal =
      [
        //tyler
        [[355, 78, 85, alpha],
         [169, 75, 65, alpha],
         [39, 59, 95, alpha],
         [22, 44, 35, alpha],
         [227, 65, 20, alpha],
         [10, 35, 97, alpha],
         [25, 77, 90, alpha],
         [40, 12, 88, alpha],
         [0, 0, 0, alpha]],
        // pscott-rosc-extended
        [[208, 65, 74, alpha],
         [107, 60, 45, alpha],
         [79, 83, 74, alpha],
         [0, 76, 94, alpha],
         [208, 65, 74, alpha],
         [107, 60, 45, alpha],
         [79, 83, 74, alpha],
         [0, 76, 94, alpha],
         [0, 0, 0, alpha]],
        //
        [[355, 78, 85, alpha],
         [169,75,65,alpha],
         [39,59,95,alpha],
         [22,44,35,alpha],
         [227,65,20,alpha],
         [10,35,97,alpha],
         [25,77,90,alpha],
         [160,15,85,alpha],
         [40,12,88,alpha],
         [0, 0, 0, alpha]],
        //vibrating-boundaries
        [[185, 98, 65, alpha],
         [185, 98, 95, alpha],
         [185, 10, 65, alpha],
         [185, 98, 45, alpha],
         [40, 50, 100, alpha],
         [40, 100, 100, alpha],
         [0, 0, 0, alpha],
         [0, 0, 0, alpha],
         [0, 0, 0, alpha]],
        //XI-3
        [[22,44,35,1],
         [151, 56, 37, alpha],
         [0, 83, 61, alpha],
         [42, 67, 66, alpha],
         [135, 24, 21, alpha],
         [151, 96, 37, alpha],
         [0, 0, 100, alpha],  //white makes a big differenec to palette!
         [0, 0, 50, alpha],
         [0, 0, 0, alpha]],
        //frozenFog
        [
          [179, 24, 71, 1],
          [202, 67, 44, 1],
          [107, 47, 65, 1],
          [214, 51, 71, 1],
          [252, 2, 87, 1],
          [336, 49, 73, 1],
          [200, 85, 87, 1],
          [30, 37, 69, 1],
          [19, 68, 87, 1]
        ],
        //unfold [7]
        [
          [19, 68, 87, 1],
          [16, 92, 85, 1],
          [19, 3, 32, 1],
          [19, 3, 68, 1],
          [0, 76, 94, 1],
          [19, 95, 95, 1],
          [30, 95, 95, 1],
          [7, 95, 80, 1],
          [19, 68, 87, 1]
        ]
      ];

  // this p.bgColVec could possibly be moved into p.sColVecPal above... optimise later!
  var bAlpha = 1.0;//0.05;
  p.bgColVec = [[208,25,95,bAlpha],
                  //[160, 15, 85, bAlpha],
                  [48, 42, 27, bAlpha],
                  [50, 45, 80, bAlpha],
                  [18, 86, 91, bAlpha],
                  [50,30,90, bAlpha],
                  [47,78,92, bAlpha],
                  [28,81,27, bAlpha]                
                 ];

  // #################  


  // // /////////////////////////////////////////////
  // // IMPORTANT!!! How colour is selected probabilitically from within palette, with no repeats!
  // // ///////////////////////////////////////////// 
  // // INSTANTIATE COLOURS TO BE USED, OF WHICH A PERMUTATION of noIter COLOURS IS SELECTED PROBABILITICALLY FROM PALETTE sColVec


  for(let palno = 0; palno < p.sColVecPal.length; palno++){
    p.sColVec_selected[palno] = [];
    let sColVec = p.sColVecPal[palno];
    let jpal = 0;
    let ipal = maxNoSpirals; 
    while (ipal--){
      jpal = Math.floor(R.random_dec() * (sColVec.length)); //sColVec.length
      p.sColVec_selected[palno].push(sColVec[jpal]);
      sColVec.splice(jpal,1);
    }
  }

  // weird one! maybe could have done all the above as standalone loop, ie called at setup, not draw!
  // SETTING THE MACRO VISUAL STRUCTURE OF THE PIECE,SPIRAL CENTRES
// prob equal for dev, skew towards 0.5,0.5 later!
  for (let i = 0; i < 33; i++){p.xmeanVec[i] = 0.5}; //replace i < 6
  for (let i = 33; i < 66; i++){p.xmeanVec[i] = (1 / (1 + PHI))/(1 + PHI)}; //PHI -1};
  for (let i = 66; i < 100; i++){p.xmeanVec[i] = 1 - (1 / (1 + PHI))/(1 + PHI)}; //2 - PHI};

  for (let i = 0; i < 11; i++){p.ymeanVec[i] = 0.5}; 
  for (let i = 11; i < 22; i++){p.ymeanVec[i] = (1 / (1 + PHI))/(1 + PHI)};
  for (let i = 22; i < 33; i++){p.ymeanVec[i] = 1 - (1 / (1 + PHI))/(1 + PHI)};
  for (let i = 33; i < 66; i++){p.ymeanVec[i] = PHI -1};
  for (let i = 66; i < 100; i++){p.ymeanVec[i] = 2 - PHI};


  // ~~~~~~~~~~
  // REFACTORED: BIG STRUCTURE FEATURE..... 5-limit lattice
  // CONVERT INTO FUNCTION...
  // ~~~~~~~~~~
  let mid = 0.5;
  let phiReduced1minor = 1 / (1 + PHI);
  let phiReduced1major = 1 - (1 / (1 + PHI));  
  let phiReduced2minor = (1 / (1 + PHI))/(1 + PHI);
  let phiReduced2major = 1 - (1 / (1 + PHI))/(1 + PHI);  

  p.maPos = [mid, phiReduced2major];
  p.saPos = [mid, phiReduced1major];
  p.paPos = [mid, phiReduced1minor];
  p.rePos = [mid, phiReduced2minor];
  p.gaPos = [phiReduced2minor, phiReduced1major];
  p.kdhaPos = [phiReduced2major, phiReduced1major];    
  p.niPos = [phiReduced2minor, phiReduced1minor];

  // SET UP THE VECTOR OF [x,y] LATTICE POSITIONS CORRESPONDING TO f0s_full
  p.meanPosVec = [p.saPos,p.rePos,p.gaPos,p.maPos].concat([p.paPos,p.kdhaPos,p.niPos,p.saPos]);


  
  // ~~~~~~~~
  
  

  p.setupJuxtParameters = function() {

    // ~~~~~~~~~~~~~~~~~~~
    // audio param set up - short for now!
    // ~~~~~~~~~~~~~~~~~~~
    //window.adsrGain = p.guiParams["adsrGain"];

    
    // ~~~~~~~~~~~~~~~~~~~
    // visual param set up
    // ~~~~~~~~~~~~~~~~~~~

    window.numStrings = 8;//R.random_int(5,7); //BIG ONE HERE - Need to revisit for arbitrary upper limits! 

    // select window.numStrings number of notes from mode 
    f0s_ = f0s_full.slice(0,window.numStrings); // f0s_ needed by pluck function, should ensure only numStrings are being plucked at any given time - REFACTORING COMMENT - CHECK THIS LEGACY LINE OF CODE AND LOGIC!

    
    let palNo = R.random_int(0,p.sColVec_selected.length - 1); // mmmm this should be a pre-declared parameter called p.palNo ... CORRECT LATER!!
     
    // SET UP all probabilistic arrays for this minting
    // ##########
    // refactored
    p.noiseSeed(100);
    p.vertexSdVec = p.shuffleVec.map(()=>{return R.random_choice([0,0,0,0,0,0,0,0,0,0,0.001,0.01,0.05])});//once in a blue moon I want a non-zero value ... RETURN TO THIS! the highest val is great with Fill Outer Spirals - organic look with low opacity overlays!
    p.xSdVec = p.shuffleVec.map(()=>{return R.random_choice([0,0,0,0,0,0,0,0,0.001,0.01,0.05])}); //R.random_pareto_bounded(0.01, 0.05, 1.16)});
    p.ySdVec = p.shuffleVec.map(()=>{return R.random_choice([0,0,0,0,0,0,0,0,0.001,0.01,0.05])}); //R.random_pareto_bounded(0.01, 0.05, 1.16)});
    p.spiralStepVec = p.shuffleVec.map(()=>{return  R.random_pareto_bounded(0.02, 0.5, 1.16)});  // 0.5 may be a bit high??
    p.startAngle = p.shuffleVec.map(()=>{return R.random_choice(p.startAngleVec)}); 
    p.endAngle = p.shuffleVec.map(()=>{return R.random_choice(p.endAngleVec)});
    p.reverseSpiralVec = p.shuffleVec.map(()=>{return R.random_choice([0,0,0,0,1])}); //20% likelihood of reverse
    p.scaleVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(3,30, 3.16)});  // LOVE having all same scale at a 3 or so , now and then - IMPLEMENT!!!  MAYBE JUST MAKE 99/1 pareto... trying 3.16 exponent
//    p.scaleVec = p.shuffleVec.map(()=>{return (3 + R.random_gaussian(0,5))});    
    p.lpos0Vec = p.shuffleVec.map(()=>{return 0.25}); //tune with GUI ... RETURN TO THIS!    0.05 before curveVertex!!!   THIS IS PRETTY NICE - DESIGN FREEZE?
    p.lneg0Vec = p.shuffleVec.map(()=>{return 0.1}); // tune with GUI... RETURN TO THIS!  0.0125 before curveVertex!!! THIS IS PRETTY NICE - DESIGN FREEZE?
    p.lposSlopeVec = p.shuffleVec.map(()=>{return 0.0}); //once in a blue moon I want a non-zero value ... RETURN TO THIS!
    p.lnegSlopeVec = p.shuffleVec.map(()=>{return 0.001}); //once in a blue moon I want a non-zero value ... RETURN TO THIS!
    p.strokeMinVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.000075,0.0001, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!!  CONSIDER FATSO FEATURE!!!! ca 0.001 --- IT'S STILL PERFORMANT!!!  OR PLAY WITH FACTORS APPLIED FOR DIFFERENT SPIRAL STEPS!!!
    p.spiralFillAlphaFactorVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.025,0.075, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!!  ADD FACTOR FOR CIRCLES Vs SPIRALS! FEELS LIKE LESS IF MORE FOR SPIRALS ANYWAY - OVERLAYS ARE BEAUTIFUL ESP. WHEN GRADIENT IS SMOOTH.  FOR LOWER OPACITY ONCE IN A WHILE, INCREASE FREQUENCY OF A COLOUR IN A PALETTE!
    p.outerCircleDiaVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.005,0.05, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!!  
    p.outerCircleDiaSlopeVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.0,0.0001, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!! EFFECTIVELY ZERO JUST NOW!
    p.innerCircleDiaVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.001,0.01, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!!  //SETTING innercircleDiaVec big has PERFORMANCE PROBS WHEN FILLED!!!
    p.innerCircleDiaSlopeVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.0,0.05, 1.16)}); //TUNE PARETO EXTENTS WITH GUI!!!  EFFECTIVELY ZERO JUST NOW!

    // ##########


    // SET UP all probabilistic single value variables/parameters for this minting
    // ##########
    // refactored
    // ##########

    //fair enough to do these at the top level, as it is like colour palette, ie set once for a particular mint
    p.spiralConfigFeature = R.random_choice_string(["overlayConfig","latticeConfig","latticeConfig","latticeConfig"]); // add in "latticeConfig" with relative frequency I desire
    p.innerCirclesFeature = R.random_choice_string(["on","off","random"]); // adjust frequency of each option according to my taste informed by GUI, perhaps using something like shufflevec to build up a vec with required distribution for each feature
    p.outerCirclesFeature = R.random_choice_string(["on","off","random"]); // adjust frequency of each option according to my taste informed by GUI
    p.innerSpiralCloseFeature = R.random_choice_string(["all open","all closed","random"]); // adjust frequency of each option according to my taste informed by GUI, perhaps using something like shufflevec to build up a vec with required distribution for each feature
    p.outerSpiralCloseFeature = R.random_choice_string(["all open","all closed","random"]); // adjust frequency of each option according to my taste informed by GUI, perhaps using something like shufflevec to build up a vec with required distribution for each feature
    p.innerSpiralFillFeature = R.random_choice_string(["fill all","no fill","random"]); // adjust frequency of each option according to my taste informed by GUI, perhaps using something like shufflevec to build up a vec with required distribution for each feature
    p.outerSpiralFillFeature = R.random_choice_string(["no fill","no fill","random"]); // adjust frequency of each option according to my taste informed by GUI, perhaps using something like shufflevec to build up a vec with required distribution for each feature

    
    
    
    p.spiralFillAlphaFactor = R.random_choice(p.spiralFillAlphaFactorVec); // not so this one I reckon, reconsider if this is set once for all spirals like this!!!!!!!


    

    // ####################
    // SET UP xvec and yvec (REFACTORED)
    // NOTE that the for loop is up to maxNoSpirals, while loop below in next section take "numStrings" on the fly from GUI - ie this current loop is NOT copied into updateJuxtParameterGuiMode()
    p.xmean_all = R.random_choice(p.xmeanVec);
    p.ymean_all = R.random_choice(p.ymeanVec);


    for (let iterNo = 0; iterNo < maxNoSpirals; iterNo++){  //NOTE Changed this from GuiParames["numStringsMax"]

      // default is to allocate lattice mode to p.xmean and p.ymean (might change naming scheme if more than 2 configs later!, ie next two line would then change to p.xmean_latticeConfig = ...  and p.ymean_latticeConfig = ...)
     // EDIT 24.01.2023! 
      p.xmean[iterNo] = p.meanPosVec[iterNo][0]; //R.random_choice(p.xmeanVec);
      p.ymean[iterNo] = p.meanPosVec[iterNo][1]; //R.random_choice(p.ymeanVec);

      p.baseN[iterNo] = (p.baseEnd - p.baseStart)/p.spiralStepVec[iterNo];
      
      p.xvec_latticeConfig[iterNo] = [];
      p.yvec_latticeConfig[iterNo] = [];
      p.xvec_overlayConfig[iterNo] = [];
      p.yvec_overlayConfig[iterNo] = [];      
      for(let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){
        // set up "lattice" config (default / most likely)
        p.xvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.xmean[iterNo], p.xSdVec[iterNo]);
        p.yvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.ymean[iterNo], p.ySdVec[iterNo]);
        // set up "spiral overlay" config once here to avoid calling R.random_gaussian in GUI update function
        p.xvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.xmean_all, p.xSdVec[iterNo]);
        p.yvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.ymean_all, p.ySdVec[iterNo]);
      }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // SET UP xvec and yvec (REFACTORED)
    // NOTE 1 - could possibly update p.spiralConfigVec but seems overkill now - reserve for option of mixing configs across iterNo...
    // NOTE 2 - this if / else conditional is copied in Gui update below, tho without the random bits in the for loop immediately above
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(p.spiralConfigFeature === "latticeConfig"){
      p.xvec = p.xvec_latticeConfig;
      p.yvec = p.yvec_latticeConfig
    }
    else if (p.spiralConfigFeature === "overlayConfig"){
      p.xvec = p.xvec_overlayConfig;
      p.yvec = p.yvec_overlayConfig
    }

    
    // generate colour vectors p.bgCol
    // possibly move into a single vector with p.col later, not sure if it helps logic or performance so leaving as an possible optimisation later!
    p.bgCol = p.bgColVec[palNo];

    
    for (let iterNo = 0; iterNo < maxNoSpirals; iterNo++){

      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // generate vectors which only change on iterNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      // generate colour vectors p.col
      // NOTE the window.stringAmplitudes vector needs to be made robust against increasing maxNoSpirals > numStrings
      p.col[iterNo] = [p.sColVec_selected[palNo][iterNo][0], p.sColVec_selected[palNo][iterNo][1], p.sColVec_selected[palNo][iterNo][2], amplitudeAmplifier(window.stringAmplitudes[iterNo],3)];

      // stroke-weight for various steps between spiral arms
      if (p.spiralStepVec[iterNo] <= 0.01 && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMinVec[iterNo]*10}//0.001}//0.0007}//0.0005}  
      else if ((p.spiralStepVec[iterNo] > 0.01 && p.spiralStepVec[iterNo] < 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMinVec[iterNo]*15}//0.0015}//0.001}//0.001}
      else if ((p.spiralStepVec[iterNo] > 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMinVec[iterNo]*25}//0.0025}//0.002}//0.003}//0.001}
      else {p.sWeightVec[iterNo] = p.strokeMinVec[iterNo]*15};//0.0015};//0.0005};  //changed from 0.00005

      
      // ~~~~~~~~~~~~~~~~~~~~
      // binary-ish options... ie conditionals based on FEATURE ATTRIBUTES!
      // ~~~~~~~~~~~~~~~~~~~~
      if(p.innerCirclesFeature === "off"){
        p.innerCirclesVec[iterNo] = 0;
      }
      else if (p.innerCirclesFeature === "on"){
        p.innerCirclesVec[iterNo] = 1;
        p.lneg0[iterNo] = p.lneg0[iterNo]*p.lneg0CircleFactor;  
      }
      else if (p.innerCirclesFeature === "random"){
        p.innerCirclesVec[iterNo] = R.random_int(0,1);
        if(p.innerCirclesVec[iterNo])
          p.lneg0[iterNo] = p.lneg0[iterNo]*p.lneg0CircleFactor;  
      }

      if(p.outerCirclesFeature === "off"){
        p.outerCirclesVec[iterNo] = 0;
      }
      else if (p.outerCirclesFeature === "on"){
        p.outerCirclesVec[iterNo] = 1;
        p.lpos0[iterNo] = p.lpos0[iterNo] * p.lpos0CircleFactor; 
      }
      else if (p.outerCirclesFeature === "random"){
        p.outerCirclesVec[iterNo] = R.random_int(0,1);
        if(p.outerCirclesVec[iterNo])
          p.lpos0[iterNo] = p.lpos0[iterNo] * p.lpos0CircleFactor; 
      }

      
      if(p.innerSpiralCloseFeature === "all open"){
        p.innerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.innerSpiralCloseFeature === "all closed"){
        p.innerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.innerSpiralCloseFeature === "random"){
        p.innerSpiralCloseVec[iterNo] = R.random_int(0,1);
      }
      
      if(p.outerSpiralCloseFeature === "all open"){
        p.outerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.outerSpiralCloseFeature === "all closed"){
        p.outerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.outerSpiralCloseFeature === "random"){
        p.outerSpiralCloseVec[iterNo] = R.random_int(0,1);
      }


      if(p.innerSpiralFillFeature === "no fill"){
        p.innerSpiralFillVec[iterNo] = 0;
      }
      else if (p.innerSpiralFillFeature === "fill all"){
        p.innerSpiralFillVec[iterNo] = 1;
      }
      else if (p.innerSpiralFillFeature === "random"){
        p.innerSpiralFillVec[iterNo] =  R.random_int(0,1);
      }
      
      if(p.outerSpiralFillFeature === "no fill"){
        p.outerSpiralFillVec[iterNo] = 0;
      }
      else if (p.outerSpiralFillFeature === "fill all"){
        p.outerSpiralFillVec[iterNo] = 1;
      }
      else if (p.outerSpiralFillFeature === "random"){
        p.outerSpiralFillVec[iterNo] =  R.random_int(0,1);
      }


      
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // generate vectors which only change on baseNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      p.spiralxyVecPos[iterNo] = [];
      p.spiralxyVecNeg[iterNo] = [];
      p.baseVec[iterNo] = [];      
      for (let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){
        p.baseVec[iterNo][baseNo] = p.baseStart + baseNo * p.spiralStepVec[iterNo];
        // generate p.spiralxyVecPos and p.spiralxyVecNeg!
        p.spiralxyVecPos[iterNo][baseNo] = genSpiralxyVecPos(p.baseVec[iterNo][baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lpos0Vec[iterNo],p.lposSlopeVec[iterNo],p.vertexSdVec[iterNo]);
        p.spiralxyVecNeg[iterNo][baseNo] = genSpiralxyVecNeg(p.baseVec[iterNo][baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lneg0Vec[iterNo],p.lnegSlopeVec[iterNo],p.vertexSdVec[iterNo], p.reverseSpiralVec[iterNo]);
        
      }
    }
  }

  p.setupGuiParams = function(){
    p.guiParams = {
      //big structural
      "numStrings": 7,
      "numStringsMin": 1,
      "numStringsMax": f0s_full.length, //dubious - may be circular logic. Idea here is that AW processor sets up the full mode but then only plucks the number determined on the fly by guiParams.numStrings.  The order of the f0s_ sent to AW processor can be shuffled but isn't at the moment.
      "numStringsStep": 1,
      "palNo": 6,
      "palNoMin": 0,
      "palNoMax": 6,
      "palNoStep": 1,    
      "colPalette": ["tyler","frozenFog"],
      "spiralConfig": ["latticeConfig","overlayConfig"],
      "strokeBase": 0.000075,  //reduced from originally 0.001
      "strokeBaseMin": 0.00001,
      "strokeBaseMax": 0.001,
      "strokeBaseStep": 0.00001,
      "lpos0": 0.05,
      "lpos0Min": 0.0001,
      "lpos0Max": 0.75,
      "lpos0Step": 0.0001,
      "lposSlope": 0.00,
      "lposSlopeMin": 0.0,
      "lposSlopeMax": 0.5,
      "lposSlopeStep": 0.00001,
      "lneg0": 0.0125,
      "lneg0Min": 0.0001,
      "lneg0Max": 0.75,
      "lneg0Step": 0.0001,
      "lnegSlope": 0.0,
      "lnegSlopeMin": 0.0,
      "lnegSlopeMax": 0.5,
      "lnegSlopeStep": 0.00001,
      "innerCircles": ["off","on","random"],
      "outerCircles": ["off","on","random"],
      "circleDia": 0.01,
      "circleDiaMin": 0.0,
      "circleDiaMax": 0.1,
      "circleDiaStep": 0.0001,
      "circleDiaSlope": 0.0,
      "circleDiaSlopeMin": 0.0,
      "circleDiaSlopeMax": 1,
      "circleDiaSlopeStep": 0.01,
      //medium
      "xSd": 0.0,
      "xSdMin": 0.00,
      "xSdMax": 0.1,
      "xSdStep": 0.001,      
      "innerSpiralsClosed": ["all open","all closed","random"],
      "outerSpiralsClosed": ["all open","all closed","random"],
      "innerSpiralsFill": ["no fill", "fill all","random"],
      "outerSpiralsFill": ["no fill", "fill all","random"],
      "spiralFillAlphaFactor": 1.0,
      "spiralFillAlphaFactorMin": 0.0,
      "spiralFillAlphaFactorMax": 1.0,
      "spiralFillAlphaFactorStep": 0.01,
      "scale": 3,
      "scaleMin": 0.1,
      "scaleMax": 100,
      "scaleStep": 0.1,
      "vertexSd": 0.0,
      "vertexSdMin": 0.0,
      "vertexSdMax": 0.05,
      "vertexSdStep": 0.001,     
      "adsrGain": 0.2,
      "adsrGainMin": 0.0,
      "adsrGainMax": 1.0,
      "adsrGainStep": 0.01
    };
  }
  
  p.setupJuxtParametersGuiMode = function(){

    
    p.setupGuiParams();

    
    // ~~~~~~~~~~~~~~~~~~~
    // audio param set up - short for now!
    // ~~~~~~~~~~~~~~~~~~~
    //window.adsrGain = p.guiParams["adsrGain"];

    
    // ~~~~~~~~~~~~~~~~~~~
    // visual param set up
    window.numStrings = p.guiParams["numStrings"];//param1; //7; //R.random_int(7,17); //numStrings;
    // ~~~~~~~~~~~~~~~~~~~

    // select window.numStrings number of notes from mode 
    f0s_ = f0s_full.slice(0,window.numStrings); // f0s_ needed by pluck function, should ensure only numStrings are being plucked at any given time



    // not sure if this next bit re xSd/ySd stays...
    p.xSdVec = p.shuffleVec.map(()=>{return p.guiParams["xSd"]});
    p.ySdVec = p.shuffleVec.map(()=>{return p.guiParams["xSd"]});

    
    // SET UP all probabilistic arrays for this minting, such that GUI "numStrings" param can then access some or all of these array values
    // ##########
    // refactored
//    p.vertexSdVec = p.shuffleVec.map(()=>{return 0.01});//[0, R.random_num(0,0.05)];
//    p.xSdVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.01, 0.05, 1.16)});
//    p.ySdVec = p.shuffleVec.map(()=>{return R.random_pareto_bounded(0.01, 0.05, 1.16)});
    p.spiralStepVec = p.shuffleVec.map(()=>{return  R.random_pareto_bounded(0.02, 0.2, 1.16)});
    p.scaleVec = p.shuffleVec.map(()=>{return  R.random_pareto_bounded(5, 15, 1.16)});
    p.startAngle = p.shuffleVec.map(()=>{return R.random_choice(p.startAngleVec)}); 
    p.endAngle = p.shuffleVec.map(()=>{return R.random_choice(p.endAngleVec)});
    p.reverseSpiralVec = p.shuffleVec.map(()=>{return R.random_choice([0,0,0,0,1])}); //20% likelihood of reverse
    p.spiralConfigVec = p.shuffleVec.map(()=>{return R.random_choice(["overlayConfig"])})
    //revisit vals in 6 subsequent distribs - currently a coin toss for each, not what I want eventually! Base on GUI tuning....
    p.innerSpiralCloseVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])});  
    p.outerSpiralCloseVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])});
    p.innerCirclesVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])});
    p.outerCirclesVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])}); 
//    p.innerSpiralFillVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])});
//    p.outerSpiralFillVec = p.shuffleVec.map(()=>{return R.random_choice([0,1])});
    // ##########


    

    

    // ####################
    // SET UP xvec and yvec (REFACTORED)
    // NOTE that the for loop is up to maxNoSpirals, while loop below in next section take "numStrings" on the fly from GUI - ie this next loop is NOT copied into updateJuxtParameterGuiMode().
    // xvec and yvec IS allocated in the GUI update function!
    p.xmean_all = R.random_choice(p.xmeanVec);
    p.ymean_all = R.random_choice(p.ymeanVec);
    
    for (let iterNo = 0; iterNo < maxNoSpirals; iterNo++){  //NOTE Changed this from GuiParames["numStringsMax"]

      // edit 24.01.23 (original commented)
      p.xmean[iterNo] = p.meanPosVec[iterNo][0]; //R.random_choice(p.xmeanVec);
      p.ymean[iterNo] = p.meanPosVec[iterNo][1]; //R.random_choice(p.ymeanVec);

      // default is to allocate lattice mode to p.xmean and p.ymean (might change naming scheme if more than 2 configs later!)
//      p.xmean[iterNo] = p.xmean_all;
//      p.ymean[iterNo] = p.ymean_all;
      
      p.baseN[iterNo] = (p.baseEnd - p.baseStart)/p.spiralStepVec[iterNo];
      
      p.xvec_latticeConfig[iterNo] = [];
      p.yvec_latticeConfig[iterNo] = [];
      p.xvec_overlayConfig[iterNo] = [];
      p.yvec_overlayConfig[iterNo] = [];      
      for(let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){
        // set up "lattice" config (this config is the default / most likely)
        p.xvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.xmean[iterNo], p.xSdVec[iterNo]);
        p.yvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.ymean[iterNo], p.ySdVec[iterNo]);
        // set up "spiral overlay" config once here to avoid calling R.random_gaussian in GUI update function
        p.xvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.xmean_all, p.xSdVec[iterNo]);
        p.yvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.ymean_all, p.ySdVec[iterNo]);
        
      }
      
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // SET UP xvec and yvec (REFACTORED)
    // NOTE 1 - could possibly update p.spiralConfigVec but seems overkill now - reserve for option of mixing configs across iterNo...
    // NOTE 2 - this if / else conditional is copied in Gui update below, tho without the random bits in the for loop immediately above
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(p.guiParams["spiralConfig"] === "latticeConfig"){
      p.xvec = p.xvec_latticeConfig;
      p.yvec = p.yvec_latticeConfig
    }
    else if (p.guiParams["spiralConfig"] === "overlayConfig"){
      p.xvec = p.xvec_overlayConfig;
      p.yvec = p.yvec_overlayConfig
    }



    

    // ###########################

    
    // SET UP colour vectors p.bgCol
    // possibly move into a single vector with p.col later, not sure if it helps logic or performance so leaving as an possible optimisation later!
    p.bgCol = p.bgColVec[p.guiParams["palNo"]];


    p.spiralFillAlphaFactor = p.guiParams["spiralFillAlphaFactor"];
    

    for (let iterNo = 0; iterNo < p.guiParams["numStrings"]; iterNo++){

      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // SET UP vectors which only change on iterNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      // SET UP colour vectors p.col
      p.col[iterNo] = [p.sColVec_selected[p.guiParams["palNo"]][iterNo][0], p.sColVec_selected[p.guiParams["palNo"]][iterNo][1], p.sColVec_selected[p.guiParams["palNo"]][iterNo][2], amplitudeAmplifier(window.stringAmplitudes[iterNo],3)];


      // SET UP param vectors which are independent of "binary-ish" / "drop-down" options
      p.scaleVec[iterNo] = p.guiParams["scale"];
      p.vertexSdVec[iterNo] = p.guiParams["vertexSd"];
      p.lposSlope[iterNo] = p.guiParams["lposSlope"];
      p.lnegSlope[iterNo] = p.guiParams["lnegSlope"];      
      p.outerCircleDiaVec[iterNo] = p.guiParams["circleDia"];
      p.outerCircleDiaSlopeVec[iterNo] = p.guiParams["circleDiaSlope"];
      p.innerCircleDiaVec[iterNo] = p.guiParams["circleDia"];
      p.innerCircleDiaSlopeVec[iterNo] = p.guiParams["circleDiaSlope"];            
      
      // strokeWeight 
      p.strokeMin = p.guiParams["strokeBase"];
      // stroke-weight for various steps between spiral arms
      if (p.spiralStepVec[iterNo] <= 0.01 && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*10}//0.001}//0.0007}//0.0005}  
      else if ((p.spiralStepVec[iterNo] > 0.01 && p.spiralStepVec[iterNo] < 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*15}//0.0015}//0.001}//0.001}
      else if ((p.spiralStepVec[iterNo] > 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*25}//0.0025}//0.002}//0.003}//0.001}
      else {p.sWeightVec[iterNo] = p.strokeMin*15};//0.0015};//0.0005};  //changed from 0.00005


      // ~~~~~~~~~~~~~~~~~~~~
      // binary-ish options...
      // ~~~~~~~~~~~~~~~~~~~~
      if(p.guiParams["innerCircles"] === "off"){
        p.innerCirclesVec[iterNo] = 0;
        p.lneg0[iterNo] = p.guiParams["lneg0"];
      }
      else if (p.guiParams["innerCircles"] === "on"){
        p.innerCirclesVec[iterNo] = 1;
        p.lneg0[iterNo] = p.guiParams["lneg0"]*p.lneg0CircleFactor;
      }
      else if (p.guiParams["innerCircles"] === "random"){
        p.innerCirclesVec[iterNo] = p.innerCirclesVec[iterNo];
        }

      if(p.guiParams["outerCircles"] === "off"){
        p.outerCirclesVec[iterNo] = 0;
        p.lpos0[iterNo] = p.guiParams["lpos0"];
      }
      else if (p.guiParams["outerCircles"] === "on"){
        p.outerCirclesVec[iterNo] = 1;
        p.lpos0[iterNo] = p.guiParams["lpos0"]*p.lpos0CircleFactor;
      }
      else if (p.guiParams["outerCircles"] === "random"){
        p.outerCirclesVec[iterNo] = p.outerCirclesVec[iterNo];
      }

      
      if(p.guiParams["innerSpiralsClosed"] === "all open"){
        p.innerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.guiParams["innerSpiralsClosed"] === "all closed"){
        p.innerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.guiParams["innerSpiralsClosed"] === "random"){
        p.innerSpiralCloseVec[iterNo] = p.innerSpiralCloseVec[iterNo];
        }
      
      if(p.guiParams["outerSpiralsClosed"] === "all open"){
        p.outerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.guiParams["outerSpiralsClosed"] === "all closed"){
        p.outerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.guiParams["outerSpiralsClosed"] === "random"){
        p.outerSpiralCloseVec[iterNo] = p.outerSpiralCloseVec[iterNo];
        }


      if(p.guiParams["innerSpiralsFill"] === "no fill"){
        p.innerSpiralFillVec[iterNo] = 0;
      }
      else if (p.guiParams["innerSpiralsFill"] === "fill all"){
        p.innerSpiralFillVec[iterNo] = 1;
      }
      else if (p.guiParams["innerSpiralsFill"] === "random"){
        p.innerSpiralFillVec[iterNo] = p.innerSpiralFillVec[iterNo];
      }
      
      if(p.guiParams["outerSpiralsFill"] === "no fill"){
        p.outerSpiralFillVec[iterNo] = 0;
      }
      else if (p.guiParams["outerSpiralsFill"] === "fill all"){
        p.outerSpiralFillVec[iterNo] = 1;
      }
      else if (p.guiParams["outerSpiralsFill"] === "random"){
        p.outerSpiralFillVec[iterNo] = p.outerSpiralFillVec[iterNo];
      }

      
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // SET UP vectors which only change on baseNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      p.spiralxyVecPos[iterNo] = [];
      p.spiralxyVecNeg[iterNo] = [];
      for (let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){

        p.baseVec[baseNo] = p.baseStart + baseNo * p.spiralStepVec[iterNo];

        // generate p.spiralxyVecPos and p.spiralxyVecNeg!
        p.spiralxyVecPos[iterNo][baseNo] = genSpiralxyVecPos(p.baseVec[baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lpos0[iterNo], p.lposSlope[iterNo], p.vertexSdVec[iterNo]);

        p.spiralxyVecNeg[iterNo][baseNo] = genSpiralxyVecNeg(p.baseVec[baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lneg0[iterNo], p.lnegSlope[iterNo], p.vertexSdVec[iterNo], p.reverseSpiralVec[iterNo]);
        
      }
    }
  }


  p.updateJuxtParametersGuiMode = function(){

    // contains no explicit random functions - just updates juxtParams hashMap with values predefined during setup
    // NOTE - exception is implicit call to random function via genSpiralxyVecPos, affecting p.spiralSdVec - this seems unavoidable for GuiMode, or at least ALARP with no down-side to MintMode


    // ~~~~~~~~~~~~~~~~~~~
    // audio param updates - short for now!
    window.adsrGain = p.guiParams["adsrGain"];
    // ~~~~~~~~~~~~~~~~~~~
    

    // ~~~~~~~~~~~~~~~~~~~
    // visual param updates
    // ~~~~~~~~~~~~~~~~~~~
    window.numStrings = p.guiParams["numStrings"];

    // select window.numStrings number of notes from mode 
    f0s_ = f0s_full.slice(0,window.numStrings); // f0s_ needed by pluck function, should ensure only numStrings are being plucked at any given time

    // generate colour vectors p.bgCol
    // possibly move into a single vector with p.col later, not sure if it helps logic or performance so leaving as an possible optimisation later!
    p.bgCol = p.bgColVec[p.guiParams["palNo"]];


    p.spiralFillAlphaFactor = p.guiParams["spiralFillAlphaFactor"];





    // not sure if this next bit re xSd/ySd stays...
    p.xSdVec = p.shuffleVec.map(()=>{return p.guiParams["xSd"]});
    p.ySdVec = p.shuffleVec.map(()=>{return p.guiParams["xSd"]});

        // ####################
    // UPDATE xvec and yvec (REFACTORED), only changing xSdVec and ySdVec, not touching xmean ymean etc!!!!!  Not ideal that it'll shimmer but best I can do, as with vertexSd as a GUI param :)
    // NOTE that the for loop is up to maxNoSpirals, while loop below in next section take "numStrings" on the fly from GUI - ie this next loop is NOT copied into updateJuxtParameterGuiMode().
    // xvec and yvec IS allocated in the GUI update function!

    //p.xmean_all = R.random_choice(p.xmeanVec);
    //p.ymean_all = R.random_choice(p.ymeanVec);
    
    for (let iterNo = 0; iterNo < maxNoSpirals; iterNo++){  //NOTE Changed this from GuiParames["numStringsMax"]
      //p.xmean[iterNo] = R.random_choice(p.xmeanVec);
      //p.ymean[iterNo] = R.random_choice(p.ymeanVec);

      p.baseN[iterNo] = (p.baseEnd - p.baseStart)/p.spiralStepVec[iterNo];
      
      p.xvec_latticeConfig[iterNo] = [];
      p.yvec_latticeConfig[iterNo] = [];
      p.xvec_overlayConfig[iterNo] = [];
      p.yvec_overlayConfig[iterNo] = [];      
      for(let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){
        // set up "lattice" config (this config is the default / most likely)
        p.xvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.xmean[iterNo], p.xSdVec[iterNo]);
        p.yvec_latticeConfig[iterNo][baseNo] = R.random_gaussian(p.ymean[iterNo], p.ySdVec[iterNo]);
        // set up "spiral overlay" config once here to avoid calling R.random_gaussian in GUI update function
        p.xvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.xmean_all, p.xSdVec[iterNo]);
        p.yvec_overlayConfig[iterNo][baseNo] = R.random_gaussian(p.ymean_all, p.ySdVec[iterNo]);
        
      }
      
    }
    

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // UPDATE xvec and yvec (REFACTORED)
    // NOTE - could possibly update p.spiralConfigVec but seems overkill now - reserve for option of mixing configs across iterNo...
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(p.guiParams["spiralConfig"] === "latticeConfig"){
      p.xvec = p.xvec_latticeConfig;
      p.yvec = p.yvec_latticeConfig
    }
    else if (p.guiParams["spiralConfig"] === "overlayConfig"){
      p.xvec = p.xvec_overlayConfig;
      p.yvec = p.yvec_overlayConfig
    }
      

    // ~~~~~~~~~~~~~~~~
    // main update loop
    // ~~~~~~~~~~~~~~~~
    for (let iterNo = 0; iterNo < p.guiParams["numStrings"]; iterNo++){

      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // UPDATE vectors which only change on iterNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      // UPDATE colour vectors p.col
      p.col[iterNo] = [p.sColVec_selected[p.guiParams["palNo"]][iterNo][0], p.sColVec_selected[p.guiParams["palNo"]][iterNo][1], p.sColVec_selected[p.guiParams["palNo"]][iterNo][2], amplitudeAmplifier(window.stringAmplitudes[iterNo],3)];

      // UPDATE param vectors which are independent of "binary-ish" / "drop-down" options
      p.scaleVec[iterNo] = p.guiParams["scale"];
      p.vertexSdVec[iterNo] = p.guiParams["vertexSd"];
      p.xSdVec[iterNo] = p.guiParams["xSd"];
      p.ySdVec[iterNo] = p.guiParams["xSd"];            
      p.lposSlope[iterNo] = p.guiParams["lposSlope"];
      p.lnegSlope[iterNo] = p.guiParams["lnegSlope"];      
      p.outerCircleDiaVec[iterNo] = p.guiParams["circleDia"];
      p.outerCircleDiaSlopeVec[iterNo] = p.guiParams["circleDiaSlope"];
      p.innerCircleDiaVec[iterNo] = p.guiParams["circleDia"];
      p.innerCircleDiaSlopeVec[iterNo] = p.guiParams["circleDiaSlope"];            

      
      // strokeWeight 
      p.strokeMin = p.guiParams["strokeBase"];
      // stroke-weight for various steps between spiral arms
      if (p.spiralStepVec[iterNo] <= 0.01 && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*10}//0.001}//0.0007}//0.0005}  
      else if ((p.spiralStepVec[iterNo] > 0.01 && p.spiralStepVec[iterNo] < 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*15}//0.0015}//0.001}//0.001}
      else if ((p.spiralStepVec[iterNo] > 0.05) && p.vertexSdVec[iterNo] <= 0.01){
        p.sWeightVec[iterNo] = p.strokeMin*25}//0.0025}//0.002}//0.003}//0.001}
      else {p.sWeightVec[iterNo] = p.strokeMin*15};//0.0015};//0.0005};  //changed from 0.00005

      
      // ~~~~~~~~~~~~~~~~~~~~
      // binary-ish options...
      // ~~~~~~~~~~~~~~~~~~~~      
      if(p.guiParams["innerCircles"] === "off"){
        p.innerCirclesVec[iterNo] = 0;
        p.lneg0[iterNo] = p.guiParams["lneg0"];
      }
      else if (p.guiParams["innerCircles"] === "on"){
        p.innerCirclesVec[iterNo] = 1;
        p.lneg0[iterNo] = p.guiParams["lneg0"]*p.lneg0CircleFactor;
      }
      else if (p.guiParams["innerCircles"] === "random"){
        p.innerCirclesVec[iterNo] = p.innerCirclesVec[iterNo];
        }

      if(p.guiParams["outerCircles"] === "off"){
        p.outerCirclesVec[iterNo] = 0;
        p.lpos0[iterNo] = p.guiParams["lpos0"];
      }
      else if (p.guiParams["outerCircles"] === "on"){
        p.outerCirclesVec[iterNo] = 1;
        p.lpos0[iterNo] = p.guiParams["lpos0"]*p.lpos0CircleFactor;
      }
      else if (p.guiParams["outerCircles"] === "random"){
        p.outerCirclesVec[iterNo] = p.outerCirclesVec[iterNo];
      }

      
      if(p.guiParams["innerSpiralsClosed"] === "all open"){
        p.innerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.guiParams["innerSpiralsClosed"] === "all closed"){
        p.innerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.guiParams["innerSpiralsClosed"] === "random"){
        p.innerSpiralCloseVec[iterNo] = p.innerSpiralCloseVec[iterNo];
        }
      
      if(p.guiParams["outerSpiralsClosed"] === "all open"){
        p.outerSpiralCloseVec[iterNo] = 0;
      }
      else if (p.guiParams["outerSpiralsClosed"] === "all closed"){
        p.outerSpiralCloseVec[iterNo] = 1;
      }
      else if (p.guiParams["outerSpiralsClosed"] === "random"){
        p.outerSpiralCloseVec[iterNo] = p.outerSpiralCloseVec[iterNo];
        }


      if(p.guiParams["innerSpiralsFill"] === "no fill"){
        p.innerSpiralFillVec[iterNo] = 0;
      }
      else if (p.guiParams["innerSpiralsFill"] === "fill all"){
        p.innerSpiralFillVec[iterNo] = 1;
      }
      else if (p.guiParams["innerSpiralsFill"] === "random"){
        p.innerSpiralFillVec[iterNo] = p.innerSpiralFillVec[iterNo];
      }
      
      if(p.guiParams["outerSpiralsFill"] === "no fill"){
        p.outerSpiralFillVec[iterNo] = 0;
      }
      else if (p.guiParams["outerSpiralsFill"] === "fill all"){
        p.outerSpiralFillVec[iterNo] = 1;
      }
      else if (p.guiParams["outerSpiralsFill"] === "random"){
        p.outerSpiralFillVec[iterNo] = p.outerSpiralFillVec[iterNo];
      }

      
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // UPDATE vectors which only change on baseNo
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      p.spiralxyVecPos[iterNo] = [];
      p.spiralxyVecNeg[iterNo] = [];
      for (let baseNo = 0; baseNo < p.baseN[iterNo]; baseNo++){

        p.baseVec[baseNo] = p.baseStart + baseNo * p.spiralStepVec[iterNo];

        // generate p.spiralxyVecPos and p.spiralxyVecNeg!
        p.spiralxyVecPos[iterNo][baseNo] = genSpiralxyVecPos(p.baseVec[baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lpos0[iterNo], p.lposSlope[iterNo], p.vertexSdVec[iterNo]);

        p.spiralxyVecNeg[iterNo][baseNo] = genSpiralxyVecNeg(p.baseVec[baseNo], p.startAngle[iterNo], p.endAngle[iterNo], p.scaleVec[iterNo], p.lneg0[iterNo], p.lnegSlope[iterNo], p.vertexSdVec[iterNo], p.reverseSpiralVec[iterNo]);
        
      }
    }
  }

  // TO DO - insert gClosure buzness.....
  p.genMainMap = function(){
    // #######################
    // key refactoring step...
    p.juxtParametersMap =
      {
        "numStrings": window.numStrings,
        "palette": {
          "col": p.col,
          "bgCol": p.bgCol
        },
        "scaleVec": p.scaleVec,
        "sWeightVec": p.sWeightVec,
        "xvec": p.xvec,
        "yvec": p.yvec,
        "vertexSdVec": p.vertexSdVec,
        "spiralFillAlphaFactor": p.spiralFillAlphaFactor,
        "+ve": {
          "spiralxyVec": p.spiralxyVecPos,
          "circles": p.outerCirclesVec,
          "spiralClose": p.outerSpiralCloseVec,
          "spiralFill": p.outerSpiralFillVec,
          "circleDia": p.outerCircleDiaVec,
          "circleDiaSlope": p.outerCircleDiaSlopeVec
        },
        "-ve": {
          "spiralxyVec": p.spiralxyVecNeg,
          "circles": p.innerCirclesVec,
          "spiralClose": p.innerSpiralCloseVec,
          "spiralFill": p.innerSpiralFillVec,
          "circleDia": p.innerCircleDiaVec,
          "circleDiaSlope": p.innerCircleDiaSlopeVec
        }
      };
    // #######################
  }

  
  // !!!!! P5JS SETUP() !!!!!
  let aratio = PHI;
  p.setup = function() {
    //p.setupParams();  weirdly this only results in one spiral being drawn
    p.createCanvas(DIM, aratio*DIM);
    p.colorMode(p.HSB, 360, 100, 100, 1);
    p.frameRate(60); //possibly reduce later but have as my benchmark for good performance on range of architectures (desktop/mobile) for now

    // #############
    // refactored...
    if(guiMode){
      p.setupJuxtParametersGuiMode();
      p.genMainMap();
      p.gui = p.createGui(w(1.1),h(0),this,"juxt-GUI");
      p.gui.addObject(p.guiParams);
    }
    else{
      p.setupJuxtParameters();
      p.genMainMap();
      p.bgCol = p.juxtParametersMap["palette"]["bgCol"];
    }

    console.log("p.juxtParametersMap = ", p.juxtParametersMap);

    // #############
    
  }

  
  
  // !!!!! P5JS DRAW() !!!!!
  p.draw = function() {

    if(guiMode){
      p.updateJuxtParametersGuiMode();
      p.genMainMap();
    }

    // refresh background colour
    p.bgCol = p.juxtParametersMap["palette"]["bgCol"];
    p.background(p.bgCol);



    if(guiMode){
      //GUI MODE  CHECK ON LATTICE VERTS!
      let sargamCol = [
        [0,100,100,1],
        [30,100,100,1],
        [60,100,100,1],
        [90,100,100,1],
        [120,100,100,1],
        [150,100,100,1],
        [180,100,100,1],
        [0,100,100,1]];
      let sargamTxt = ["sa","re","ga","ma","pa","kdha","ni","sa"];
      
      for(let iterNo = 0; iterNo < 8; iterNo++){
        p.fill(sargamCol[iterNo]);
        p.ellipse(w(p.meanPosVec[iterNo][0]), h_(p.meanPosVec[iterNo][1]), w(0.05),w(0.05));
        p.fill([0,100,0,1]);
        p.text(sargamTxt[iterNo],w(p.meanPosVec[iterNo][0]), h_(p.meanPosVec[iterNo][1]), w(0.05),w(0.05));
      }
    }

    
    
    vertCounter = 0; //reset

    for (let i = 0; i < p.juxtParametersMap["numStrings"]; i++)
    {
      p.pct[i] = [];
      for (let baseNo = 0; baseNo < p.baseN[i]; baseNo++){
        p.pct[i][baseNo] = amplitudeAmplifier(window.stringAmplitudes[i],3); // scaffolding there to vary as fn of baseNo, not done for now
        // draw spiral for positive theta values
        p.drawSpiralRefactored(p.juxtParametersMap, "+ve", i, baseNo, p.pct[i][baseNo]);

        // draw spiral for negative theta values
        p.drawSpiralRefactored(p.juxtParametersMap, "-ve", i, baseNo, p.pct[i][baseNo]);
      }
//      console.log("Number of vertices = ", vertCounter,"\nPerctage reduction from constant lpos = ", vertCounter/25493*100,"%");
    }

    p.drawMap();

//    p.saveThumb(); // DURING DEVELOPMENT

    p.drawStringAmplitudes();
    
  }


  p.drawStringAmplitudes = function(){

    for (let s = 0; s < f0s_full.length; s++){

      // remove 1st element from start, then add current strings amplitude to the end
      p.stringAmps[s] = p.stringAmps[s].slice(1);
      p.stringAmps[s].push(window.stringAmplitudes[s]);
//      p.stringAmps[s].push(window.stringVibrations[s]);      
      p.noFill();
      p.stroke([40*s,100,50,1.0]);
      p.strokeWeight(w(0.01));
      p.beginShape();
      for(let i = 0; i < p.stringAmps[s].length; i++){
         p.vertex(w(i/(p.stringAmps[s].length)),5*h_(p.stringAmps[s][i]));
      }
      p.endShape();

    }

  }

  
  p.saveThumb = function(){
    if(p.saveFlag)
      p.save(tokenData.hash+".png");
    p.saveFlag = 0;
  }

  p.drawMap = function(){
    let mapGapx = Math.pow((PHI-1),7);
    let mapGapy = mapGapx
    p.fill(p.bgCol);
    p.noStroke();
    p.beginShape();
    p.vertex(w(0),h(0));
    p.vertex(w(1),h(0));
    p.vertex(w(1),h(aratio));
    p.vertex(w(0),h(aratio));
    p.beginContour();
    p.vertex(w(mapGapx),h(mapGapy));
    p.vertex(w(mapGapx),h(aratio-mapGapy));
    p.vertex(w(1-mapGapx),h(aratio-mapGapy));
    p.vertex(w(1-mapGapx),h(mapGapy));
    p.endContour();
    p.endShape(p.CLOSE);
  }


  
  /**
   * drawSpiralRefactored
   * @param {Object} juxtParams hash-map of all params! (could make type more specific by using {Object<string,number>} ref https://github.com/google/closure-compiler/wiki/Types-in-the-Closure-Type-System)
   * @param {number} spiralNo usually each spiral "family" is associated with a specific stringNo, but generalising is good as I may want to draw more spiral families than there are strings
   * @param {number} baseNo number of the curve within spiral family
   * @param {number=} pct Default 1.0
   //   * @param {number=} circles Default 1
   //   * @param {number=} spiralClose Default 0
   //   * @param {number=} spiralFill Default 0
   */
  p.drawSpiralRefactored = function(juxtParams, posnegKey, spiralNo, baseNo, pct) {
    
    // ##########
    // refactored
    let spiralVerts = juxtParams[posnegKey]["spiralxyVec"][spiralNo][baseNo];
    let scale = juxtParams["scaleVec"][spiralNo][baseNo]; //baseNo redundant hopefully no performance impact, allows for change in scale per baseNo later! NOT USED ANYWHERE IN THIS DRAWSPIRALREFACTORED FUNCTION (except in commented out line)!!! MAINTAIN IN JUSTPARAMS FOR FUTURE PROOFING, METADATA REPORTING, AND QAQC
    let col = juxtParams["palette"]["col"][spiralNo];//baseNo redundant as above! also leads to error as col has 4 elements corresponding to HSBA
    let x = juxtParams["xvec"][spiralNo][baseNo];
    let y = juxtParams["yvec"][spiralNo][baseNo];
    let vertexSd = juxtParams["vertexSdVec"][spiralNo]; //[baseNo]; NOT USED ANYWHERE IN THE DRAWSPIRALREFACTORED FUNCTION (except in commented out line)!!! MAINTAIN IN JUSTPARAMS FOR FUTURE PROOFING, METADATA REPORTING, AND QAQC
    let sWeight0 = juxtParams["sWeightVec"][spiralNo];
    let circles = juxtParams[posnegKey]["circles"][spiralNo];//[baseNo]; // baseNo is currently redundant and may well cause problems !
    let spiralClose = juxtParams[posnegKey]["spiralClose"][spiralNo];//[baseNo];
    let spiralFill = juxtParams[posnegKey]["spiralFill"][spiralNo];//[baseNo];
    let dia = juxtParams[posnegKey]["circleDia"][spiralNo];
    let diaSlope = juxtParams[posnegKey]["circleDiaSlope"][spiralNo];
    // ##########


    
    let spiralLength;
    // let v = [R.random_gaussian(s[0], vertexSd)/scale, R.random_gaussian(s[1], vertexSd)/scale];
    let sWeight
    let sWeightSlope;
    let fillCol = [col[0],col[1],col[2],pct*juxtParams["spiralFillAlphaFactor"]]
    let spiralCol = [col[0],col[1],col[2],pct];


    if(spiralFill){
      p.fill(fillCol);
      p.noStroke();
    }
    else{
      p.noFill();
      p.stroke(spiralCol);
    }
    
    switch(circles)
    {
      case 0:
      sWeight =  sWeight0;// 0.001;// 0.0003;//0.0000001;
      sWeightSlope = 0;//weight/500;  //TUNING TBD!!!
      spiralLength = spiralVerts.length;
      break;
      case 1:
      sWeight =  sWeight0; // wt/100 //TUNING TBD!!!
      sWeightSlope = 0;  //TUNING TBD!!!
      spiralLength = spiralVerts.length - 1; //remove straight edge for circles
      break;
    }
    p.push();
    p.translate(w(x),h_(y));
    p.beginShape()
    for (let i = 0; i < spiralLength*pct; i++){  // pct SO important here!!!
      let v = spiralVerts[i];
      p.strokeWeight(w(sWeight + sWeightSlope*i));
      switch(circles)
      {
        case 0:
        p.curveVertex(w(v[0]), h(v[1]));
//        p.vertex(w(v[0]), h(v[1]));
        // p.ellipse(w(v[0]), h(v[1]), w(dia),w(dia)); 
        vertCounter++;      
        break;
        case 1:
        p.ellipse(w(v[0]), h(v[1]),w(dia + diaSlope*i),w(dia + diaSlope*i));
//        p.myCircle(v[0], v[1],(dia + diaSlope*i),25);
//        p.ardmore(v[0], v[1],0.001);
        vertCounter++;      
        break;
      }
    }
    // this if else statement makes a MASSIVE difference to the viusals!!!!!!!!!
    if(spiralClose)
      p.endShape(p.CLOSE);
    else
      p.endShape();
//    p.translate(w(-x),h_(-y));
    p.pop();
  }

  p.myCircle = function(x,y,r,n){

    let myCircleVertices = [];
    
    for (let i = 0; i <= n; i++) {
      let u = i / n;
      let theta = 2 * PI * u;
      let _x =  r * Math.cos(theta);
      let _y =  r * Math.sin(theta);
      myCircleVertices.push([_x, _y]);
    }
    p.push();
    p.translate(w(x),h(y));
    p.beginShape();
    for (let i = 0; i < myCircleVertices.length; i++){
      p.vertex(w(myCircleVertices[i][0]),h(myCircleVertices[i][1]));
    }
    p.endShape(p.CLOSE);
    p.pop();
//    p.ellipse(w(x), h(y),w(r),w(r));
  }

  p.ardmore = function(x,y,scale){

    let flagVertices = [];

    flagVertices.push([-1.0,1.0]);
    flagVertices.push([-1.0,1.0]);
    flagVertices.push([1.0,1.0]);
    flagVertices.push([1.0,-1.0]);
    flagVertices.push([-1.0,-1.0]);
    flagVertices.push([-1.0,-1.0]);        

    p.scale(scale);
    p.push();
    p.translate(w(x),h(y));
    p.beginShape();
    for (let i = 0; i < flagVertices.length; i++){
      p.curveVertex(w(flagVertices[i][0]),h(flagVertices[i][1]));
    }
    p.endShape();
    p.pop();
  }

  
}


new p5(juxtSketch,"juxtSketch");



// #################
// audio
// #################

// moved next two to the top, to be safe, given they are globals used in the visual part!
//window.stringAmplitudes = new Array(f0s_full.length).fill(1); //dubious again - circular????
//window.stringVibrations = new Array(f0s_full.length).fill(0);

let audioContext = null;


// mode palette - MOVED TO VERY TOP!!!!!!
//let sa = 351.2*7/8;
//var f0s_full = [sa, sa*6/5, sa*3/2, sa*8/5, sa*9/5, sa*2, sa*12/5];
//let f0s_ = [sa];  // set within p5 draw fn


// pluck parameters
// var adsr_ = [100,100]; // ad for now!
// var pluckGain_ = 0.1;


/**
 * @return AudioWorkletNode;
 */
sketch.createMyInstrumentProcessor = async function() {
  if (!audioContext) {
    try {
      audioContext = new AudioContext();
    } catch(e) {
      // console.log("** Error: Unable to create audio context");
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
          "f0s_": f0s_full //changed from f0s_ for GUI version
        }
      }
    );
  } catch(e) {
    try {
      // console.log("adding instrument-processor...")
      await audioContext.audioWorklet.addModule("js/instrument-processor-compiled.js");
      myInstrumentNode = new AudioWorkletNode(
        audioContext,
        "instrument-processor",
        {
          processorOptions: {
            "f0s_": f0s_full
          }
        });
    } catch(e) {
      // console.log(`** Error: Unable to create myInstrumentNode worklet node: ${e}`);
      return null;
    }
  }
  await audioContext.resume();
  return myInstrumentNode;
}

sketch.audioStart = async function() {
  var harpNode = await sketch.createMyInstrumentProcessor();
  if (!harpNode) {
    // console.log("** Error: unable to create AW processor");
    return;
  }  

  // Connect and start
  harpNode.connect(audioContext.destination);

  // comms from processor
  harpNode.port.onmessage = (event) => {
    if(event.data["msg"] === "analysis"){
      window.stringAmplitudes[event.data["stringno"]] = event.data["amplitude"];
      window.stringVibrations[event.data["stringno"]] = event.data["vibration"];
      window.stringNum = event.data["stringno"];
    }
  }

  // comms to processor
  // post pluck message to processor
  // TO DO: convert to google closure format
   var pluck = function(stringnum, noiseArr, adsr, gain){
    harpNode.port.postMessage({
      "type": "play",
      "stringnum": stringnum,
      "noise": noiseArr,
      "adsr": adsr,
      "adsrGain": gain
    });
  }

  // ///////////////////////
  // generative composition
  // simple loop
  // TO DO: design a idiomatic, simple composition system
  // ///////////////////////

  let SR = audioContext.sampleRate;
  let adsr_ = [20,5]; // ad for now!
  let adsrGain = 0.01; //window.adsrGain; //p.guiParams["adsrGain"]; // 0.2
  let ia = Math.round(adsr_[0]/1000*SR);
  let id = Math.round(adsr_[1]/1000*SR);
  let adsrSampleLength = ia+id; // envelope length in samples


  let noiseArr = [];
  for(let i = 0; i < adsrSampleLength; i++){
    noiseArr[i] = R.random_dec();
  }

  let baseDelay = 500; // in milliseconds
  let loopDelays = [];
  let initialDelays = [1,2,3,4,5,6,7,8].map((val)=>val*1500);//[4000, 8100, 5600, 12600, 9200, 14100,3100];
  loopDelays = [19700, 17800, 21300, 22100, 18400, 20000, 17700, 33000].map( (val) => val * 1.0); //R.random_num(0.25,0.75));
  for (let stringno = 0; stringno < f0s_.length; stringno++){
    setTimeout(() => pluck(stringno, noiseArr, adsr_, adsrGain), initialDelays[stringno]);
  }
  for (let stringno = 0; stringno < f0s_.length; stringno++){ //seems f0s.length is read only once, with all setTimout commands being set once and composition is then off!  Need a more dynamic method of bringing in/out strings!!! Also of changing adsrGain!!!
    setInterval(() => {
      setTimeout(() => pluck(stringno, noiseArr, adsr_, adsrGain), R.random_num(1500,10000));
    }, loopDelays[stringno]);
  }
  
};




window.addEventListener("load", event => {
  document.getElementById("toggle").addEventListener("click", toggleSound);
});

/**
 */
var toggleSound = async function(event) {
  if (!audioContext) {
    sketch.audioStart();
  } else {
//    console.log("just switched off, f0s_full.length = ", f0s_full.length);
    window.stringAmplitudes.fill(1);
    await audioContext.close();
    audioContext = null;
  }
}

















