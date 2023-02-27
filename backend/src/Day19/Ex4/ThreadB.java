package Day19.Ex4;

public class ThreadB extends Thread{
	private Calculator calculator;
	
	public ThreadB() {
		setName("ThreadB");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory2(50);
	}
	
}
