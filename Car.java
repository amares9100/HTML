package model;

public class Car {

	public String model;
	public int km;
	public int price;
	public int 지역;

	public Car() {
		super();
		
	}

	public Car(String string, int km, int price , int 지역) {
		this.model = string;
		this.km = km;
		this.price = price;
		this.지역 = 지역;
	}
	
	public int price() {
		System.out.println("차가 목적지에 도착했습니다.");
		System.out.println("요금은"+price+"입니다.");
		return 0;
	}
	
	public int run() {
		System.out.println("달립니다.");
		지역 = 지역-km;
		if(0 < 지역) {
			
			System.out.println("목적지까지"+지역+"만큼 남았습니다.");
			return 1;
		}
		else {return 0;}
	
	}
}
