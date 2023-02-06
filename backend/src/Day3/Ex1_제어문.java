package Day3;

import java.util.Random;

public class Ex1_제어문 {
	public static void main(String[] args) {
		int score = 85;

		if(score >=90) {
			System.out.println("점수가 90~100입니다.");
			System.out.println("등급은 A입니다.");
		}else if (score >=80) {
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");
		}else if (score >=70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		}else {
			System.out.println("점수가 70미만 입니다.");
			System.out.println("등급은 D입니다.");
		}

		int num = (int)((Math.random()*6)+1);
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		}
		else if (num==2) {
			System.out.println("2번이 나왔습니다.");
		}
		else if (num==3) {
			System.out.println("3번이 나왔습니다.");
		}
		else if (num==4) {
			System.out.println("4번이 나왔습니다.");
		}
		else if (num==5) {
			System.out.println("5번이 나왔습니다.");
		}
		else{
			System.out.println("6번이 나왔습니다.");
		}

		Random random = new Random();
		System.out.println(random.nextInt()); // int범위만큼의 난수
		System.out.println(random.nextInt(3)); // 0~2
		System.out.println(random.nextInt(6)); // 0~5

		char c1 = (char)(random.nextInt(25)+97); // 97~122 의 난수
		System.out.println(c1);
	}
}
