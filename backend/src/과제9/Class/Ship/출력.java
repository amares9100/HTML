package 과제9.Class.Ship;

public class 출력 {
	public static void main(String[] args) {
		
		Ship container = new Container("3000k", "1.5년");
		Ship lng = new LNG("1500k", "1년");
		Ship cruise = new Cruise("3500k", "2년");
		
		
		// 출력
		container.run();
		System.out.println("------------------");
		lng.run();
		System.out.println("------------------");
		cruise.run();
		
		
	}

	
}
