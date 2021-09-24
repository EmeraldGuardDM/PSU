//1
function Calculator() {

    this.read = function () {
        this.a = +prompt('a?', 0);
        this.b = +prompt('b?', 0);
    }

    this.sum = function () {
        return this.a + this.b;
    }

    this.mul = function () {
        return this.a * this.b;
    }
}

function firstTask() {
    let calculator = new Calculator();
    calculator.read();

    alert("Sum = " + calculator.sum());
    alert("Mul = " + calculator.mul());
}


//2
function Accumulator(stringValue) {
    this.value = stringValue;

    this.read = function () {
        this.value += +prompt('Сколько нужно добавить?', 0);
    };
}

function secondTask() {
    let accumulator = new Accumulator(1);
    accumulator.read();
    accumulator.read();

    alert(accumulator.value);
}


//3
function random(min, max) {
    let rand = min + Math.random() * (max - min);
    return rand;
}

//4
function extractCurrencyValue(str) {
    return +str.slice(1);
}

//5
function sumInput() {
    let numbers = [];

    while (true) {
        let value = prompt("Введите число", 0);

        if (value === "Отмена" || value === null) break;

        numbers.push(+value);
    }

    let sum = 0;
    for (let number of numbers) {
        sum += number
    }
    return sum;
}


//6
function sumSalaries(salaries) {
    let sum = 0;
    for (let salary of Object.values(salaries)) {
        sum += salary;
    }
    return sum;
}

function sixthTask() {
    let salaries = {
        "Nikita": 100,
        "Fedya": 200,
        "Petya": 300
    };

    alert(sumSalaries(salaries));
}

//7
function topSalary(salaries) {
    let max = 0;
    let maxName = null;

    for (const [name, salary] of Object.entries(salaries)) {
        if (max < salary) {
            max = salary;
            maxName = name;
        }
    }

    return maxName;
}

function seventhTask() {
    let salaries = {
        "Nikita": 100,
        "Fedya": 300,
        "Petya": 200
    };

    alert(topSalary(salaries));
}


//8
function sum(a) {
    let currrentSum = a;

    function f(b) {
        currrentSum += b;
        return f;
    }

    f.toString = function () {
        return currrentSum;
    };

    return f;
}
