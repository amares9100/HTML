package 과제9.Class.Apartment;

public class LowQuality extends Apart{
	
	
	
	public LowQuality(String land_price, String local, String floors) {
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
		
	}
	
	
	
}
