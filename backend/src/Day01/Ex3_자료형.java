package Day01;

public class Ex3_자료형 {
	public static void main(String[] args) {
		
		
		int var1 = 0b1011;	// 2진수 : 앞에 0b
		int var2 = 0206;	// 8진수 : 앞에 0
		int var3 = 365;		// 10진수 : 평소처럼 사용
		int var4 = 0xb3;	// 16진수 : 앞에 0x
		
		System.out.println("2진수 :" + var1);
		System.out.println("8진수 :" + var2);
		System.out.println("10진수 :" + var3);
		System.out.println("16진수 :" + var4);
		
		byte b1 = -128; System.out.println("byte1 :" + b1);
		byte b2 = 127; System.out.println("byte2 :" + b2);
		//byte b3 = 128; System.out.println("byte3 :" + b3); 범위벗어난 데이터
		
		short s1 = -32000; System.out.println("short1 :" + s1); // short : +- 3만2천쯤
		//short s2 = 33000; System.out.println("short2 :" + s2); // 범위벗어난 데이터
		
		int i1 = 2000000000; System.out.println("int1 :" + i1); // int : +- 21억쯤
		//int i2 = 3000000000; System.out.println("int2 :" + i2); // 범위벗어난 데이터
		
		long l1 = 10; System.out.println("long1 :" + l1); // 대입전 int 10
		long l2 = 20L; System.out.println("long2 :" + l2); // 대입전 long 10
		//long l3 = 10000000000; System.out.println("long3 :" + l3); // 정수 기본값이 int 이기때문에 오류
		long l4 = 10000000000L; System.out.println("long4 :" + l4);  // int값보다 클경우 대입값에 L 추가
		
		char c1 = 'A'; // char : ''사용 , 문자열은 x(한글자만 가능)
		char c2 = 65;
		char c3 = '가';
		char c4 = 44032;
		
		System.out.println("c1 :" + c1);
		System.out.println("c2 :" + c2);
		System.out.println("c3 :" + c3);
		System.out.println("c4 :" + c4);
		
		String str1 = "안녕하세요"; // String : S대문자 사용, 문자여러개 저장, ""사용
		System.out.println("str1 :" + str1);
		
		float f1 = 0.1234567890123456789f; // 대입전 기본값이 double이기때문에 float대입전 뒤에 f추가 
		double d1 = 0.1234567890123456789;
		System.out.println("f1 :" + f1);
		System.out.println("d1 :" + d1);
		
		boolean bo1 = true; // true값 저장
		boolean bo2 = false;// false값 저장
		System.out.println("bo1 :" + bo1);
		System.out.println("bo2 :" + bo2);
		
		int x = 10;
		boolean result = (x == 10); // 변수의 값이 10인가? 참으로 true 저장
		System.out.println("x == 10 :" + result);
	}
}















