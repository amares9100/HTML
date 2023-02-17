package 과제9.Interface.Pay;

public class 차장 implements Pay{

	int 통신비 = 100000;
	int 성과금배율 = 6;
	
	
	
	@Override
	public void 월급(int x) {
		System.out.println("차장님 안녕하세요.");
		System.out.println("월급은 : "+ ((x*12000)+통신비) + "원 입니다.");
		
	}

	@Override
	public void 퇴직금(int x) {
		System.out.println("퇴직금은 : " + x*6000000+"원 입니다.");
		
	}

	@Override
	public void 성과금(int x) {
		System.out.println("성과금은 : "+ x*1000000*성과금배율+"원 입니다.");
		
	}


}
