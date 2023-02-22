package 과제11;

import java.util.ArrayList;

public class Controller {
	
	private static Controller controller = new Controller();
	private Controller() { }
	public static Controller getInstance() { return controller;	}
	
	


	public boolean create_product(String pname , int pprice , int pinven) {
		
		ProductDto dto = new ProductDto(0, pname, pprice, pinven);
		
		return ProductDao.getInstance().create_product(dto);
	}
	
	
	public ArrayList<ProductDto> list(){
		
		return ProductDao.getInstance().list();
	}
	
	public boolean update(String pname , int ppice , int pno) {
		
		return ProductDao.getInstance().update(pname, ppice, pno);
	}
	
	public boolean inven_update(int pno , int pinven) {
		
		return ProductDao.getInstance().inven_update(pno, pinven);
	}
	
	public boolean delete(int pno) {
		
		
		return ProductDao.getInstance().delete(pno);
	}
	
	
	
	
	ArrayList<ProductDto> user_basket = new ArrayList<>();
	
	public ArrayList<ProductDto> user_basket(int pno){
		
		
		user_basket.add(ProductDao.getInstance().user_basket(pno));
		
		return user_basket;
	}
	
	
	
	
	
	public boolean user_sell() {
		
		
		return ProductDao.getInstance().user_sell();
	}
	
}
