package Day19.Ex4;

public class Synchro {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		ThreadA threadA = new ThreadA();
		threadA.setCalculator(calculator);
		threadA.start();
		
		
		
		
		ThreadB threadB = new ThreadB();
		threadB.setCalculator(calculator);
		threadB.start();
		
	}
}
