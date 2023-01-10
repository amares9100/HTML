// 1. 추가 버튼을 눌렀을때 이벤트

function onAdd(){      // 1. function : 함수정의 키워드
					   // 2. onAdd : 함수명[아무거나]
					   // 3. () : 인수 [함수안으로 전달받는 데이터]
					   // 4. {} : 함수가 실행되는 구역
	alert('클릭했습니다.')


// 2. 입력받은 input value[값]을 가져오기
	// HTML 마크업을 변수화 하기 = DOM
	
	// 1. class명으로 해당 마크업을 JS변수로 가져올때
	// document.querySelector('.클래스명')
	// 2. id명으로 해당 마크업을 JS변수로 가져올때
	// document.querySelector('#id명')
let sname =	document.querySelector('.sname')
		//sname 변수에 input 마크업 저장
	
	//마크업의 속성호출
	// HTML변수명.속성명
	alert(sname.value)
}

