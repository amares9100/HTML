package Day08.Ex3_p225;

public class Car {

	// 1. 필드
	String company = "현대";
	String model;
	String color;
	int maxSpeed;
	// 2. 실행자
	public  Car() {
		
	}
	
	public Car(String model) {
		this.model = model;
	}
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	
	
	
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
}
