package 과제7;

public class Accounts {

	
	public String name;
	public String pw;
	public String accountno;
	public int money;
	
	
	



	public Accounts() {
		super();
	}


	public Accounts(String name, String pw, String accountno, int money) {
		super();
		this.name = name;
		this.pw = pw;
		this.accountno = accountno;
		this.money = money;
	}
	
	
	public boolean Create(String name, String pw) {
		
		
		accountno = "은행"+" "+ (int) (Math.random()*20)+" "+(int) (Math.random()*20);
		money = 0;
		System.out.println("은행 계좌가 생성되었습니다.");
		return true;
	}
	
	
}
