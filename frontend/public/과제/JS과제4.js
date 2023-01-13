/*
과제4
파일 : 과제4.html, 과제4.js, 과제4.css
	let 도서목록 = '혼자공부하는 자바' , '이것이자바다' , ' 열혈 C언어'
	let 대여목록 = []

	주제 : 도서 관리 시스템
	조건1 : 관리자입장
		1. 도서 등록[도서명]
			1. 도서 중복 불가[중복검사] - indexof
			5. 5~10사이만 도서명 입력가능 - lenght

			ex) 번호 	도서 			도서 대여여부	비고
			    1	혼자공부하는 자바		대여중		삭제[대여중에는 삭제 불가능하게]
			    2	이것이자바다		대여가능		삭제
			    3	열혈 C언어		대여가능		삭제

		2. 도서 현황 출력
			1. 도서 번호 출력
			2. 도서명
			3. 도서 대여여부
			4. 도서 삭제


	조건2 : 고객 입장
		1. 도서목록
			1. 번호 2. 도서명 3. 도서 대여버튼
						-도서 대여
						1. 없는 도서명 불가
						2. 대여중인 도서 불가능
		2. 도서 반납
			1. 없는 도서명은 불가능
			2. 대여중인 도서가 아니면 불가능


			ex) 번호 	도서 			도서 대여여부	비고
			    1	혼자공부하는 자바		대여중		대여/반납
			    2	이것이자바다		대여가능		대여/반납
			    3	열혈 C언어		대여가능		대여/반납
*/


let 도서목록 = ['혼자공부하는 자바' , '이것이자바다' , '열혈 C언어']
let 대여목록 = []

function add( ) {
	
	let join = document.querySelector('.add1').value
	
	for(let i = 0 ; i<=도서목록.length ; i++){
		if(도서목록.indexOf(join) != -1){
			console.log('등록불가 :' + i)
			
		}
		else{
			console.log(join)
			도서목록.push(join)
			alert('등록되었습니다.')
			새로고침()
			return false;
		}
	}
	
}

	

	
	
function 새로고침(){
	
	let list = `<tr><th>등록번호</th><th>도서명</th><th>상태</th><th>비고</th></tr>`
	
	for(let i = 0 ; i < 도서목록.length ; i++){
	
		if( 대여목록.includes( 도서목록[i] ) ){
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>삭제불가</td><td><button onclick="삭제불가()">삭제불가</button></td></tr>`
		
		}else{
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>삭제가능</td><td><button onclick="삭제(${i})">삭제하기</button></td></tr>`
		}

	}
	document.querySelector('.도서리스트').innerHTML=list
	새로고침2()
}

function 삭제( dno ){
	도서목록.splice( dno , 1 )
	새로고침( )
	새로고침2()
}




//-----------------------------------------------------//

function 새로고침2(){
		
	let list = `<tr><th>등록번호</th><th>도서명</th><th>상태</th><th>비고</th></tr>`
	
	for(let i = 0 ; i < 도서목록.length ; i++){
	
		if( 대여목록.includes( 도서목록[i] ) ){
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>대여중</td><td><button onclick="반납(${i})">반납</button></td></tr>`
		
		}else{
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>대여가능</td><td><button onclick="대여(${i})">대여가능</button></td></tr>`
		}

	}
	document.querySelector('.대여리스트').innerHTML=list

}

function 대여( dno ){
	대여목록.push(도서목록[dno])
	새로고침2()
	새로고침( )
}

function 반납(dno){
	대여목록.splice(대여목록.indexOf( dno ), 1 )
	새로고침2()
	새로고침( )
}



