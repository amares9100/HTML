package Day11.Ex6;

public class KumhoTire extends Tire{

	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다.");
	}

	@Override
	public void stop() {
		System.out.println("금호 타이어가 멈춥니다.");
	}
	
}
