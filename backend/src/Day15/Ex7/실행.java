package Day15.Ex7;

import java.text.ParseException;
import java.util.ArrayList;

public class 실행 {
	public static void main(String[] args) {
		//p.526
		Integer obj = 100;			// boxing // 객체화
		System.out.println(obj);
		
		
		int value = obj;			// unboxing
		System.out.println(value);
		
		
		int result = obj + 100; // 연산시 obj 언박싱됨
		System.out.println(result);
		
		
		//value.?? 접근연산자 반응없음
		// obj.byteValue(); // 접근연산자 사용가능
		
		//ArrayList < int > list = new ArrayList<>();  // 기본값은 불가능
		ArrayList< Integer > list2 = new ArrayList<>(); // 객체지원
	}


}
