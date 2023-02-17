package 과제9.Class.Nobel;

public class Nobel {
	public String write = "글쓰기";
	public String correction = "내용수정";
	public String grammar = "맞춤법 검사";
	public String era;
	public String background;
	public String character;
	
	
	
	
	public Nobel() {
		
	}




	public Nobel(String era, String background, String character) {
		super();
		this.era = era;
		this.background = background;
		this.character = character;
	}
	
	
	
	
	public void run() {
		System.out.println("소설가가 되자");
		System.out.println(write);
		System.out.println(correction);
		System.out.println(grammar);
		System.out.println("시대 : " + era);
		System.out.println("배경 : " + background);
		System.out.println("주인공 : " + character);
	}
	
	
	
	
}
