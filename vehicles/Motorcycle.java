package vehicles;

public class Motorcycle implements Vehicle{

	@Override
	public void start() {

		System.out.println("Motorcyle starts");
	}

	@Override
	public void accelerate() {

		System.out.println("Motorcyle accelerates ");
	}

	@Override
	public void brake() {

		System.out.println("Motorcycle applies brake");
	}

}
