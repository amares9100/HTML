package Day15.Ex9;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class view {
	Scanner sc = new Scanner(System.in);
	
	private static view view = new view();
	private view() {}
	public static view getInstance() { return view;}
	
	// 메인화면
	public void index() {
		while(true) {
		System.out.println("1. 회원가입[C] 2. 출력[R] 3. 수정[U] 4. 삭제[D]");
		int ch = sc.nextInt();
		
		if(ch == 1) {
			signup();
		}
		else if(ch==2) {
			list();
		}
		else if(ch==3) {
			update();
		}
		else if(ch==4) {
			delete();
		}
		}
	}
	//회원가입화면
	public void signup() {
		System.out.println("------회원가입------");
		System.out.println("id :");
		String mid = sc.next();
		System.out.println("비밀번호 : ");
		String mpw = sc.next();
		// 전달후 리턴값 받기
		boolean result = controller.getInstance().singup(mid, mpw);
		if(result) {
			System.out.println("회원가입 성공");
		}
		else {System.out.println("회원가입 실패");}
		
	}
	
	public void list() {
		System.out.println("------------------------");
		System.out.printf("%2s \t %s \t %10s \n" , "회원번호" , "아이디" , "비밀번호");
		
		ArrayList<MemberDto> result = controller.getInstance().list();
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.printf("%2d \t %10s \t %10s \n" , result.get(i).getMno() , result.get(i).getMid() , result.get(i).getMpw());
		}
	}
	
	public void update() {
		System.out.println("----------------");
		System.out.println("회원번호 : ");
		int mno = sc.nextInt();
		System.out.println("변경할 비밀번호 : ");
		String mpw = sc.next();
		
		boolean result = controller.getInstance().update(mno, mpw);
		if(result) {
			System.out.println("수정 성공");
		}
		else {System.out.println("수정 실패");}
		
	}
	
	public void delete() {
		System.out.println("-----------------");
		System.out.println("삭제할 회원번호 : ");
		int mno = sc.nextInt();
		
		boolean result = controller.getInstance().delete(mno);
		if(result) {
			System.out.println("삭제 성공");
		}
		else {System.out.println("삭제 실패");}
	}
}














