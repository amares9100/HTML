<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/Ex/css/chatting.css" rel="stylesheet">
</head>
<body>
		<%@ include file = "../header.jsp" %>
		
		<div class="container">
		
			<!-- 채팅내용표시 -->
			<div class="chattingbox">
				<div class="contentbox">
					
					<!-- 보낼때 -->
					
					
					<!-- 알림 -->
					
					
					<!-- 받을때 -->
					
				
				</div>
				<!-- 채팅입력창 -->
				<textarea class="msgbox form-control"  rows="" cols=""></textarea>
				<div class="chattingbtnbox">
					<span>이모티콘</span>
					<span>첨부파일</span><br>
					<!-- 전송버튼 -->
					<button class="sendbtn" onclick="ssend()" type="button">보내기</button>
				</div>
			</div>
		
		</div>
		
		
		
		
	<script src="/jspweb/Ex/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>