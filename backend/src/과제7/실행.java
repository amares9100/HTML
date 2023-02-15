package 과제7;

import java.util.Scanner;


public class 실행 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		accountCreate accountCreate = new accountCreate();
		Accounts accounts = new Accounts();
		while(true) {
			System.out.println("1. 계좌생성   2. 예금");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				System.out.println("-------계좌생성-------");
				System.out.println("은행을 선택하세요.");
				System.out.println("1. 신한은행 2. 국민은행 3. 우리은행");
				int ch2 = sc.nextInt();
				if(ch2 == 1) {
					
				}
				else if(ch2 == 2) {
					
				}
				else if(ch2 == 3) {
					
					String name = sc.next();
					String pw = sc.next();
					accountCreate.woori = new Woori(name, pw);
					int result = accountCreate.run(name , pw);
					
					if(result == 0) {
						System.out.println("계좌등록에 성공했습니다.");
					}
			
			}
		}else if(ch == 2) {
			System.out.println("예금확인");
			
		
		}
			
	}
}

	@Override
	public String toString() {
		return "실행 [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}