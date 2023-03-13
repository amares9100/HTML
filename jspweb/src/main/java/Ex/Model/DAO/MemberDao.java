package Ex.Model.DAO;

import java.sql.Statement;
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
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate();
			
				// 포인트 지급
					// insert 이후 생성된 auto키(pk)값 찾기
					// ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				int pk = rs.getInt(1);
				setPoint("회원가입축하", 100, pk);
			}
			
				
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
	
	// 4. 아이디,비밀번호 검증   [ 로그인 ]
		public boolean login( String mid , String mpwd ) {
			String sql = "select * from member where mid = ? and mpwd = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , mid );
				ps.setString( 2 , mpwd );
				rs = ps.executeQuery();
				if( rs.next() ) {  return true; } // 만약에 조건에 충족한 레코드가 존재하면 
			}catch (Exception e) {System.out.println(e);} return false;
		}
		// 5. 특정 회원1명 찾기 
		public MemberDto getMember( String mid ) {
			String sql = "select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint "
					+ "from member m , mpoint p "
					+ "where m.mno = p.mno and m.mid=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , mid );
				rs = ps.executeQuery();
				if( rs.next() ) {	// 비밀번호 제외한 검색된 레코드1개를 dto 1개 만들기 
					MemberDto dto = new MemberDto( 	rs.getInt(1), rs.getString(2),null ,rs.getString(3), rs.getString(4) );
					dto.setMpoint(rs.getInt(5));
					return dto;	// 레코드1개 --> 회원1명 --> 회원dto 반환 
				}
			}catch (Exception e) {System.out.println(e);} 
			return null; // 없다.
		}
		// 6. 아이디찾기 
		public String findid( String memail ) {
			String sql = "select mid from member where memail = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , memail );
				rs = ps.executeQuery();
				if( rs.next() ) { return rs.getString( 1 ); } // 찾은 아이디 반환
			}catch (Exception e) {System.out.println(e);} 
			return "false"; // 없으면 false 
		}
		// 7. 비밀번호찾기 
		public String findpwd( String mid , String memail , String updatePwd ) {
			String sql = "select mno from member where mid = ? and memail = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , mid );
				ps.setString( 2 , memail);
				rs = ps.executeQuery();
				if( rs.next() ) {  // 만약에 동일한 아이디와 이메일 일치한 레코드가 있으면 [ 찾았다. ]
					sql = "update member set mpwd = ? where mno = ?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , updatePwd );		// 임시비밀번호로 업데이트
					ps.setInt( 2 ,  rs.getInt( 1 ) );	// select 에서 찾은 레코드의 회원번호 
					int result = ps.executeUpdate();	// 업데이트한 레코드 개수 반환
					if( result == 1 ) { // 업데이트한 레코드가 1개 이면 
						// -- 이메일전송 테스트 되는경우 만 -- //
						//new MemberDto().sendEmail( memail, updatePwd ); // 임시비밀번호를 이메일로 보내기 
						//return "true";
						// -- 이메일전송 테스트 안되는 경우 -- //
						return updatePwd;
					}
				}
			}catch (Exception e) {System.out.println(e);} 
			return "false";
		}
		
		// 포인트 함수 [ 지급내용 , 지급개수 , 대상 ]
		public boolean setPoint(String content , int point , int mno) {
			String sql = "insert into mpoint(mpcomment ,mpamount , mno) values(?,?,?)";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, content);
				ps.setInt(2, point);
				ps.setInt(3, mno);
				ps.executeUpdate();
				return true;
				
			} catch (Exception e) {System.out.println(e);}
			return false;
		}
		
		// 회원탈퇴 [ 인수 : mid 반환 : 성공실패 ]
		public boolean setDelete(String mid , String mpwd) {
			String sql = "delete from member where mid=? and mpwd=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				ps.setString(2, mpwd);
				
				int count = ps.executeUpdate(); // 삭제된 레코드 수 반환
				if(count == 1 ) {
					return true;
				}
			} catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
		// 회원수정 [ 인수 : mid , mpwd , memail  반환 : 성공실패 ]
		public boolean Update(String mid , String mpwd,String newmpwd ,String memail , String newmimg ) {
			String sql = "update member set mpwd = ? , memail = ? , mimg=? where mid = ? and mpwd = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, newmpwd);
				ps.setString(2, memail);
				ps.setString(3, newmimg);
				ps.setString(4, mid);
				ps.setString(5, mpwd);
				int count = ps.executeUpdate();
				if(count == 1 ) {
					return true;
				}
			} catch (Exception e) {System.out.println(e);}
			return false;
		}
}
























