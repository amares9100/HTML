package Day15.Ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB연동 {
	
	//DriverManager.getConnection() *해당 DB주소와 연결 성공시 성공한 DB구현객체 반환
	private Connection conn; // 1. DB에 연결된 구현객체를 받아서 다양한 메소드 제공
	private PreparedStatement ps; // 2. 연결된 SQL 조작 메소드 제공[? : 매개변수 사용가능]
	private ResultSet rs;		// 3. SQL결과 조작메소드 제공
	
	
	public DB연동() {
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "1234");
		System.out.println("연동성공");
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	public static void main(String[] args) {
		DB연동 db연동 = new DB연동();
		
	}
	
	
}

// 준비물
	// 1. DB서버주소 [ localhost vs 개인ip vs aws]
	// 2. 해당 DB서버의 계정
	// 3. 해당 계정의 비밀번호
// 자바에서 DB 조작 클래스 및 인터페이스