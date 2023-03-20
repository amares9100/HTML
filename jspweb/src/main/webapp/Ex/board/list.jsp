<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>

	<link href="/jspweb/Ex/css/list.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	
	<%@ include file = "../header.jsp" %>
	
	<%
		String cno = request.getParameter("cno");
	%>
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<div class="container">
		<div class="boardbox">
			
			<div class="boardtoptitle">
				<h3 class="cname"> 공지사항 </h3>
				<p> 다양한 사람들과 정보를 공유해보세요.</p>
			</div>
			
			<div class="boardtopetc">
				<a href="write.jsp"><button class="bbtn" type="button"><i class="fas fa-pencil-alt"></i>글쓰기 </button></a>
				<div><span class ="searchcount"></span>
				<button class="search" onclick="setsearch()" type="button"> 전체보기 </button>
				<select onchange="listsize()" class="printkey">
					<option>3</option>
					<option>5</option>
					<option>10</option>
				</select>
				</div>
			</div>
		
			<div class="contentlist boardTable">
				
			</div>
		</div>
		
		
		<!-- 페이징 처리버튼 -->
		<div class="pagebox">
			
		</div>
		<div class="getsearch">
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text">
			<button class="search" onclick="getsearch()" type="button">검색</button>
		</div>
	
	</div>



	<script src="/jspweb/Ex/js/board/list.js" type="text/javascript"></script>
</body>
</html>