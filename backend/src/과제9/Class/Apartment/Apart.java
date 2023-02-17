package 과제9.Class.Apartment;

public class Apart {
	public String 자재 = "철근,시멘트";
	public String 인력 = "인력[8m/h]";
	public String 중장비 = "굴삭기, 타워크레인";
	public String land_price;
	public String local;
	public String floors;
	public String health;
	public String garden;
	
	

	



	public Apart(String land_price, String local, String floors) {
		super();
		this.land_price = land_price;
		this.local = local;
		this.floors = floors;
	}



	public Apart(String land_price, String local, String floors, String health) {
		super();
		this.land_price = land_price;
		this.local = local;
		this.floors = floors;
		this.health = health;
	}



	public Apart(String land_price, String local, String floors, String health, String garden) {
		super();
		this.land_price = land_price;
		this.local = local;
		this.floors = floors;
		this.health = health;
		this.garden = garden;
	}
	
	
	public void run() {
		System.out.println("공사계획");
		System.out.println(자재);
		System.out.println(인력);
		System.out.println(중장비);
		System.out.println(land_price);
		System.out.println(local);
		System.out.println(floors);
		System.out.println(health);
		System.out.println(garden);
	}
	
}
