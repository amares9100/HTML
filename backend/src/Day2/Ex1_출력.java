package Day2;

public class Ex1_출력 {
	public static void main(String[] args) {
		System.out.println();
			//시스템 클래스 [관련 메소드(함수)제공]
				//out : 출력 vs in : 입력
				//println() : 출력후 행바꾸기
				//print() : 출력
				//prinf() : 형식에 맞춰서 뒤의 값을 출력
		System.out.print("print 함수1");
		System.out.print("print 함수2");

		System.out.println("printIn 함수1");
		System.out.println("printIn 함수2");

		int value = 123;
		System.out.printf("상품의 가격 : %d원\n" , value);
		System.out.printf("상품의 가격 : %6d원\n" , value);
		System.out.printf("상품의 가격 : %-6d원\n" , value);
		System.out.printf("상품의 가격 : %06d원\n" , value);

		double area = 3.14159;
		System.out.println("파이출력 : " + area);
		System.out.printf("파이출력 : %f\n" , area);
		System.out.printf("파이출력 : %.1f\n" , area);
		System.out.printf("파이출력 : %3.2f\n" , area);
		System.out.printf("파이출력 : %3.3f\n" , area);


		String name = "홍길동";
		String job = "도적";

		System.out.printf("%6d | %-10s | %10s\n" , 1 , name , job);

		// 제어문자
/*
		 * 	\n : 줄바꿈
		 * 	\t : 탭
		 * 	\" : "출력
*/
	}
}
