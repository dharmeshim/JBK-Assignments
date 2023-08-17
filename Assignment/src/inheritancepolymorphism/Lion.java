package inheritancepolymorphism;

public class Lion extends Animal{
	

	public Lion(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		System.out.println("lion sound");
	}

}
