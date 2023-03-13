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
function preimg(e){
	console.log('확인')
	//console.log(e.files[0])
	let file = new FileReader();
	// 해당파일 읽어오기  //file.readAsDataURL(첨부파일)
	file.readAsDataURL(e.files[0]); 
	// 읽어온 파일 꺼내기 [바이트]
	file.onload = (e)=>{
		//console.log(e.target.result) // 해당 타겟[첨부파일]을 바이트로 변환한 결과값]
		
		// 해당 클래스의 src에 이미지[바이트]를 대입
		document.querySelector('.preimg').src = e.target.result;
		}
}


function signup(){
	let count = 0;
	for(let i=0 ; i<checkconfirm.length ; i++){
		if(checkconfirm[i].innerHTML == 'O'){
			count++;
		}
	}
	if(count != 4){
		alert('입력되지 않은 데이터가 있습니다.')
		return;
	}
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
			+		: 앞에 있는 패턴 1개 이상 반복
			?		: 앞에 있는 패턴 0개 혹은 1개 반복
			
		-- 1개 이상 문자가 포함되어야 하는 경우
			(?=.*[a-z]) : 소문자 한개 이상
			(?=.*[A-Z]) : 대문자 한개 이상
			(?=.*[0-9]) : 숫자 한개 이상
			(?=.*[!@#$%^&*]) : 해당하는 특수문자가 1개 이상
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
let checkconfirm = document.querySelectorAll('.checkconfirm');

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
				checkconfirm[0].innerHTML = "사용중인 아이디 입니다."
			}
			else{checkconfirm[0].innerHTML = 'O'}
		}
		})
	}
	else {
		checkconfirm[0].innerHTML = "사용불가능한 아이디 입니다."
	}
	
}


function pwdcheck(){
	let mpwd = document.querySelector('.mpwd').value;
	
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	console.log(mpwdj.test(mpwd))
	
	if(mpwdj.test(mpwd)){
		checkconfirm[1].innerHTML = 'O';
	}
	else {checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20글자';}
}



function pwdconfirmcheck(){
	let mpwd = document.querySelector('.mpwd').value;
	let pwdconfirm = document.querySelector('.mpwdconfirm').value;
	
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	if(mpwdj.test(pwdconfirm)){
		if(mpwd != pwdconfirm){
			checkconfirm[2].innerHTML = '두 비밀번호가 일치하지 않습니다.';
		}
		else{checkconfirm[2].innerHTML = 'O';}
	}
	else{checkconfirm[2].innerHTML = '영대소문자+숫자 조합 5~20글자';}
	
}


function emailcheck(){
	let memail = document.querySelector('.memail').value;
	
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	console.log(memailj.test(memail))
	
	if(memailj.test(memail)){
		checkconfirm[3].innerHTML = 'O';
	}
	else {checkconfirm[3].innerHTML = '적합한 이메일이 아닙니다.';}
	
}

//=======================================================================
// 6. 이메일 인증 함수 
function getauth(){	console.log('getauth()함수 실행')
	// ------------------ 1. 메일 전송 테스트 할 경우 ---------------- //
	// * ajax가 JAVA에게 이메일 전송후 인증코드 받기;
	/*
	$.ajax({
		url : "/jspweb/email" , 
		method :"post",
		data : { "memail" : document.querySelector('.memail').value } ,
		success : (r)=>{ 
			console.log('통신'); console.log(r);
			let html =  `<div class="timebox"> 02 : 00</div>
			<input type="text" class="authinput" placeholder="인증코드">
			<button onclick="authconfirm()" type="button">확인</button>`
			// 2. html 대입 
			document.querySelector('.authbox').innerHTML = html;
			// 3. 타이머 함수 실행 
			auth = r;		//  *** 이메일 에게 보낸 난수 대입  ** 
			timer = 120;	// 인증 시간 대입 
			settimer();		// 타이머 함수 실행 
		} // success end 
	}) // ajax end 
	*/
	// ------------------ 2. 메일 전송 테스트 안되는 경우 임시 테스트 ---------------- //
	// 1. 인증 구역 html 구성 
	let html =  `<div class="timebox"> 02 : 00</div>
				<input type="text" class="authinput" placeholder="인증코드">
				<button onclick="authconfirm()" type="button">확인</button>`
	// 2. html 대입 
	document.querySelector('.authbox').innerHTML = html;
	// 3. 타이머 함수 실행 
	auth = 1234;	// **인증 임시 코드 대입	[ 이메일 에게 보낸 난수 대입 ]
	timer = 120;	// 인증 시간 대입 
	settimer();		// 타이머 함수 실행 
	
} // end 
let auth = 0;	// 인증 코드 변수 
let timer = 0;	// 인증 시간 변수
let timerInter;	// Interval 함수를 저장할 변수 
// 7. 타이머 함수 
function settimer(){
	// setInterval : 특정 시간마다 함수 실행 		// setInterval( ()=>{} , 시간/밀리초 )
		// clearInterval : Interval 종료
	timerInter = setInterval( ()=>{
		let minutes = parseInt( timer / 60 ) ;	// 분 계산 
		let seconds = parseInt( timer % 60 ) ;	// 분 계산후 나머지가 초
		// 한자리수 이면 0 추가 
		minutes = minutes < 10 ? "0"+minutes : minutes;
		seconds = seconds < 10 ? "0"+seconds : seconds;
		// 시간 구성 
		let timeHTML = minutes +" : " + seconds ;	// 시 : 분 형식으로 html 구성 
		// html 대입 
		document.querySelector('.timebox').innerHTML = timeHTML;
		// 1초 차감 
		timer--;
		// 만약에 인증시간이 0보다 작으면  
		if( timer < 0 ){
			clearInterval( timerInter );	// setInterval 정지
			checkconfirm[2].innerHTML = '인증실패';
			document.querySelector('.authbox').innerHTML = ""; // auth 내 html 지우기
		}
	} , 1000 );	// 1초마다 { } 코드 
}
// 8. 인증코드 확인 
function authconfirm(){
	console.log( "authconfirm() 함수 실행 ")
	// 1. 입력받은 인증코드 호출 
	let authinput = document.querySelector('.authinput').value;
	// 2. 발급된 인증코드 와 입력한 인증코드 비교 
	if( auth == authinput ){ // 인증코드 일치 
		clearInterval( timerInter );
		document.querySelector('.authbox').innerHTML = "";
		document.querySelector('.authbtn').innerHTML = "완료";
		document.querySelector('.authbtn').disabled = true;
		checkconfirm[2].innerHTML = 'O';
	}else{ // 인증코드 불일치 
		checkconfirm[2].innerHTML = '인증코드 일치하지 않습니다.';
	}
}

/*	
	// 1. [첨부파일 없을떄] 입력받은 값 모두 가져와서 객체화 
	let info = {
		mid : document.querySelector(".mid").value , 
		mpwd : document.querySelector(".mpwd").value , 
		mpwdconfirm : document.querySelector(".mpwdconfirm").value , 
		memail : document.querySelector(".memail").value , 
		mimg : document.querySelector(".mimg").value , 
	};console.log( info );
			
	// 2. [ 첨부파일 없을때 ] ajax 통신을 이용한 서블릿에게 데이터 보내고 응답 받기 
	$.ajax({
		url : "/jspweb/member" ,	// 서블릿 클래스의 @WebServlet("/member")
		method : "post" ,			// 메소드 선택
		data : info ,
		success : (r)=>{ 
			console.log('ajax응답'); 
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원가입실패') }
		} // success end 
	}) // ajax end 
	
*/
















