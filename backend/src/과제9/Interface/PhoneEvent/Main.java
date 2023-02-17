package 과제9.Interface.PhoneEvent;

public class Main implements PhoneEvent{

	@Override
	public void push() {
		System.out.println("앱을 실행합니다.");
		
	}

	@Override
	public void drag() {
		System.out.println("드래그하여 이동합니다.");
		
	}

}
