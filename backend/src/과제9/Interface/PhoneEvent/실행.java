package 과제9.Interface.PhoneEvent;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PhoneEvent pe = null;
		
		
		while(true) {
			
			System.out.println("길가에 핸드폰이 떨어져있습니다.");
			System.out.println("핸드폰을 확인하시려면 1번 , 그냥 가시려면 2번을 눌러주세요.");
			int event1 = sc.nextInt();
			
			if(event1 == 1) {
				System.out.println("핸드폰을 확인합니다.");
				pe = new Lock();
				pe.push();
				System.out.println("잠금을 해제하시겠습니다?");
				System.out.println("해제하시려면 1번 , 아니면 2번을 눌러주세요.");
				int event2 = sc.nextInt();
				if(event2 == 1) {
					pe.drag();
				}
				else if(event2 == 2) {break;}
			}else if(event1 == 2) {break;}
			
			pe = new Main();
			System.out.println("핸드폰의 메인화면이 보입니다. 중앙에는 별다른게 없습니다.");
			System.out.println("좌우메인화면을 확인합니다. 1. 좌측메인화면 2. 우측메인화면");
			int event3 = sc.nextInt();
			if(event3 == 1) {
				pe.drag();
				System.out.println("좌측메인화면입니다.");
				System.out.println("별다른건 보이지않습니다. 중앙메인화면으로 이동합니다.");
				
				
			}
			else if(event3 == 2) {
				pe.drag();
				System.out.println("우측메인화면입니다.");
				System.out.println("별다른건 보이지않습니다. 중앙메인화면으로 이동합니다.");
				
				
			}
			
			System.out.println("중앙에 수상한 앱이 생겼습니다.");
			pe.push();
			
			
			pe = new Apprun();
			System.out.println("앱을 실행하자 검은 화면만 보입니다.");
			System.out.println("앱이 이상합니다. 1. 터치해보기 2. 드래그해보기");
			int event4 = sc.nextInt();
			if(event4 == 1) {
				pe.push();
			}
			else if(event4 == 2) {
				pe.drag();
			}
			System.out.println("뭔가 머리가 아파옵니다..");
			System.out.println("뭔가 머리가 아파옵니다.......");
			System.out.println("뭔가 머리가 아파옵니다.............");
			System.out.println("-----------------");
			
		}
	}
}
















