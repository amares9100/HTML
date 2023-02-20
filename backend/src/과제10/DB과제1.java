package 과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		
		
		while(true) {
			try {
			System.out.println("1. DB연결 2. SQL구문작성 3. 매개변수 입력");
			int ch = sc.nextInt();
			
			if(ch==1) {
				System.out.println("DB이름을 입력하세요. : ");
				String db = sc.next();
				
				System.out.println("id를 입력하세요. : ");
				String id = sc.next();
				
				System.out.println("pw를 입력하세요. : ");
				String pw = sc.next();
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db , id , pw);
			}
			else if(ch==2) {
				System.out.println("SQL 구문을 작성하세요.(table)");
				sc.nextLine();
				String table = sc.nextLine();
				//create table product(pno int , pname varchar(20) , pn varchar(100), pprice int);
				PreparedStatement ps = con.prepareStatement(table);
				ps.execute();
			}
			else if(ch==3) {
				System.out.println("제품번호(정수),제품명,제품설명,제품가격(int)를 입력해주세요.");
				System.out.println("제품번호 : ");
				sc.nextLine();
				int pno = sc.nextInt();
				System.out.println("제품명 : ");
				String pname = sc.next();
				System.out.println("제품설명 :");
				String pn = sc.next();
				System.out.println("제품가격 : ");
				int pprice = sc.nextInt();
				
				String input = "insert into product( pno , pname , pn , pprice ) values( ? , ? , ? ,?)";
				PreparedStatement ps = con.prepareStatement(input);
				
				ps.setInt(1, pno);
				ps.setString(2, pname);
				ps.setString(3, pn);
				ps.setInt(4, pprice);
				
				ps.executeUpdate();
				
				
			}
			
			}
			catch(InputMismatchException e) {
				System.out.println("잘못입력하였습니다."+e);
			}
			catch(SQLException e) {
				System.out.println("SQL 오류"+e);
			}
			catch(Exception e) {
				System.out.println("오류. 다시연결하세요."+e);
			}
		}
	}
}




















