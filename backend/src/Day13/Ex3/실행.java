package Day13.Ex3;

public class 실행 {
	public static void main(String[] args) {
		
		RemoteControl rc = new smartTV();
		
		rc.turnOn();
		rc.turnOff();
		
		Searhable searh = new smartTV();
		searh.search("https://www.youtube.com");
	}
}
