package shapes;

public class Rectangle implements Shape {

	private double width;
	private double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public void calculateArea() {
		double area = width * length;

		System.out.println("Area of rectangle : " + area);

	}

	@Override
	public void calculatePerimeter() {

		double perimeter = 2 * (width + length);

		System.out.println("Perimeter of rectangle : " + perimeter);
	}

}
