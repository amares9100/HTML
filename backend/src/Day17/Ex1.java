package Day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex1 {

	public static void main(String[] args) {
		
		
		
		double v1 = Math.ceil(5.3); // 올림
		double v2 = Math.floor(5.3);// 내림
		System.out.println("v1 : " +v1);
		System.out.println("v2 : " +v2);
		
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3 : "+v3);
		System.out.println("v4 : "+v4);
		
		double value = 12.3456;
		double temp1 = value*100;
		long temp2 = Math.round(temp1);
		double v5 = temp2/100.0;
		System.out.println("v5 : "+ v5);
		
		double v6 = Math.round(3.4567);
		System.out.println("v6 : "+ v6);
		
		
		Random ran = new Random();
		int x = ran.nextInt(45);
		System.out.println(x);
		
		System.out.println(String.format("%.2f", 3.14159));
		// 클래스 : 서로 다른 자료형/타입을 한곳[객체]에 저장
		// 배열/리스트 : 동일한 자료형의 데이터를 여러개 저장
			// int형 변수를 6개 저장할 수 있는 배열[고정길이 , 메소드제공x]
		int[] selectNumber = new int[6];
			// vs
			// int형 변수 6개를 저장할 수 있는 리스트 [가변길이 , 메소드제공o , 기본길이 10;]
		//ArrayList<Integer> selectNumber2 = new ArrayList<>(6);
			// 포장클래스 : 기본자료형 --> 클래스 [*특정API클래스중 기본자료형 사용불가]
		ran = new Random(3);
		System.out.println("선택번호");
		for(int i = 0 ; i < 6 ; i++) {
			selectNumber[i] = ran.nextInt(45)+1;
			System.out.print(selectNumber[i]+" ");
		}
		
		int[] winNumber = new int[6];
		ran = new Random(5);
		System.out.println("당첨번호");
		for(int i = 0 ; i < 6 ; i++) {
			winNumber[i] = ran.nextInt(45)+1;
			System.out.print(winNumber[i]+" ");
		}
		System.out.println();
		
		
		Arrays.sort(selectNumber); // 배열정렬
		System.out.println(Arrays.toString(selectNumber));
		Arrays.sort(winNumber);		// 배열정렬
		System.out.println(Arrays.toString(winNumber));
		boolean result = Arrays.equals(selectNumber, winNumber);
		System.out.println("당첨여부");
		if(result) {
			System.out.println("1등입니다");
		}else {System.out.println("당첨되지않았습니다");}
	}
}

























