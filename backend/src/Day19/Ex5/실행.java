package Day19.Ex5;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Music music = new Music();
		
		Muvie muvie = new Muvie();
		
		while(true) {
			System.out.println("1.음악재생 / 2.영화재생");
			int ch = sc.nextInt();
			if(ch==1 && music.stop == false) {
				music.start();
				music.stop = true;
				
				
				
			}else if(ch==1 && music.stop == true) {
				music.stop = false;
				music = new Music();
				
			}
			if(ch==2 && muvie.stop == false) {
				muvie.start();
				muvie.stop = true;
				
				
			}else if(ch==2 && muvie.stop == true) {
				muvie.stop = false;
				muvie = new Muvie();
			}
		}
	}
}
