/*

	삼항연산자 - 조건 ? 참 : 거짓
	제어문
		IF : 만약에 ~~ [경우의 수 판단]
		1. 형태
			1. if(조건) [true]실행문
			
			2. if(조건) { [true]실행문1; 실행문2; 실행문3;} 
				실행문이 2개 이상일때 { } 이용한 묶음처리
				
			3. if(조건){[true];}
				else{[false] 실행문;}
				
			4. if(조건){[true1];}
				else if(조건2) {[true2]실행문;}
					else if(조건3) {[true3]실행문;}
						else if(조건4) {[true4]실행문;}
							else{false실행문;}
							
			5. 중첩
				if(조건1){
					if(조건2){
						if(조건3){
							
						}
					}
				}
*/


/*
// 1. if형태
if(10>3) console.log('[참1] 10이 더 크다')
if(10>20) console.log('[참2] 10이 더 크다')
if(10>20); console.log('[참3] 10이 더 크다') // [ X ]

//  ; : 세이콜론[명령어단위 마침표]    /  : 콜론
/*    실행문
      실행문; 실행문;
	  if() [참]실행문
	  if(); [참]실행문  [if뒤에 ; 금지]
*/

// 2. if형태2
/*
//2번째 콘솔은 if관계없이 실행 [이렇게 사용x]
if(10>3) console.log('[참1]'); console.log('1. 10이 더 크다');
if(10>20) console.log('[참2]'); console.log('2. 10이 더 크다');

// { } 로 묶여있어서 정상적으로 작동
if(10>20){console.log('[참3]'); console.log('3. 10이 더 크다');}

// 3. if형태3
if(10>3){console.log('[참1] 10이 더 크다');}
else{console.log('[거짓1] 10이 더 작다')}
// vs 삼항연산자 : 코드가 길어지면 가독성이 떨어짐
10>3 ? console.log('[참2]') : console.log('[거짓2]')

// 4. if형태3
if(10>=20){console.log('참1 10이 20보다 이상이다.')}
else if(10>=15){console.log('참2 10이 15보다 이상이다.')}
else if(10>=10){console.log('참3 10이 10보다 이상이다.')}
else{console.log('거짓 10이 10미만이다')}
//vs 삼항연산자
10>=20 ? console.log('참1 10이 20보다 이상이다.') :
10>=15 ? console.log('참2 10이 15보다 이상이다.') :
10>=10 ? console.log('참3 10이 10보다 이상이다.') : console.log('거짓 10이 10미만이다')
*/



/* 

문제1. prompt 로 정수 1개 입력받아 90이상이면 합격 아니면 탈락
		-console로 출력
		
문제2. prompt 로 성별 입력받아 
	'M'또는 'm' 또는'남' 또는 '남자' '남자 이군요' console출력
	'W'또는 'w' 또는'여' 또는 '여자' '여자 이군요' console출력
	그외 '남자 : m,M,남,남자
		여자:w,W,여,여자 로 입력해주세요'라고 console출력
		
문제3. prompt 로 점수 1개 입력받아
		90점 이상이면 'A등급' 80점 이상이면 'B'등급
		70점 이상이면 'C등급' 그외 '탈락' console출력

 */


// 문제1.
/*let q1 = Number(prompt('점수'))
if(q1>100){console.log('최고점수는 100입니다.다시입력하세요.')}
else if(q1>=90){console.log('합격입니다.')}
else{console.log('불합격입니다.')}*/

// 문제2.
/*let q2 = prompt('성별입력')
if(q2 == 'M'){console.log('남자이군요')}
else if(q2 == 'm'){console.log('남자이군요')}
else if(q2 == '남'){console.log('남자이군요')}
else if(q2 == '남자'){console.log('남자이군요')}
else if(q2 == 'W'){console.log('여자이군요')}
else if(q2 == 'w'){console.log('여자이군요')}
else if(q2 == '여'){console.log('여자이군요')}
else if(q2 == '여자'){console.log('여자이군요')}
else{console.log('남자:m,M,남,남자 여자:w,W,여,여자 로 입력해주세요')}*/
// 혹은
/*if(q2 == 'M'|| q2 == 'm'|| q2 == '남'|| q2 == '남자'||){console.log('남자이군요')}
else if(q2 == 'W'|| q2 == 'w'|| q2 == '여'|| q2 == '여자'||){console.log('여자이군요')}
else{console.log('남자:m,M,남,남자 여자:w,W,여,여자 로 입력해주세요')}*/


// 문제3.
/*let q3 = Number(prompt('점수'))
if(q3>100){console.log('최고점수는 100입니다. 다시입력하세요.')}
else if(q3>=90){console.log('A등급')}
else if(q3>=80){console.log('B등급')}
else if(q3>=70){console.log('C등급')}
else{console.log('불합격입니다.')}*/