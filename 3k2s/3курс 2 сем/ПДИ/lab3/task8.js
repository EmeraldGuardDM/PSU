function compareStr(a,b) {
    var str1 = "" + a;
    var str2 = "" + b;
    if (str1.length<str2.length) return 1;
    else return -1;
}

var str = "Самолет Машина Ковер Снег Кол Достопримечательность Компьютер";
var arr = str.split(' ');
arr.sort(compareStr);
var str = arr.join(' ');
alert( str );