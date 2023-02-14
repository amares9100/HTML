package 과제4싱글톤.view;

import java.util.Scanner;

import 과제4.model.Board;
import 과제4싱글톤.controller.Bcontroller;
import 과제4싱글톤.controller.Mcontroller;
import 과제4싱글톤.model.board;

public class Front {
	
	// 싱글톤
	private static Front front = new Front();
	private Front(){}
	public static Front getInstance() {
		
		
		return front;}
	
	private Scanner sc = new Scanner(System.in);
	// 1. 메인페이지
	void index() {
		while(true) {
			System.out.println("-------------이젠커뮤니티-------------");
			System.out.println("1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기");
			int ch = sc.nextInt();
			if(ch==1) {
				signup_page();
			}
			else if(ch == 2) {
				login_page();
			}
			else if(ch == 3) {
				findid_page();
			}
			else if(ch == 4) {
				findpw_page();
			}
		
		}
	}
	
	// 2. 회원가입 페이지
	public void signup_page() {
		System.out.println("아이디 : ");			String id= sc.next();
		System.out.println("비밀번호 : ");			String pw= sc.next();
		System.out.println("비밀번호 확인 : ");		String confirmpw= sc.next();
		System.out.println("이름 : ");			String name= sc.next();
		System.out.println("전화번호 : ");			String phone= sc.next();
		
		int result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		
		if(result == 1) {
			System.out.println("회원가입 실패 - 패스워드가 서로 다릅니다.");
		}
		else if( result == 2) {
			System.out.println("회원가입 성공");
		}
		
	}
	
	// 3. 로그인 페이지
	public void login_page() {
		System.out.println("아이디 : ");			String id= sc.next();
		System.out.println("비밀번호 : ");			String pw= sc.next();
		
		int result = Mcontroller.getInstance().login(id, pw);
		if(result == -1) {
			System.out.println("로그인 실패 - 패스워드가 틀립니다.");
		}
		else if(result == -2) {
			System.out.println("로그인 실패 - 아이디가 존재하지 않습니다.");
		}
		else {
			System.out.println("로그인 성공");
			board_page();
		}
	}
	
	// 4. 아이디찾기 페이지
	public void findid_page() {
		System.out.println("이름 : ");			String name= sc.next();
		System.out.println("전화번호 : ");			String phone= sc.next();
		
		String result = Mcontroller.getInstance().findId(name, phone);
		if(result == null) {
			System.out.println("아이디 찾기 실패");
		}
		else {
			System.out.println("회원님의 아이디는 "+ result + "입니다.");
		}
	}
	
	// 5. 비밀번호 찾기 페이지
	public void findpw_page() {
		System.out.println("아이디 : ");		String id= sc.next();
		System.out.println("전화번호 : ");		String phone = sc.next();
		
		String result = Mcontroller.getInstance().findPw(id, phone);
		if(result == null) {
			System.out.println("비밀번호 찾기 실패");
		}
		else {
			System.out.println("회원님의 비밀번호는 "+result+"입니다.");
		}
	}
	
	// 6. 로그인 성공시 게시물 출력 페이지
	public void board_page() {
		
		while(true) {
		System.out.println("---------------------------");
		System.out.println("번호\t조회수\t작성자\t제목");
		int i = 0;
		for(board b : Bcontroller.getInstance().getList()) {
			System.out.println(i+"\t"+b.getView()+"\t"+
								b.getMember().getId()+"\t"+b.getTitle());
		i++;
		}
		System.out.println("1. 쓰기 2. 글보기 3. 로그아웃");
		int ch2 = sc.nextInt();
		if(ch2==1) {}
		else if(ch2==2) {}
		else if(ch2==3) {Mcontroller.getInstance().logOut(); break;}
		
		}
	}
	// 7. 게시물 쓰기 페이지
	public void write_page() {
		System.out.println("------------글쓰기-------------");
		System.out.println("제목 : ");		String title=sc.next();
		System.out.println("내용 : ");		String content=sc.next();
		boolean result = Bcontroller.getInstance().write(title, content);
		if(result) {
			System.out.println("작성 성공");
		}
		else {
			System.out.println("작성 실패");
		}
		
	}
	// 8. 게시물 상세 페이지
	public void view_page() {
		System.out.println("이동할 게시물 번호 : ");
		int bno = sc.nextInt();
		board result = Bcontroller.getInstance().getBoard(bno);
		
		System.out.println("제목 : " + result.getTitle());
		System.out.println("작성자 : "+ result.getMember().getId()+" 조회수 : " + result.getView());
		System.out.println("내용 : "+ result.getContent());
		System.out.println("1. 삭제  2. 수정 3. 돌아가기");
		
		int ch3 = sc.nextInt();
		if(ch3==1) {
			delete_page(bno);
		}
		else if (ch3==2) {
			update_page(bno);
		}
		else if(ch3==3) {
			return;
		}
	}
	
	// 8. 게시물 삭제 페이지
	public void delete_page(int bno) {
		// 유효성 검사 [ 글쓴이와 현재 로그인된 회원이 같으면]
		if(Bcontroller.getInstance().getBoard(bno).getMember().
				equals(Mcontroller.getInstance().getLoginSession())) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("삭제되었습니다.");
			return;
		}
		System.out.println("삭제 권한이 없습니다.");
	}
	// 9. 게시물 수정 페이지
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getBoard(bno).getMember().
				equals(Mcontroller.getInstance().getLoginSession())) {
			System.out.println("새로운 제목 : ");	String title = sc.next();
			System.out.println("새로운 내용 : ");	String content = sc.next();
			Bcontroller.getInstance().update(bno, title, content);
			System.out.println("수정되었습니다.");
			return;
		}
		System.out.println("수정 권한이 없습니다.");
	}
	
	
	
	
	
}
