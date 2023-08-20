package shapes;

public class Circle implements Shape {

	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void calculateArea() {
		double area = 3.14 * radius * radius;

		System.out.println("Area of circle : " + area);

	}

	@Override
	public void calculatePerimeter() {
		double perimeter = 2 * 3.14 * radius;
		System.out.println("Perimeter of circle : " + perimeter);

	}

}
