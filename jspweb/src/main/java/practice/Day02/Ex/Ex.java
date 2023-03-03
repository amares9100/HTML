package practice.Day02.Ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Ex
 */
@WebServlet("/Ex")
public class Ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<Dto> list = Dao.getInstance().getqData();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String qdata1 = request.getParameter("qdata1");
		String qdata2 = request.getParameter("qdata2");
		double qdata3 = Double.parseDouble(request.getParameter("qdata3")) ;
		int qdata4 = Integer.parseInt(request.getParameter("qdata4")) ;
		String qdata5 = request.getParameter("qdata5");
		String qdata6 = request.getParameter("qdata6");
		boolean qdata7 = Boolean.parseBoolean(request.getParameter("qdata7")) ;
		String qdata8 =  request.getParameter("qdata8");
		String qdata9 = request.getParameter("qdata9");
		
		Dto dto = new Dto(qdata1, qdata2, qdata3, qdata4, qdata5, qdata6, qdata7, qdata8, qdata9);
		
		boolean result = 
				Dao.getInstance().setqData(dto);
		
		response.getWriter().print(result);
		
	}

}
