package Day19.Ex5;

public class Music extends Thread{

	public boolean stop = false;
	
	@Override
	public void run() {
		while(stop) {
			try {Thread.sleep(1000);}
			catch (Exception e) {}
			System.out.println("--음악재생중--");
		}
	}
}
