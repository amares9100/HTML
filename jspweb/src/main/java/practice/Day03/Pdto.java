package practice.Day03;

public class Pdto {
	private int pno;
	private String pname;
	private int pprice;
	
	
	public Pdto(int pno, String pname, int pprice) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
	}
	public Pdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Pdto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	
}
