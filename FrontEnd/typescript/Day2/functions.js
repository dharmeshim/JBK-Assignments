// anonymous function without parameter and with return type
var anonymousReturn = function () {
    return 10 + 5;
};
var result = anonymousReturn();
console.log("anonymousReturn ".concat(result));
// anonymous function with parameter and without return type
var anonymousParameter = function (number1, number2) {
    console.log("anonymousParameter ".concat(number1 + number2));
};
anonymousParameter(10, 20);
// fat arrow function without parameter and with return type
var fatReturn = function () {
    return 10 + 5;
};
console.log("fatReturn ".concat(fatReturn()));
// fat arrow function with parameter and without return type
var fatParameter = function (number1, number2) {
    console.log("In fatParameter ".concat(number1 + number2));
};
fatParameter(50, 50);
