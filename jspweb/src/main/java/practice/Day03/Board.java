package practice.Day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(content + writer);
		BoardDto boardDto = new BoardDto(0, content, writer, null);
		boolean result = BoardDao.getInstance().onwrite(boardDto);
		
		response.getWriter().print(result);
		
	}    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		ArrayList<BoardDto> list = 
		BoardDao.getInstance().print();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list);
		
		//System.out.println(jsonArray);
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("content");
		
		boolean result = BoardDao.getInstance().update(bno, content);
		
		response.getWriter().print(result);
	}
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		
		String bno = request.getParameter("bno");
		boolean result = BoardDao.getInstance().del(Integer.parseInt(bno));
		
		response.getWriter().print(result);
	}

}

	/*
	 	JSP서블릿 put, delete 사용시에 필수 설정값
	 		*기본값 : 매개변수 요청 차단
	 	Servers -> server.xml -> 하단 소스탭 -> 60번대줄
	  	<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
	 */

















