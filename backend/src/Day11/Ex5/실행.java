package Day11.Ex5;

public class 실행 {
	
	public static void main(String[] args) {
		
	
	// 1. 자식 객체 만들기
	child child = new child();
		child.name = "유재석";
		child.job = "방송인";
	
		//------------자동변환------------
		
	
	// 2. 자식 객체를 부모 객체로 이동[타입변환]
	parent parent = child; // child -> parent로 바꿈
	
	// 3.
	parent.method1();		// 
	System.out.println("--------------");
	parent.method2();		//
	System.out.println("--------------");
//	parent.method3(); 호출 불가
	
	System.out.println(parent.name);
	//System.out.println(parent.job);
	
	// ----------강제변환-----------
	// 1. 부모 객체를 자식 객체로 이동[강제 타입 변환]
	child child2 = (child)parent;
	
	child2.method1();
	child2.method2();
	child2.method3();
	
	System.out.println(child2.name);
	System.out.println(child2.job);
	}
}













