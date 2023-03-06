package practice.Day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() {return dao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private BoardDao() {
			/*
			create database jspweb;
			use jspweb;
			create table ex1(
				e_data varchar(100)
			    );
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jspweb" ,
				"root" ,
				"1234"
				);
		}catch (Exception e) {System.out.println(e);}
	}
	
	//1. 등록
	public boolean onwrite(BoardDto dto) {
		String sql = "insert into ex3(bcontent , bwriter) values(? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	//2.
	public ArrayList<BoardDto> print(){
		String sql = "select * from ex3";
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto((rs.getInt(1)),
				(rs.getString(2)),
				(rs.getString(3)),
				(rs.getString(4)));
				list.add(dto);
				//System.out.println("리스트" + list);
			}
		} catch (Exception e) {System.out.println(e);}
		
		return list;
	}
	//3.
	public boolean update(int bno , String content) {
		String sql = "update ex3 set bcontent =? where bno=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(2, bno);
			ps.setString(1, content);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	//4.
	public boolean del(int bno) {
		String sql = "delete from ex3 where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
}





























