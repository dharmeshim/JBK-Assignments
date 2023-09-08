// anonymous function without parameter and with return type

let anonymousReturn = function (): number{

    return 10+5;
}

let result = anonymousReturn();
console.log(`anonymousReturn ${result}`);

// anonymous function with parameter and without return type


let anonymousParameter = function(number1:number, number2:number){
    console.log(`anonymousParameter ${number1 + number2}`);
}

anonymousParameter(10,20);



// fat arrow function without parameter and with return type

let fatReturn = ():number => {
    return 10 + 5;
}

console.log(`fatReturn ${fatReturn()}`);


// fat arrow function with parameter and without return type


let fatParameter = (number1:number, number2:number) => {
    console.log(`In fatParameter ${number1+number2}`);

}

fatParameter(50,50);
