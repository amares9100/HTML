/*

*/

// 1. 숫자 버튼 출력하는 함수

function btn(){
	//	console.log('작동확인')
let 저장 = '';

	for(let i = 1 ; i<=45 ; i++){
		// ` (백틱 - esc아래) : 작은따옴표 아님
		// 1. 전체를 백틱으로 감싼다.
		// 2. 변수는 ${}로 감싼다.
		저장 += `<button onclick="btn(${i})" type="button">${i}</button>`
		
		if(i % 5 == 0){저장 += '<br/>'}

}
document.querySelector('.num').innerHTML=저장
document.querySelector('.취소하기').style.display='inline'
}

function 취소하기(){
	
	document.querySelector('.num').innerHTML=''
	document.querySelector('.취소하기').style.display='none'
}













