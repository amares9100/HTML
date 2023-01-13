/*
과제3 방문록 게시판 구현

	조건1 : 방문록 내용을 여러개 담는 배열 선언 : let contentArray = [ ]
	조건2 : 내용작성 <input> 입력받기
	조건3 : 등록버튼<button> 클릭시 입력된 데이터가 배열에 저장
	조건4 : 현재 배열에 저장된 모든 방문록을 <table>에 출력
	
		<tr>
			<th> 번호 </th> <th> 방문록 </th>
		</tr>*/
		

		
let contentArray = []  // 누적기록


function addContent() {
let table1 = '<tr> <th>번호</th> <th>방문록</th>';
let centent = document.querySelector('.centent').value // 인풋으로 입력받은 값 저장

contentArray.push(centent) // 저장된 값 contentArray에 기록
console.log(contentArray)

let num = contentArray.length // contentArray에 저장된 값의 길이를 num에 입력
console.log(num)

for(let 번호 = 1 ; 번호<=(num) ; 번호++){ // 번호=1이고 번호가 num보다 작거나 같을때 번호는 1씩 증가

	// 테이블1에 테이블과 번호, contentArray[번호-1] 내용을 (인덱스는 0부터 시작하기때문에 -1 추가) 입력
	table1 += '<tr> <th>'+번호+' </th> <th>'+contentArray[번호-1]+'</th></tr>';
	
}	
	// 클래스 방문록에 table1을 출력
document.querySelector('.방문록').innerHTML = table1
}