package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api
 */
@WebServlet("/api1")
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공공데이터 포털에서 신청한 데이터 가져오기
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=aSDmkWpHl3Cr1RdJPq5tKKlCp58KfgDH5oFC1P0MUp3XiijgdU4aVotmsBIuUW3TQOZZ3qyCrcEWg7t1Ip5RqA%3D%3D");
		
		// 해당 URL데이터 읽어오기 위한 스트림 객체 만들기
		//InputStreamReader reader = new InputStreamReader(url.openStream() , "UTF-8");
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream() , "UTF-8"));
		//char[] array = new char[100000];
		
		//reader.read(array);		// 문자 배열로 가져옴
		String result = bf.readLine();			// 모든 바이트를 읽은 후 문자열로 반환
		
		//System.out.println(array);
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}































