package Day15.Ex2;

public class 실행 {
	public static void main(String[] args) {
		
		System.out.println("자바".hashCode());
		System.out.println("자바".hashCode());
		System.out.println("자바".hashCode() == "자바".hashCode());
		
		Student s1 = new Student(1, "홍길동");
		System.out.println(s1);
		Student s2 = new Student(1, "홍길동");
		System.out.println(s2);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.hashCode() == s2.hashCode());
		
		if(s1.hashCode() == s2.hashCode()) { // 해시코드 검사
			if(s1.equals(s2)) {				// 데이터 동일한지 검사
				System.out.println("동등");
			}else { System.out.println("데이터 다름");}
		}else {System.out.println("해시코드 다름");}
	}
}	
