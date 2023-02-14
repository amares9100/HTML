package Day09.Ex6;
/*

	정적멤버 : 
		1. static 키워드
		2. JVM메소드 영역 저장
		3. 객체 없이 사용 가능
		4. 사용방법
		클래스명.정적멤버
		5. 프로그램 시작시 생성, 프로그램 종료시 초기화
			- 효율성 생각 : 
				- 모든 클래스에서 공통[공유]으로 사용되는 메모리일때 효율이 좋음
		6. 정적멤버는 인스턴스멤버를 사용할 수 없다.
*/


public class Calculator {
	// 1. 필드
		// 1. 인스턴스 멤버
	int no;
		// 2. 정적 멤버
	static double pi = 3.14159;
	
	// 2. 생성자
	
	// 3. 메소드
	int getNumber() {
		return no;
	}
	
	static int plus(int x , int y) {
		return x+y;
	}
	
	static int minus(int x , int y) {
		return x-y;
	}
	
	static String info;
	static {
		info = pi+"파이 입니다.";
	}
	
	
	
	
	
	
	
	
	
	
	
}
