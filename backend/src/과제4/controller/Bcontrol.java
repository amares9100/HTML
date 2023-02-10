package 과제4.controller;

import java.sql.Array;
import java.util.ArrayList;

import 과제4.model.Board;

public class Bcontrol {
	
	public ArrayList<Board> boardDb = new ArrayList<>();
	
	
	
	public int write(int read , String name , String title , String content , int indexid , String id) {
		
		
		
		Board board = new Board(read, name, title, content, indexid , id);
		
		boardDb.add(board);
		return 0;
	}
	
	public void board_p() {
		for(int i = 0 ; i < boardDb.size(); i++) {
			int no = i;
			int read = boardDb.get(i).read;
			String name = boardDb.get(i).name;
			String title = boardDb.get(i).title;
			
			System.out.println(no+"\t"+read+"\t"+name+"\t"+title);
		}
	}
	
	public void board_no(int b_no) {
		for(int i = 0 ; i <boardDb.size(); i++) {
			if(i == b_no) {
				boardDb.get(b_no).read += 1;
				System.out.println("no."+i+"제목 : " + boardDb.get(b_no).title);
				System.out.println("작성자 : " + boardDb.get(b_no).name +"  "+
						"조회수 : " + boardDb.get(b_no).read);
				System.out.println("내용 : " + boardDb.get(b_no).content);
				
			}
		}
	}
	
	public int board_del(int del , String id) {
		for(int i = 0 ; i < boardDb.size(); i++) {
			
			if(boardDb.get(del).id.equals(id) ) {
				boardDb.remove(del);
				return 1;
			}
		}
		return -1;
	}
	
	public int board_re(int re , String id , String re_content) {
		for(int i = 0 ; i < boardDb.size(); i++) {
			
			if(boardDb.get(re).id.equals(id)) {
				boardDb.get(re).content = re_content;
				return 1;
			}
		}
		return -1;
	}
	
}










