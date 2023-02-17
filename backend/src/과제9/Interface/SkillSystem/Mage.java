package 과제9.Interface.SkillSystem;

public class Mage implements Skill_Key{

	@Override
	public void Q() {
		System.out.println("화염마법!");
		
	}

	@Override
	public void W() {
		System.out.println("얼음마법!!");
		
	}

	@Override
	public void E() {
		System.out.println("mp회복!!!");
		
	}
	
}
