// 1. select 변경 이벤트

let selectbox = document.querySelector('.selectbox')
selectbox.addEventListener('change' , (e) => {
	console.log(e)
	// 1. 선택괸 option
	e.currentTarget // 이벤트 실행한 타겟[마크업]
	console.log(e.currentTarget)
	
	let options = e.currentTarget.options // select의 모든 옵션들을 배열로 변환
	console.log(e.currentTarget.options)
	
	let Index = e.currentTarget.options.selectedIndex // select에서 선택한 인덱스 가져오기
	console.log(e.currentTarget.options.selectedIndex)


	console.log(options[Index].value)

	document.querySelector('h3').innerHTML=`선택한 옵션 : ${ options[Index].value }`


})

// 2. checkbox 변경 이벤트
let checkbox = document.querySelector('.checkbox')
checkbox.addEventListener('change' , (e) => {
	console.log(e)
	
	e.currentTarget
	console.log(e.currentTarget)
	
	e.currentTarget.checked // 체크박스 체크 확인[ true/false ]
	console.log(e.currentTarget.checked)
})

// 3. 타이머 예제
let timer = 0 // 타이머 시간(초) 저장하는 변수
let timerid = 0

let timerbox = document.querySelector('.timerbox')
timerbox.addEventListener('change' , (e) => {
	if(e.currentTarget.checked){
		// 만약에 체크박스에 체크가 되어있으면
		 // 특정시간마다 함수 실행 : setInterval(함수명 , 시간(밀리초))
		 //setInterval(()=>{} , 1000) : 1초마다 화살표함수실행
		 //clearInterval() : Interval 초기화
		timerid = setInterval( ()=> { 
			timer++;
			timerspan.innerHTML = timer
		} , 1000)
	
	
	
	}
	else{clearInterval( timerid)}
})













