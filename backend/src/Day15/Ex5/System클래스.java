package Day15.Ex5;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class System클래스 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		long time1 = System.nanoTime(); // 현재시간을 나노초로 표현
		int sum = 0;
		
		
		for(int i = 1 ; i <= 1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime();
		System.out.println(sum);
		System.out.println(time2 - time1);
		
		
		System.out.println("----------------");
		System.out.println("Key    :                            value");
		Properties props = System.getProperties(); // 모든 시스템 속성 호출
		
		for(Object obj : props.keySet()) { // 시스템 속성들의 키를 반복문 돌리기
			System.out.println(
					(String)obj +"              "+ // 해당 키를 문자열 변환
					System.getProperty((String)obj)// 해당 키를 이용한 속성 호출
					);
		}
		
		// p.520
		System.out.println("---------------------");
		String data = "자바";
		byte[] arr1 = data.getBytes(); 				// 문자열을 바이트열로 변환		인코딩 타입 : UTF-8 [한글 3바이트]
		System.out.println(arr1); 					// 배열의 주소값 출력
		System.out.println(Arrays.toString(arr1));	// 배열내 데이터 출력
		
		System.out.println("---------------------");
		// 문자열 -> 바이트열로 변환 getBytes()
		byte[] arr2 = data.getBytes("EUC-KR"); 		// 인코딩 타입 : EUC-KR [ 한글2바이트 ]
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("---------------------");
		// 바이트열 -> 문자열 new String(배열명)
		String str1 = new String(arr1);
		System.out.println(str1);
		
		System.out.println("---------------------");
		String str2 = new String(arr2 , "EUC-KR");
		System.out.println(str2);
		
		
	}
}















