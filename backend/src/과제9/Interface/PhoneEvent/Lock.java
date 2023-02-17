package 과제9.Interface.PhoneEvent;

public class Lock implements PhoneEvent{

	@Override
	public void push() {
		System.out.println("휴대폰을 누릅니다.");
		System.out.println("화면이 밝아집니다.");
		System.out.println("핸드폰이 잠겨있습니다.");
		
	}

	@Override
	public void drag() {
		
		System.out.println("드래그하여 잠금이 해제됩니다.");
	}
	
}
