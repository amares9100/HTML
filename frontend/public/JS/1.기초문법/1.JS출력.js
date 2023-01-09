/*
		크롬[브라우저] 개발자 도구 F12
			console : 입력/출력 가능한 구역
				
*/



//	JS : 1. 주석 : // : 한줄주석
//		        /* */: 여러줄 주석

/*		 2. 출력
			1. console.log() : 콘솔에 출력하는 함수 [테스트용도]
			- js코드 -----> 브라우저 개발자도구 console 출력
			
			2. alert()		 : 알람 메시지 출력하는 함수
			
			3. document.write(); : html에 출력하는 함수
			
		 3. 제어문자 [ 이스케이프 문자 ]
		 	- 엔터 위에 원화기호백슬래시] : \
		 	1. \n : 줄바꿈
		 	2. \t : 들여쓰기
		 	3. \\ : \  [백슬래시 출력시 \\ 2개 필요]
			4. \' : ' 출력
			5. \" : " 출력
			
		 *출력문구인지 명령어인지 구분이 필요*
		 키워드 : 미리 만들어진 단어들(명령어)
		 데이터 :
		 	1. 문자 : 1. ' '   /   2. "  " 
		 	2. 숫자 : 숫자는 제약 없이 입력가능 ''/""사용시 문자로 처리
		 	3. 논리 : true , false
*/

// 1. console.log(출력할 데이터/값)
console.log('hello world') 	  // ' ' 안에 있는 데이터는 문자처리
// console.log(hello world)   // 문자처리 생략시 오류 발생
console.log("hello world")	  // "  " 안에 있는 데이터는 문자처리
console.log( 100 )			  // 숫자는 문자처리 안함
console.log( "100" )		  // 숫자에 문자처리 하면 문자로 출력
console.log( true )			  // 논리는 문자처리 안함

// 2. alert(출력할 데이터/값)
alert('hello world2')		  // 알람으로 문자출력
alert('hello world3') 		  // 알람으로 문자출력, 알람이 여러개일경우 순차적으로 출력
alert(200+200) 				  // 계산하고 출력
alert( true ) 				  // 논리값 출력

// 3. 제어문자 [\]
console.log('안녕하세요\njs 처음입니다.')		// 줄바꿈
console.log('안녕하세요\tjs 처음입니다.')		// 들여쓰기
console.log('안녕하세요\\js 처음입니다.')		// \출력
console.log('안녕하세요\'js 처음입니다.\'')		// ' ' 출력
console.log('안녕하세요\"js 처음입니다.\"')		// " " 출력




