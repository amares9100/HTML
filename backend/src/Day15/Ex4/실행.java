package Day15.Ex4;

import java.io.IOException;

public class 실행 {
	public static void main(String[] args) throws IOException{
		
		System.out.println("출력");
		System.err.println("에러");
		
		
		int value = 100;	// int 에 100 대입 가능[정수]
	//	int value2 = "100";	// int 에 "100"대입 불가능[문자]
			// 문자열 --> 기본타입(형변환)
		int value2 = Integer.parseInt("100"); // 숫자로 이루어진 문자열을 int 로 형변환
		
		try {
		int value3 = Integer.parseInt("1oo"); // 숫자와 문자가 섞인 문자열이라 변형 불가
		}
		catch(Exception e) {
			System.err.println("에러내용");
			System.err.println(e.getMessage());
		}
		
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			if(keyCode != 13 && keyCode != 10) {
				if(keyCode == 49) {
					speed++;
				}
				else if(keyCode == 50) {
					speed--;
				}
				else if(keyCode == 51) {
					//break
					System.exit(0);
				}
				System.out.println("현재속도 : " + speed);
				System.out.println("1. 증속 2. 감속 3. 중지");
			
			}
			keyCode = System.in.read(); // 입력받아 코드로 반환
		}
	}
}
