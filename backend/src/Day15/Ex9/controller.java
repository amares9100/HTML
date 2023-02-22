package Day15.Ex9;

import java.util.ArrayList;

public class controller {
	// 싱글톤
	private static controller control = new controller();
	private controller() {}
	public static controller getInstance() {return control; }
	
	
	
	
	public boolean singup(String mid , String mpw) {
		// 유효성검사 생략
		
		// 객체화[이유 : 여러개 변수가 이동하면 로직이 길어짐 -> 여러개변수를 하나로 묶음처리
		MemberDto dto = new MemberDto(0 , mid , mpw);
		
		boolean result =
				MemberDao.getInstance().signup(dto);
		return result;
	}
	
	public ArrayList<MemberDto> list(){
		ArrayList<MemberDto> result = MemberDao.getInstance().list();
		return result;
	}
	
	
	public boolean update(int mno , String mpw) {
		
		boolean result = MemberDao.getInstance().update(mno , mpw);
		
		return result;
	
	
	}
	
	
	public boolean delete(int mno) {
		
		return MemberDao.getInstance().delete(mno);
	}
	
	
	
	
}
