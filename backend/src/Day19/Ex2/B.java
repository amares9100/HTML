package Day19.Ex2;

public class B implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("B인터페이스 스레드 : " +Thread.currentThread());
			try {Thread.sleep(1000);}
			catch (Exception e) { }
			
		}
	}
	
}
