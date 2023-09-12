import { Person } from "../basefolder/person";

class Teacher extends Person{


    constructor(name:string){
        super(name);

    }


    override whoAmI(): void {
        console.log("I am teacher");
        
    }



   
}

let teacherObj = new Teacher("good name");
teacherObj.whoAmI();  