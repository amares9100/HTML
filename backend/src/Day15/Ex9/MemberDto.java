package Day15.Ex9;



public class MemberDto {
	// 필드
	private int mno;
	private String mid;
	private String mpw;
	
	
	
	


	public MemberDto() {
	
	}



	public MemberDto(int mno, String mid, String mpw) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}



	@Override
	public String toString() {
		return "BoardDao [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}



	public int getMno() {
		return mno;
	}



	public void setMno(int mno) {
		this.mno = mno;
	}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public String getMpw() {
		return mpw;
	}



	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	// 메소드 [ private쓰기때문에 무조건 get/set 생성
	
	
}
