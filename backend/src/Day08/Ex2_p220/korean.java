package Day08.Ex2_p220;

public class korean {
	// 1. 필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	// 2. 생성자
	public korean() {
		
	}
	
	public korean(String name , String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	
	
	// 3. 메소드
	@Override
	public String toString() {
	return "korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
}
