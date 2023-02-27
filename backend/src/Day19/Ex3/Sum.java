package Day19.Ex3;

public class Sum extends Thread{
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for(int i = 1 ; 1<100; i++) {
			sum+=i;
		}
		
	}
	
	
}
