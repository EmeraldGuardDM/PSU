
function getDecimal(num) {
    return (num > 0) ? (num - Math.floor(num)) : (Math.ceil(num) - num);
}

function compareDec(a, b) {
  return (getDecimal(a) > getDecimal(b))? 1: -1;
}

var mass = [1.2,3.1,0.01,0.002];
alert(mass);
mass.sort(compareDec);
alert( mass );