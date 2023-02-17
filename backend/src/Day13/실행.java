package Day13;

import java.util.Scanner;

// 인터페이스 = 참조타입 = 힙영역



public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		RemoteControl rc; // 인터페이스 변수 'rc'선언 [ 스택영역 ]
		rc = new Television(); // 힙영역에 객체 선언하고 주소를 반환하고 반환된 주소를 'rc'스택영역의 변수에 대입
		
	//	new Television().turnOn();		// 스택영역 없이 힙에서 바로 불러옴.
	//	rc.turnOn(); // 구현객체 실행		// 스택영역 rc에 힙을 불러옴.
		System.out.println(RemoteControl.MAX_VOLUME);
		System.out.println(RemoteControl.MIN_VOLUME);
		
		while(true) {
			System.out.println("1. TV_control 2. Audio_control"); // 리모콘 버튼 입력
			int ch = sc.nextInt();
			
			if(ch == 1) 		{rc = new Television();} // TV전환	:rc(리모트컨트롤)에 구현객체(Television)연결
			else if(ch == 2) 	{rc = new Audio();}		 // Audio전환:rc(리모트컨트롤)에 구현객체(Audio)연결
			System.out.println("----------------");
			// 객체 구현
			rc.turnOn();
			rc.setVolume(8);
			rc.turnOff();
			// rc의 디폴트 메소드
			rc.setMute(true);
			rc.setMute(false);
			// rc의 정적 메소드
			RemoteControl.changeBattery();
			System.out.println("----------------");
			
		}
		
	}
}
