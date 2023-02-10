package Day08.Ex3_p230;

public class Calculator {

	//1. 필드
	
	//2. 생성자
	
	//3. 메소드
		// 1. 반환x / 인수x
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
		// 2. 반환x / 인수x
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
		// 3. 인수 int x,y / 반환o
	int plus(int x , int y) { // x=3 y=5  return = 8
		int result = x + y;
		return result;
	}
		// 4. 인수 double x,y / 반환o
	double divide(int x , int y) { // x=3 y=5 return = 0.6
		double result = (double)x / (double)y;
		return result;
	}
	
	// 5. 인수x,y / 반환x
	void multply(int x , int y) {
		double result = (double)x * (double)y;
		System.out.println(result);
	}
	
	// 6. 인수x / 반환o
	String info() {
		return "by. 이젠 계산기";
	}
	
	// 7. 내부에서 함수 호출
	void 함수호출() {
		powerOn();
	}
	
}

/*

	함수 = 메소드
	js
	function 함수명(인수명){}
	호출 : 함수명(인수)
	
	
	JAVA
	리턴타입 함수명(인수1,인수2...){}
	호출 : 함수며(인수)
	외부호출 : - 객체가 필요
			객체명.함수명(인수)

	1.인수x 반환x
		void 함수명(){}
		
	2. 인수o 반환x
		void 함수명(인수1, 인수2...){}
		
	3. 인수o 반환o
		리턴타입 함수명(인수1, 인수2..){return 값;}
		
	4. 인수x 반환o
		리턴타입 함수명(){return 값;}

*/