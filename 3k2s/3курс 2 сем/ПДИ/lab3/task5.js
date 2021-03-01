var arr = [8,4,1,4,1,0,1,4,1,5,10,9,9,1];
alert(arr);
var min = arr[0];
var max = arr[0];
var a = 0;
var b = 0;
for (var i = 0; i < arr.length; i++) {
  if (min>arr[i]) {
      min = arr[i];
      a = i;
  }
  if (max<arr[i]) {
      max = arr[i];
      b = i;
  }
}
if (a>b) {
    t = a;
    a = b;
    b = t;
}
arr.splice(a+1,b-a-1);
alert(arr);