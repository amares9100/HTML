package Ex.Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Ex.Model.DAO.MemberDao;
import Ex.Model.DTO.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/Ex/Member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Info() {
        super();
        
    }
    
    
    // 회원가입
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 첨부파일 쓰기전
 		/*
		String mid = request.getParameter("mid");
 		String mpwd = request.getParameter("mpwd");
 		String memail = request.getParameter("memail");
 		String mimg = request.getParameter("mimg");
 		
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 		
 		boolean result = MemberDao.getInstance().signup(dto);
 		response.getWriter().print(result);
 		*/
		
		// 첨부파일 있을때
		// request는 첨부파일(대용량)에 대한 요청이 불가 --> 외부 라이브러리 사용 cos.jar 빌드패스 추가
		// WEB-INF - lib에 cos.jar 추가
		// MultipartRequest 제공
		
		// 현재 서버의 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/Ex/Member/pimg");
		// 현재 프로젝트의 경로찾기
		// String path = "C:\\Users\\504\\git\\HTML\\jspweb\\src\\main\\webapp\\Ex\\Member\\pimg";
		System.out.println(uploadpath);
		// 업로드
		MultipartRequest multi = new MultipartRequest(
				request , 						// 요청방식
				uploadpath , 					// 첨부파일 가져와서 저장할 폴더
				//수업에서는 서버로 올림 				// 1.프로젝트[GIT] / 2.서버[WORKSPACE]
				1024*1024*10 ,					// 첨부파일 허용 범위 용량[바이트단위]		
				"UTF-8" ,						// 인코딩
				new DefaultFileRenamePolicy() 	// 동일한 첨부파일명이 있으면 뒤에 숫자 붙여짐
				);
		
		// 멀티로 불러오기 -- form->input의 name 식별자로 값 입력
		String mid = multi.getParameter("mid");
 		String mpwd = multi.getParameter("mpwd");
 		String memail = multi.getParameter("memail");
 		//String mimg = multi.getParameter("mimg"); // 첨부파일된 파일명 호출필요
 		String mimg = multi.getFilesystemName("mimg"); // getFilesystemName사용
 		
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 		
		boolean result = MemberDao.getInstance().signup(dto);
		response.getWriter().print(result);
		
 	
 	}
 		
 	
 	
	// 로그인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	

	// 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	/*
		// 로그인된 회원 수정
		String mid = (String) request.getSession().getAttribute("login");
		String mpwd = request.getParameter("mpwd");
		String newmpwd = request.getParameter("newmpwd");
		String memail = request.getParameter("memail");
		
		boolean result = MemberDao.getInstance().Update(mid, mpwd, memail, newmpwd);
		
		response.getWriter().print(result);
	*/
		String path = request.getSession().getServletContext().getRealPath("/Ex/Member/pimg");
		MultipartRequest Multi = new MultipartRequest(
				request , 						// 요청방식
				path , 					// 첨부파일 가져와서 저장할 폴더
				//수업에서는 서버로 올림 				// 1.프로젝트[GIT] / 2.서버[WORKSPACE]
				1024*1024*10 ,					// 첨부파일 허용 범위 용량[바이트단위]		
				"UTF-8" ,						// 인코딩
				new DefaultFileRenamePolicy() 	// 동일한 첨부파일명이 있으면 뒤에 숫자 붙여짐	
				);
		
		String mid = (String)request.getSession().getAttribute("login");	System.out.println( "mid:"+mid);
		String mpwd = Multi.getParameter("mpwd");							System.out.println( "mpwd:"+mpwd);
		String newmpwd = Multi.getParameter("newmpwd");						System.out.println( "newmpwd:"+newmpwd);
		String memail = Multi.getParameter("memail");						System.out.println( "memail:"+memail);
		String newmimg = Multi.getFilesystemName("newmimg");				System.out.println( "newmimg:"+newmimg);
		String defaultimg = Multi.getParameter("defaultimg");				System.out.println( "defaultimg:"+defaultimg);
		
		// 3. 만약에 새로운 첨부파일이 없으면 
		if( newmimg == null ) { // 기존 이미지 파일 그대로 사용 
			newmimg = MemberDao.getInstance().getMember( mid ).getMimg();
		}
		// 3. 만약에 기본프로필 사용체크 했으면
		if(  defaultimg.equals( "true" ) ) { // 기본프로필 사용 
			newmimg = "X.jpg";
		}
		// *추후: 프로필 변경시 기존프로필 실제파일을 서버에서 삭제
		
		boolean result =  MemberDao.getInstance().Update(mid, mpwd, newmpwd, memail, newmimg);
 		System.out.println(result);
 		response.getWriter().print(result);
 		
 		
		
	}

	// 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 로그인된 회원 삭제
		String mid = (String)request.getSession().getAttribute("login");
		String mpwd = request.getParameter("mpwd");	
		System.out.println(mid);
			
			
		boolean result = MemberDao.getInstance().setDelete(mid , mpwd);
		
		response.getWriter().print(result);
	}

}





































