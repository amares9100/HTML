package controller;

import model.Car;

public class run {
		public Car 대형 = new Car();
		public Car 중형 = new Car();
		public Car 소형 = new Car();
	
	// run을 소,중,대형으로 나눠줌.	
	public int run2() {
		System.out.println("[자동차가 달립니다.]");
		
		if( 대형.run() == 0){ // 리턴값이 0이면 도착
			stop(); 	return 5; 
			}
		if( 중형.run() == 0){ // 리턴값이 0이면 도착
			stop(); 	return 6;
			}
		if( 소형.run() == 0){ // 리턴값이 0이면 도착
			stop(); 	return 7;
			}
		return 1;
	}
	void stop() {}
	
	// 들어온 result에 따라 각 차종별 가격 출력
	public void price2(int result) {
		if(result == 7) {	
			
			소형.price();
		}
		else if(result == 6) {
			
			중형.price();
		}
		else if(result == 5) {
			
			대형.price();
		}
		
	}

}
