package 과제9.Class.Ship;

public class Ship {
	public String 항법 = "항법시스템";
	public String ICCP = "ICCP";
	public String Echo_Sound = "Echo_Sound";
	public String size;
	public String create_time;
	public String transit;
	
	
	
	
	
	public Ship() {
	
	}


	public Ship(String size, String create_time) {
		super();
		this.size = size;
		this.create_time = create_time;
		
	}

	public void run() {
		System.out.println(항법);
		System.out.println(ICCP);
		System.out.println(Echo_Sound);
		System.out.println(size);
		System.out.println(create_time);
		System.out.println(transit);
	}



	public String get항법() {
		return 항법;
	}





	public void set항법(String 항법) {
		this.항법 = 항법;
	}





	public String getICCP() {
		return ICCP;
	}





	public void setICCP(String iCCP) {
		ICCP = iCCP;
	}





	public String getEcho_Sound() {
		return Echo_Sound;
	}





	public void setEcho_Sound(String echo_Sound) {
		Echo_Sound = echo_Sound;
	}





	public String getSize() {
		return size;
	}





	public void setSize(String size) {
		this.size = size;
	}





	public String getCreate_time() {
		return create_time;
	}





	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}





	public String getTransit() {
		return transit;
	}





	public void setTransit(String transit) {
		this.transit = transit;
	}
	
	
}
