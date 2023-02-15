package Day11.Ex1;

public class 실행 {
	public static void main(String[] args) {
		Smartphone myPhone = new Smartphone();
		myPhone.color = "은색";
		myPhone.model = "갤럭시";
		
		phone phone = new phone();
		
		phone.color = "빨강";
		System.out.println("색상 : "+ phone.color);
		// 부모는 자식객체의 멤버 호출 불가
		// phone.wifi; <-- 오류
		
		
		//			자식클래스		extents 부모클래스		부모클래스
		// 실행 -> Smartphone클래스 extends phone -> phone클래스로 이동
		// Smartphone 에서 가져옴
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
		System.out.println("와이파이 상태 : " + myPhone.wifi);
		
		// Smartphone을 거쳐서 phone에서 가져옴
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요~");
		myPhone.sendVoice("반갑반갑");
		myPhone.hangUp();
		
		//Smartphone에서 가져옴
		myPhone.setWifi(true);
		myPhone.internet();
		
	}
}
