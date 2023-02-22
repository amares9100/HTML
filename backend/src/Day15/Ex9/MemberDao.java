package Day15.Ex9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class MemberDao {
	
	// 싱글톤 : Dao 싱글톤 사용이유 : 프로그램내 연동 1번만 해서 하나의 연동객체 사용
		// 1. 내부에 객체 만들기
	private static MemberDao dao = new MemberDao();
		// 2. 생성자 private로 막아서 외부에서 사용금지
		// 3. 외부에서 사용할 수 있게 내부객체 반환 메소드 [getInstance]
	public static MemberDao getInstance() {return dao;}
	
	// 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement stmt;
	
	
	
	
	// 생성자
	private MemberDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root" , "1234");
			System.out.println("DB연동성공");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// SQL처리 메소드
	// 1. 회원가입 메소드
	public boolean signup(MemberDto dto) {
		String sql="insert into member (mid , mpw) values( ? , ?)";
		try {
		ps = conn.prepareStatement(sql);
		// ps는 매개변수에 대한 조작 가능
		ps.setString(1, dto.getMid());
		ps.setString(2, dto.getMpw());
		ps.executeUpdate(); // 실행
		return true;
		}
		catch (Exception e) {
			System.out.println("회원가입오류" + e.getMessage());
		}
		return false; // - 회원가입실패
	}
	
	// 모든회원 출력 [ 인수 x  / 반환 : 여러명 회원정보]
	
	public ArrayList<MemberDto> list() {
		
		
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			//stmt = conn.createStatement();
			//rs = stmt.executeQuery("select * from member");
			
			ps = conn.prepareStatement("select * from member"); // 입력한 명령어로 자료 가져옴
			rs = ps.executeQuery();					// 입력한 자료 출력해서 rs에 저장
			
			while(rs.next()) { // rs에서 불러올 레코드가 있으면 true 아니면 false
			//각 레코드의 값을 dto에 저장 >>
				//rs.getInt(1) - 회원번호, rs.getString(2) - mid, rs.getString(3) - mpw
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(dto); // 불러온 레코드값을 list로 저장
			}
			return list; // list값 반환
			}
		catch (Exception e) {
			System.out.println("회원가입오류" + e.getMessage());
		}
		return null;
	}
	
	public boolean update(int mno , String mpw) {
		try {
			ps = conn.prepareStatement("update member set mpw = ? where mno=?");
			ps.setString(1, mpw);
			ps.setInt(2, mno);
			ps.executeUpdate(); // 실행
			return true;
		}
		catch (Exception e) {
			System.out.println("변경오류"+e.getMessage());
		}
		return false;
	}
	
	public boolean delete(int mno) {
		String sql = "delete from member where mno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("삭제오류"+e.getMessage());
		}
		return false;
	}
	
}
























