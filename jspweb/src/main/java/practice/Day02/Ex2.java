package practice.Day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<Dto> list = Dao.getInstance().getData2();
		
			// JAVA  ----> JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		//ArrayList<Object> list = Dao.getInstance().getData();
		//response.getWriter().print(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : JS 요청 객체
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		System.out.println(request.getParameter("data3"));
		System.out.println(request.getParameter("data4"));
		System.out.println(request.getParameter("data5"));
		
		System.out.println(request.getParameter("data6"));
		System.out.println(request.getParameter("data7"));
		System.out.println(request.getParameter("data8"));
		System.out.println(request.getParameter("data9"));
		System.out.println(request.getParameter("data10"));
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		double data3 = Double.parseDouble(request.getParameter("data3")) ;
		int data4 = Integer.parseInt(request.getParameter("data4")) ;
		String data5 = request.getParameter("data5");
		
		String data6 = request.getParameter("data6");
		String data7 =  request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean(request.getParameter("data8")) ;
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		
		Dto dto = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		boolean result2 =   Dao.getInstance().setData2(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result2);
		
		
		// Dao
		//Boolean result = Dao.getInstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		//response.setCharacterEncoding("UTF-8");
		//response.getWriter().print(result);
	}

}
































