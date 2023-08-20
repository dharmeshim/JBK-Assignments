package vehicles;

public class VehicleInteraction {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        
        car.start();
        car.accelerate();
        car.brake();
        
        motorcycle.start();
        motorcycle.accelerate();
        motorcycle.brake();
        
     

       
    }
}

