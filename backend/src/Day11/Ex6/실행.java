package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {
		//타이어
		Tire tire = new Tire();
		
		// Car 객체 생성
		Car mycar = new Car();
		
		// Tire 객체 장착
		mycar.tire = new Tire();
		mycar.run();
		mycar.parking(tire);
		
		// 한국타이어 객체 장착
		mycar.tire = new HanKookTire();
		mycar.run();
		
		HanKookTire hanKookTire = new HanKookTire();
		mycar.parking(hanKookTire);
		
							//강제 타입변환
		HanKookTire result = (HanKookTire)mycar.parking(hanKookTire);
		System.out.println(result instanceof Tire);
		System.out.println(result instanceof Object);
		// 자식객체 instanceof 상위클래스명 : 타입 확인 [ 해당 객체의 부모글래스를 확인]
		// 
		
		// 금호타이어 객체 장착
		mycar.tire = new KumhoTire();
		mycar.run();
		
		KumhoTire kumhoTire = new KumhoTire();
		mycar.parking(kumhoTire);
	}
}
