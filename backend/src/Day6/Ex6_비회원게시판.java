package Day6;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex6_비회원게시판 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fs = new FileInputStream("C:/Users/504/Desktop/비회원게시판.txt");
		FileOutputStream fout = new FileOutputStream("C:/Users/504/Desktop/비회원게시판.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/504/Desktop/비회원게시판.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		// 0 : 게시물의 상세페이지
		// -1 : 쓰기
		// -2 : 나가기
		
		String str = " ";
		byte[ ] readBuffer = new byte[fs.available()];
        
	board : while(true) {
		
		System.out.println("------------게시판------------");
		System.out.println("번호	" + "내용	" + "제목	"+ "작성자	");
		
		while (fs.read( readBuffer ) != 0){
			 System.out.println(new String(readBuffer));
			}
       
		System.out.println("-----------------------------");
				
				
		System.out.println("-1 : 쓰기 / -2 : 나가기");
		int a = sc.nextInt();
		
		if(a == -1) {
			
			System.out.println("제목을 입력하세요. : ");
			String stitle = sc.next();
			System.out.println("이름을 입력하세요. : ");
			String sname =  sc.next();
			System.out.println("조회수를 입력하세요. : ");
			String sread =  sc.next();
			System.out.println("내용을 입력하세요.");
			String scontent =  sc.next();
			
			str += stitle+"\t"+sname+"\t"+sread+"\t"+scontent;
			StringTokenizer st = new StringTokenizer(str , " ");
			bw.write(st.nextToken()+"\n");
			// 게시글 출력
			bw.flush();
			
		}
		if(a == -2 ) {
			System.out.println("종료합니다.");
			break board;
		}
		
		
		
		}
		bw.close();
		br.close();
	}
}
