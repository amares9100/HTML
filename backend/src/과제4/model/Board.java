package 과제4.model;

public class Board {
	
	public int read;
	public String name;
	public int  id;
	public String title;
	public String content;
	
	
	
	public Board() {
		
	}



	public Board(int read, String name, String title, String content , int id) {
		super();
		this.read = read;
		this.name = name;
		this.title = title;
		this.content = content;
		this.id = id;
	}
	
	
}
