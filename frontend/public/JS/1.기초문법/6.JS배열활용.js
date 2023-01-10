// 1. 추가 버튼을 눌렀을때 이벤트


// * 함수 밖에 만든이유 : 함수가 실행될때마다 선언하면 기존데이터 삭제
let 학생리스트 = [] // 배열선언, 초기요소 없음[깡통]

function onAdd(){      // 1. function : 함수정의 키워드
					   // 2. onAdd : 함수명[아무거나]
					   // 3. () : 인수 [함수안으로 전달받는 데이터]
					   // 4. {} : 함수가 실행되는 구역
	alert('클릭했습니다.')


//입력받은 input value[값]을 가져오기
	// HTML 마크업을 변수화 하기 = DOM
	
	// 1. class명으로 해당 마크업을 JS변수로 가져올때
	// document.querySelector('.클래스명')
	// 2. id명으로 해당 마크업을 JS변수로 가져올때
	// document.querySelector('#id명')
	
//2. sname 변수에 input 마크업 저장	
let sname =	document.querySelector('.sname')
		
	
// 3. 마크업에서 값 가져와서 배열 담기
	// HTML변수명.속성명
	//alert(sname.value)
	
	학생리스트.push(sname.value)
	//console.log(학생리스트)
	
// 4. 마크업에 출력
document.querySelector('#slist')
slist.innerHTML = '<li>'+학생리스트 + '</li>'
}

/* 클릭시 배열내 요소 삭제 */
function onDelete(){
	// 1. <input> 입력받은 데이터 가져오기 [DOM 객체]
let sname =	document.querySelector('.sname')
	// 2. <input> 입력된 value[값] 가져오기
let dname =	sname.value
	// 3. 배열내 값으로 요소 인덱스 찾기
let dindex = 학생리스트.indexOf(dname);// 입력받은 이름의 인덱스 찾기
	// 4. 배열내 해당 인덱스의 요소 제거
	학생리스트.splice(dindex,1);
	
	// [출력부]
	// 1. <ul> 가져와서 변수에 저장 [DOM 객체]
let slist = document.querySelector('#slist')
	// 2. <ul>innerHTML 이용한 <ul> {여기에 데이터 넣기} </ul>
	slist.innerHTML = '<li>'+학생리스트+'</li>'
}





