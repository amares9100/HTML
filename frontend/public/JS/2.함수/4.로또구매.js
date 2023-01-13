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
		저장 += `<button onclick="btns(${i})" type="button" style="width: 25px; margin: 5px;">${i}</button>`
		
		if(i % 5 == 0){저장 += '<br/>'}

}
document.querySelector('.num').innerHTML=저장
document.querySelector('.취소하기').style.display='inline'
}

//3. 구매취소
function 취소하기(){
	
	document.querySelector('.num').innerHTML=''
	document.querySelector('.취소하기').style.display='none'
	// 배열내 모든 요소 제거
	구매추첨취소();
	초기화();
}
// 선택한 숫자를 저장할 배열만들기
let 선택목록 = []


//3. 버튼클릭함수
function btns(i){
	console.log(i + '클릭')

	// 1. 중복검사 [배열명.indexOf(데이터)] : 찾으면 인덱스 번호, 없으면 -1]
	if(선택목록.indexOf(i) >= 0){alert('선택한번호입니다.')
		선택목록.splice(선택목록.indexOf(i),1)
		document.querySelector('.번호출력').innerHTML=선택목록
		구매추첨취소();
		return;
	}
	// 2. 6개까지만 저장
	else if(선택목록.length == 6 ){ // 배열내 숫자가 6개 존재하면 리턴
		alert('6개 다 선택하였습니다.')
		return;
	}
	// 위 2가지 유효성 검사 통과시 저장
	선택목록.push(i)
	구매추첨취소();

}

// 4. 선택번호목록 출력 및 추첨버튼 활성화
function 구매추첨취소(){ // 구매취소, 버튼클릭시 숫자등록, 버튼클릭시 숫자취소 3군대에서 사용중.
		if(선택목록.length == 6){ 
		document.querySelector('.구매추첨').style.display='inline'	
}
		else{document.querySelector('.구매추첨').style.display='none'}
	
		document.querySelector('.번호출력').innerHTML=선택목록
}


let 추첨번호목록 = []
//5. 추첨하기 버튼을 클릭했을때 함수
function 구매추첨(){
	// 1. 컴퓨터가 난수 발생(1~ 45사이의 수 6개)
	for(let i = 1 ; i<=6 ; i++){
/* 	
	난수만들기	
		1. Math 클래스 [ 미리 만들어져있는 설계도 ]
			1. random() 함수 [ Math클래스가 제공하는 미리 만들어둔 함수]
				Math.random() : 0~1사이의 실수난수 발생
				Math.random()+1 : 1~2사이의 실수난수 발생
				Math.random()*45 : 0~45사이의 실수난수 발생
				Math.random()*45+1 : 1~46사이의 실수난수 발생
			parseInt() : 입력된 숫자를 정수로 변환
*/		
		let 실수 = Math.random()*45+1
		let 정수 = parseInt(실수)
		
		if(추첨번호목록.indexOf(정수)>=0){
			i--;
		}
		else{
			추첨번호목록.push(정수)
		}
	}
	
	
	document.querySelector('.추첨번호').innerHTML=추첨번호목록
	// 두 배열 비교
	//	1. 배열1 : 3 7 2 5
	//  2. 배열2 : 1 5 3 4
	let 맞은개수 = 0;
	for(let i = 0; i<추첨번호목록.length ; i++){
		for( let j = 0; j<선택목록.length ; j++ ){
			console.log(추첨번호목록[i] +' : '+ 선택목록[j])
			if(추첨번호목록[i] == 선택목록[j]){
				맞은개수++
			
			}
		}
	}
	alert('맞은개수 : ' + 맞은개수)
	초기화();
}

function 초기화(){  // 추첨번호목록 초기화
	if(추첨번호목록.length == 6){
		추첨번호목록.splice(0);
		선택목록.splice(0);
		맞은개수.splice(0);
	}
}



