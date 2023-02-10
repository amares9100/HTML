package 과제4.model;

public class Board {
	
	public int read;
	public String name;
	public String title;
	public String content;
	public int  indexid;
	public String id;
	
	
	public Board() {
		
	}



	public Board(int read, String name, String title, String content , int indexid ,String id) {
		super();
		this.read = read;
		this.name = name;
		this.title = title;
		this.content = content;
		this.indexid = indexid;
		this.id = id;
	}
	
	
}
