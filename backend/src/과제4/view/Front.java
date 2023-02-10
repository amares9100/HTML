package 과제4.view;

import java.util.Scanner;

import 과제4.controller.Bcontrol;
import 과제4.controller.Mbcontrol;

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
		int login_id = -1;
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
		login :	while(true) {
				System.out.println("1. 글쓰기 / 2. 상세메뉴 / 3. 로그아웃");
				int ch = sc.nextInt();
				if(ch == 1) {
				login_write();
				board_print();
				}
				else if(ch == 2) {
					
					System.out.println(" 1. 글보기 / 2. 글삭제 / 3. 글수정 / 4. 뒤로가기");
					int ph = sc.nextInt();
					if(ph == 1) {login_view();}
					else if(ph == 2) {
						board_del();
					}
					else if(ph == 3) {
						board_re();
					}
					else if(ph == 4) {
						continue login;
					}
					
				}
				else if(ch == 3) {
					index();
					login_id = -1;
				}

			}
		}else if(result_log == -1) {
			System.out.println("비밀번호가 틀립니다.");
		}
		else if(result_log == -2) {
			System.out.println("없는 아이디입니다.");

			
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

	// 로그인후 게시글 출력
	void board_print() {
		System.out.println("----------게시판----------");
		System.out.println("번호\t조회수\t작성자\t제목");
		mc.board_p();
		System.out.println("------------------------");
	}


	// 로그인후 글쓰기
	void login_write() {
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		
		String id = mb.memberDb.get(login_id).id;
		String name = mb.memberDb.get(login_id).name;
		mc.write( 0 , name , title, content , login_id , id);

	}
	// 로그인후 글보기
	void login_view() {
		board_print();
		System.out.println("게시글 번호를 입력하세요. : ");
		int b_no = sc.nextInt();
		System.out.println("---------------------");
		mc.board_no(b_no);
		System.out.println("---------------------");
	}
	
	void board_del() {
		System.out.println("삭제할 번호를 입력하세요. : ");
		board_print();
		int del = sc.nextInt();
		String id = mb.memberDb.get(login_id).id;
		int result_del = mc.board_del(del , id);
		if(result_del == 1) {
			System.out.println("삭제하였습니다.");
		}
		else if(result_del == -1) {
			System.out.println("본인이 아닙니다. 삭제할 수 없습니다.");
		}
	}
	
	void board_re() {
		board_print();
		System.out.println("수정할 게시글 번호를 입력하세요. : ");
		int re = sc.nextInt();
		System.out.println("수정할 내용을 입력하세요. : ");
		String re_content = sc.next();
		String id = mb.memberDb.get(login_id).id;
		
		int result_re = mc.board_re(re , id , re_content);
		if(result_re == 1) {
			System.out.println(re+"번 게시글을 수정하였습니다.");
			mc.board_no(re);
		}
		else if(result_re == -1) {
			System.out.println("본인이 아닙니다. 수정에 실패하였습니다.");
		}
	}
}
