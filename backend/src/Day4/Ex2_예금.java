package Day4;

import java.util.Scanner;

public class Ex2_예금 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int y = 0;
		String ac = "123-1234";
		short pw = 1234;
		while(true) {
			System.out.println("---------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료 : ");
			System.out.println("---------------------");
			System.out.println(">> 선택 : ");

			int x = sc.nextInt();
			if(x==1) {
				System.out.println(">>> 예금할 계좌번호");
				String inac = sc.next();
				if(inac.equals(ac)) {
					System.out.println("예금 금액을 입력하세요.");
					y += sc.nextInt();
				}
				else {
					System.out.println("없는 계좌입니다.");
				}
			}
			else if (x==2) {
				System.out.println("출금할 계좌번호를 입력하세요.");
				String inac = sc.next();
				System.out.println("출금계좌의 비밀번호를 입력하세요.");
				short inpw = sc.nextShort();
				if (inac.equals(ac)) {
					if(inpw == pw) {
						System.out.println("출금 금액을 입력하세요.");
						y-= sc.nextInt();
					}
				}

			}
			else if (x==3) {
				System.out.println("잔고 : "+ y + "원 입니다.");
			}
			else if (x==4) {
				System.out.println("종료"); break;
			}
			else {
				System.out.println("알수없는 입력");
			}
		}
	}
}
