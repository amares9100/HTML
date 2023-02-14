package 과제4싱글톤.controller;

import java.util.ArrayList;

import 과제4싱글톤.model.board;

public class Bcontroller {

	private ArrayList<board> boardDb = new ArrayList<>();
	
	
	
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {
		
		return bc;
	}
	
	
	//1. 글쓰기
	public boolean write( String title , String content) {
		// 로그인 유효성 검사 [ 로그인이 안되어있으면 false ]
		if(Mcontroller.getInstance().loginSession == null) {
			return false;
		}
		// 2. DB저장
			// 1. 객체화[입력받은 타이틀,내용, 초기값0 , 로그인한 회원 객체 = 글쓴이]
		board board = new board(title , content , 0 , Mcontroller.getInstance().loginSession);
			// 2. 
		boardDb.add(board);
		
			// 3. 멤버 객체에 내가 쓴 글 등록
		Mcontroller.getInstance().loginSession.getBoardlist().add(board);
			// 
		return true;
	}
	
	//2. 글출력
	public ArrayList<board> getList(){
		
		return boardDb;
	}
	
	//3. 글상세
	public board getBoard(int bno) {
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1);
		return boardDb.get(bno);
	}
	
	//4. 글삭제
	public boolean delete(int bno) {
		boardDb.remove(bno);
		return true;
	}
	
	//5. 글수정
	public boolean update(int bno , String title , String content) {
		boardDb.get(bno).setTitle(title);
		boardDb.get(bno).setContent(content);
		return true;
	}


	
}
