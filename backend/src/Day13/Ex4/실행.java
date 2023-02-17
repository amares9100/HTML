package Day13.Ex4;

public class 실행 {
	public static void main(String[] args) {
		
	InterC_Im im = new InterC_Im();	// 구현객체
	
	InterA ia = im; // interC 구현한 interC_im을 interA 변수에 대입
	ia.methodA();	// A는 실행가능
	// ia.methodB();  B는 실행안됨 
	System.out.println("-------------");
	
	InterB ib = im; // interC 구현한 interC_im을 interB 변수에 대입
	//ib.methodA(); // A는 실행안됨
	ib.methodB();	// B는 실행됨
	System.out.println("-------------");
	
	InterC ic = im;// interC 구현한 interC_im을 interC 변수에 대입
	ic.methodA();	// 가능
	ic.methodB();	// 가능
	ic.methodC();	// 가능
	}
}
