package Day13;

// class 키워드 : 클래스 선언 키워드
// interface 키워드 : 인터페이스 선언 키워드
// implement : 구현하다.  인터페이스를 사용하는 구현class에 추가하여야됨.
public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	// 인터페이스 멤버
		// 1. 상수 필드	[변수x]
		// 2. 생성자 x
		// 3. 메소드
			// ! 추상 메소드
			// 디폴트 메소드
			// 정적 메소드
	// * 추상메소드 : 선언부만 존재 / 구현부{} 작성 안함.
	void turnOn(); // 추상 메소드
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 인스턴스 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리 합니다.");
			// 추성메소드 호출하면서 상수 필드 사용
			setVolume(MIN_VOLUME);
		}
		else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// 정적 메소드
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
	
}
