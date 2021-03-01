function findC(a, b, c) {
	if (0.5<a*b && a*b<10){
        return Math.exp(Math.abs(a)-Math.abs(b));
    }
    if (0.1<a*b && a*b<0.5){
        return Math.sqrt(Math.abs(parseFloat(a)+(+b)));
    }
    return 2*Math.pow(b, 2);
}

var a = prompt("Введите значение a", '');
var b = prompt("Введите значение b", '');

alert( findC(a,b) );