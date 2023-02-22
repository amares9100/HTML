package 과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProductDao {

	private static ProductDao dao = new ProductDao();
	
	public static ProductDao getInstance() {return dao;}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment11", "root" , "1234");
			System.out.println("DB연결확인");
		}
		catch (Exception e) {
			System.out.println("DB연결오류");
		}
		
	}
	
	public boolean create_product(ProductDto Dto) {
		try {
			ps = conn.prepareStatement("insert into product(pname , pprice , pinven)values( ? , ? , ?)");
			ps.setString(1, Dto.getPname());
			ps.setInt(2, Dto.getPprice());
			ps.setInt(3, Dto.getPinven());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DB제품등록오류");
		}
		return false;
	}
	
	
	public ArrayList<ProductDto> list(){
		try {
			ps = conn.prepareStatement("select * from product");
			rs = ps.executeQuery();
			ArrayList<ProductDto> list = new ArrayList<>();
			while(rs.next()) {
				
				
				ProductDto dto = new ProductDto(rs.getInt(1) , rs.getString(2) , rs.getInt(3) , rs.getInt(4));
				list.add(dto);
				
			}return list;
		}
		catch (Exception e) {
			System.out.println("DB제품출력오류");
		}
		return null;
	}
	
	public boolean update(String pname , int pprice , int pno) {
		try {
			ps = conn.prepareStatement("update product set pname = ? , pprice = ? where pno=?");
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DB제품수정오류");
		}
		return false;
	}
	
	
	public boolean inven_update(int pno , int pinven) {
		try {
			ps = conn.prepareStatement("update product set pinven = ? where pno=?");
			ps.setInt(1, pinven);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DB재고수정오류");
		}
		return false;
	}
	
	public boolean delete(int pno) {
		try {
			ps = conn.prepareStatement("delete from product where pno=?");
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DB제품삭제오류");
		}
		return false;
	}
	
	// 사용자 제품 구매리스트
	public ProductDto user_basket(int pno){
		try {
			ps = conn.prepareStatement("select * from product where pno=?");
			ps.setInt(1, pno);
			rs = ps.executeQuery();
			
			rs.next();
				ProductDto dto = new ProductDto(rs.getInt(1) , rs.getString(2) , rs.getInt(3) , rs.getInt(4));
				
				
			return dto;
			
		}
		catch (Exception e) {
			System.out.println("DB제품구매리스트오류");
		}
		return null;
	}
	
	
	// 사용자 구매
	public boolean user_sell() {
		try {
			ArrayList<ProductDto> list = new ArrayList<>();
			for(int i = 0 ; i < Controller.getInstance().user_basket.size() ; i++) {
				ps = conn.prepareStatement("select * from product where pno=?");
				ps.setInt(1, Controller.getInstance().user_basket.get(i).getPno());
				rs = ps.executeQuery();
				rs.next();
					ProductDto dto = new ProductDto(rs.getInt(1) , rs.getString(2) , rs.getInt(3) , rs.getInt(4));
					list.add(dto);
				int x= (list.get(i).getPinven())-1;
				if(x>=0) {
				ps = conn.prepareStatement("update product set pinven = ? where pno=?");
				ps.setInt(1, x);
				ps.setInt(2, Controller.getInstance().user_basket.get(i).getPno());
				ps.executeUpdate();
				}
				else { System.out.println("재고부족"); break;}
			}return true;
		}
		catch (Exception e) {
			System.out.println("DB제품구매오류"+e.getMessage());
		}
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
}


















