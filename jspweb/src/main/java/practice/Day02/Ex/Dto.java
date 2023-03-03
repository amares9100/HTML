package practice.Day02.Ex;

public class Dto {
	private String qdata1;
	private String qdata2;
	private double qdata3;
	private int qdata4;
	private String qdata5;
	private String qdata6;
	private boolean qdata7;
	private String qdata8;
	private String qdata9;
	
	private static Dto dto = new Dto();
	private Dto() {};
	public static Dto getInstance() {return dto;}
	public String getQdata1() {
		return qdata1;
	}
	
	
	
	
	
	public Dto(String qdata1, String qdata2, double qdata3, int qdata4, String qdata5, String qdata6, boolean qdata7,
			String qdata8, String qdata9) {
		super();
		this.qdata1 = qdata1;
		this.qdata2 = qdata2;
		this.qdata3 = qdata3;
		this.qdata4 = qdata4;
		this.qdata5 = qdata5;
		this.qdata6 = qdata6;
		this.qdata7 = qdata7;
		this.qdata8 = qdata8;
		this.qdata9 = qdata9;
	}
	public void setQdata1(String qdata1) {
		this.qdata1 = qdata1;
	}
	public String getQdata2() {
		return qdata2;
	}
	public void setQdata2(String qdata2) {
		this.qdata2 = qdata2;
	}
	public double getQdata3() {
		return qdata3;
	}
	public void setQdata3(double qdata3) {
		this.qdata3 = qdata3;
	}
	public int getQdata4() {
		return qdata4;
	}
	public void setQdata4(int qdata4) {
		this.qdata4 = qdata4;
	}
	public String getQdata5() {
		return qdata5;
	}
	public void setQdata5(String qdata5) {
		this.qdata5 = qdata5;
	}
	public String getQdata6() {
		return qdata6;
	}
	public void setQdata6(String qdata6) {
		this.qdata6 = qdata6;
	}
	public boolean isQdata7() {
		return qdata7;
	}
	public void setQdata7(boolean qdata7) {
		this.qdata7 = qdata7;
	}
	public String getQdata8() {
		return qdata8;
	}
	public void setQdata8(String qdata8) {
		this.qdata8 = qdata8;
	}
	public String getQdata9() {
		return qdata9;
	}
	public void setQdata9(String qdata9) {
		this.qdata9 = qdata9;
	}

	
	
	
}
