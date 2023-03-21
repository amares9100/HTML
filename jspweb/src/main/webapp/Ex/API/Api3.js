/**
 * 
 */
 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });
 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=aSDmkWpHl3Cr1RdJPq5tKKlCp58KfgDH5oFC1P0MUp3XiijgdU4aVotmsBIuUW3TQOZZ3qyCrcEWg7t1Ip5RqA%3D%3D", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        
        //console.log(data.data)
        var markers = $(data.data).map(function(i, position) {
           // console.log(position)
           let coords;
            var geocoder = new kakao.maps.services.Geocoder();
             geocoder.addressSearch(position.주소, function(result, status) {
			// 정상적으로 검색이 완료됐으면 
     		if (status === kakao.maps.services.Status.OK) {
			coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			//console.log(coords.La)
			};
        	});
        	
	 		return new kakao.maps.Marker({
                position : coords
            });
		console.log(markers)
    	clusterer.addMarkers(markers);
	});
	
        
});
