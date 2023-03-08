package Ex.Model.DAO;

import java.util.ArrayList;

import Ex.Model.DTO.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return dao;}
	
	public boolean idCheck( String mid ) {
		String sql = "select * from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			if( rs.next() ) { return true; } // 중복이면 true
			else { return false; }			// 중복없으면 false
		}
		catch (Exception e) {System.out.println(e);}
		return false; 
	}
	
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid , mpwd , memail , mimg) values(? , ? , ? , ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return false;
	}
	
	public ArrayList<MemberDto> userlist(){
		String sql = "select * from member";
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5));
				list.add(dto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
}
























