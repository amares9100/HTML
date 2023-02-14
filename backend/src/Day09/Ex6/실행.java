package Day09.Ex6;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 인스텉ㄴ스 멤버 호출
			// 객체 -> 인스턴스 멤버 호출
		Calculator myCal = new Calculator();
		System.out.println(myCal.no);
		myCal.no = 10;
		System.out.println(myCal.getNumber());
		
		
		// 2. 정적멤버 호출
		double result1 = 10*10*Calculator.pi;
		System.out.println(result1);
		System.out.println(Calculator.plus(5, 10));
		
		System.out.println(Calculator.minus(10, 3));
		
		System.out.println(Calculator.info);
	}
}
