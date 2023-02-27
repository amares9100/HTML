package Day19.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sleep {
	public static void main(String[] args) {
		
		// 1.
		/*
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i< 10 ; i++) {
			toolkit.beep();
			try { Thread.sleep(500);}
			catch (Exception e) {}
			}
		*/
		
		// 2.
		/*
		while(true) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");
		System.out.println(sdf.format(date));
		try { Thread.sleep(1000);}
		catch (Exception e) {}
		}
		*/
		
		// 3.
		/*
		Sum sum = new Sum();
		sum.start();
		System.out.println(sum.getSum());
	
		
		Sum sum = new Sum();
		sum.start();
		try {sum.join();}
		catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println(sum.getSum());
		*/
		
		// 4.
		
		WorkThread threadA = new WorkThread("AThread");
		WorkThread threadB = new WorkThread("BThread");
		
		threadA.start();
		threadB.start();
		
		try {	Thread.sleep(3000);}
		catch (Exception e) {}
		threadA.work = false;
		
		try {	Thread.sleep(6000);}
		catch (Exception e) {}
		threadA.work = true;
		
	}
}

