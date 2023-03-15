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
	
	public ArrayList<BoardDto> getlist(){
		String sql = "select board.* , member.mid from member natural join board";
		ArrayList<BoardDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
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
	 
	
	
}






























