let stringArray:string[] = ["TypeScript", "adds", "syntax", "on", "top", "of", "JavaScript", "allowing", "developers", "to", "add", "types" ];


stringArray = stringArray.concat("welcome");

// stringArray.


console.log(stringArray);


// traditional for loop

for (let i = 0; i < stringArray.length; i++) {
    console.log(stringArray[i]);
}


// for each loop

stringArray.forEach((element, index) => {
    console.log(element);
});


// map
let copyArray = stringArray.map((element) => console.log(element));


//join

console.log(stringArray.join(" : "));
console.log(stringArray.join(" ")+".");

//slice

console.log(stringArray.slice(1,6));

// adding elements to dynamic array

for (let i = 0; i <= 10; i++) {
    stringArray = stringArray.concat("word "+i);
}

stringArray.map((element) => console.log(element));