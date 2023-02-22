package 과제11;

import java.util.ArrayList;
import java.util.Scanner;


public class View {
	private static View view = new View();
	private View() {}
	public static View getInstance() { return view;}
	
	Scanner sc = new Scanner(System.in);
	
	
	
	// 메인화면
	public void index() {
		while(true) {
			System.out.println("사용자 선택 : 1.관리자 2.사용자");
			int ch2 = sc.nextInt();
			
			// 1. 사용자
			if(ch2==1) {
				System.out.println("1.제품등록 / 2.모든 제품출력 / 3. 제품수정[이름,가격] / 4. 제품재고수정 / 5.제품삭제");
				int ch = sc.nextInt();
				
				if(ch==1) {
					create_product();
				}
				else if (ch==2) {
					list();
				}
				else if (ch==3) {
					update();
				}
				else if (ch==4) {
					inven_update();
				}
				else if (ch==5) {
					delete();
				}
			}
			
			// 2. 사용자
			else if(ch2==2) {
				while(true) {
				user_list();
				System.out.println("0.제품결제 / 1.제품선택 / 2. 나가기");
				int ch = sc.nextInt();
				if(ch==0) {
					user_sell();
				}
				else if(ch==1) {
					user_basket();
				}
				else if(ch==2) {
					break;
				}
				}
			}
		}
	}
	
	
	
	
	
	
	
	// 제품등록
	public void create_product() {
		System.out.println("제품이름 : ");
		String pname = sc.next();
		System.out.println("제품가격 : ");
		int pprice = sc.nextInt();
		System.out.println("제품재고 : ");
		int pinven = sc.nextInt();
		
		boolean result = Controller.getInstance().create_product(pname, pprice, pinven);
		if(result) {
			System.out.println("등록완료");
		}
		else {System.out.println("등록실패");}
	}
	
	// 제품출력
	public void list() {
		
		ArrayList<ProductDto> list = Controller.getInstance().list();
		System.out.println("----------------------------------------------------");
		System.out.println("제품번호 \t 제품이름 \t 제품가격 \t 제품재고");
		for(int i = 0 ; i <list.size() ; i++) {
			
			System.out.println(list.get(i).getPno()+"\t  "+list.get(i).getPname()+"\t\t  "+list.get(i).getPprice()+"\t\t "+list.get(i).getPinven());
		}
		System.out.println("----------------------------------------------------");
	}
		
	// 제품수정
	public void update() {
		System.out.println("수정할 제품번호 : ");
		int pno = sc.nextInt();
		System.out.println("수정될 제품이름 : ");
		String pname = sc.next();
		System.out.println("수정될 제품가격 : ");
		int pprice = sc.nextInt();
		
		boolean result = Controller.getInstance().update(pname , pprice , pno);
		if(result) {
			System.out.println("제품수정성공");
		}
		else {System.out.println("수정실패");}
	}
	
	// 재고수정
	public void inven_update() {
		System.out.println("수정할 제품번호 : ");
		int pno = sc.nextInt();
		System.out.println("수정될 제품재고 : ");
		int pinven = sc.nextInt();
		
		boolean result = Controller.getInstance().inven_update(pno, pinven);
		if(result) {
			System.out.println("재고수정성공");
		}
		else {System.out.println("재고수정실패");}
	}
	
	// 제품삭제
	public void delete() {
		System.out.println("삭제할 제품번호 : ");
		int pno = sc.nextInt();
		
		boolean result = Controller.getInstance().delete(pno);
		
		if(result) {
			System.out.println("제품삭제성공");
		}
		else {System.out.println("제품삭제실패");}
		
	}
	
	
	
	// 사용자 제품출력
	public void user_list() {
		
		ArrayList<ProductDto> list = Controller.getInstance().list();
		System.out.println("----------------------------------------------------");
		System.out.println("제품번호 \t 제품이름 \t 제품가격 \t 상태");
		for(int i = 0 ; i <list.size() ; i++) {
			if(list.get(i).getPinven()>0) {
				System.out.println(list.get(i).getPno()+"\t  "+list.get(i).getPname()+"\t\t  "+list.get(i).getPprice()+"\t\t "+"판매중");
			}
			else {System.out.println(list.get(i).getPno()+"\t  "+list.get(i).getPname()+"\t\t  "+list.get(i).getPprice()+"\t\t "+"재고부족");
		}
		
		}
		System.out.println("----------------------------------------------------");
	}
	
	public void user_basket() {
		System.out.println("장바구니에 넣을 제품번호 : ");
		int pno = sc.nextInt();
		Controller.getInstance().user_basket(pno);
		System.out.println("제품을 장바구니에 넣었습니다.");
	}
	
	public void user_sell() {
		System.out.println("장바구니 목록");
		System.out.println("제품번호 \t 제품이름 \t 제품가격 \t 상태");
		for(int i = 0 ; i<Controller.getInstance().user_basket.size(); i++) {
			System.out.println(Controller.getInstance().user_basket.get(i).getPno()+"\t"+
					Controller.getInstance().user_basket.get(i).getPname()+"\t\t  "+
					Controller.getInstance().user_basket.get(i).getPprice());
		}
		Controller.getInstance().user_sell();
		Controller.getInstance().user_basket=null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

















