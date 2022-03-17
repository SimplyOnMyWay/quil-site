goog.provide('sketch');

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

// params used to decide canvas size
// as per AB 101
var DEFAULT_SIZE = 1000
var WIDTH = window.innerWidth
var HEIGHT = window.innerHeight
var DIM = Math.min(WIDTH, HEIGHT)
var M = DIM / DEFAULT_SIZE

// relative width function, relative to canvas width
var w = function(val) {
  return width*val;
}
// relative height function, relative to canvas height
var h = function(val) {
  return height*val;
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
  let thetaVec = [];
  let rVec = [];
  let spiralxyVec = [];
  //note <=, without this small numberVertices values result in endAngle not being quite reached 
  for (let i = 0; i <= numberVertices; i++) {
    thetaVec[i] = startAngle + step*i;
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
  }
  endShape();
  translate(w(-x),h(-y));
}


setup = function() {
  createCanvas(DIM, DIM);
  colorMode(HSB, 360, 100, 100, 1);
}

draw = function() {
  noLoop();
  noFill();
  //noStroke();
  //fill(0, 50, 20, 0.01);
  //var bgCol = [253,45,85,1.0];
  var bgCol = [48, 42, 27, 1.0];
  background(bgCol[0],bgCol[1],bgCol[2],bgCol[3]);
//  var sCol = [208, 25, 95, 1.0];
  var alpha = 0.68
  var sColVec = [[208, 65, 74, alpha],
                 [107, 60, 45, alpha],
                 [79, 83, 74, alpha],
                 [0, 76, 94, alpha]];
  var numVertices = 1500;
  var startAngle0 = 0;
  var startAngleN = -10*PI;
  var startAngleStep = -0.5*PI;
  var startAngleIndMax = (startAngleN - startAngle0)/startAngleStep;
  var endAngle0 = 1*PI;
  var endAngleN = 3*PI;
  var endAngleStep = 0.125*PI;
  var endAngleIndMax = (endAngleN - endAngle0)/endAngleStep;
  var noIter = 2;
  var sWeight;
  var startAngleVec = [0, 0, 0];
  for (let i = 3; i < startAngleIndMax + 3; i++){
    startAngleVec[i] = startAngle0 + (i - 3)*startAngleStep;
  }
  var endAngleVec = [];
  for (let i = 0; i < endAngleIndMax; i++){
    endAngleVec[i] = endAngle0 + i*endAngleStep;
  }
  console.log("endAngleVec = ",endAngleVec);

  //var scale = 20;
  //var vertexSd = 0.01;
  //var spiralStep = 0.05;
  //strokeWeight(w(0.001));
  //var xmean = 0.5;

  for (let i = 0; i < noIter; i++)
  {
    let xmeanVec = [];
    for (let i = 0; i < 15; i++){xmeanVec[i] = 0.5};
    for (let i = 15; i < 16; i++){xmeanVec[i] = PHI -1};
    for (let i = 16; i < 18; i++){xmeanVec[i] = 2 - PHI};
    let xmean = xmeanVec[R.random_int(0, (xmeanVec.length - 1))];
    console.log("xmeanVec = ",xmeanVec);
    let ymeanVec = [];
    for (let i = 0; i < 8; i++){ymeanVec[i] = 0.5};
    for (let i = 8; i < 15; i++){ymeanVec[i] = xmean};    
    for (let i = 15; i < 16; i++){ymeanVec[i] = PHI -1};
    for (let i = 16; i < 18; i++){ymeanVec[i] = 2 - PHI};
    let ymean = ymeanVec[R.random_int(0, (ymeanVec.length - 1))];
    //let xsdVec = [0, R.random_pareto_bounded(0.01, 2, 0.1)];
    let xsd = 0; //xsdVec[R.random_int(0, (xsdVec.length - 1))];
    //let ysdVec = [0, xsd/10, xsd];
    let ysd = 0; //ysdVec[R.random_int(0, (ysdVec.length - 1))];

    let startAngle = startAngleVec[R.random_int(0, (startAngleVec.length - 1))];
    let endAngle = endAngleVec[R.random_int(0, (endAngleVec.length - 1))];

    let vertexSdVec = [0, R.random_pareto_bounded(0.01, 0.1, 0.1)];
    let vertexSd = vertexSdVec[R.random_int(0, (vertexSdVec.length - 1))];
    let scaleVec = [10, R.random_pareto_bounded(5, 20, 1.16)];
    let scale = scaleVec[R.random_int(0, (scaleVec.length - 1))];
    let spiralStepVec = [0.005, R.random_pareto_bounded(0.005, 0.1, 1.16)];
    let spiralStep = spiralStepVec[R.random_int(0, (spiralStepVec.length - 1))];
    if (spiralStep <= 0.01 && vertexSd <= 0.01){
      sWeight = 0.0005}
    else if ((spiralStep > 0.01 && spiralStep < 0.05) && vertexSd <= 0.01){
    sWeight = 0.001}
    else {sWeight = 0.00005};

    let colInd = R.random_int(0, sColVec.length -1);
    stroke(sColVec[colInd][0], sColVec[colInd][1], sColVec[colInd][2], sColVec[colInd][3]);
//    stroke(sCol[0], sCol[1], sCol[2], sCol[3]);
    strokeWeight(w(sWeight));

    /*
    console.log(
      "Params... ",                              
      "\nstart-angle = ", startAngle,
      "\nend-angle = ", endAngle, 
      "\nx-mean = ", xmean,               
      "\ny-mean = ", ymean,                     
      "\nx-sd = ", xsd,                         
      "\ny-sd = ", ysd,                         
      "\nvertex-sd = ", vertexSd,               
      "\nnumber-vertices = ", numVertices,   
      "\nscale = ", scale,                       
      "\nno-iter = ", noIter,                   
      "\ns-weight = ", sWeight);
    */
    
    for (let base = 1.0; base <= PHI; base = base + spiralStep) {
      let spiralxyVec = genSpiralxyVec(base, startAngle, endAngle, numVertices);
      drawSpiral(spiralxyVec, vertexSd, scale, xmean, ymean, xsd, ysd);
    }
  }    
}


