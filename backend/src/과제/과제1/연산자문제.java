package 과제.과제1;

import java.util.Scanner;

public class 연산자문제 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
	
/*		
		// 문제1
		System.out.println("문제1 ");
		System.out.println(
				"|\\_/|\n"
				+ "|q p|   /}\n"
				+ "( 0 )\"\"\"\\\n"
				+ "|\"^\"'    |\n"
				+ "||_/=\\\\__|"
				);
		
		
		// 문제2
		System.out.println("문제2");
		System.out.println("이름 입력 : ");
		String name = scanner.next();
		System.out.println("내용 입력 : ");
		String content = scanner.next();;
		System.out.println("날짜 입력 : ");
		String month = scanner.next();;
		System.out.println("-------------------------");
		System.out.printf(
				"|순번| 작성자 |    내용    |  날짜  |\n"
				+"| %1s |%4s | %6s | %5s |\n" , 1 , name , content , month
				);
		System.out.println("-------------------------");
		
		
		//문제3
		System.out.println("문제3");
		System.out.println("기본급 입력 : ");
		String strx = scanner.next();
		int x = Integer.parseInt(strx);
		
		System.out.println("수당 : ");
		String stry = scanner.next();
		int y = Integer.parseInt(stry);
		
		System.out.println("실수령액 = 기본급 + 수당 - 세금[기본급10%]");
		System.out.println("실수령액 : " + (int)(x + y - (x*0.1)));
		
		
		//문제4
		System.out.println("문제 4 - 금액 입력 : ");
		String str1 = scanner.next();
		int z = Integer.parseInt(str1);
		System.out.println("십만원부터 백원까지의 개수 세기");
		
		int q1 = z/100000;
		int q2 = (z-(q1*100000))/10000;
		int q3 = (z-(q1*100000)-(q2*10000))/1000;
		int q4 = (z-(q1*100000)-(q2*10000)-(q3*1000))/100;
		
		System.out.println("십만원 : " + q1 +"장\n"
							+"만원 : " + q2 +"장\n"
							+ "천원 : " + q3 + "장\n"
							+ "백원 : " + q4 + "개\n"
				);
		
		
		//문제5
		System.out.println("문제5");
		System.out.println("정수입력 : ");
		String str5 = scanner.next();
		int x5 = Integer.parseInt(str5);
		
		boolean bo5 = (x5%7 == 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수인가? : " + bo5);
		
		
		//문제6
		System.out.println("문제6");
		System.out.println("정수입력 : ");
		String str6 = scanner.next();
		int x6 = Integer.parseInt(str6);
		
		boolean bo6 = (x6%2 != 0) ? true : false;
		System.out.println("입력한 정수는 홀수인가? : " + bo6);
		
		
		//문제7
		System.out.println("문제7");
		System.out.println("정수입력 : ");
		String str7 = scanner.next();
		int x7 = Integer.parseInt(str7);
		
		boolean bo7 = (x7%7 == 0 && x7%2 == 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수이면서 짝수인가? : " + bo7);
		
		
		//문제8
		System.out.println("문제8");
		System.out.println("정수입력 : ");
		String str8 = scanner.next();
		int x8 = Integer.parseInt(str8);
		
		boolean bo8 = (x8%7 == 0 || x8%2 != 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수이거나 홀수인가? : " + bo8);
		
		
		//문제9
		System.out.println("문제9");
		System.out.println("정수1입력 : ");
		String str9 = scanner.next();
		int x9 = Integer.parseInt(str9);
		
		System.out.println("정수2입력 : ");
		String stry9 = scanner.next();
		int y9 = Integer.parseInt(stry9);
		
		int xy9 = 0;
		
		if(x9 > y9) {
			xy9 = x9;
		}
		else if (y9 > x9) {
			xy9 = y9;
		}
		else {System.out.println("x와 y는 같다.");}
			
		System.out.println("x와 y중 더 큰값  : " + xy9);
		
		
		//문제10
		System.out.println("문제10");
		System.out.println("반지름 입력 : ");
		String str10 = scanner.next();
		double x10 = Double.parseDouble(str10);
		
		System.out.println("원의 넓이 : " + (x10*x10*3.14));
		
		
		//문제11
		System.out.println("문제11");
		System.out.println("실수1 입력 : ");
		String str11 = scanner.next();
		double x11 = Double.parseDouble(str11);
		
		System.out.println("실수2 입력 : ");
		String stry11 = scanner.next();
		double y11 = Double.parseDouble(stry11);
		
		System.out.println("실수1은 실수2의 : " +(x11*100/y11) +"%");
		
		//문제12
		System.out.println("문제12");
		
		System.out.println("윗변 입력 : ");
		String str12 = scanner.next();
		double x12 = Double.parseDouble(str12);
		
		System.out.println("밑변 입력 : ");
		String stry12 = scanner.next();
		double y12 = Double.parseDouble(stry12);
		
		System.out.println("높이 입력 : ");
		String strz12 = scanner.next();
		double z12 = Double.parseDouble(strz12);
		
		System.out.println("사다리꼴 넓이 : " + (x12*y12*z12/2));
	
		//문제13
		
		System.out.println("문제13");
		
		System.out.println("키 입력 : ");
		String str13 = scanner.next();
		int x13 = Integer.parseInt(str13);
		
		System.out.println("표준체중 : "+ (int)((x13-100)*0.9));
		
	
		//문제14
		System.out.println("문제14");
		
		System.out.println("키 입력 : ");
		String str14 = scanner.next();
		int x14 = Integer.parseInt(str14);
		
		System.out.println("몸무게 입력 : ");
		String stry14 = scanner.next();
		int y14 = Integer.parseInt(stry14);
		
		double z14 = y14/((x14/100)*(x14/100));
		System.out.println("MBI 계산 : " + z14);
		
		
		
		//문제15
		System.out.println("문제15");
		
		System.out.println("inch 입력 : ");
		String str15 = scanner.next();
		int x15 = Integer.parseInt(str15);
		
		double y15 = x15*2.54;
		
		System.out.println("cm변환값 : " + y15+"cm");
	
		
		//문제16
		System.out.println("문제16");
		
		System.out.println("중간고사점수 입력 : ");
		String str16 = scanner.next();
		int x16 = Integer.parseInt(str16);
		
		System.out.println("기말고사점수 입력 : ");
		String stry16 = scanner.next();
		int y16 = Integer.parseInt(stry16);
		
		System.out.println("수행평가점수 입력 : ");
		String strz16 = scanner.next();
		int z16 = Integer.parseInt(strz16);
		
		double xyz16 = (x16*0.3)+(y16*0.3)+(z16*0.4);
		double x16a =	(x16*0.3);
		double y16a =	(y16*0.3);
		double z16a =	(z16*0.4);
		System.out.printf("중간고사비율 : %3.2f \n"
				+ "기말고사비율 : %3.2f \n"
				+ "수행평가비율 : %3.2f \n"
				+ "총합 : %3.2f" , x16a , y16a , z16a , xyz16);
*/		
		
		//문제17
		System.out.println("문제17");
		
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.println("10+5+8");
		System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
		

		
	}
}












