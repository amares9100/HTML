package 과제9.Interface.SkillSystem;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Skill_Key skill = null;
		
		
		while(true) {
			System.out.println("직업을 골라주세요.");
			System.out.println("1. 전사 2. 마법사 3. 성직자");
			int select = sc.nextInt();
			
			if(select == 1) {
				skill = new Warriors();
			}
			else if( select == 2) {
				skill = new Mage();
			}
			else if(select == 3) {
				skill = new Saint();
			}
			System.out.println("---------------");
			skill.Q();
			skill.E();
			skill.W();
			System.out.println("---------------");
		}
	}
}
