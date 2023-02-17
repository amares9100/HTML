package Day13.Ex5;

public class 실행 {
	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.run();
		
		mycar.tire1 = new Kumhootire(); // Car의 tire1 에 금호타이어 대입
		mycar.tire2 = new Hankooktire();// Car의 tire2 에 한국타이어 대입
		
		mycar.run();
	}
}
