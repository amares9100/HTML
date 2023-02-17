package Day13;

public class Audio implements RemoteControl{
	
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}
		else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}
		else {this.volume = volume;}
		System.out.println("현재 Audio 볼륨 : "+volume);
		
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
