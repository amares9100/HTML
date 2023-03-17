<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
	
	<%@ include file = "../header.jsp" %>
	
	<%
		String cno = request.getParameter("cno");
	%>
	<input type="hidden" class="cno" value="<%=cno%>">
	<div class="container">
	
		<h3 class="cname"></h3>
		<a href="write.jsp">글쓰기</a>
		
		
	<button onclick="setsearch()" type="button"> 전체보기 </button>
	<div class ="searchcount"></div>
	<select onchange="listsize()" class="printkey">
		<option>3</option>
		<option>5</option>
		<option>10</option>
	</select>
		<table class="boardTable table table-hover">
			
		
		</table>
		<!-- 페이징 처리버튼 -->
		<div class="pagebox">
			
		</div>
		<div>
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text">
			<button onclick="getsearch()" type="button">검색</button>
		</div>
	
	</div>



	<script src="/jspweb/Ex/js/board/list.js" type="text/javascript"></script>
</body>
</html>