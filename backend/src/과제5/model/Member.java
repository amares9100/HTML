package 과제5.model;

public class Member {
	
	private int mno;
	
	
	private String id;
	private String pw;
	private String phone;
	
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(int mno, String id, String pw, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
}
