package Ex.Controller.Board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filedownload
 */
@WebServlet("/filedownloade")
public class Filedownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Filedownload() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String bfile = request.getParameter("bfile");
		System.out.println(bfile);
		
		// 파일 경로 추적
		String downloadpath = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile/"+bfile);
		System.out.println(downloadpath);
		// 찾은 파일 경로로 파일객체 만들기
		File file = new File(downloadpath);
		
	
		// HTTP 다운로드 형식 [ 프론트엔드] = 각 브라우저 제공
		/*
		 * response.setHeader( // HTTP Header메소드[ HTTP 옵션정보 설정 ] "Content-Disposition" ,
		 * // 각 브라우저마다 다운로드형식 HTTP 옵션에 포함해서 보내기
		 * "attachment;filename="+URLEncoder.encode( bfile , "UTF-8" ) // 다운로드시 파일명이
		 * 표시되는 옵션 [ 한글파일 인코딩 ] // URLEncoder.encode( 파일명 , "UTF-8" ) : URL(통신주소) 의
		 * 한글인코딩 );
		 */
		
		
		
		// 파일 스트림 다운로드 형식
			// 1. 파일 객체의 바이트를 모두 읽어오기
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
			// 2. 바이트를 저장할 바이트 배일 준비
		byte[] bytes = new byte[(int)file.length()]; 
			// 3. read() : 해당 파일을 바이트로 읽어오는 함수 fin.read(bytes); -> fin을 읽어서 bytes배열에 바이트로 저장
		fin.read(bytes);
			// 4. 읽어온 바이트를 출력
		BufferedOutputStream finout = new BufferedOutputStream(response.getOutputStream());
			// 5. 바이트 배열에 저장된 바이트를 내보내기
		finout.write(bytes);
			// 6. 스트림 닫기
		fin.close();
		finout.flush();
		finout.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

}
