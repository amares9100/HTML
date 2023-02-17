package 과제9.Class.Apartment;

public class 실행 {
	public static void main(String[] args) {
		
		Apart low = new LowQuality("평당 200만", "지방", "6층");
		Apart middle = new MiddleQuality("평당 300만", "경기도", "10층");
		Apart high = new HighQuality("평당 800만", "서울", "20층");
		
		
		// 실행
		low.run();
		System.out.println("-------------");
		middle.run();
		System.out.println("-------------");
		high.run();
	}
}
