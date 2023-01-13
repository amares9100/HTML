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
let 대여목록 = ['혼자공부하는 자바']

console.log(도서목록)
console.log(도서목록.length)


function 등록(){
	let 등록대기 = document.querySelector('.등록').value
	let 등록대기검사 = document.write(등록대기.lenght)
	console.log(등록대기)
	if (등록대기검사 < 5) {
            alert("5글자이상입력");
            return false;
	}
	else if (등록대기검사 > 10) {
            alert("10글자이하입력");
            return false;
	}
	for(let i = 0 ; i < 도서목록.length ; i++){
		console.log(도서목록[i])
		if(등록대기.includes(도서목록[i])){
			return;
		}
		else{
			도서목록.push(등록대기);
			alert('등록되었습니다.');
			return;
		}
	} 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

function 새로고침(){
	
	let list = `<tr><th>등록번호</th><th>도서명</th><th>상태</th><th>비고</th></tr>`
	
	for(let i = 0 ; i < 도서목록.length ; i++){
	
		if( 대여목록.includes( 도서목록[i] ) ){
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>불가능</td><td><button onclick="삭제()">삭제하기</button></td></tr>`
		
		}else{
			list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'>가능</td><td><button onclick="삭제()">삭제하기</button></td></tr>`
		}

	}
	document.querySelector('.도서리스트').innerHTML=list
}




//list += `<tr><td>${i+1}</td><td>${도서목록[i]}</td><td class='대여여부'></td><td><button onclick="삭제()">삭제하기</button></td></tr>`


/* 대여 확인
for(let i = 0 ; i < 도서목록.length ; i++ ){
		for(let j = 0 ; j < 대여목록.length ; j++ ){
			console.log(도서목록[i] +' : '+ 대여목록[j])
			if(도서목록[i] == 대여목록[j]){
				
		}
			
	}
	
}



*/





