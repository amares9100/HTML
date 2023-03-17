package Ex.Model.DAO;

import java.util.ArrayList;

import Ex.Model.DTO.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}
	
	
	public boolean bwrite(BoardDto dto) {
		String sql = "insert into board(btitle , bcontent , bfile , mno , cno)values(?,?,?,?,?)";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			
			ps.executeUpdate();
			return true;
			
			
		} catch (Exception e) {System.out.println(e);}
	
	return false;
	
	}
	
	public ArrayList<BoardDto> getlist(int startrow , int listsize , String key , String keyword , int cno){
		
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql = "select b.* , m.mid from member m natural join board b where b.cno="+cno+"  order by b.bdate desc limit ? , ?";
		}
		else {
			sql = "select b.* , m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno="+cno+" order by b.bdate desc limit ? , ?";
		}
		
		
		
		
		ArrayList<BoardDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), 
						rs.getInt(9), rs.getInt(10), rs.getString(11));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	  public BoardDto getBoard(int bno){ 
		  String sql = "select board.*, member.mid, member.mimg from board natural join member where board.bno=?";
	  
		  try {
			  ps = con.prepareStatement(sql);
			  ps.setInt(1, bno);
			  rs = ps.executeQuery();
			  if(rs.next()) {
				  BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6), rs.getInt(7), rs.getInt(8), 
							rs.getInt(9), rs.getInt(10), rs.getString(11));
				  return dto;
		  }
	   } catch (Exception e) {System.out.println(e);}
	  return null;
	  
	  }
	 
	public int gettotalsize(String key , String keyword , int cno) {
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql = "select count(*) from member m natural join board b where b.cno ="+cno;
		}
		else {
			sql = "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno="+cno;
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
	
	public boolean bIncrease(String type , int bno) {
		String sql = "";
		if(type.equals("1")) {
			sql = "update board set bview=bview+1 where bno = ?";
		}
		else if(type.equals("2")) {
			sql = "update board set bup=bup+1 where bno = ?";
		}
		else if(type.equals("3")) {
			sql = "update board set bdown=bdown+1 where bno = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean bdelete(int bno) {
		String sql = "delete from board where bno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count == 1)return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	public boolean bupdate(BoardDto dto) {
		String sql = "update board set btitle=? , bcontent=? , bfile=? , cno=? where bno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getCno());
			ps.setInt(5, dto.getBno());
			int count = ps.executeUpdate();
			if(count == 1) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}






























