<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href = "/jspweb/Ex/css/modal.css" rel="stylesheet">
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	<div class="container"> 
	
		<h3> 회원정보 </h3>
		<div>
			<div>
				<img class="mimg">
			</div>
			<div>
				<div>  </div>
				<div class="mid"></div>
			</div>
			<div>
				<div>  </div>
				<div class="memail"></div>
			</div>
			<div>
				<div> 보유포인트 </div>
				<div class="mpoint"></div>
			</div>
			
			<a href="/jspweb/Ex/Member/update.jsp"><button type="button">회원수정</button></a>
			<button onclick="openModal()" type="button">회원탈퇴</button>
		</div>
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
				회원탈퇴
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
				회원탈퇴합니다.<br/>
				비밀번호확인 : <input type="password" class="mpwd">
			</div>
			<div class="modal_btns">
				<button onclick="del()" class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
		
		
		
		
		
		
		
		
	</div>



	<script src="/jspweb/Ex/js/modal.js" type="text/javascript"></script>
	<script src="/jspweb/Ex/js/info.js" type="text/javascript"></script>
</body>
</html>