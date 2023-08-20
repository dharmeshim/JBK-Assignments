package vehicles;

public class Car implements Vehicle{

	@Override
	public void start() {
		System.out.println("Car starts");
	
		
	}

	@Override
	public void accelerate() {

		System.out.println("Car accelerates");
	}

	@Override
	public void brake() {

		System.out.println("car applied brake");
	}

}
