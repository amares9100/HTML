package 과제9.Interface.Pay;

public class 과장 implements Pay{

	int 통신비 = 50000;
	int 성과금배율 = 4;
	
	@Override
	public void 월급(int x) {
		System.out.println("과장님 안녕하세요.");
		System.out.println("월급은 : "+ ((x*11000)+통신비) + "원 입니다.");
		
	}

	@Override
	public void 퇴직금(int x) {
		System.out.println("퇴직금은 : " + x*5000000+"원 입니다.");
		
	}

	@Override
	public void 성과금(int x) {
		System.out.println("성과금은 : "+ x*1000000*성과금배율+"원 입니다.");
		
	}


}
