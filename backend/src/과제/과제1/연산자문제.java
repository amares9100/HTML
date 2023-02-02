package 과제.과제1;

import java.util.Scanner;

public class 연산자문제 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
	
	
		// 문제1 - 강아지 console 출력
		System.out.println("문제1 - 강아지 console 출력");
		System.out.println(
				"|\\_/|\n"
				+ "|q p|   /}\n"
				+ "( 0 )\"\"\"\\\n"
				+ "|\"^\"'    |\n"
				+ "||_/=\\\\__|"
				);
		
		
		// 문제2 - 입력받은 3개 데이터를 이용한 표 만들기 
		System.out.println("문제2 - 입력받은 3개 데이터를 이용한 표 만들기");
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
		
		
		//문제3 - 급여 계산
		System.out.println("문제3 - 급여 계산");
		System.out.println("기본급 입력 : ");
		String strx = scanner.next();
		int x = Integer.parseInt(strx);
		
		System.out.println("수당 : ");
		String stry = scanner.next();
		int y = Integer.parseInt(stry);
		
		System.out.println("실수령액 = 기본급 + 수당 - 세금[기본급10%]");
		System.out.println("실수령액 : " + (int)(x + y - (x*0.1)));
		
		
		//문제4 - 지폐 세기
		System.out.println("문제 4 - 지폐 세기");
		System.out.println("금액 입력 : ");
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
		
		
		//문제5 - 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]
		System.out.println("문제5 - 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]");
		System.out.println("정수입력 : ");
		String str5 = scanner.next();
		int x5 = Integer.parseInt(str5);
		
		boolean bo5 = (x5%7 == 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수인가? : " + bo5);
		
		
		//문제6 - 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]
		System.out.println("문제6 - 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]");
		System.out.println("정수입력 : ");
		String str6 = scanner.next();
		int x6 = Integer.parseInt(str6);
		
		boolean bo6 = (x6%2 != 0) ? true : false;
		System.out.println("입력한 정수는 홀수인가? : " + bo6);
		
		
		//문제7 - 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]
		System.out.println("문제7 - 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]");
		System.out.println("정수입력 : ");
		String str7 = scanner.next();
		int x7 = Integer.parseInt(str7);
		
		boolean bo7 = (x7%7 == 0 && x7%2 == 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수이면서 짝수인가? : " + bo7);
		
		
		//문제8 - 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]
		System.out.println("문제8 - 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]");
		System.out.println("정수입력 : ");
		String str8 = scanner.next();
		int x8 = Integer.parseInt(str8);
		
		boolean bo8 = (x8%7 == 0 || x8%2 != 0) ? true : false;
		System.out.println("입력한 정수는 7의 배수이거나 홀수인가? : " + bo8);
		
		
		//문제9 - 두개의 정수를 입력받아 더 큰수 출력
		System.out.println("문제9 - 두개의 정수를 입력받아 더 큰수 출력");
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
		
		
		//문제10 - 반지름을 입력받아 원 넓이 출력하기 
		System.out.println("문제10 - 반지름을 입력받아 원 넓이 출력하기");
		System.out.println("반지름 입력 : ");
		String str10 = scanner.next();
		double x10 = Double.parseDouble(str10);
		
		System.out.println("원의 넓이 : " + (x10*x10*3.14));
		
		
		//문제11 - 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
		System.out.println("문제11 - 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기");
		System.out.println("실수1 입력 : ");
		String str11 = scanner.next();
		double x11 = Double.parseDouble(str11);
		
		System.out.println("실수2 입력 : ");
		String stry11 = scanner.next();
		double y11 = Double.parseDouble(stry11);
		
		System.out.println("실수1은 실수2의 : " +(x11*100/y11) +"%");
		
		//문제12 - 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기
		System.out.println("문제12 - 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기");
		
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
	
		//문제13 - 키를 정수를 입력받아 표준체중 출력하기 
		
		System.out.println("문제13 - 키를 정수를 입력받아 표준체중 출력하기");
		
		System.out.println("키 입력 : ");
		String str13 = scanner.next();
		int x13 = Integer.parseInt(str13);
		
		System.out.println("표준체중 : "+ (int)((x13-100)*0.9));
		
	
		//문제14 - 키와 몸무게를 입력받아 BMI 출력하기
		System.out.println("문제14 - 키와 몸무게를 입력받아 BMI 출력하기");
		
		System.out.println("키 입력 : ");
		String str14 = scanner.next();
		int x14 = Integer.parseInt(str14);
		
		System.out.println("몸무게 입력 : ");
		String stry14 = scanner.next();
		int y14 = Integer.parseInt(stry14);
		
		double z14 = y14/((x14/100)*(x14/100));
		System.out.println("MBI 계산 : " + z14);
		
		
		
		//문제15 - inch 를 입력받아 cm 로 변환하기 
		System.out.println("문제15 - inch 를 입력받아 cm 로 변환하기 ");
		
		System.out.println("inch 입력 : ");
		String str15 = scanner.next();
		int x15 = Integer.parseInt(str15);
		
		double y15 = x15*2.54;
		
		System.out.println("cm변환값 : " + y15+"cm");
	
		
		//문제16 - 중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
		//계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %
		System.out.println("문제16 - 중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오");
		
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
				+ "총합 : %3.2f\n" , x16a , y16a , z16a , xyz16);
	
		
		//문제17 - 연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
		System.out.println("문제17 - 연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.");
		
		int x17 = 10;
		int y17 = x17-- + 5 + --x17;
		System.out.printf(" x의 값 : %d , y의값 :  %d ", x17, y17);
		System.out.println("10(--전값)+5+8(앞의 --와 이번 --로 -2)");

		
		//문제18 - 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
		System.out.println("문제18 - 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기");
		
		System.out.println("나이 입력 : ");
		String str18 = scanner.next();
		int x18 = Integer.parseInt(str18);
		
		if(x18 >= 40) {
			System.out.println(x18 + " = 중년입니다.");
		}
		else if (x18 >= 20) {
			System.out.println(x18 + " = 성인입니다.");
		}
		else if (x18 >= 10) {
			System.out.println(x18 + " = 학생입니다.");
		}
		else {
			System.out.println(x18 + " = 아가입니다.");
		}
	



		
		//문제19 - 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력
		System.out.println("문제19 - 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력");
		
		System.out.println("국어점수 입력 : ");
		String str19 = scanner.next();
		int x19 = Integer.parseInt(str19);
		
		System.out.println("영어점수 입력 : ");
		String stry19 = scanner.next();
		int y19 = Integer.parseInt(stry19);
		
		System.out.println("수학점수 입력 : ");
		String strz19 = scanner.next();
		int z19 = Integer.parseInt(strz19);
		
		int xyz19 = x19+z19+y19;
		double xyz19a = xyz19/3;
		
		System.out.println("총점 : " + xyz19);
		System.out.printf("평균 : %3.2f\n" , xyz19a);



		//문제20 - 아이디[문자열] 와 비밀번호[문자열] 를 입력받아
		//아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력
		System.out.println("문제20 - 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 /n 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력");
		
		System.out.println("아이디 입력 : ");
		String str20 = scanner.next();
		
		
		System.out.println("비밀번호 입력 : ");
		String stry20 = scanner.next();
		
		
		
		if(! str20.equals("admin")) {
			System.out.println("로그인 실패 : 아이디가 틀립니다.");
		}
		else if (! stry20.equals("1234")) {
			System.out.println("로그인 실패 : 비밀번호가 틀립니다.");
		}
		else {
			System.out.println("로그인성공");
		}
	
		
		//문제21 - 세 정수를 입력받아 가장 큰수 출력
		System.out.println("문제21 - 세 정수를 입력받아 가장 큰수 출력");
		
		System.out.println("정수1 입력 : ");
		String str21 = scanner.next();
		int x21 = Integer.parseInt(str21);
		
		System.out.println("정수2 입력 : ");
		String stry21 = scanner.next();
		int y21 = Integer.parseInt(stry21);
		
		System.out.println("정수3 입력 : ");
		String strz21 = scanner.next();
		int z21 = Integer.parseInt(strz21);
		
		if(x21 > y21 && x21 > z21) {
			System.out.println("가장 큰 정수 :" + x21);
		}
		else if (y21 > x21 && y21 > z21) {
			System.out.println("가장 큰 정수 :" + y21);
		}
		else if (z21 > x21 && z21 > y21) {
			System.out.println("가장 큰 정수 :" + z21);
		}
	

		
		//문제22 - [ 가위바위보 게임 ] 
		System.out.println("문제22 - [ 가위바위보 게임 ] ");
		
		System.out.println("player1 = 가위(0),바위(1),보(2) 입력 : ");
		String str22 = scanner.next();
		int x22 = Integer.parseInt(str22);
		
		System.out.println("player2 = 가위(0),바위(1),보(2) 입력 : ");
		String stry22 = scanner.next();
		int y22 = Integer.parseInt(stry22);
		// 플레이어1
		if(y22 == 0 && x22 == 1) {
			System.out.println("player1 승리 : " +"player1바위("+x22+")"+" vs "+"player2가위("+y22+")");
		}
		else if (y22 == 1 && x22 == 2) {
			System.out.println("player1 승리 : " +"player1보("+x22+")"+" vs "+"player2바위("+y22+")");
		}
		else if (y22 == 2 && x22 == 0) {
			System.out.println("player1 승리 : " +"player1가위("+x22+")"+" vs "+"player2보("+y22+")");
		}
		// 플레이어2
		else if(x22 == 0 && y22 == 1) {
			System.out.println("player2 승리 : " +"player2바위("+y22+")"+" vs "+"player1가위("+x22+")");
		}
		else if (x22 == 1 && y22 == 2) {
			System.out.println("player2 승리 : " +"player2보("+y22+")"+" vs "+"player1바위("+x22+")");
		}
		else if (x22 == 2 && y22 == 0) {
			System.out.println("player2 승리 : " +"player2가위("+y22+")"+" vs "+"player1보("+x22+")");
		}
		else if(x22 == y22 && x22 == 0){
			System.out.println("무승부 : " +"가위 vs 가위");
		}	
		else if(x22 == y22 && x22 == 1){
			System.out.println("무승부 : " +"바위 vs 바위");
		}	
		else if(x22 == y22 && x22 == 2){
			System.out.println("무승부 : " +"보 vs 보");
		}
		else {
			System.out.println("입력값이 잘못되었습니다.");
		}
	}
}



