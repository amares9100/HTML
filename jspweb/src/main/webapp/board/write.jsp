<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body>

	<%@include file ="../header.jsp" %>
	
	<script type="text/javascript">
	/* 	
		// 1. js 로그인 여부 제어 
		if( memberInfo.mid == null ){
			alert('회원제 기능입니다. 로그인후 작성해주세요'); 
			location.href="/jspweb/member/login.jsp";
		} */
	</script>
	<%
		// 2. jsp 로그인 여부 제어 
		Object o = request.getSession().getAttribute("login");
		if( o == null ){
			response.sendRedirect("/jspweb/member/login.jsp");
		}
	%>
	
	<div class="container">
		<h3> 글쓰기 </h3>
		<form class="writeForm">
			카테고리 : <select name="cno" class="cno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 커뮤니티 </option>
						<option value="3"> QnA </option>
						<option value="4"> 노하우 </option>
					</select> <br>
			제목	: <input name="btitle" type="text"> <br>
			내용 : <textarea id="summernote" name="bcontent"></textarea> <br>
			첨부파일 : <input name="bfile" type="file"> <br>
			<button onclick="bwrite()" type="button">쓰기</button> <br>
		</form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
	
	<!-- 
		
		HTML ---- > form [ 동기식 : 페이지전환이 있음 ] 
		<form action="통신할URL" method="HTTP메소드" >
		<form method="post" action="서블릿URL" enctype="multipart/form-data">
			1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송타입 
			2. enctype="multipart/form-data"
		- 주의 form 태그 안에 있는 <button> type 생략시 type="submit"( 폼보내기 )
			- form 태그 안에 있는 <button> type="button" 명시 
			
		vs JS ---- > AJAX [ 비동기식 , 동기식 ] 
		
	 -->

</body>
</html>