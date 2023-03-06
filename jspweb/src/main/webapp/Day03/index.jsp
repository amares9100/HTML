<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<button onclick="doPOST()" type="button">POST 메소드</button>
	<button onclick="doGet()" type="button">GET 메소드</button>
	<button onclick="doPUT()" type="button">PUT 메소드</button>
	<button onclick="doDELETE()" type="button">DELETE 메소드</button>
	
	<h3>	예제		</h3>
	<h3> 비회원 게시판 </h3>
	제목 : <input type="text" class="content"><br/>
	작성자 : <input type="text" class="writer">
	<button type="button" onclick="onwrite()">전송</button>
	<br/>
	<table class="print" border="1"></table>
	
	<div>==============================================================</div>
	<!-- 
		과제3
		jsp,js 기존파일
		dao,dto,servlet 새로만들기
		
			1. 제품등록 [ 제품명,가격]
			2. 제품출력 [table 출력]
			3. 제품삭제 [제품번호 이용 삭제]
			4. 제품수정 [제품명, 가격 수정 = promt입력받기]
	-->
	<h3>과제3</h3>
	제품명 : <input type="text" class="pname"><br/>
	가격 : <input type="text" class="pprice">
	<button type="button" onclick="product()">제품등록</button>
	<br/>
	<table class="pprint" border="1"></table>
	
	
	
	
	
	
	
	<!-- 최신 jquery[ js 라이브러리 ] 가져오기  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src="index.js" type="text/javascript"></script>
</body>
</html>




















