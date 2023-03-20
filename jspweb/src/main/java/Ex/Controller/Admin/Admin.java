package Ex.Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Ex.Model.DTO.AdminDto;
import Ex.Model.DTO.MemberDto;
import Ex.Model.DAO.AdminDao;
import Ex.Model.DAO.BoardDao;
import Ex.Model.DAO.MemberDao;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		int type = Integer.parseInt(request.getParameter("type"));
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		int startrow = (page-1)*listsize;
		
		// page 버튼 출력
		
		//int totalsize = BoardDao.getInstance().gettotalsize();
		
		int totalsize = AdminDao.getInstance().getMembertotalsize(key, keyword);
		int totalpage = totalsize% listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
		
		int btnsize = 5;
		int startbtn = ((page-1) / btnsize) * btnsize+1;
		int endbtn = startbtn +btnsize-1;
		if(endbtn > totalpage) {
			endbtn = totalpage;
		}
		System.out.println("startrow " + startrow);
		System.out.println("listsize " + listsize);
		
		System.out.println("totalsize " + totalsize);
		System.out.println("totalpage " + totalpage);
		System.out.println("startbtn " + startbtn);
		System.out.println("endbtn " + endbtn);
		
		
		
		ArrayList<MemberDto> result = AdminDao.getInstance().getmemberlist(startrow, listsize, key, keyword);
		System.out.println("응답 : "+result);
		
		AdminDto addto = new AdminDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
		System.out.println(addto.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(addto);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
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
