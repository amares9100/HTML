package 과제9.Interface.Pay;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Pay pay = null;
		
		while(true) {
			System.out.println("직급과 한달동안 일한 시간 , 근속년수를 입력하세요.");
			System.out.println("------------------------------------");
			System.out.println("직급 : 1. 대리 , 2. 과장 , 3. 차장");
			int x = sc.nextInt();
			System.out.println("노동시간(정수) : ");
			int y = sc.nextInt();
			System.out.println("근속년수(정수) : ");
			int z = sc.nextInt();
			
			if(x == 1) {
				pay = new 대리();
				
			}
			else if(x == 2) {
				pay = new 과장();
				
			}
			else if(x == 3) {
				pay = new 차장();
				
			}
			System.out.println("------------------------");
			pay.월급(y);
			pay.성과금(z);
			pay.퇴직금(z);
			System.out.println("------------------------");
		}
	}
}
