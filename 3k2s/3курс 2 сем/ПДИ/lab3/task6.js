var str = prompt("Введите строку","");
var target = prompt("Введите искомое слово","");

var pos = 0;
var count=0;
while (true) {
  var foundPos = str.indexOf(target, pos);
  if (foundPos == -1) break;

  count ++;
  pos = foundPos + 1;
}
alert("Слово: "+target+" встречается "+count+" раз");