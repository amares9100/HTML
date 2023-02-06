package Day2;

import java.util.Scanner; // 스캐너 클래스 사용하기 위한 스캐너 클래스 가져오기

public class Ex2_입력 {
	public static void main(String[] args) {

		// 지역별{} 1번만 선언
		Scanner scanner = new Scanner(System.in);
		/*
		 * scanner.next(); 					: 문자열[띄어쓰기x] 입력받기 함수
		 * scanner.nextLine(); 				: 문자열[띄어쓰기o] 입력받기 함수 [.nextLine() 앞에 다른 next가 있으면 앞에 nextLine(); 작성
		 * scanner.nextByte(); 				: byte 정수형으로 입력받기
		 * scanner.nextShort(); 			: short 정수형으로 입력받기
		 * scanner.nextInt()				: int 정수형으로 입력받기
		 * scanner.nextLong(); 				: long 정수형으로 입력받기
		 * scanner.nextFloat(); 			: float 실수형 입력받기
		 * scanner.nextDouble();			: double 실수형 입력받기
		 * scanner.next().charAt(0);		: 첫글자만 입력받기- .next() 문자열중에서 .charAt(0)으로 해당 문자열만 출력
		 */


		System.out.println("x값 입력 : ");
		String strx = scanner.next();
		int x = Integer.parseInt(strx);

		System.out.println("y값 입력 : ");
		String stry = scanner.next();
		int y = Integer.parseInt(stry);

		int result = x+y;
		System.out.println("x+y : " + result);


		// 기본자료형 비교
		int 비밀번호 = 1234;
			System.out.println(비밀번호 == 1234);
		// 기본타입비교는 == 사용

		String 아이디 = "qwe";
			System.out.println(아이디.equals("qwe"));
		//스트링 타입 값 비교는 .equals() 사용











	}
}
