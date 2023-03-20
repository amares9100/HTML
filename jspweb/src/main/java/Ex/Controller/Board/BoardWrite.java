package Ex.Controller.Board;

import java.io.File;
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
import Ex.Model.DTO.PageDto;

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
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			// 검색
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			
			// page 출력 게시물 
			int page = Integer.parseInt(request.getParameter("page"));
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			
			
			int startrow = (page-1)*listsize;
			
			// page 버튼 출력
			
			//int totalsize = BoardDao.getInstance().gettotalsize();
			
			int totalsize = BoardDao.getInstance().gettotalsize(key , keyword , cno);
			int totalpage = totalsize% listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
			
			int btnsize = 5;
			int startbtn = ((page-1) / btnsize) * btnsize+1;
			int endbtn = startbtn +btnsize-1;
			if(endbtn > totalpage) {
				endbtn = totalpage;
			}
			
			//ArrayList<BoardDto> result = BoardDao.getInstance().getlist(startrow , listsize);
			ArrayList<BoardDto> result = BoardDao.getInstance().getlist(startrow , listsize , key , keyword , cno);
			
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(pageDto);
			
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
 		if(mno == 0) {
 			 response.getWriter().print(false);
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
		
		String path = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile");
		// 현재 프로젝트의 경로찾기
		// String path = "C:\\Users\\504\\git\\HTML\\jspweb\\src\\main\\webapp\\Ex\\Member\\pimg";
		System.out.println(path);
		// 업로드
		MultipartRequest multi = new MultipartRequest(
				request , 						// 요청방식
				path , 					// 첨부파일 가져와서 저장할 폴더
				//수업에서는 서버로 올림 				// 1.프로젝트[GIT] / 2.서버[WORKSPACE]
				1024*1024*10 ,					// 첨부파일 허용 범위 용량[바이트단위]		
				"UTF-8" ,						// 인코딩
				new DefaultFileRenamePolicy() 	// 동일한 첨부파일명이 있으면 뒤에 숫자 붙여짐
				);
		
		
		int bno = Integer.parseInt(multi.getParameter("bno"));
		int cno = Integer.parseInt(multi.getParameter("cno")); 
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		String oldbfile = BoardDao.getInstance().getBoard(bno).getBfile();
		if(bfile == null) {
			bfile = oldbfile;
		}else {
			
			String odlpath = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile/"+oldbfile);
			File file = new File(odlpath);
			if(file.exists()) file.delete();
		}
		
		
		
		
		
		BoardDto dto = new BoardDto(bno, btitle, bcontent, bfile, cno);
		
		boolean result = BoardDao.getInstance().bupdate(dto);
		
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		boolean result = true;
		
		if(type == 1) {
			result = BoardDao.getInstance().bdelete(bno);
		}
		else if(type == 2) {
			result = BoardDao.getInstance().bfiledelete(bno);
		}
		
		if(result) {
			String path = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile/"+bfile);
			File file = new File(path);
			if(file.exists()) file.delete();
			response.getWriter().print(result);
		}
		
		
		
	}

}
