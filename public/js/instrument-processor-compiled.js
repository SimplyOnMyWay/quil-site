function f(a,b){this.i=a;this.j=b;this.h=Array(this.i.length).fill(0);this.g=Array(this.j.length).fill(0)}f.prototype.I=function(){return this.g[0]};f.prototype.l=function(a){this.g[0]=0;this.h[0]=a;for(a=this.i.length-1;0<a;a--)this.g[0]+=this.i[a]*this.h[a],this.h[a]=this.h[a-1];this.g[0]+=this.i[0]*this.h[0];for(a=this.j.length-1;0<a;a--)this.g[0]+=-1*this.j[a]*this.g[a],this.g[a]=this.g[a-1];return this.g[0]};
function h(a,b){this.h=Array(b+1).fill(0);this.j=[0];this.v=0;b=this.h.length;a=this.v-a+1;0>a&&(a+=b);this.g=Math.round(a);this.g==b&&(this.g=0);this.i=1+this.g-a;.5>this.i&&(this.g+=1,this.g>=b&&(this.g-=b),this.i+=1);this.L=(1-this.i)/(1+this.i);this.A=this.i=this.K=0;this.G=!0}h.prototype.I=function(){return this.j[0]};
h.prototype.l=function(a){this.h[this.v++]=a;this.v==this.h.length&&(this.v=0);a=this.j;this.G&&(this.A=-this.L*this.j[0],this.A+=this.K+this.L*this.h[this.g],this.G=!1);a[0]=this.A;this.G=!0;this.K=this.h[this.g++];this.g==this.h.length&&(this.g=0);return this.j[0]};
var k=class extends AudioWorkletProcessor{static get parameterDescriptors(){return[]}constructor(a){super();this.o=0;this.H=Math.floor(sampleRate/6E3);this.R=Math.exp(Math.log(.01)/(.1*sampleRate));this.s=[];this.m=[];a=a.processorOptions.f0s_;this.J=[];this.B=1024;this.u=[];a.forEach(e=>{this.u.push(new h(sampleRate/e-1,this.B));this.J.push(new f([.99002,.53323,-.059946,.47646,.6579,.41096,.10609,.25464,.1224,.1032,.23355,.1154,.027333,.24254,.11144,.13616,.29518,.22837,.20541,.1811,.23351,.25601,
.18682,.1572,.12634,.1038,.10661,.083271,.077115,.020829,.01552],[1,.52874,-.064736,.48365,.65922,.40633,.10369,.25905,.11832,.10181,.23729,.11339,.026769,.24361,.11236,.13613,.29448,.22862,.20701,.17915,.23339,.2578,.18605,.15629,.1266,.10381,.10485,.084,.0772,.019029,.016185]));this.m.push(this.B);this.s.push(0)});this.M=new f([1,-1.9583,.95958],[1,-1.9983,.99915]);this.N=new f([1,-1.7944,.8077],[1,-1.9937,.99715]);this.O=new f([1,-1.9537,.95903],[1,-1.9936,.99858]);this.T=new f([2.6493,-.34918,
-1.3627,1.2731,-1.8866,.40363,-.28791,-.48267,.13639,-.64097,.53584],[1,-.64514,.49419,-.13298,.054118,-.15693,.15583,-.18782,.34938,-.30862,.29745]);this.P=Array(9*sampleRate).fill(0);this.P[0]=1;a=9*sampleRate;var b=Math.round(10*sampleRate/1E3);let c=Math.round(5*sampleRate/1E3);var d=1/b;let g=-1/c;this.C=Array(a).fill(0);for(let e=0;e<b-1;e++)this.C[e]=d*e;for(d=b;d<b+c-1;d++)this.C[d]=g*d;this.F=Array(a).fill(0);for(b=0;b<this.F.length;b++)this.F[b]=1.5*(Math.random()-.49999);this.D=Array(a);
for(a=0;a<this.D.length;a++)this.D[a]=this.O.l(this.N.l(this.M.l(this.T.l(.1*this.F[a]*this.C[a]))));this.port.onmessage=this.S.bind(this)}};k.prototype.S=function(a){"play"===a.data.type&&(this.m[a.data.stringnum]=0)};
k.prototype.process=function(a,b){a=b[0][0];a.fill(0);b=[1,1,.5,.5,.5,1,1.5].map(c=>.2*c);for(let c=0;c<this.u.length;c++)for(let d=0;d<a.length;d++){const g=this.u[c].l(this.J[c].l(.99999*this.u[c].I()+(this.m[c]<this.B?this.D[this.m[c]]:0))),e=Math.abs(g)*b[c];this.s[c]=this.R*(this.s[c]-e)+e;a[d]+=g*b[c];this.m[c]++}this.o+=a.length;if(this.o>=this.H)for(this.o%=this.H,a=0;a<this.s.length;a++)b=this.B,this.port.postMessage({msg:"analysis",amplitude:this.s[a],vibration:this.m[a]/3%b/b,stringno:a});
return!0};registerProcessor("instrument-processor",k);
