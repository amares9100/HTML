package 과제9.Interface.PhoneEvent;

public class Apprun implements PhoneEvent{

	@Override
	public void push() {
		System.out.println("터치는 아무런 반응이 없습니다.");
		
	}

	@Override
	public void drag() {
		System.out.println("드래그는 아무런 반응이 없습니다.");
		
	}

}
