package jspweb.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	
	public Dao() {
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
	
	public boolean setData(String data) {
		// 1. SQL 작성
		String sql = "insert into ex1 values(?)";
		// 2. SQL 대입
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {System.out.println(e);}
		return false;
		
	}
	public ArrayList<String> getData(){
		String sql = "select * from ex1";
		ArrayList<String> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public boolean setQdata(String qdata) {
		String sql = "insert into q1 values(?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, qdata);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public ArrayList<String> getQdata(){
		String sql = "select * from q1";
		ArrayList<String> qdata = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				qdata.add(rs.getString(1));
			}
		}
		catch (Exception e) {System.out.println(e);}
		return qdata;
	}
	
}
