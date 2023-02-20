package Day14;

/*

		에러 : 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생
		예외 : 에러 이외 예외라는 오류
			* 잘못된 사용 또는 코딩 인해 발생
			* 잘못된 사용 : 사용자가 비정상적인 행동했을때 --> 경험바탕
				1. 일반 예외 : 컴파일전에 발생할 수 있는 예외 검사 [ *자바 외부 통신[스트림] ]
				2. 실행 예외 : 컴파일후에 발새하는 예외 --> 경험
		
		예외 클래스
			Exception 클래스 : 모든 예외를 받을 수 있는 예외중에 최상위 클래스
		
		문법
			try{
				1. 예외발생 할 것 같은 코드[경험]
			}
			catch(예외클래스 e){
				2. try{}에서 예외가 발생했을때 실행되는 코드 [ 만일 예외발생했을때 이후 실행 코드]
			}
			finally{
				3. 마지막으로 실행할 코드
			}
 
 
 
*/

public class Ex1_p466 {
	public static void printLength (String data) {
		try {	// 예외 발생할것 같은 코드를 try { } 안에 넣기
		int result = data.length();
		System.out.println("문자수: "+ result);
		}
		catch(NullPointerException e){	// 만약에 try { }안에서 예외 발생시 실행부
										// 예외가 발생하지않으면 실행안됨
		//	System.out.println(e.getMessage());
			System.out.println(e.toString());
		//	e.printStackTrace();
		}
		finally {
			System.out.println("[ 마무리 실행 ]");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("Thisisjava");
		printLength(null);					// NullPointerException : 데이터가 null이라서 length사용 불가
		System.out.println("[프로그램 종료]");
	}
}
