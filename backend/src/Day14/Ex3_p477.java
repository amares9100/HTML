package Day14;

/*
	예외 떠넘기기
		- 메소드 내부에서 예외발생했을때 메소드 호출했던 곳으로 예외를 넘기기

*/

public class Ex3_p477 {
	
	public static void findClass() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
	}
	
	public static void main(String[] args) throws Exception{
		try {
			findClass();
		}
		catch(ClassNotFoundException e) {
			System.out.println("예외처리 : "+ e.toString());
		}
		
	}
}
