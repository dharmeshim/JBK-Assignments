package shapes;

public class Triangle implements Shape {
	private double base;
	private double height;

	private double side1;
	private double side2;

	public Triangle(double base, double height, double side1, double side2) {
		super();
		this.base = base;
		this.height = height;
		this.side1 = side1;
		this.side2 = side2;
	}

	@Override
	public void calculateArea() {
		double area =  (base * height)/2;
		System.out.println("Area of triangle : " + area);

	}

	@Override
	public void calculatePerimeter() {
		double perimeter = side1 + side2 + base;
		System.out.println("Perimeter of triangle : " + perimeter);

	}

}
