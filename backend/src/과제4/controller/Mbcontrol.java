package 과제4.controller;

import java.util.ArrayList;

import 과제4.model.Member;

// 처리/제어 담당

public class Mbcontrol {
	//DB대신할 리스트
	
	public ArrayList<Member> memberDb = new ArrayList<>();
	
	
	// 회원가입
	public int signup(String id ,String pw ,String cfpw ,String name ,String phone) {
		//1. 유효성검사
		if(!pw.equals(cfpw)) { // 1 -> 회원가입 실패
			return 1;
		}
		//2. 객체 만들어서
		Member member = new Member(id, pw , name, phone);
		
		//3. DB처리
		memberDb.add(member);
		return 0; // 0 -> 회원가입 성공
	}
	// 로그인
	public int login(String logid , String logpw) {
		for(int i = 0 ; i < memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(logid) ) {
				if(memberDb.get(i).pw.equals(logpw)) {
					return i; // 회원 인덱스
				}
				else {return -1;} // 비밀번호 틀림
			}
		}
		return -2;
	}
		
	
	
	
	// 아이디찾기
	public int find(String findName , String findPhone) {
		for(int i = 0 ; i<memberDb.size(); i++) {
			if(memberDb.get(i).name.equals(findName)) {
				if(memberDb.get(i).phone.equals(findPhone)) {
					return i;
				}
			}
		}
		return -1;
	} 
	// 비밀번호 찾기
	public int find_id(String findId , String findPhone) {
		for(int i = 0 ; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(findId)) {
				if(memberDb.get(i).phone.equals(findPhone)) {
					return i;
				}
			}
		}
		return -1;
	}
	
}	
	

