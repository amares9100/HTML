package Day11.Ex7;

import java.util.ArrayList;

import Day11.Ex6.HanKookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {
	public static void main(String[] args) {
		
		
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HanKookTire hanKookTire = new HanKookTire();
		
		// 1. 참조타입의 자동타입 변환
		Tire temp = tire;
			Tire temp2 = kumhoTire;
				Tire temp3 = hanKookTire;
					Object temp4 = temp3;
					
		// 2. 참조타입의 강제타입 변환
		Tire tire2 = (Tire)temp4;
			KumhoTire kumhoTire2 = (KumhoTire)tire;
				HanKookTire hanKookTire2 = (HanKookTire)tire;
				
		// 3. 매개변수 , 리턴타입
		Tire result = 함수1(kumhoTire2);		
		
		KumhoTire result2 = (KumhoTire)함수2((KumhoTire)temp2);
		
		
		ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);		//o
		//kumhoList.add(hanKookTire);	//x
		//kumhoList.add(tire);			//x
		
		ArrayList<Tire> TireList = new ArrayList<>();
		TireList.add(hanKookTire);		//o
		TireList.add(kumhoTire);		//o
		TireList.add(tire);				//o
	}
	
	public static KumhoTire 함수1(Tire tire) {
		return new KumhoTire();
	}
	
	public static Tire 함수2(KumhoTire kumhoTire) {
		return new Tire();
	}
}
























