/**
 * 
 */
console.log('확인')
/*	
		let info = {
		
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mimg').value
	}
	
	
	$.ajax({
		url : "/jspweb/Member" ,
		method : "post" ,
		data : info,
		success : (r) =>{console.log('ajax확인')
			if(r == 'true'){
				alert('회원가입 성공')
				location.href="/jspweb/Ex/index.jsp"
			}
			else{alert('회원가입 실패')}
		}
		
	})
*/

function signup(){
	
	// 1. form 가져오기
	let signupform = document.querySelectorAll('.signupform')[0]; // 첫번째 form 가져오기
	// 2. form안에 있는 데이터 가져오기
	let signupformData = new FormData(signupform);
	console.log(signupformData)
	
	
	// 3. 첨부파일 있을때 ajax쓰기
	$.ajax({
		url : "/jspweb/Ex/Member" ,			// 서블릿주소
		method : "post" ,					// 첨부파일은 post/put
		data : signupformData ,			// FormData 객체 전송
		// 첨부파일 있을때 추가
		contentType : false ,
		// 기본값(true)[문자열전송]
			// form-urlencoded 타입 전송
		// false : 해제
			// multipart/form 형식으로 전송
		processData : false ,				// 
		success : (r) =>{
			console.log('ajax확인')
			console.log(r)
			if(r == 'true'){
				alert('회원가입 성공')
				location.href="/jspweb/Ex/index.jsp"
			}
			else{alert('회원가입 실패')}
		}
		
	})
}
/*
	js 정규표현식 : 문자 특정 규칙 , 패턴 , 집합표현
		-- 문법
			/^		: 정규표현식 시작
			$/		: 정규표현식 끝
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: 대문자 A-Z 패턴
			[0-9]	: 숫자 0-9 패턴
			[가-힣]	: 한글 패턴
		-- 영문만 입력
			[a-zA-Z]	: 영문만 입력
		-- 영문+숫자
			[a-zA-Z0-9]	: 영문+숫자만 입력
		-- {최소길이 , 최대길이} : 문자열 길이 패턴
		-- 패턴검사 함수
			정규표현식.test(데이터)	: 패턴이 적합하면 true / 아니면 false
			ex)
			/^[a-z]&/.test(qwe) -- true
			/^[a-z]&/.test(QWE) -- false

*/


function idcheck(){ // onkeyup="idcheck()" = 키보드에서 키를 누르고 떼었을때 실행
	// 입력할때마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	console.log(mid)
	// 정규표현식 [영문대소문자 + 숫자 / 5~30글자]
	let midj = /^[a-z0-9]{5,30}$/
	
	if(midj.test(mid)){
		$.ajax({
		url : "/jspweb/Ex/Mconfirm" ,
		method : "get" ,
		data :{"mid" : mid} ,
		success : (r) =>{
			if(r=='true'){
				document.querySelector('.idcheck').innerHTML = "사용중인 아이디 입니다."
			}
			else{document.querySelector('.idcheck').innerHTML = "사용가능한 아이디 입니다."}
		}
		})
	}
	else {
		document.querySelector('.idcheck').innerHTML = "사용불가능한 아이디 입니다."
	}
	
}




























