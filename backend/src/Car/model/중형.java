package Car.model;

public class 중형 extends Car{

	public 중형(String string, int km, int price , int 지역) {
		super(string , km , price , 지역);
	}

	@Override
	public int price() {
		System.out.println("중형차가 목적지에 도착했습니다.");
		System.out.println("중형차 요금은"+(price*2)+"입니다.");
		return 0;
	}

	@Override
	public int run() {
		System.out.println("중형차가 달립니다.");
		지역 = 지역-km;
		if(0 < 지역) {
			
			System.out.println("목적지까지"+지역+"만큼 남았습니다.");
			return 1;
		}
		else { return 0;
		}
	}
	
	
	
}
