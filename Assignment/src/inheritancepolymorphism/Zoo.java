package inheritancepolymorphism;

public class Zoo {
	
	public static void main(String[] args) {
		
		Animal lionObject = new Lion("lion",10);
		lionObject.makeSound();
		
		Animal elephantObject = new Elephant("elephant",04);
		elephantObject.makeSound();
		
		Animal giraffeObject = new Giraffe("giraffe",15);
		giraffeObject.makeSound();
	}
}
