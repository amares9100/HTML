package Ex.Model.DAO;

import java.util.ArrayList;


import Ex.Model.DTO.MemberDto;

public class AdminDao extends Dao{
	private static AdminDao dao = new AdminDao();
	private AdminDao() {}
	public static AdminDao getInstance() {return dao;}
	
	public int getMembertotalsize(String key , String keyword) {
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql = "select count(*) from member";
		}
		else {
			sql = "select count(*) from member m where "+key+" like '%"+keyword+"%'";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	public ArrayList<MemberDto> getmemberlist(int startrow , int listsize , String key , String keyword){
		
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql = "select * from member limit ? , ?";
		}
		else {
			sql = "select * from member m where "+key+" like '%"+keyword+"%' limit ? , ?";
		}
		
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3),
						rs.getString(4), rs.getString(5));
						
				list.add(dto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
}
