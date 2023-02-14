package Day09.Ex4;

	// 오버라이딩 : 이미 존재하는 메소드를 제정의[리모델링]
	// 오버로딩  : 이름은 같되 매개변수의 타입, 개수, 순서가 다르게 여러개 선언
	//		생성자, 메소드 사용
	
public class Calculator {
	double areaRectangle(double width) {
		return width*width;
	}
	
	double areaRectangle(double width , double height) {
		return width*height;
	}
}
