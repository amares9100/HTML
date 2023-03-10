/*

	JS 객체 - JAVA/JS : 객체 지향 언어[oop]
	1.메모리/저장소
		1. 변수 : let 변수명 = 데이터						:데이터 1개
		2. 상수 : const 상수명 = 데이터					:데이터 1개
		3. 배열 : let 배열명 = [데이터1, 데이터2, ....n] 	:데이터 n개
			*3명의 아이디와 비밀번호, 이름 저장시*
			- 서로 다른 데이터유형들을 저장시 식별이 힘듬
			
		4. 객체 : let 객체명 = { 
				속성명 : 데이터,
				속성명 : 변수,
				속성명 : 상수,
				속성명 : 배열명,
				속성명 : 함수명,
				
			
		}
			-객체[object]
				1. 사용목적 : 서로 다른 데이터유형(속성)들을 한번에 저장
				2. 형태 : 
					let 객체명 = { 속성명 : 데이터 , 속성명 : 데이터 , 속성명 : 데이터}

			예) let 회원 = { 아이디 : 'qweqwe' , 비밀번호 : 'asdasd' , 이름 : '유재석'}
		
		5. 객체 호출
			1. 객체 정보 = 객체명
			2. 객체.속성명 : 객체내 해당 속성/함수 호출
				. : 접근연산자 [속성 호출]
		
		6. 객체 속성 추가
			객체명.새로운속성명 = 데이터
			
		7. 객체 속성 제거
			delete 객체명.속성명
			
		8. 객체내 속성값 변경
			객체명.속성명 = 변경값
			
		

*/


// 1. 객체의 선언 : 서로 다른 데이터유형들 간의 식별가능
let 객체1 = {
	id : 'qweqwe' ,
	pw : '1234' ,
	name : '유재석' ,
}
console.log(객체1)

// 2. 객체의 호출
console.log(객체1) // 객체의 모든 정보 호출
console.log(객체1.id) // 객체의 id(속성) 호출
console.log(객체1.pw) // 객체의 pw(속성) 호출 
console.log(객체1.name)// 객체의 name(속성) 호출 

// 3. 객체의 속성 추가
객체1.주소 = '안산시 상록구'
객체1.연락처 = '010-4444-4444'
console.log(객체1)


// 4. 객체의 속성 제거
delete 객체1.주소
console.log(객체1)

// 5. 속성의 값 변경
객체1.비밀번호 = '789'
console.log(객체1.비밀번호)

// 6. 배열과 객체의 관계 [배열 안에 객체저장가능/ 객체 안에 배열 저장 가능]
	// 1. 배열 안에 여러개 객체 저장 [동일한 객체의 유형]
let 게시물1 = {제목 : '제목입니다.1' , 내용 : '내용입니다.1'}
let 게시물2 = {제목 : '제목입니다.2' , 내용 : '내용입니다.2'}
let 게시물배열 = [게시물1 , 게시물2]

	// 2. 객체 안에 배열 속성 저장
let 공지사항 = {
	게시물이름 : '공지사항' ,
	게시물목록 : 게시물배열
}

console.log(공지사항)








