package practice.Day02.Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class Dao {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	private Dao () {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/jspweb" ,
			"root" ,
			"1234"
			);
		}catch (Exception e) {System.out.println(e);}
	}
	
	
	// 자료형 매칭 중요
	public boolean setqData(Dto dto) {
		String sql = "insert into qex2 values(? , ? , ? , ? , ? , ? , ? , ? , ? )";
		try { 
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getQdata1());
			ps.setString(2, dto.getQdata2());
			ps.setDouble(3, dto.getQdata3());
			ps.setInt(4, dto.getQdata4());
			ps.setString(5, dto.getQdata5());
			
			ps.setString(6, dto.getQdata6());
			ps.setBoolean(7, dto.isQdata7());
			ps.setString(8, dto.getQdata8());
			ps.setString(9, dto.getQdata9());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	public ArrayList<Dto> getqData(){
		String sql = "select * from qex2";
		ArrayList<Dto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(rs.getString(1), rs.getString(2), rs.getDouble(3),rs.getInt(4),rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8), rs.getString(9));
				list.add(dto);
			}
			
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	
}


























