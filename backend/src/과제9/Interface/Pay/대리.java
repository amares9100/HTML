package 과제9.Interface.Pay;

public class 대리 implements Pay{
	
	int 통신비 = 0;
	int 성과금배율 = 2;
	
	@Override
	public void 월급(int x) {
		System.out.println("대리님 안녕하세요.");
		System.out.println("월급은 : "+ ((x*10000)+통신비) + "원 입니다.");
		
	}

	@Override
	public void 퇴직금(int x) {
		System.out.println("퇴직금은 : " + x*4000000+"원 입니다.");
		
	}

	@Override
	public void 성과금(int x) {
		System.out.println("성과금은 : "+ x*1000000*성과금배율+"원 입니다.");
		
	}
	
}
