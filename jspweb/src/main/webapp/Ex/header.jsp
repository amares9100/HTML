<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 반응형 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	<!-- 모든페이지 공통 css -->
	<link href="/jspweb/Ex/css/modal.css" rel="stylesheet">
	<link href="/jspweb/Ex/css/index.css" rel="stylesheet">


</head>
<body>
	<div class="container"> <!-- bs 박스권 -->
		<div class="header">
			<!-- logo -->
			<div class="mainlogo">
				<a href="/jspweb/Ex/index.jsp">
					<img  src="" >
				</a>
			</div>
			<!-- 본메뉴 -->
			<ul class="mainmenu">
				<li> <a href="/jspweb/Ex/index.jsp"> HOME </a> </li>
				<li> <a href="/jspweb/Ex/board/list.jsp?cno=1"> 공지사항 </a> </li>
				<li> <a href="/jspweb/Ex/board/list.jsp?cno=2"> 커뮤니티 </a> </li>
				<li> <a href="/jspweb/Ex/board/list.jsp?cno=3"> QnA </a> </li>
				<li> <a href="/jspweb/Ex/board/list.jsp?cno=4"> 노하우 </a> </li>
				<li> <a href=""> 추가예정 </a> </li>
			</ul>
			<!-- 서브메뉴 -->
			<div class="submenu">
				<!-- js가 들어가는 자리  -->
			</div>
		</div>
		
	</div>
	
	
	
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="/jspweb/Ex/js/modal.js" type="text/javascript"></script>	
	<script src="/jspweb/Ex/js/header.js" type="text/javascript"></script>	
</body>
</html>