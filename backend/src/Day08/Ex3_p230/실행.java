package Day08.Ex3_p230;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 외부에서 함수 호출 -> 객체 필요
		Calculator myCalc = new Calculator();
		
		// 2. 객체를 통한 멤버 함수 호출;
		myCalc.powerOn();
		
		int result1 = myCalc.plus(3, 5);
		System.out.println(result1);
		
		int x = 3;
		int y = 5;
		
		double result2 = myCalc.divide(x, y);
		System.out.println(result2);
		
		myCalc.powerOff();
		
		
		System.out.println(myCalc.info());
	}
}
