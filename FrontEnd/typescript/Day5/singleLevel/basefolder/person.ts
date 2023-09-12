export class Person{

    name:string;

    constructor(name:string){
        this.name = name;
    }

    whoAmI(){
        console.log("I am Person, my name is"+this.name);
    }

}