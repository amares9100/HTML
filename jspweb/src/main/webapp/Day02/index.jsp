<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h3>예1) HTML --> JS --ajax--> servlet --메소드--> dao</h3>
	data1[문자열] : <input type="text" class="data1"><br/>
	data2[패스워드] :<input type="password" class="data2"><br/>
	data3[실수] : <input type="text" class="data3"><br/>
	data4[정수] : <input type="number" class="data4"><br/>
	data5[날짜] : <input type="date" class="data5"><br>
	data6[날짜/시간] : <input type="datetime-local" class="data6"><br/>
	data7[선택버튼] : <input type="radio" name="data7" value="남">남
					<input type="radio" name="data7" value="여">여<br/>
	data8[체크상자] : <input type="checkbox" class="data8"><br/>
	data9[목록상자] : <select class="data9">
						<option>안산</option><option>수원</option><option>성남</option>
					</select><br/>
	data10[긴글] : <textarea class="data10"></textarea>
	<button type="button" onclick="ex1()">전송</button>

	<h3>예1) dao --> servlet --> JS --> HTML</h3>
	<div class="getData">
	
	</div>
	
	<div>================================================================================</div>
	
	
	<h3>과제2</h3>
	이름[문자열] : <input type="text" class="qdata1"><br/>
	전화번호[문자열] :<input type="text" class="qdata2"><br/>
	키[실수] : <input type="text" class="qdata3"><br/>
	나이[정수] : <input type="number" class="qdata4"><br/>
	등록일자[날짜] : <input type="date" class="qdata5"><br>
	성별[선택버튼] : <input type="radio" name="qdata6" value="남">남
					<input type="radio" name="qdata6" value="여">여<br/>
	개인정보동의[체크상자] : <input type="checkbox" class="qdata7"><br/>
	사는지역[목록상자] : <select class="qdata8">
						<option>안산</option><option>수원</option><option>성남</option>
					</select><br/>
	자기소개[긴글] : <textarea class="qdata9"></textarea>
	<button type="button" onclick="ex2()">전송</button>

	
	
	
	

	<h3>과제2</h3>
	<div class="getData2">
	
	</div>
	
	
	
	
	
	
	
	<!-- 최신 jquery[ js 라이브러리 ] 가져오기  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="index.js" type="text/javascript"></script>
</body>
</html>