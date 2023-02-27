package Day19.Ex2;

public class A extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println("A클래스 스레드 : " +Thread.currentThread());
			try {Thread.sleep(1000);}
			catch (Exception e) { }
			
		}
	}
	
}
