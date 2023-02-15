package Day11.Ex6;

public class Car {
	// 필드 선언
	public Tire tire;
	
	// 메소드 선언
	public void run() {
		// 타이어 필드에 대입된 객체의 roll() 메소드 호출
		tire.roll();
	}
	
	public Tire parking(Tire tire) {
		tire.stop();
		return tire;
	}
}
