package 과제9.Interface.SkillSystem;

public class Warriors implements Skill_Key{

	@Override
	public void Q() {
		System.out.println("근접공격!");
		
	}

	@Override
	public void W() {
		System.out.println("배쉬!!");
		
	}

	@Override
	public void E() {
		System.out.println("방어태세!!!");
		
	}
	
}
