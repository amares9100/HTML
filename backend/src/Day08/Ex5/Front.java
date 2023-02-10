package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	//1. 필드
	Scanner sc = new Scanner(System.in);
	//2. 생성자
	ArrayList<Member> memberList = new ArrayList<>();
	
	//3. 메소드
	
	// 1. 메인페이지 함수
	void index() {
		
		while(true) {
			print();
			System.out.println("1.회원등록 2.회원삭제");
			int ch = sc.nextInt();
			
			if(ch==1) { signup();
			print();
				
				
			}
			else if (ch==2) { delete();
			print();
			}
			else { }
			
		}
	}
	// 2. 회원등록
			void signup() {
				System.out.println("회원명 : ");
				String name = sc.next();
				System.out.println("전화번호 : ");
				String phone = sc.next();
				// 생성자를 이용한객체 선언
				Member member = new Member(name, phone);
				memberList.add(member);
			
			
			}
			
	// 3. 회원삭제
			void delete() {
				System.out.println("삭제할 번호(인덱스) : ");
				int no = sc.nextInt();
				memberList.remove(no);
				
			}
			
	// 4. 출력
			void print() {
				System.out.println("번호\t회원\t전화번호");
				for(int i = 0 ; i <memberList.size(); i++) {
					System.out.println(i+"\t"+memberList.get(i).name+"\t"+memberList.get(i).phone);
				}
			}
			
			
}
