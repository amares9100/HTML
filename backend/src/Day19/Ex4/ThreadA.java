package Day19.Ex4;

public class ThreadA extends Thread{
	private Calculator calculator;
	
	public ThreadA() {
		setName("ThreadA");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory1(100);
	}
	
	
}
