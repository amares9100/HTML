package 과제4.controller;

import java.util.ArrayList;

import 과제4.model.Board;

public class Bcontrol {
	
	public ArrayList<Board> boardDb = new ArrayList<>();
	
	
	public int write(int read , String name , String title , String content , int id) {
		Board board = new Board(read, name, title, content, id);
		
		boardDb.add(board);
		return 0;
	}
	
}
