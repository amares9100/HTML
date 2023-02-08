package Day6;

public class Ex1_참조타입 {
	public static void main(String[] args) {
		int[] arr1;
		int[] arr2;
		int[] arr3;
		
		arr1 = new int[] {1, 2, 3};
		arr2 = new int[] {1, 2, 3};
		arr3 = arr2;
		
		System.out.println(arr1 == arr2);
		
		System.out.println(arr2 == arr3);
		
		int[] intArray = null;
		//intArray[0] = 10;  - NullpointerException
		
		String str = null;
		//System.out.println(str.length()); - NullpointerException
		
		String name1 = "재석"; // 스택영역에 name1 변수 선언 - 힙영역에 재석의 메모리주소 할당
		String name2 = "재석"; // 스택영역에 name2 변수 선언 - 재석의 메모리주소를 가져옴
		System.out.println("----------------");
		System.out.println(name1 == name2); // 같은 메모리주소를 공유하기때문에 true
		
		String name3 = new String("재석"); // 스택영역에 name3 변수 선언 - 힙영역에 새로운 메모리 주소에 재석 할당
		String name4 = new String("재석"); // 스택영역에 name4 변수 선언 - 힙영역에 새로운 메모리 주소에 재석 할당
		
		// name1 == name2 / name2 != name3 / name3 != name4
		System.out.println("----------------");
		System.out.println(name2 == name3); // 할당된 메모리주소가 다르기때문에 false
		System.out.println(name3 == name4); // 할당된 메모리주소가 다르기때문에 false
		
		System.out.println("----------------");
		System.out.println(name1.equals(name4)); // 메모리주소가 아닌 내부 문자열만 비교할때는 equals사용.
		System.out.println(name1.equals(name3)); // 메모리주소는 다르지만 내부 문자열이 동일하기때문에 true
		
		
		
		// 자바 문자열 함수들
		/*
		 * 1. .charAt(인덱스); : 인덱스 위치의 문자 1개 추출 
		 * 2. .length(); : 문자열 길이 
		 * 3. .replace("기존문자" , "새로운 문자"); : 기존문자를 새로운 문자로 치환/교체 
		 * 4. .subString(인덱스); : 0 ~ 인덱스 자르기
		 * 	  .subString(s인덱스, e인덱스); : s~e인덱스 자르기 
		 * 5. .split("자를기준"); : 기준문자 기준으로 자르기 
		 * 6. .indexof("찾을문자"); : 찾을문자의 찾은 인덱스 번호 반환
		 */		
		
		// ' ' : 문자	char		: 기본타입
		// " " : 문자열	String		: 참조타입
		
		//  1. .charAt(인덱스); : 인덱스 위치의 문자 1개 추출 
		String ssn = "9506241230123";
		char sex = ssn.charAt(6);
		System.out.println(sex);
		if( sex == '1' || sex == '3') {
			System.out.println("남자");
		}
		else {System.out.println("여자");}
		
		
		// 2. .length(); : 문자열 길이 
		int length = ssn.length();
		if(length == 13) {
			System.out.println("13자리 확인");
		}
		else {System.out.println("자리수 틀림");}
		
		
		// 3. .replace("기존문자" , "새로운 문자"); : 기존문자를 새로운 문자로 치환/교체 
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 불변입니다.";
		String newStr = oldStr.replace("자바", "java");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		//4. .subString(인덱스); : 0 ~ 인덱스 자르기
		//     .subString(s인덱스, e인덱스); : s~e인덱스 자르기
		
		ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
		
		//5. .split("자를기준"); : 기준문자 기준으로 자르기 
		String ssn2 = "880815-9876541";
		System.out.println(ssn2.split("-"));
		System.out.println(ssn2.split("-")[0]);
		System.out.println(ssn2.split("-")[1]);
		
		
		String board = "1,자바 학습,참조 타입 string을 학습합니다.,홍길동";
		String[] token = board.split(","); // ,기준으로 인덱스/배열로 저장
		System.out.println(token[0]);		// ,기준 인덱스0 / 저장된 값 : 1
		System.out.println(token[1]);		// ,기준 인덱스1 / 저장된 값 : 자바 학습
		System.out.println(token[2]);		// ,기준 인덱스2 / 저장된 값 : 참조 타입 string을 학습합니다.
		System.out.println(token[3]);		// ,기준 인덱스3 / 저장된 값 : 홍길동
		//6. .indexof("찾을문자"); : 찾을문자의 찾은 인덱스 번호 반환
		
		
		
		
		
		
		
		
		
		
		
	}
}
