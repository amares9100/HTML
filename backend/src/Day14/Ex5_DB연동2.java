package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		while(true) {
			try {
			System.out.println("1.DB연결 2. sql 구문입력 3. 매개변수 구문 삽입");
			int ch = sc.nextInt();
			
				if(ch==1) {
					System.out.println("연동할 DB명 입력 : ");
					String dbname = sc.next();
					System.out.println(dbname + "에 연결합니다.");
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname , "root" , "1234");
					System.out.println("연결성공");
				}
				else if(ch==2) {
					System.out.println("--sql입력 : ");
					sc.nextLine();
					String sql = sc.nextLine();
					PreparedStatement ps =  conn.prepareStatement(sql);
					ps.execute();
				}
				else if(ch==3) {
					System.out.println("번호 : "); int  mno = sc.nextInt();
					System.out.println("아이디 : ");String mid = sc.next();
					System.out.println("비밀번호 : ");String mpw = sc.next();
					
					String sql="insert into member values(? , ? , ?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					// ? 매개변수에 데이터변수 대입
					ps.setInt(1, mno); // 1 : sql 구문에서 첫번째 ? 자리
					ps.setString(2, mid);
					ps.setString(3, mpw);
					ps.executeUpdate();
					
				}
				
				
			}
			catch (InputMismatchException e) {
				System.out.println("알수없는 번호입니다.");
				sc = new Scanner(System.in);
			}
			catch(SQLException e) {
				System.out.println("sql오류 : "+e);
			}
			catch(Exception e) {
				System.out.println("DB연결 후 다시 실행");
			}
		}
	}
}
