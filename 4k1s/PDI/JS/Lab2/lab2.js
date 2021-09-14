//1

//одну закоментишь
function checkAge(age) { 
  return age > 18 ? true : confirm('Родители разрешили?');
}

function checkAge(age) { 
  return age > 18 || confirm('Родители разрешили?');
  
}

checkAge(20);

//2
function min(a, b) {
  return a > b ? b : a ;
}

console.log(min(50, 6))

//3
function pow(x, n) {
  let num = 1;
  for(var i = 0; i < n; i++) num = num * x;
  return num;
}

console.log(pow(2, 3))

//4
function odd(a) {
  if(a % 2 == 0) {
    alert(a);
  } else {
    odd(+prompt("Введите число"))
  }
}

odd(5);

//5

function onlyNums(str) {
  if(parseInt(str).toString() == str) {
    console.log(parseInt(str) * 2);
    return parseInt(str) * 2;
  } else {
    onlyNums(prompt("Введите число"))
  }
}

onlyNums('1a')

//6

function displayArray(arr) {
	for(var i = 0; i < arr.length; i++) {
  	if(i % 2 != 0) {
    	console.log(arr[i]);
    }
  }
}

displayArray([
11, 22, 33, 44, 55, 66, 77
])