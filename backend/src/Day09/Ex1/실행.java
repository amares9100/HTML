package Day09.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 객체 만들기
		Member member = new Member();
		// 2. 맴버의 필드 호출 가능
		System.out.println(member.name);
		// 3. 맴버 안에 있는 변수 호출 불가능
		// System.out.println(member.inputName);
	}
}
