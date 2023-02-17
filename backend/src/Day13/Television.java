package Day13;

public class Television implements RemoteControl{

		private int volume;
		
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {	// 만약에 요청한 소음이 최대소음보다 크면
			this.volume = RemoteControl.MAX_VOLUME;	// 현재소음에 최대소음을 대입
		}
		else if(volume<RemoteControl.MIN_VOLUME) { // 만역에 요청한 소음이 최소소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME;	// 현재 소음에 최소 소음 대입
		}
		else {this.volume = volume;}	// 현재 소음 입력
		System.out.println("현재 TV 볼륨 : "+this.volume);
		
	}

	
	private int memoryVolume;
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음처리 합니다.");
			// 추성메소드 호출하면서 상수 필드 사용
			setVolume(MIN_VOLUME);
		}
		else {
			System.out.println("무음 해제합니다.");
			setVolume(this.memoryVolume);
		}
		
	}
	
	
	
}
