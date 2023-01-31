/*
	new Date() 날짜/시간 관련된 클래스
		1. let date = new Date() : 현재 날짜/시간 객체
		2. let date = new Date(2023 , 01 , 31) : 사용자 정의 날짜/시간 객체
			1. get함수 제공
				1. .getFullYear()		: 연도
				2. .getMonth()			: 월	 [0~11]- 0=1월
				3. .getDate()			: 일
				4. .getDay()			: 요일[0~6]- 0=일요일
	

*/
/*let date = new Date();
console.log(date)
let date2 = new Date(2023 , 01 , 31)
console.log(date2)
console.log('연도 : ' + date.getFullYear())
console.log('월 : ' + date.getMonth())
console.log('일 : ' + date.getDate())
console.log('요일 : ' + date.getDay())
*/
let content = [	]






// 1. js가 열렸을때 현재 연도와 월을 구해서 변수에 저장
let year = new Date().getFullYear(); // 기본값 : 현재 연도
let month = new Date().getMonth()+1; // 기본값 : 현재 월

cal_print();
// 2. 캘린더 상단에 표시[1. JS열렸을때 출력 , 2. 이전/다음 버튼 클릭할때마다 출력]
function cal_print(){
	// 1. 상단에 년/월 표시
	document.querySelector('.top_date').innerHTML=`${year}년 ${month}월`
	
	// 2. 현재 설정된 날짜dml 마지막 일의 날짜 객체 만들기
	let lastdate = new Date(year , month , 0).getDate();; // 설정된 년월의 마지막날
	//console.log(lastdate)

	let html = `<div class="day weekday sunday">일</div>
				<div class="day weekday">월</div>
				<div class="day weekday">화</div>
				<div class="day weekday">수</div>
				<div class="day weekday">목</div>
				<div class="day weekday">금</div>
				<div class="day weekday">토</div>`
	// 2. 시작 요일 구하기 - 현재 설정된 날짜의 1일
	let weekday = new Date(year , month-1 , 1).getDay(); // 설정된 년월의 첫날
	
	// 시작 요일전에 공백 채우기
	for(let b = 1 ; b<=weekday ; b++){
		html += `<div class="day"></div>`
	}
			
	// 1. 일 만들기 [ 1일부터 ~ 마지막날[월마다 다름]까지]			
	for(let day = 1 ; day <=lastdate; day++){
		// 4. 날짜 확인
		let date = new Date(year , month-1 , day);
		//console.log(date);
		let fdate = date_format(date);
		//console.log(fdate)
		html += `<div onclick="openModal(${fdate})" class="day">${day} ${content_print(fdate)}</div>`
	}
	
	document.querySelector('.cal_day').innerHTML=html;
}

document.querySelector('.modal_close').addEventListener('click' , (e)=>{
	 document.querySelector('.modal_wrap').style.display = 'none';
})

document.querySelector('.modal_write').addEventListener('click' , (e)=>{
	// 1. 입력받은 내용, 선택된 날짜 가져와서 객체화
	let content1 = {
		date : document.querySelector('.modal_date').innerHTML ,
		content : document.querySelector('.modal_input').value ,
		bg_color : document.querySelector('.modal_color').value
	} 
	//console.log(content)
	// 2. 유효성 생략
	// 3. 배열저장
	content.push(content1);
	// 4. 화면 업데이트
		// 1. 입력된 데이터 초기화
		document.querySelector('.modal_input').value = '';
		document.querySelector('.modal_wrap').style.display = 'none';
		cal_print();
})

function openModal(fdate){
	// 1. 모달 배경구역 css 변경해서 모달표시
	document.querySelector('.modal_wrap').style.display = 'flex';
	// 2. 모달에 선택된 날짜 표시
	document.querySelector('.modal_date').innerHTML = fdate;
	
	let html = `<tr>
					<th width="5%">#</th><th>일정내용</th><th width="15%">비고</th>
				</tr>`;
	let j = 0; // j : 동일한 일정[객체] 들의 개수		
			content.forEach((o , i ) => { // i  : content의 인덱스
				if(fdate == o.date){
					j++;
					html +=`<tr>
								<td > ${j}</td>
								<td >${o.content}</td>
								<td><button onclick="ondelete(${i})" type="button" >삭제</button></td>
							</tr>`
				}
			})
	document.querySelector('.table').innerHTML=html;
}

// 3. 이전달 다음달 버튼에 따른 연도와 월이 변경
document.querySelector('.previousbtn').addEventListener('click' , (e)=>{
// 1. 월을 1 차감했을경우 만약에 0이면 연도를 차감시키고 월을 12로 설정
	month--;
	if(month < 1){
		year--; month = 12;
	}
	cal_print();
})
document.querySelector('.nextbtn').addEventListener('click' , (e)=>{
// 1. 월이 1 증가했을때 만약에 월이 12보다 크면 연도1증가 월을 1로 설정
	month++;
	if(month > 12){
		 year++; month = 1;
	}
	cal_print();
})

// 4. 날짜 포멧 함수
function date_format(date){

	let d_year = date.getFullYear();
	let d_month = (date.getMonth()+1) <= 9 ? '0'+(date.getMonth()+1) : (date.getMonth()+1)  ;
	let d_day = date.getDate() <= 9 ? '0'+ date.getDate() : date.getDate() ;
	return `${d_year}${d_month}${d_day}`;
}


function content_print(fdate){
	let html = ``
	content.forEach((o)=>{
		if(fdate == o.date){
			html += `<div class="content" style="background-color : ${o.bg_color}">${o.content}</div>`
		}
	})
	return html;
}

function ondelete(i){
	content.splice( i , 1)
	document.querySelector('.modal_input').value = '';
	document.querySelector('.modal_wrap').style.display = 'none';
	cal_print();
}






