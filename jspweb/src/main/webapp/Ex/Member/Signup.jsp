<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/Ex/css/signup.css" rel="stylesheet">
	
</head>
<body>
	
	
	<%@ include file= "../header.jsp" %>
	<div class="container"> <!-- bs : 박스권 -->
	<form class="signupform"> <!-- form 전송시 매개변수 식별 : name -->
		<h3> Ezen Community </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다 </p>
		
		<div class="title">아이디</div>
			<input onkeyup="idcheck()" maxlength="30" type="text" name="mid" class="mid">
		<div class="checkconfirm"></div><br/>
		
		<div class="title">비밀번호</div>
			<input onkeyup="pwdcheck()" maxlength="20" type="password" name="mpwd" class="mpwd">
			<div class="checkconfirm"></div><br/>
		
		<div class="title">비밀번호 확인 </div>
			<input onkeyup="pwdconfirmcheck()" maxlength="20" type="password" name="mpwdconfirm" class="mpwdconfirm">
		<div class="checkconfirm"></div><br/>
		
		<div class="title" >이메일</div>
		<div class="emailbox">
			<input onkeyup="emailcheck()" type="text" name="memail" class="memail">
			<button onclick="getauth()" class="authbtn" type="button"> 인증 </button>
		</div>
		
		<!-- 인증코드 입력 구역  -->
			<div class="authbox">
				<!-- js 들어가는 자리 -->
			</div>
			<div class="checkconfirm"></div>
		
		
		<div class="title"> 프로필 </div>
			<div class="pimgbox">
					<input onchange="preimg(this)" type="file" name="mimg" class="mimg">
					<img class="preimg" src="pimg/X.jpg" width="10%">
			</div>
				
		<button class="signupbtn"  type="button" onclick="signup()">가입</button>
		
	</form>
	</div>




	<script src="Signup.js" type="text/javascript"></script>
</body>
</html>



























