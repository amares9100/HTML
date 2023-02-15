package Day11.Ex3;

public class SportCar extends Car{

	@Override
	public void speedUp() {
		super.speedUp();
		speed += 10;
	}
/*	
	@Override
	public void stop() {	// final 메소드 호출 불가
		speed = 0;
	}
*/	
}
