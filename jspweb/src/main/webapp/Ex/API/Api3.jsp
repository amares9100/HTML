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
		<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map" style="width:600px;height:500px;"></div>


	
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d34fb1a2896d17cdd46ab843621610a6&libraries=clusterer,services"></script>
		
		<script src="/jspweb/Ex/API/Api3.js" type="text/javascript"></script>
</body>
</html>