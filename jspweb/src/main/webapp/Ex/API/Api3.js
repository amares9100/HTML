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
 
    
let ssy = [
	
	
];

$.get("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=aSDmkWpHl3Cr1RdJPq5tKKlCp58KfgDH5oFC1P0MUp3XiijgdU4aVotmsBIuUW3TQOZZ3qyCrcEWg7t1Ip5RqA%3D%3D", function(data) {
	var geocoder = new kakao.maps.services.Geocoder();
	data.data.forEach((o,i )=>{
			geocoder.addressSearch(o.주소, function(result, status) {
			
			  // 정상적으로 검색이 완료됐으면 
			  if (status === kakao.maps.services.Status.OK) {
			
			  var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			 // console.log(coords)   
			  let ss = {
				   "lat": coords.Ma,
      				"lng": coords.La
				}
				 ssy.push(ss)
				 
          }
           });
		})
	
})   
   console.log(ssy)
   
   

var markers = ssy.map(function(i, position) {
        console.log(position.lat)
		// 주소-좌표 변환 객체를 생성합니다
		return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
            });
            
        });
		
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
        
    