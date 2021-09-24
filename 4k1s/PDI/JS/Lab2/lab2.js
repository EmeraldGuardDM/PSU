//1

function checkAge(age) {
    return age > 18 ? alert('Пользователю больше 18 лет') : confirm('Родители разрешили?');
}

//function checkAge(age) { 
//  return age > 18 || confirm('Родители разрешили?');
//  
//}

//2
function min(a, b) {
    return a > b ? b : a;
}


//3
function pow(x, n) {
    let num = 1;
    for (var i = 0; i < n; i++) num = num * x;
    return num;
}


//4
function odd(a) {
    if (a % 2 == 0) {
        alert(a);
    } else {
        odd(+prompt("Введите число"))
    }
}

//5

function onlyNums(str) {
    if (parseInt(str).toString() == str) {
        alert(parseInt(str) * 2);
        return parseInt(str) * 2;
    } else {
        onlyNums(prompt("Введите число"))
    }
}


//6

function displayArray(arr) {
    for (var i = 0; i < arr.length; i++) {
        if (i % 2 != 0) {
            alert(arr[i]);
        }
    }
}
