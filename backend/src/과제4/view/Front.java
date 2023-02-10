package 과제4.view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import 과제4.controller.Bcontrol;
import 과제4.controller.Mbcontrol;
import 과제4.model.Member;

// 입출력 담당
// print , scanner


public class Front {
	
	Scanner sc = new Scanner(System.in);
	Mbcontrol mb = new Mbcontrol();
	Bcontrol mc = new Bcontrol();
	public void index() {
		while(true) {
			System.out.println("1. 회원가입 / 2. 로그인 / 3. 아이디찾기 / 4. 비밀번호찾기");
			int ch = sc.nextInt();
			if(ch == 1) {
				signup();
				
			}
			else if(ch == 2) {
				login();
			}
			else if(ch == 3) {
				findId();
			}
			else if(ch == 4) {
				findPassword();
			}
		}
		
		
		
		
	}
	
	
	
	//회원가입
	void signup() {
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		System.out.println("비밀번호 확인 : ");
		String cfpw = sc.next();
		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("전화번호 : ");
		String phone = sc.next();
		
		mb.signup(id , pw , cfpw , name , phone);
		int result = mb.signup(id, pw, cfpw, name, phone);
		if( result == 1 ) {
			System.out.println("[회원가입 실패]");
		}else if( result == 0 ) {
			System.out.println("[회원가입 성공]");
		}
		
	}
		int login_id = 0;
	//로그인
	void login() {
		System.out.println("----로그인----");
		System.out.println("id : ");
		String logid = sc.next();
		System.out.println("pw : ");
		String logpw = sc.next();
		
		int result_log = mb.login(logid , logpw);
		if(result_log >= 0) {
			System.out.println("로그인 성공");
			login_id = result_log;	
		}else if(result_log == -1) {
			System.out.println("비밀번호가 틀립니다.");
		}
		else if(result_log == -2) {
			System.out.println("없는 아이디입니다.");
			
			while(true) {
				System.out.println("1. 글쓰기 / 2. 글보기 / 3. 로그아웃");
				int ch = sc.nextInt();
				if(ch == 1) {
				login_write();
				
				}
				else if(ch == 2) {
					login_view();
				}
				else if(ch == 3) {
					login_out();
				}
				
			}
		}
	}
	//아이디찾기
	void findId() {
		System.out.println("----아이디 찾기----");
		System.out.println("이름을 입력하세요. : ");
		String findName = sc.next();
		System.out.println("전화번호를 입력하세요. : ");
		String findPhone = sc.next();
		
		int result_find = mb.find(findName, findPhone);
		
		if(result_find >= 0) {
			System.out.println("아이디는 : "+mb.memberDb.get(result_find).id + "입니다.");
		}
		else {System.out.println("찾을수 없는 회원입니다.");}
		}
	//비밀번호찾기
	void findPassword() {
		System.out.println("----비밀번호 찾기----");
		System.out.println("아이디를 입력하세요. : ");
		String findId = sc.next();
		System.out.println("전화번호를 입력하세요. : ");
		String findPhone = sc.next();
		
		int result_findId = mb.find(findId, findPhone);
		
		if(result_findId >= 0) {
			System.out.println("비밀번호는 : "+mb.memberDb.get(result_findId).pw+"입니다.");
		}
		else {System.out.println("아이디와 비밀번호가 틀립니다.");}
	}
	
	// 로그인후 글쓰기
	void login_write() {
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		int read;
		/*
		 * //mb.signup(id , pw , cfpw , name , phone); mc.write(read , title , content ,
		 * login_id , mb.memberDb.get(login_id).name); int result_write = mc.write(read,
		 * content, title, content, login_id);
		 * System.out.println("----------게시판----------");
		 * System.out.println("번호\t조회수\t작성자\t제목");
		 * System.out.println(login_id+"\t"+read+"\t"++);
		 */
	}
	// 로그인후 글보기
	void login_view() {
		
	}
	// 로그아웃
	void login_out() {
		
	}
}
