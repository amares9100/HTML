package Day4;

import java.util.Random;
import java.util.Scanner;

public class Ex1_가위바위보 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) { // 1. 무한루프
			// 2. 입력받기
			System.out.println("가위(0) 바위(1) 보(2) 종료(3)");

			byte player = sc.nextByte();
			System.out.println("player 낸 수 : " + player);

			if ( player == 3) {
				System.out.println("--종료");

			}

			// 난수 생성 [1. Math  2. Random]
			Random rn = new Random();
			int com = rn.nextInt(3);
			System.out.println("> com 낸 수 : " + com);

			if( player == 0 && com == 2 ||player == 1 && com == 0 ||player == 2 && com == 1 ) {
				System.out.println( "player 승리");
			}
			else if (player == com) {
				System.out.println("비겼습니다");
			}
			else {
				System.out.println("com 승리");
			}
			}
	}
}
