package 과제9.Class.Nobel;

public class 실행 {
	public static void main(String[] args) {
	
	Nobel 일반 = new 일반문학("현대", "서울", "김서울");
	Nobel fan = new Fantasy("이세계", "??왕국", "아리에스");
	Nobel wuxia = new Wuxia("삼국시대", "장안성", "남궁남궁");
	
	
	//실행
	일반.run();
	System.out.println("-------------------");
	fan.run();
	System.out.println("-------------------");
	wuxia.run();
	
	
	}		
}
