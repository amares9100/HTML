package Day13.Ex2;

public interface Remotecontrol {
	// 상수 필드 [ 인터페이스는 변수x ]
		// new 연사자[생성자x] -> 객체없음 -> 인스턴스멤버x -> static멤버만 가능
		// 상수 : static final	// 고정된 값o -> 초기값 필수 : 변수 선언시 값 대입
		// 인터페이스 에서는 생략 가능
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;	// 자동으로 public static final
}
