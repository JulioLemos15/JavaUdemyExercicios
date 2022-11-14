package entities;

public class Circle extends Shape {
	
	private Double radius;
	
	public Circle() {
		super();
	}

	
	public Circle(entities.enums.Color color, Double radius) {
		super(color);
		this.radius = radius;
	}



	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}


	@Override
	public double area() {
		
		return Math.PI * radius * radius; //calcula area do circulo que é pi vezes radius ao quadrado.
	}
	
	
}
