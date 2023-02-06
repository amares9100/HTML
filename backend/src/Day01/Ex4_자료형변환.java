package Day01;

public class Ex4_자료형변환 {
	public static void main(String[] args) {

		byte b1 = 10;
		int i1 = b1;
		System.out.println("byte b1 -> int 변환 : " + i1);

		char c1 = '가';
		i1 = c1;
		System.out.println("char c1 -> int 변환(유니코드) : " + i1);

		i1 = 50;
		long l1 = i1;
		System.out.println("int -> long 변환 : " + l1);

		l1 = 100;
		float f1 = l1;
		System.out.println("long -> float 변환 : " + f1);


		// 강제변환 [ 강제로 변환시킬 최대값보다 크기가 크면 값이 손실됨]

		i1 = 10;
		b1 = (byte) i1;
		System.out.println("int(작은값 : 10) -> byte 강제 변환 : " + b1);

		i1 = 202020202;
		b1 = (byte) i1;
		System.out.println("int(높은값 : 202020202) -> byte 강제 변환 : " + b1);

		l1 = 300;
		i1 = (int)l1;
		System.out.println("long(작은값 : 300) -> int 강제 변환 : " + i1);

		l1 = 123456789123456L;
		i1 = (int)l1;
		System.out.println("long(높은값 : 123456789123456L) -> int 강제 변환 : " + i1);


		// 연산시 자동 타입 변환 - 피연산자중 큰 타입으로 반환. 단 byte,short는 int로 변환
		// int 보다 작은값 연산시 결과물은 int
		// byte + byte -> int / short + short -> int
		// int + long -> long

		// 실수
		// float + double -> double



		// 문자열 타입변환 - 숫자로 된 문자열을 정수로 변환. 문자로된 문자열을 정수변환 x
		String str1 = "10";
		byte b2 = Byte.parseByte(str1);
		System.out.println("String str1에 입력된 문자 10을 숫자로 변환 : " + b2);

		str1 = "200";
		short s2 = Short.parseShort(str1);
		System.out.println("String str1에 입력된 문자 200을 숫자로 변환 : " + s2);

		str1 = "30000";
		int i2 = Integer.parseInt(str1);
		System.out.println("String str1에 입력된 문자 30000을 숫자로 변환 : " + i2);

		str1 = "40000000000";
		long l2 = Long.parseLong(str1);
		System.out.println("String str1에 입력된 문자 40000000000을 숫자로 변환 : " + l2);

		str1 = "true";
		boolean bo1 = Boolean.parseBoolean(str1); // String true/false 문자열을 boolean true/false값으로 변환
		System.out.println("String str1에 입력된 문자 true를 boolean-true값으로 변환 : " + bo1);










	}
}
