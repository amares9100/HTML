package practice.과제1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import practice.과제1.model.dto.CompanyDto;


public class CompanyDao extends Dao{
	
	private static CompanyDao dao = new CompanyDao();
	private CompanyDao() {}
	public static CompanyDao getInstance() {return dao;}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs ;
	
	public ArrayList<CompanyDto> list(){
		String sql = "select * from workers";
		ArrayList<CompanyDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CompanyDto dto = new CompanyDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7), 
						rs.getString(8),
						rs.getString(9));
				list.add(dto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
}
