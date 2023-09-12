import { Car } from "../childfolder/car";


class CarModel extends Car{

    display(): void {
        console.log("In Car Model class")
    }
}

let model = new CarModel();
model.display();
console.log(model.name);