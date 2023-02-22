package Day15.Ex6;

import java.util.StringTokenizer;

public class 실행 {
	public static void main(String[] args) {
		
		// String vs StringBuilder
				String data = "ABC";
				data+="DEF"; // 변경된것처럼 보이지만 새로운 참조할당[효율성떨어짐]
				
				
				String data2 = new StringBuilder()
						.append("EDF")
						.insert(0, "ABC")
						.delete(3, 4)
						.toString();
				
				System.out.println(data2);
				
				String data3 = "홍길동&이수홍-박연수";
				String[] arr = data3.split("&|-");
				String[] arr2 = data3.split("&");
				for(String token : arr) {
					System.out.println(token);
				}
				for(String token : arr2) {
					System.out.println(token);
				}
				
				String data4 = "홍길동/이수홍/박연수";
				StringTokenizer st = new StringTokenizer(data4 , "/");
				
				while(st.hasMoreTokens()) { // 남아있는 문자열이 있으면 True 아니면 false
					String token = st.nextToken(); // st의 문자열을 하나씩 가져옴
					System.out.println(token);	   // 출력
				}
	}
}
