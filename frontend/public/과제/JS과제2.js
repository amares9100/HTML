

/*

*과제2 입력된 값으로 입력구구단만들기

	조건1 : 단 [input]과 곱[input] 입력받기
	조건2 : 확인[button] 클릭하면 결과가 실행
	조건3 : 결과는 테이블에 출력

*/

// 테이블의 첫행[제목] html 마크업 대입된 변수 
// let html변수명 = 'HTML마크업작성'		//! : 마크업 문자처리
let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	

/* 3. <table>의 행<tr> 반복문으로 만들기 */
for( let 곱 = 1 ; 곱 <= 9 ; 곱++  ){ // for s 
	// 곱은 1부터 9까지 1씩증가 반복 처리 
	// ! : 변수명 과 수식은 문자처리 X
	// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
	테이블행 += '<tr> <th> 2 </th> <th>'+곱+'</th> <th>'+(2*곱)+'</th> </tr>';
	// += 추가 /  = 대입

} // for e

// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기 
document.querySelector('.gu_table').innerHTML = 테이블행


let 테이블행2 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	
function on(){
let 단수 = document.querySelector('.단')
let 곱 = document.querySelector('.곱')
let 값 = (단수.value*곱.value)

테이블행2 += '<tr> <th>'+단수.value+'</th> <th>'+곱.value+'</th> <th>'+값+'</th> </tr>';
document.querySelector('.gu_table2').innerHTML = 테이블행2
}
