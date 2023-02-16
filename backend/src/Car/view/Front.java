package Car.view;

import java.util.Scanner;

import Car.controller.run;
import Car.model.대형;
import Car.model.소형;
import Car.model.중형;



public class Front {
	
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		run run = new run();
		
		
		
		// 목적지 입력
		System.out.println("목적지를 입력하세요.");
		System.out.println("1. 대전 2. 대구 3. 부산");
		int ch = sc.nextInt();
		
		// 목적지 입력시 지역값 대입
		if(ch == 1) ch = 20;
		if(ch == 2) ch = 30;
		if(ch == 3) ch = 36;
		
		// stopper
		int x= 0;
		int y= 0;
		int z= 0;
		
		
		
	no : for(int i = 1 ; i <=20 ; i++) {
			
		//첫 시작에 지역값 포함해서 소중대형에 값 대입
			if(i == 1) {
				run.대형 = new 대형("대형" , 6 ,30000 , ch);
				run.중형 = new 중형("중형" , 8 ,20000 , ch);
				run.소형 = new 소형("소형" , 10 ,20000 , ch);
			}
			
			// 턴[TIME] 출력
			System.out.println(i+"Time");
			
			// 자동차 run
			int result = run.run2();
		
			
			// 요금 출력
			if(result == 5 && x == 0) { // run반환값이 5(대형)이고 x가 0이면
				x++;					// x++
				run.price2(result);		// 요금표 출력
				break no;				// 대형차가 가장 느리기때문에 들어오면 반복문 break;
			}
			else if( result == 6 && y == 0) {// run반환값이 5(대형)이고 y가 0이면
				y++;						// y++
				run.price2(result);			// 요금표 출력
				
			}
			else if(result == 7 && z == 0) {// run반환값이 5(대형)이고 z가 0이면
				z++;						// z++
				run.price2(result);			// 요금표 출력
				
			}
			}
		}
		
	}
