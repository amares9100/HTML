package 과제9.Class.Apartment;

public class HighQuality extends Apart{
	String health = "보유";
	String garden = "보유";
	
	public HighQuality(String land_price, String local, String floors) {
		super(land_price,local,floors);
	}

	@Override
	public void run() {
		System.out.println("LowQuality 공사계획");
		System.out.println(자재);
		System.out.println(인력);
		System.out.println(중장비);
		System.out.println(land_price);
		System.out.println(local);
		System.out.println(floors);
		System.out.println("헬스장 : " + health);
		System.out.println("정원 : " + garden);
	}
	
	
}
