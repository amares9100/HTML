package 과제7;

public class Woori extends Accounts {
	public Woori(String name, String pw) {
		super.Create(name, pw);
	}
	
	
	
	@Override
	public boolean Create(String name, String pw) {
		
		
		
		
		accountno = "03"+"-"+ (int) (Math.random()*20+10)+"-"+(int) (Math.random()*20+10);
		money = 0;
		System.out.println("우리은행 계좌가 생성되었습니다.");
		System.out.println(accountno);
		return true;
	}






	
}
