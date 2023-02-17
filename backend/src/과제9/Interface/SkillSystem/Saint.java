package 과제9.Interface.SkillSystem;

public class Saint implements Skill_Key{

	@Override
	public void Q() {
		System.out.println("힐!");
		
	}

	@Override
	public void W() {
		System.out.println("공격력UP!!");
		
	}

	@Override
	public void E() {
		System.out.println("방어력UP!!!");
		
	}
	
}
