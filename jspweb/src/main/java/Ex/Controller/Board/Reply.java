package Ex.Controller.Board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Ex.Model.DAO.BoardDao;
import Ex.Model.DAO.MemberDao;
import Ex.Model.DTO.ReplyDto;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/Ex/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type = Integer.parseInt(request.getParameter("type"));
		
		int rindex =0;
		if(type == 1) {
			
		}
		else if(type == 2) {
			rindex = Integer.parseInt(request.getParameter("rindex"));
		}
		
		
		ArrayList<ReplyDto> result =  BoardDao.getInstance().getReplyList(bno , rindex);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String rcontent = request.getParameter("rcontent");
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = MemberDao.getInstance().getMno((String) request.getSession().getAttribute("login")) ;
		int type = Integer.parseInt(request.getParameter("type"));
		
		ReplyDto dto = null;
		if(type == 1) {
			dto = new ReplyDto(rcontent, mno, bno);
		}
		else if(type == 2) {
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto = new ReplyDto(rcontent, mno, bno);
			dto.setRindex(rindex);
		}
		
		
		
		boolean result = BoardDao.getInstance().rwrite(dto);
		
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
