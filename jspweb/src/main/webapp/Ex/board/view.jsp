<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/Ex/css/list.css" rel="stylesheet">
	<link href="/jspweb/Ex/css/view.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp"%>
	<% 
	// 1. jsp 이용한 http url 변수 호출
	int bno =Integer.parseInt(request.getParameter("bno"));
	%>
	
	

	<div class="container">
		<div class="boardbox">
		<h3><%=bno%>  <!-- 자바 코드 html 출력 -->번 게시글 </h3>
		
		<div >
		<div>
			<div> 게시물 번호 </div>
			<div class="bno"><%=bno%></div>
		</div>
		<div class="viewright">
			<div class="mimg">
				
			</div>
		<div>
			<span class="mid"></span>
			<span class="bdate"></span><br>
			<span class="vud"></span>
		</div>
		</div>
			
		<div class="wcontent">
			<div class="btitle"></div>
			<div class="bcontent"></div>
			<div class="bfile"><i class="fas fa-download"></i></div>
			<div class="c_box"></div>
			<div class="replycount">  </div>
			<div class="replywritebox">
					
					<textarea disabled="disabled" class="rcontent" rows="3" cols="30">댓글작성</textarea>
					<button onclick="rwrite()" class="rwrite rwri" type="button">댓글작성</button>
					
			</div>
			
			
			<div class="R_reply">
		
			</div>
		
		</div>
		</div>	
		
	</div>
	</div>

	<script src="/jspweb/Ex/js/board/view.js" type="text/javascript"></script>

</body>
</html>