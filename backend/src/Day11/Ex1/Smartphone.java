package Day11.Ex1;

public class Smartphone extends phone{
	public boolean wifi;
	
	
	
	public Smartphone() {
		super();
	}

	public Smartphone(String model , String color) {
		super(model , color);
		System.out.println("자식 생성자 실행");
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷을 연결합니다.");
	}
	
	
}
