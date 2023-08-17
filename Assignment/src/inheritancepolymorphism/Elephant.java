package inheritancepolymorphism;

public class Elephant extends Animal{
	
	public Elephant(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		System.out.println("elephant sound");
	}

}
