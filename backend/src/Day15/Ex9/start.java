package Day15.Ex9;

public class start {
	public static void main(String[] args) {
		
		//싱글톤
		view.getInstance().index();
		
		//인스턴스 메소드
		//view view = new view();
		//view.index();
	}
}

/*
	
	내부에서 메소드[멤버] 호출 방법 [ 메모리 할당 전]
		1. 메소드명();
	외부에서 메소드[멤버] 호출 방법 [ 메모리 할당 후]
		1. 인스턴스 메소드
			클래스명 객체명 = new 생성자();
			객체명.메소드();
			vs
			new 생성자().메소드명;
			
		2. 정적 메소드
			클래스명.메소드명();
			
		3. 싱글톤내 메소드 호출
			클래스명.get싱글톤.메소드();
			
			
			
			JVM
			
			[현재 사용중인 메모리 : 컴파일한 클래스 + import 클래스]
		메소드 영역 					스택 영역 : 				힙 영역 : 
									- 기본자료형
									- 힙주소 저장
			: 클래스 멤버정보			클래스명 객체명 	= 		new 생성자();	
			: static										new 생성자().메소드명;
		
		
		
	

*/
