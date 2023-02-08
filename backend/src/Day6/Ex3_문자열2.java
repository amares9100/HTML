package Day6;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex3_문자열2 {
	public static void main(String[] args) throws IOException{
		
		
		while(true) {
		//1. 문자열 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("안내문구 입력 :");
		String a = sc.nextLine()+"\n";
		System.out.println(a);
		
		//FileOutputStream("파일경로"); : 파일쓰기 클래스
		//FileOutputStream("파일경로" , true) : 파일 이어쓰기
		FileOutputStream fout = new FileOutputStream("C:/Users/504/Desktop/test.txt" , true);
		
		
		fout.write( a.getBytes() );
		}
		
		
	}
}
