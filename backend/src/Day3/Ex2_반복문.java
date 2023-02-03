package Day3;

import java.util.Iterator;

public class Ex2_반복문 {
	public static void main(String[] args) {
		for(int i=1; i<=10;i++) {
			System.out.print(i+" ");
		}
		
		int sum = 0;
		int j;
		for(j=1 ; j<=100; j++) {
			sum+=j;
		}
		System.out.println(sum);
		
		
		for(int m=2 ; m<=9; m++) {
			System.out.println("***" + m + "단***");
			for(int n=1 ; n<=9; n++) {
				System.out.println(m+"x"+n+" = "+ (m*n));
			}
		}
		
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if(num == 6) {
				System.out.println("6이 나왔습니다. 탈출합니다.");
				break; // 가장 가까운 반복문 탈출
			}
		}
		
		
		no1 : for(char upper = 'A' ; upper <= 'Z'; upper++) {
			System.out.println(upper);
			for(char lower = 'a' ; lower <= 'z'; lower++) {
				System.out.println("\t"+lower);
				if(lower == 'g') {
					break no1; // 이름지정으로 특정위치 break 가능
				}
			}
		}
		
		
		
		for(int x = 1; x<=10 ; x++) {
			if(x%2 != 0) {
				continue; // 가장 가까운 반복문[증감식]으로 이동
			}
			System.out.println(x+" ");
		}
		
		
		
		
		
		
		
		
	}
}
