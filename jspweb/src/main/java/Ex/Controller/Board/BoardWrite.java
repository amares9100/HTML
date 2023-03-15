package Ex.Controller.Board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Ex.Model.DAO.BoardDao;
import Ex.Model.DAO.MemberDao;
import Ex.Model.DTO.BoardDto;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		if(type == 1) {
			ArrayList<BoardDto> result = BoardDao.getInstance().getlist();
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(type == 2) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile");
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
		int cno = Integer.parseInt(multi.getParameter("cno")); 	System.out.println("cno : "+cno);
 		String btitle = multi.getParameter("btitle");System.out.println("btitle : "+ btitle);
 		String bcontent = multi.getParameter("bcontent");System.out.println("bcontent : " + bcontent);
 		String bfile = multi.getFilesystemName("bfile"); System.out.println("bfile : " + bfile);
 			String mid = (String)request.getSession().getAttribute("login");
 		int mno = MemberDao.getInstance().getMno(mid);
 		if(mno>0) {
 			response.getWriter().print("false");
 		}
 		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
 		System.out.println("dto : " + dto);
 		
 		boolean result = BoardDao.getInstance().bwrite(dto);
 		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

}
