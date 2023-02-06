package 과제.과제2;

import java.util.Scanner;

public class Console_키오스크 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//가격  콜라x : 300 , 사이다y : 400 , 환타z : 500
		int x = 300;
		int y = 400;
		int z = 500;
				
		//수량  콜라x1 : 10 , 사이다y1 : 8 , 환타z1 : 15
		int x1 = 10;
		int y1 = 8;
		int z1 = 15;
		
		int xe = 0;
		int ye = 0;
		int ze = 0;
	order :	while(true) {
			
			// 제품선택
			System.out.println("제품을 선택하세요. 1.콜라 / 2.사이다 / 3.환타 / 4. 결제,취소");
			int o = sc.nextInt();
			
			// 1. 콜라 구매
			if(o == 1) { // 구매수량 선택
				System.out.println("주문하실 콜라의 수량을 선택하세요.");
				xe += sc.nextInt(); // 주문수량 저장
				if(x1-xe < 0) { // 재고 - 구매한 수량이 0보다 작거나 같을경우에 주문취소 / 재고팝업
					System.out.println("재고가 부족합니다. 첫화면으로 돌아갑니다.");
					System.out.println("현재 재고는 " + x1 + "입니다.");
					System.out.println("다시 주문해주세요.");
					xe = 0; // 콜라 주문수량 초기화
					continue order;
				}
			 
			}
			
			// 2. 사이다 구매
			if(o == 2) { // 구매수량 선택
				System.out.println("주문하실 사이다의 수량을 선택하세요.");
				ye += sc.nextInt(); // 주문수량 저장
				if(y1-ye < 0) { // 재고 - 구매한 수량이 0보다 작거나 같을경우에 주문취소 / 재고팝업
					System.out.println("재고가 부족합니다. 첫화면으로 돌아갑니다.");
					System.out.println("현재 재고는 " + y1 + "입니다.");
					System.out.println("다시 주문해주세요.");
					ye = 0; // 사이다 주문수량 초기화
					continue order;
				}
			
			}
			
			// 3. 환타 구매
			if(o == 3) { // 구매수량 선택
				System.out.println("주문하실 환타의 수량을 선택하세요.");
				ze += sc.nextInt(); // 주문수량 저장
				if(z1-ze < 0) { // 재고 - 구매한 수량이 0보다 작거나 같을경우에 주문취소 / 재고팝업
					System.out.println("재고가 부족합니다. 첫화면으로 돌아갑니다.");
					System.out.println("현재 재고는 " + z1 + "입니다.");
					System.out.println("다시 주문해주세요.");
					ze = 0; // 환타 주문수량 초기화
					continue order;
				}
			
			}			
			
			// 4. 결제, 취소
		if(o == 4) {
				System.out.println("결제하시려면 1번 , 취소는 2번을 눌러주세요."); // 결제1 , 취소2 입력받기
				int o1 = sc.nextInt(); // 입력한 값 저장
				if(o1 == 1) { // 입력값이 1 = 결제이면
					System.out.println("---------------"); // 내용 출력
					System.out.println("주문내역\n"
							+ "콜라 : " + xe+"\n"
									+ "사이다 : " + ye+"\n"
											+ "환타 : " + ze+"\n"
													+ "총액 : "+(xe*x+ye*y+ze*z)+"원 입니다."); // 총결제액
					System.out.println("---------------");
					System.out.println("결제금액을 입력해주세요.");
					int p = sc.nextInt(); // 결제금액값 저장
						if(p >= (xe*x+ye*y+ze*z)) { // 입력받은 결제금액이 총액과 같거나 클경우
							System.out.println("결제되었습니다.");
							System.out.println("잔돈은 : "+(p-(xe*x+ye*y+ze*z))+"원 입니다."); // 잔돈 팝업
							// 제품 재고 정리 [ 재고 - 총 주문 수량]
							x1 -= xe;
							y1 -= ye;
							z1 -= ze;
							continue order;
						}
						// 입력받은 결제금액이 총액보다 작을경우
						else { System.out.println("결제액이 부족합니다.");
								System.out.println("주문이 취소되었습니다.");
								// 주문수량 초기화
								xe = 0;
								ye = 0;
								ze = 0;
								continue order;
						}
				}
				if(o1 == 2) {
					System.out.println("주문을 취소하셨습니다.");
					// 주문수량 초기화
					xe = 0;
					ye = 0;
					ze = 0;
					continue order;
					
				}
			}
		}
			
	}
}
