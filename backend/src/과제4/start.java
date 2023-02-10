package 과제4;


/*

	MVC : 디자인패턴 [관점별 파일 구분]
		M : Model		데이터			DB
		V : View		화면				HTML, CSS, JS
		C : controller	제어[로직/기능처리]	JAVA

*/


public class start {
	public static void main(String[] args) {
		과제4.view.Front front = new 과제4.view.Front();
		front.index();
		
	}
}
