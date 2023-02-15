package Day11.Ex5;

public class child extends parent{
	public String job;

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		super.method2();
		System.out.println("자식이 부모메소드 2 호출");
	}
	
	public void method3() {
		System.out.println("자식 메소드 3");
	}
	
}
