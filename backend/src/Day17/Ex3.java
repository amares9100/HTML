package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		// - static 멤버는 인스턴스 멤버 호출 x
			// 1. run메소드도 정적멤버로 만듬
				run2();
			// 2. [해당 멤버[메소드/필드]가 인스턴스 멤버라면] 클래스 객체만들어서 불러옴
				Ex3 ex3 = new Ex3();
				ex3.run();
		
	}
	
	
	// 달력 함수
	void run() {
		// 1. 현재 날짜
		Calendar cal = Calendar.getInstance();
		// 2. 현재 연도
		int year = cal.get(Calendar.YEAR);
		// 3. 현재 월
		int month = cal.get(Calendar.MONTH)+1;
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		System.out.printf("=====================%d년 %d월=====================\n" , year , month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//*** 현재 월의 1일 날짜의 요일
		cal.set(year, month-1 , 1); // 사용자가 직접 연 월 일을 셋팅 2023/2/1 
		int sweek = cal.get(Calendar.DAY_OF_WEEK);
		//*** 현재 월의 마지막 날
		int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 2023년/2월의 마지막 일수 
		
		
		
		for(int i = 1 ; i < sweek ; i++) {
			System.out.print("\t");
		}
		for(int i = 1 ; i <= eday ; i++) {
			System.out.printf("%2d \t" , i);
			if(sweek%7 == 0) {
				System.out.println();
				
			}
			sweek++;
		}
			System.out.println();
			System.out.println("=====================================================");
			System.out.println("1. 이전달 / 2. 다음달 / 3. 검색");
			int ch = sc.nextInt();
			if(ch==1) {
				month--;
				if(month < 1) {
					month=12;
					year--;
				}
			}
			else if(ch==2) {
				month++;
				if(month>12) {
					month=1;
					year++;
				}
			}
			else if(ch==3) {
				System.out.println("연도 : "); int inputY = sc.nextInt();
				System.out.println("월 : ");	int inputM = sc.nextInt();
				if(inputY >= 1900 && inputY<=9999 && inputM>=1 && inputM<=12) {
					year = inputY;
					month = inputM;
				}
				else {System.out.println("출력할 수 없는 달력입니다.");}
			}
		}
	}
	
	static void run2() {
		for(int i = 99; i >= 0; i--){
            switch(i){
                        case 0:
                        System.out.println("'No more bottles of beer on the wall, no more bottles of beer." );
                        System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
                        break;
                       
                        case 1:
                        System.out.println(i + "bottle of beer on the wall, " + i + "bottle of beer.");
                        System.out.println("Take one down and pass it around, no more bottles of beer on the wall.");
                        break;
                       
                        case 2:
                        System.out.println(i + "bottles of beer on the wall, " + i + "bottles of beer.");
                        System.out.println("Take one down and pass it around, 1 bottle of beer on the wall.");
                        break;
                        
                        default:
                        System.out.println(i + "bottles of beer on the wall, " + i + "bottles of beer.");
                        System.out.println("Take one down and pass it around, " + (i-1) + "bottles of beer on the wall.");
            }
        }
	}
	
	
	
	
	
	
	
	
}
