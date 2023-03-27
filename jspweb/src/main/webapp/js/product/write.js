
if(memberInfo.mid == null){
	alert('로그인해주세요.')
	location.href="/jspweb/member/login.jsp"
}


// 전역변수 
let plat = 0;
let plng = 0;

let filebox = []

// 제품 등록 함수 
function onwrite(){
	
	// 1. 폼 객체  
	let writeForm = document.querySelectorAll('.writeForm')[0];
	// 2. 폼 데이터 객체 선언 
	let writeFormData = new FormData( writeForm );
	// 3. 좌표[위도/경도]추가 
	// 폼 데이터 객체 에 필드 추가 
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
	
	if( plat == 0 || plng == 0 ){ alert('위치 선택후 등록해주세요.'); return; }
	if(filelist.length<1){
		alert('하나 이상의 이미지를 등록해주세요.')
		return;
	}
	
	filelist.forEach((f)=>{ // filelist에 있는 파일을 하나씩 꺼내서 writeFormData에 추가
		writeFormData.append("filelist" , f);
		
	})
	
	
	
	$.ajax({
		url : "/jspweb/product/info" ,
		method : "post",
		data : writeFormData , 
		contentType : false ,
		processData : false , 
		success : (r)=>{
			if(r=="true"){
				alert('등록성공'); location.href="/jspweb/index.jsp"
			}else{ alert('등록실패'); }
		}
	})
	
	
}

// --------------------------  카카오 지도를 표시할 div 객체 ----------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표.
        level: 6 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// ---------------------------- 지도를 클릭한 위치에 표출할 마커입니다 ----------------------
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// ----------------------------- 지도에 클릭 이벤트를 등록합니다 ---------------------------------
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    var latlng = mouseEvent.latLng;   // 클릭한 위도, 경도 정보를 가져옵니다 
    marker.setPosition(latlng); // 마커 위치를 클릭한 위치로 옮깁니다
    plat = latlng.getLat();		 console.log(   "위도: "+latlng.getLat() )
    plng = latlng.getLng();		 console.log(   "경도: "+latlng.getLng() )
});






// 드래그앤드랍구현
// 1. 드래그앤드랍 구역[DOM] 객체 호출

let fileDrop = document.querySelector('.fileDrop');


// 해당구역 이벤트 등록
fileDrop.addEventListener("dragenter" , (e)=>{ // dragenter : 드래그요소가 해당구역에 닿았을시
	//alert('해당구역확인')
	e.preventDefault();
	
})

fileDrop.addEventListener("dragover", (e)=>{ // dragover : 드래그요소가 해당구역에 위치하고 있을때
	e.preventDefault();
	fileDrop.style.backgroundColor="#e8e8e8";
})

fileDrop.addEventListener("dragleave" , (e)=>{ // dragleave : 드래그요소가 해당구역에서 나갔을때
	e.preventDefault();
	fileDrop.style.backgroundColor="#ffffff";
})


let filelist = [];
fileDrop.addEventListener("drop" , (e)=>{ // 드래그요소가 해당구역에 드랍되었을때
	e.preventDefault(); // 고유이벤트 제거
	
	// 드랍된 파일 호출
	let files = e.dataTransfer.files
	console.log(files)
	for(let i = 0 ; i<files.length ; i++){
		if(files[i] != null && files[i] != undefined){// f가 존재하고 정의되어있으면
			filelist.push(files[i]);
		}
	}
	printfiles()
	console.log(filelist)
	fileDrop.style.backgroundColor="#ffffff";
})

// 해당 구역에 드랍된 파일목록 출력
function printfiles(){
	let html = '';
	filelist.forEach((f , i)=>{
		let fname = f.name;
		let fsize = (f.size/1024).toFixed(3);//toFixed() 표시할 소숫점 자리
		console.log(fname)
		console.log(fsize)
		
		html += `
				<div>
					<span>${fname}</span>
					<span>${fsize}Kb</span>
					<span><button type="button" onclick="filedelete(${i})">삭제</button></span>
				</div>
		`
		
	})
	fileDrop.innerHTML = html;
}

function filedelete( i ){
	filelist.splice(i,1);
	printfiles();
}

























