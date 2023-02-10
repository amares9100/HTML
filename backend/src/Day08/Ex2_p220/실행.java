package Day08.Ex2_p220;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 객체 생성
		korean k1 = new korean();
		System.out.println(k1.toString());
		
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		// 2. 객체2 생성
		korean k2 = new korean("박자바", "123456-1234567");
		System.out.println(k2.toString());
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}
