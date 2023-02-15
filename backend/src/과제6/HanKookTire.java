package 과제6;

public class HanKookTire extends Tire {
	public HanKookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	@Override
	public boolean roll() {
		++accumulatedRotation;	
		if( accumulatedRotation < maxRotation ) {
			System.out.println( location + " HankookTire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" HankookTire 펑크 ***");
			return false; 
		}
	}
	
	
}