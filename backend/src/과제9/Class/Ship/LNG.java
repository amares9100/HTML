package 과제9.Class.Ship;

public class LNG extends Ship{
	String transit = "가스";
	
	
	public LNG(String size, String create_time) {
		super(size,create_time);
	}

	@Override
	public void run() {
		System.out.println("LNG선");
		System.out.println(항법);
		System.out.println(ICCP);
		System.out.println(Echo_Sound);
		System.out.println(size);
		System.out.println(create_time);
		System.out.println(transit);
	}
	
}
