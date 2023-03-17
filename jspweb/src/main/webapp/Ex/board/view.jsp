<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp"%>
	<% 
	// 1. jsp 이용한 http url 변수 호출
	int bno =Integer.parseInt(request.getParameter("bno"));
	
	%>
	
	

	<div class="container">
		<h3><%=bno%>  <!-- 자바 코드 html 출력 -->번 게시글 </h3>
		<div>
			<div> 게시물 번호 </div>
			<div class="bno"><%=bno%></div>
		</div>
		<div>
			<div> 작성일 / 조회수 / 좋아요 / 싫어요 </div>
			<div class="infobox"></div>
		</div>
		<div>
			<div> 작성자 프로필 </div>
			<div class="pimgbox"></div>
		</div>
		<div>
			<div> 제목 </div>
			<div class="btitle"></div>
		</div>
		<div>
			<div> 내용 </div>
			<div class="bcontent"></div>
		</div>
		<div>
			<div> 첨부파일 </div>
			<div class="bfile"></div>
		</div>
		
		<div class="c_box"></div>
		
	</div>
	
	
	<script src="/jspweb/Ex/js/board/view.js" type="text/javascript"></script>

</body>
</html>