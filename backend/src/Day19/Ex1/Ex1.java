package Day19.Ex1;

import java.awt.Toolkit;
/*
	스레드 작업 객체 만들기
		1. Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				멀티작업코드
			}
		});
		thread.start();   // 스레드 시작
		
		2. class 클래스명 extends Thread(
			@Override
			public void run() {
				멀티작업코드
			}
		);
		Thread 객체명 = new 자식클래스();
		객체명.start();
		
 
 
 
 */
public class Ex1 {
	public static void main(String[] args) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		
		for(int i = 0 ; i<5 ; i++) {
			toolkit.beep();
			try {
			Thread.sleep(500);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
		}
		
		
		
		//---------------------------------------------------//
		// 1. 멀티스레드
		
		// 스레드 객체 구현
		Thread thread = new Thread(new Runnable() {
		// run메소드 정의
		@Override
		public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for(int i = 0 ; i<5 ; i++) {
				toolkit.beep();
				try {
				Thread.sleep(500);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				}
			}
		});
		//  run메소드 실행
		thread.start();
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
		}
		//---------------------------------------------------//
		
		// 2. 멀티스레드
		// 자식클래스를 만들어서 스레드 상속후 run오버라이딩 - 코드작성
		Thread thread2 = new Sound();
		thread2.start();
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
		}
		
		// 3. 멀티스레드
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
		}
	}
}



























