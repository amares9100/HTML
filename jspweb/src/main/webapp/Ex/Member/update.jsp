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
	
	<div class="container"> 
		<h3> 회원수정 </h3>
		<div>
			<form class="updateform">
			<div>
				<img width="20%" class="mimg"><br/>
				프로필변경 : <input type="file" name="newmimg">
				<br><input class="defaultimg" name="defaultimg" type="checkbox">기본프로필사용
			</div>
			<div>
				<div> 아이디 </div>
				<div class="mid"></div>
			</div>
			<div>
				<div> 현재비밀번호 </div>
				<input class="mpwd" type="password" name="mpwd">  </input>
			</div>
			<div>
				<div> 새 비밀번호 </div>
				<input class="newmpwd" type="password" name="newmpwd"> </input>
			</div>
			<div>
				<div> 새 비밀번호 확인 </div>
				<input class="newmpwdconfirm" type="password" name="newmpwdconfirm"> </input>
			</div>
			<div>
				<div> 이메일 </div>
				<input class="memail" name="memail"></input>
				<button type="button">인증</button>
			</div>
			<button onclick="setUpdate()" type="button">회원수정</button>
			</form>
		</div>
	</div>
	
	<script src="/jspweb/Ex/js/update.js" type="text/javascript"></script>	
</body>
</html>