package Day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_p468 {
	public static void main(String[] args){
		try {
			Class.forName("java.lang.String");	// 클래스가 존재
			System.out.println("클래스가 존재합니다.");
		}
		catch(ClassNotFoundException e) {	// try에서 예외가 발생하지 않아서 catch실행 안됨
			e.printStackTrace();
		}
		
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");	// 클래스가 존재하지 않음
			System.out.println("클래스가 존재합니다.");
		}
		catch(ClassNotFoundException e) {	// try에서 예외가 발생해서 catch실행 됨
			e.printStackTrace();	
		}
		
		String[] array = {"100","1oo"};
		
		for(int i = 0 ; i <= array.length ; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array["+i+"]: " + value);
			}
		//	catch(Exception e) {
		//		System.out.println("예외 발생");
		//	}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열인덱스 초과");
			}
			catch(NumberFormatException e) {
				System.out.println("숫자변환 안됨");
			}
		}
		
		
		while(true) {
			try {
			Scanner sc = new Scanner(System.in);
			int cn = sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
