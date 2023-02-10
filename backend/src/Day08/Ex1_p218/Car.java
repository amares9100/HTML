package Day08.Ex1_p218;

// 멤버 : 1.필드  2. 생성자  3. 메소드
public class Car {
	
	// 1. 필드
	String model;
	String color;
	int maxSpeed;
	// 2. 생성자 
		// 1. 생성자가 1개도 없을때 기본생성자 사용가능
		// 2. 생성자 이름은 클래스명과 동일!! 다르면 함수 취급을 당함.
		// 3. 기본생성자[깡통] , 풀생성자 -> 관례적으로 만들고 시작
		// 4. 오버로딩 : 이름이 동일할 경우 시그니쳐(매개변수 개수 , 타입)을
			// 이용해서 식별 가능
		// 5. 오버라이딩 : 부모의 메소드를 재정의(리모델링)
	
	// 1. 빈생성자 = 객체 생성시 매개변수가 없다.
	Car() {}
	// 2. 2개의 매개변수를 받는다.
	Car( String model , String color){
		this.model = model;
		// this.필드명 = 매개변수
		this.color = color;
	}
		
	// 2. 3개의 매개변수를 받는다.
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
	
}
