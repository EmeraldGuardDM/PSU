var str = prompt("Введите строку","");
var str1 = prompt("Введите заменяемое слово","");
var str2 = prompt("Введите заменяющее слово","");
var arr = str.split(' ');
for(var i = 0;i<arr.length;i++){
    if (arr[i]==str1) arr[i]=str2;
}
var newstr = arr.join(' ');
alert(newstr);