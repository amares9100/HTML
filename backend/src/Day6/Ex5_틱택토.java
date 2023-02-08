package Day6;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {
	public static void main(String[] args) {
		
		
		
		int[] arr = {
				3, 3, 3,
				3, 3, 3,
				3, 3, 3
		};
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("player : 1 vs com : 2");
		
		//휴먼
	no : while(true) {
			
		// 판 출력
			System.out.println("----------------");
			for(int i = 0 ; i <arr.length ; i++) {
				System.out.print(arr[i]+ " ");
				if( i%3 == 2) {
					System.out.println();
				}
			}
			System.out.println("-----------------");
		
			// player 시작
			System.out.println("player 위치선택 0~8 : ");
			int a = sc.nextInt();
			
			if(a < 9 && arr[a] != 1 && arr[a] != 2) {
				arr[a] = 1; // 플레이어 돌
			}
			else { // 반복문 처음으로 되돌아감
				System.out.println("다시 선택해주세요.");
				continue no;
			}
			
			// 판 재출력
			System.out.println("---------------");
			for(int i = 0 ; i <arr.length ; i++) {
				System.out.print(arr[i]+ " ");
				if( i%3 == 2) {
					System.out.println();
				}
			}
			System.out.println("-------------------");
			
			
			// 플레이어 승리판단
			if((arr[0] == 1 && arr[1] == 1 && arr[2] == 1) || (arr[3] == 1 && arr[4] == 1 && arr[5] == 1) || (arr[6] == 1 && arr[7] == 1 && arr[8] == 1)) {
				System.out.println("player win");
				break no;
			}
			else if((arr[0] == 1 && arr[3] == 1 && arr[6] == 1) || (arr[1] == 1 && arr[4] == 1 && arr[7] == 1) || (arr[2] == 1 && arr[5] == 1 && arr[8] == 1)) {
				System.out.println("player win");
				break no;
			}
			else if((arr[0] == 1 && arr[4] == 1 && arr[8] == 1) || (arr[2] == 1 && arr[4] == 1 && arr[6] == 1)) {
				System.out.println("player win");
				break no;
			}
			
			// 무승부 판단
			int sum = 0;
			for(int i = 0 ; i < arr.length; i++) { 
			sum += arr[i]; // 판에 있는 수의 총합
			}
			if(sum < 15) { // 판에 놓을 수 있는 돌 수(length = 9), 1턴 => 플레이어 1 + com 2 = 3 , 게임은 4턴 + 5턴의 플레이어 까지
										// 3*4 = 12 + 3(아직 안놓은 곳) -> 판에 놓인 수의 총합이 15보다 작으면 더이상 돌을 놓을 수 없음.
				System.out.println("더이상 둘곳이 없습니다.");
				System.out.println("무승부입니다.");
				break no;
			}
			
			// 컴퓨터
com :	while(true) {
			
			// 컴퓨터용 변수생성
			Random rd = new Random();
			int c = rd.nextInt(9);
			System.out.println("com 선택 : " + c);
			// 유효성 검사
			if(c < 9 && arr[c] != 1 && arr[c] != 2) {
				
				arr[c] = 2;
				break;
			}
			else { // 검사 실패시 com : while로 돌아감
				System.out.println("com 다시 자리를 찾습니다.");
				continue com;
			}
			
		} // com : while - e -
			//판 재출력
			System.out.println("---------------");
			for(int i = 0 ; i <arr.length ; i++) {
				System.out.print(arr[i]+ " ");
				if( i%3 == 2) {
					System.out.println();
				}
			}
			System.out.println("-------------------");
	
			// 컴퓨터 승리판단
			if((arr[0] == 2 && arr[1] == 2 && arr[2] == 2) || (arr[3] == 2 && arr[4] == 2 && arr[5] == 2) || (arr[6] == 2 && arr[7] == 2 && arr[8] == 2)) {
				System.out.println("com win");
				break no;
			}
			else if((arr[0] == 2 && arr[3] == 2 && arr[6] == 2) || (arr[1] == 2 && arr[4] == 2 && arr[7] == 2) || (arr[2] == 2 && arr[5] == 2 && arr[8] == 2)) {
				System.out.println("com win");
				break no;
			}
			else if((arr[0] == 2 && arr[4] == 2 && arr[8] == 2) || (arr[2] == 2 && arr[4] == 2 && arr[6] == 2)) {
				System.out.println("com win");
				break no;
			}
		} // no : while - e -				
	}			
}

