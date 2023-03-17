package Ex.Controller.Board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Ex.Model.DAO.BoardDao;

/**
 * Servlet implementation class Boardview
 */
@WebServlet("/Boardview")
public class Boardview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boardview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 하루에 한번씩 조회수 또는 좋아요/싫어요 증가
		// - 회원별 vs PC마다(ip)
		
		// 자바에서 현재 요청한 클라이언트의 ip확인
		String ip = request.getRemoteAddr();
		// 세션 생성[게시글마다 / 좋아요,싫어요마다 / ip마다
		Object o = request.getSession().getAttribute(type+ip+bno);
		if(o == null) {
			request.getSession().setAttribute(type+ip+bno , 1);
			// 세션 생명주기[생명주기 지나면 자동으로 메모리 삭제]
			request.getSession().setMaxInactiveInterval(60*60*24); // 하루
			boolean result = BoardDao.getInstance().bIncrease(type, bno);
		}
		else {}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt( request.getParameter("bno"));
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		boolean result = BoardDao.getInstance().bdelete(bno);
		
		if(result) {
			String path = request.getSession().getServletContext().getRealPath("/Ex/js/board/bfile/"+bfile);
			File file = new File(path);
			if(file.exists()) {
				file.delete();
			}
		}
		
		
		
		response.getWriter().print(result);
	}

}
























