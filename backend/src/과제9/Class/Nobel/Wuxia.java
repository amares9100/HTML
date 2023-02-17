package 과제9.Class.Nobel;

public class Wuxia extends Nobel{
	
	
	
	public Wuxia(String era, String background, String character) {
				super(era,background,character);
				
	}

	@Override
	public void run() {
		System.out.println("소설가가 되자 - 무협");
		System.out.println(write);
		System.out.println(correction);
		System.out.println(grammar);
		System.out.println("시대 : " + era);
		System.out.println("배경 : " + background);
		System.out.println("주인공 : " + character);
	}
	
}
