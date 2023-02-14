package 과제5.controller;

import 과제5.model.Member;

public class CMember {

	
	private static CMember Cm = new CMember();
	private CMember() {}
	public static CMember Inst() {
		return Cm;
	}
	
	public Member login() {
		return login;
	}
	
	Member login = null;
}
