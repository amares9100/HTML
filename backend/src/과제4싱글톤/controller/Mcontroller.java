package 과제4싱글톤.controller;

import java.util.ArrayList;

import 과제4싱글톤.model.Member;


public class Mcontroller {
	// * 싱글톤 : 다른곳에서 해당 객체를 공유
		// 1. 본인 클래스로 본인 객체 만들기
	private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자를 사용할 수 없도록 생성자에 private
	private Mcontroller() {}
		// 3. 객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다.[유효성검사 위해]
	public static Mcontroller getInstance() {
		return mc;
	}
	
	public Member getLoginSession() {
		return loginSession;
	}

	//DB대신 ArrayList
	ArrayList<Member> memberDb = new ArrayList<>();
	//로그인 한 회원의 객체를 저장
		// 사용목적 : 페이지가 바뀌더라도 정보 저장[*메소드가 종료되더라도 로그인정보 저장]
	Member loginSession = null;
	
	
	//1. 회원가입 처리
	public int signup(String id , String pw , String confirmpw ,
			String name , String phone) {
		// 1. 유효성검사
		if(!pw.equals(confirmpw)) {return 1;}
		// 2. DB에 저장
			// 1. 객체화 [ 입력받은 데이터 4개와 회원마다 글을 저장할 리스트 메모리 초기화]
		Member m = new Member(id , pw , name , phone , new ArrayList<>());
			// id, pw, name, phone : 스택영역에 저장된 힙주소 전달
			// new ArrayList<>() : 힙영역에 생성된 힙주소 전달
		// 2. 리스트에 저장
		memberDb.add(m);
		return 0;
	}
	
	//2. 로그인 처리
	public int login(String id , String pw) {
		
		for(int i = 0 ; i<memberDb.size() ; i++) {
			if(memberDb.get(i).getId().equals(id)) {
				if(memberDb.get(i).getPw().equals(pw)) {
					// ! 로그인 성공 식별/흔적남기기
					loginSession = memberDb.get(i);
					return i;
				}
				else {return -1;}
			}
		}
		return -2;
	}
	
	//3. 아이디 찾기
	public String findId(String name , String phone) {
		for(Member m : memberDb) {
			if(m.getName().equals(name) && m.getPhone().equals(phone)){
				return m.getId();
			}
		}
		return null;
	}
	//4. 비밀번호 찾기
	public String findPw(String id , String phone) {
		for(Member m : memberDb) {
			if(m.getId().equals(id) && m.getPhone().equals(phone)) {
				return m.getPw();
			}
		}
		return null;
	}
	//5. 로그아웃
	public boolean logOut() {
		loginSession = null; // 필드에 저장된 로그인 성공한 회원 객체 지우기
		return true;
	}
}

























