package Day15.Ex2;

public class Student {
	private int no;
	private String name;
	
	
	
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode(); // no와 name을 합친 문자열을 해시코드(정수)로 반환
		return hashCode;						// ex) no : 4  / name : 재석   -> 4재석으로 합치고 해시코드 반환
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {
			if(no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
}
