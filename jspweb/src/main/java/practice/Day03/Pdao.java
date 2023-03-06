package practice.Day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Pdao {
	private static Pdao pdao = new Pdao();
	public static Pdao getInstence() {return pdao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Pdao() {
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
	
	public boolean product(String pname , int pprice) {
		String sql = "insert into product3(pname, pprice) values(? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		
		return false;
	}
	
	public ArrayList<Pdto> onlist() {
		String sql = "select * from product3";
		
		ArrayList<Pdto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Pdto pdto = new Pdto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(pdto);
			}
		
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	public boolean p_update(int pno , String pname , int pprice) {
		String sql = "update product3 set pname=? , pprice=? where pno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	public boolean p_del(int pno) {
		String sql = "delete from product3 where pno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
}





























