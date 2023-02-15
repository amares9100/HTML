package Day11.Ex4.pack2;

import Day11.Ex4.pack1.A;

public class D extends A{ // A 상속
	//생성자 선언
	public D() {
		// A생성자 호출
		super();
	}
	
	public void method1() {		//상속을 통해서 protected A에서 필드와 메소드 호출
		this.field = "value";
		this.method();
	}
	
	public void method2() {		// 직접 객체 생성해서 사용하는 것은 안됨
//		A a = new A();
//		a.field = "value";
//		a.method();
	}
}
