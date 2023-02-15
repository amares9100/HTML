package 과제6;

public class Ex5_실행 {
	
	public static void main(String[] args) {
		
		Car car = new Car(); 
		for( int i = 1 ; i<=10 ;i++ ) {
			int result =  car.run();
			if( result == 1 ) car.frontLeftTire = new HanKookTire( 15 , "앞왼쪽" ); 
			if( result == 2 ) car.frontRightTire = new HanKookTire( 13 , "앞오른쪽" );
			if( result == 3 ) car.backLeftTire = new KumhoTire( 14 , "뒤왼쪽" );
			if( result == 4 ) car.backRightTire = new KumhoTire( 17 , "뒤오른쪽" );
		} // for 
		
	}
}
