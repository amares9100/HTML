<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file= "../header.jsp" %>
	<div class="container">
	<h3>모든 회원 명단</h3>
	
	<button onclick="setsearch()" type="button"> 전체보기 </button>
	<table class="userlist boardTable table-hover"></table>
	
	
	<div class="pagebox">
			
	</div>
		<div>
			<select class="key">
				<option value="m.mno">번호</option>
				<option value="m.mid">아이디</option>
				<option value="m.memail">이메일</option>
			</select>
			<input class="keyword" type="text">
			<button onclick="getsearch()" type="button">검색</button>
		</div>





	</div>
	<!-- 최신 jquery[ js 라이브러리 ] 가져오기  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src="Admin.js"></script>


</body>
</html>