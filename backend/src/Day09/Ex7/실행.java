package Day09.Ex7;

public class 실행 {
	public static void main(String[] args) {
		// 객체 생성
		Korean k1 = new Korean("123456-1234567" , "김자바");
		
		// 객체 멤버 호출
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		// 객체 멤버 변경
		
		// k1.nation = "미국";  - final 변경불가
		// k1.ssn = "880888-1234567"; - final 변경불가
		k1.name = "유재석";		// final 아니기때문에 변경가능
		
	System.out.println(k1.EARTH_RADIUS);
	System.out.println(k1.EARTH_SURFACE_AREA);
	}
}
