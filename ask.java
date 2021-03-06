function ask_fsk(g,f)
%Modulation  ASK
if nargin > 2
    error('demasiados argumentos')
elseif nargin==1
    f=1;
end
 
if f<1;
    error('la frecuencia debe ser mayor que 1');
end
 
t=0:2*pi/99:2*pi;
cp=[];sp=[];
mod=[];mod1=[];bit=[];
 
for n=1:length(g);
    if g(n)==0;
        die=ones(1,100);
        se=zeros(1,100);
    else g(n)==1;
        die=2*ones(1,100);
        se=ones(1,100);
    end
    c=sin(f*t);
    cp=[cp die];
    mod=[mod c];
    bit=[bit se];
end  
ask=cp.*mod;
subplot(2,1,1);plot(bit,'ancho de linea',1.5);grid on;
title('se�al binaria');
axis([0 100*length(g) -2.5 2.5]);
 
subplot(2,1,2);plot(ask,'ancho de linea',1.5);grid on;
title('ASK modulacion ');
axis([0 100*length(g) -2.5 2.5]);
