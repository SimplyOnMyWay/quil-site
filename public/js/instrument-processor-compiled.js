function f(a,b){this.i=a;this.l=b;this.h=Array(this.i.length).fill(0);this.g=Array(this.l.length).fill(0)}f.prototype.K=function(){return this.g[0]};f.prototype.j=function(a){this.g[0]=0;this.h[0]=a;for(a=this.i.length-1;0<a;a--)this.g[0]+=this.i[a]*this.h[a],this.h[a]=this.h[a-1];this.g[0]+=this.i[0]*this.h[0];for(a=this.l.length-1;0<a;a--)this.g[0]+=-1*this.l[a]*this.g[a],this.g[a]=this.g[a-1];return this.g[0]};
function g(a,b){this.h=Array(b+1).fill(0);this.m=[0];this.i=0;a>this.h.length-1?(console.log("Delay.setDelay: argument ",a,"too big ... setting to maximum!... ",this.h.length),this.g=this.i+1,this.g==this.h.length&&(this.g=0),this.l=this.h.length-1):0>a?(console.log("whutttt?!"),this.g=this.i,this.l=0):(this.g=this.i>=a?this.i-a:this.i+this.h.length-a,this.l=a)}
g.prototype.j=function(a){this.h[this.i++]=a;this.i==this.h.length&&(this.i=0);this.m[0]=this.h[this.g++];this.g==this.h.length&&(this.g=0);return this.m[0]};function h(a,b){this.h=Array(b+1).fill(0);this.o=[0];this.m=0;let c=this.h.length;b=this.m-a+1;this.l=a;0>b&&(b+=c);this.g=Math.round(b);this.g==c&&(this.g=0);this.i=1+this.g-b;.5>this.i&&(this.g+=1,this.g>=c&&(this.g-=c),this.i+=1);this.M=(1-this.i)/(1+this.i);this.s=this.i=this.F=0;this.B=!0}h.prototype.K=function(){return this.o[0]};
h.prototype.j=function(a){this.h[this.m++]=a;this.m==this.h.length&&(this.m=0);a=this.o;this.B&&(this.s=-this.M*this.o[0],this.s+=this.F+this.M*this.h[this.g],this.B=!1);a[0]=this.s;this.B=!0;this.F=this.h[this.g++];this.g==this.h.length&&(this.g=0);return this.o[0]};function k(a){this.l=a-1;this.i=new g(this.l,this.l);this.g=[0,0];this.h=[0,0]}k.prototype.j=function(a){this.g[0]=a;this.g[1]=this.g[0]-.7*this.h[1];this.h[0]=.7*this.g[1]+this.h[1];this.h[1]=this.i.j(this.g[1]);return this.h[0]};
function l(){this.s=[1051,337,113];this.l=[4799,4999,5399,5801];this.m=.046*sampleRate;this.o=.057*sampleRate;this.i=[];this.g=[];for(var a=0;3>a;a++)this.i.push(new k(this.s[a]));for(a=0;4>a;a++)this.g.push(new g(this.l[a],this.l[a]));this.B=new g(this.m,this.m);this.F=new g(this.o,this.o);this.h=[0]}
l.prototype.j=function(a){a=this.i[0].j(a);a=this.i[1].j(a);a=this.i[2].j(a);a=.742*a+this.g[0].j(a)+.733*a+this.g[1].j(a)+.715*a+this.g[2].j(a)+.697*a+this.g[3].j(a);this.h[0]=this.B.j(a);this.h[1]=this.F.j(a);return.5*(this.h[0]+this.h[1])};let m=[0,0];function n(){this.h=.005;this.o=1;this.m=.17;this.i=0}
n.prototype.j=function(a){this.s=0==a;1==this.s?(this.target=this.i,this.g=this.m):(this.target=this.o,this.g=this.h);a=this.l=Math.exp(-1/(this.g/6.91*sampleRate));var b=[this.target];let c=[];for(let d=0;d<b.length;d++)m[0]=(1-a)*b[d]+a*m[1],c[d]=m[0],m[1]=m[0];[a]=c;return a};
var p=class extends AudioWorkletProcessor{constructor(a){super();this.port.onmessage=this.R.bind(this);this.v=0;this.J=Math.floor(sampleRate/6E3);this.P=Math.exp(Math.log(.01)/(.1*sampleRate));this.A=[];this.S=[];this.I=[];this.H=[];this.O=[];this.G=[];a=a.processorOptions.f0s_;this.u=[];this.L=[];this.D=1024;this.N=[];this.C=[];a.forEach(b=>{this.C.push(new h(sampleRate/b-1,this.D));this.L.push(new f([.99002,.53323,-.059946,.47646,.6579,.41096,.10609,.25464,.1224,.1032,.23355,.1154,.027333,.24254,
.11144,.13616,.29518,.22837,.20541,.1811,.23351,.25601,.18682,.1572,.12634,.1038,.10661,.083271,.077115,.020829,.01552],[1,.52874,-.064736,.48365,.65922,.40633,.10369,.25905,.11832,.10181,.23729,.11339,.026769,.24361,.11236,.13613,.29448,.22862,.20701,.17915,.23339,.2578,.18605,.15629,.1266,.10381,.10485,.084,.0772,.019029,.016185]));this.u.push(this.D);this.N.push(new l);this.A.push(0);this.H.push([]);this.I.push(new n)});new f([1,-1.9583,.95958],[1,-1.9983,.99915]);new f([1,-1.7944,.8077],[1,-1.9937,
.99715]);new f([1,-1.9537,.95903],[1,-1.9936,.99858]);new f([2.6493,-.34918,-1.3627,1.2731,-1.8866,.40363,-.28791,-.48267,.13639,-.64097,.53584],[1,-.64514,.49419,-.13298,.054118,-.15693,.15583,-.18782,.34938,-.30862,.29745])}};
p.prototype.R=function(a){if("play"===a.data.type){this.u[a.data.stringnum]=0;this.S[a.data.stringnum]=a.data.noise;this.O[a.data.stringnum]=a.data.adsr;this.G[a.data.stringnum]=a.data.adsrGain;a=a.data.stringnum;let b=(.005+.17)*sampleRate,c=[],d=[];for(let e=0;e<b;e++)c[e]=e<.005*sampleRate?1:0,d[e]=this.I[a].j(c[e])*this.G[a],this.H[a][e]=d[e];console.log("gate[i] = ",c);console.log("noiseBurst_ = ",d);console.log("Coming from the procesor! this.adsrGain = ",this.G)}};
p.prototype.process=function(a,b){a=b[0][0];a.fill(0);[1,1,.5,.5,.5,1,1.5].map(c=>.2*c);for(b=0;b<this.C.length;b++)for(let c=0;c<a.length;c++){const d=this.C[b].j(this.L[b].j(.999999*this.C[b].K()+(this.u[b]<this.D?this.H[b][this.u[b]]:0))),e=Math.abs(d);this.A[b]=this.P*(this.A[b]-e)+e;a[c]+=d;this.u[b]++}this.v+=a.length;if(this.v>=this.J)for(this.v%=this.J,a=0;a<this.A.length;a++)b=this.D,this.port.postMessage({msg:"analysis",amplitude:this.A[a],vibration:this.u[a]/3%b/b,stringno:a});return!0};
registerProcessor("instrument-processor",p);
