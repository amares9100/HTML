package 과제4싱글톤.model;

import java.util.ArrayList;

import 과제4싱글톤.controller.Mcontroller;

// M : 데이터 저장할대 사용되는 데이터 모델링
		// - 회원[객체] 여러명 만들어서 하나의 리스트에 저장
		// - 필드 : private 외부 직접 방지 -> getter , setter
		// - 생성자 :
				// 1. 빈생성자
				// 2. 풀생생성자
public class Member {
	
	// 인스턴스 멤버	: 객체있어야 사용 -> 스택영역
	// 정적멤버		: static 객체 없이 사용 -> 메소드영역

	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	// 한명의 회원[객체]가 여러개의 board 객체를 가질 수 있다.
	private ArrayList<board> boardlist = new ArrayList<>();
	// 2. 생성자
	public Member() {
		super();
	}
	public Member(String id, String pw, String name, String phone, ArrayList<board> boardlist) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardlist = boardlist;
	}
	
	
	// 3. 메소드


	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", boardlist=" + boardlist
				+ "]";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<board> getBoardlist() {
		return boardlist;
	}
	public void setBoardlist(ArrayList<board> boardlist) {
		this.boardlist = boardlist;
	}
	
	
}
