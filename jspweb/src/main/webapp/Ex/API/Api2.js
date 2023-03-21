/*
var positions = [
    {
        title: '카카오', 
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    }
];
*/
let positions = [
	
	
];
//getApi1();

/*
function getApi1(){
	$.ajax({
	url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=aSDmkWpHl3Cr1RdJPq5tKKlCp58KfgDH5oFC1P0MUp3XiijgdU4aVotmsBIuUW3TQOZZ3qyCrcEWg7t1Ip5RqA%3D%3D",
	method : "get",
	success : (r)=>{
		console.log(r)
		
		
		r.data.forEach((o , i) =>{
			let info = {
				title: o.충전소명 , 
        		latlng: new kakao.maps.LatLng(o['위도(WGS84)'], o['경도(WGS84)'])
				}
				
			positions.push(info)
		})
		console.log(positions)
		
	for(let i = 0 ; i<positions.length ; i++){
	// 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
        
        });
        
        kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      alert(positions[i].title+'마커클릭확인')
});
}
	}
})
}
*/

function onpenModal( ){
	document.querySelector('.modal_wrap').style.display ='flex';
}
function closeModal(){
	document.querySelector('.modal_wrap').style.display ='none';
}
//---------------지도생성---------------------//
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.321971, 126.830845), //지도의 중심좌표.
	level: 14 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 7 // 클러스터 할 최소 지도 레벨 
    });
    
$.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=aSDmkWpHl3Cr1RdJPq5tKKlCp58KfgDH5oFC1P0MUp3XiijgdU4aVotmsBIuUW3TQOZZ3qyCrcEWg7t1Ip5RqA%3D%3D", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.data).map(function(i, position) {
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)'])
            });
            
      	 
        });
        kakao.maps.event.addListener(marker, 'click', function() {
     	 // 마커 위에 인포윈도우를 표시합니다
     	 document.querySelector('.modal_title').innerHTML = o.충전소명;
     	 document.querySelector('.modal_title').style.fontSize = '10px';
     	 
     	 document.querySelector('.modal_content').innerHTML = o
     	 
     	 onpenModal( );
		});

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });    

// 마커이미지
var imageSrc = 'http://localhost:8080/jspweb/Ex/img/KakaoTalk_20230321_134017662.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다



//---------------마커표시---------------------//
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter(),
     image: markerImage,
      clickable: true
}); 

marker.setMap(map);


//---------------클릭이벤트---------------------//
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});

