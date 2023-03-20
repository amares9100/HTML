<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../header.jsp" %>
	
	<%
		Object o = request.getSession().getAttribute("login");
		if(o == null){
			response.sendRedirect("jspweb/Ex/Member/login.jsp");
		}
		String bno = request.getParameter("bno");
		
	%>
	
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
	<h3> 글수정 </h3>
		<form class="writeform">
			
			
			카테고리 : <select name = "cno" class="cno">
						<option value="1">공지사항</option>
						<option value="2">커뮤니티</option>
						<option value="3">QnA</option>
						<option value="4">노하우</option>
			
					</select><br>
			제목 : <input type="text" name="btitle" class="btitle"><br>
			내용 : <textarea rows="3" cols="3" name="bcontent" class="bcontent"></textarea><br>
			<div class="file_box">
			
			</div>
			<button onclick="bupdate()" type="button">수정</button>
			
		</form>
			
	</div>
	<!-- 
		HTML ------------ > form [ 동기식 : 페이지전환이 있음 ] 
		<form action="통신할 서블릿URL" method="HTTP메소드"(get , post)>
			1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송 타입
			2. enctype="multipart/form-data"
			
		- 주의 : form 태그 안에 있는 <button> type 생략시 type="submit"
		
		vs 
		
		JS ------------ > AJAX [ 비동기식 , 동기식 둘다 가능]
		
	 -->	
	
	
	<script src="/jspweb/Ex/js/board/update.js" type="text/javascript"></script>
	
</body>
</html>
























