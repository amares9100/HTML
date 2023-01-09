/*
	JS 연산자
		1. 산술연산자
			+더하기, -빼기, *곱하기, /나누기, %나머지
			
 		2. 연결연산자 : +
 				숫자+숫자 : 산술
 				문자+숫자 : 연결
 				문자+문자 : 연결
 				
 		3. 비교연산자 : 결과는 항상 true, false  / 참, 거짓
 			> : 초과
 			< : 미만
 			>= : 이상[크거나 같다]
 			<= : 이하[작거나 같다]
 			== : 같다[데이터만 비교]
 			=== : 같다[데이터/자료형 비교]
 			!= : 같지않다[아니다/제외]
 			!== : 같지않다[데이터/자료형 비교]
 			
 		4. 관계연산자 : 주로 비교연산자가 2개 이상일때 
 			&& : and 이면서 면서 이고 모두 그리고	  [비교연산자의 결과가 모두 참이면 결과도 참]
 				10<x<20 [ x(사용불가) ] -> x>10 && x<20
 			|| : or 이거나 거나 또는 하나라도		  [비교연산자의 결과가 하나라도 참이면 참]
 			! : 부정 반대						  [비교연산자의 결과가 참이면 거짓]
 		
 		5. 대입연산자 : 
 			= 대입[오른쪽에서 왼쪽으로 대입]
 			+= 더한후에 대입 [오른쪽 데이터를 왼쪽에 더한후 대입]
 				변수명 = 변수명 + 3  vs 변수명 += 3
 			-= *= /= %=
 			
 		6. 증감연산자 :
 			변수++	[후위 1증가 ] / 변수--	[후위 1감소 ]
 			++변수	[선위 1증가 ]	/ --변수 [선위 1감소 ]
 
 		7. 삼항연산자 : 만약에 조건이 참이면 참반환 / 거짓이면 거짓반환
 			1. 조건 ? 참 : 거짓
 				ex) - 나이 >= 19 ? '성인' : '청소년'
 			2. 중첩
 				조건1 ? 참1 : 조건2 ? 참2 : 조건3 ? 참3 : 거짓
 				ex) - 나이 <= 19 ? '청소년' : 나이 <= 40 ? '청년' : 나이 <=60 ? '중년' : '노년'
 
 */

// 1. 산술연산자
/*console.log(3+3)				// 숫자+숫자
console.log('더하기 : ' + 10+3)	// 문자+숫자 => 문자+숫자 => 문자
console.log('더하기 : ' + (10+3)) //  숫자+숫자 => 숫자+문자
console.log('빼기 : ' + (10-3))
console.log('곱하기 : ' + (10*3))
console.log('나누기 : ' + (10/3))
console.log('나누기 : ' + (10%3)) // 몫 제외한 나머지만 출력

// 2. 비교연산자
console.log('초과 : ' + (10 > 3))		//t
console.log('미만 : ' + (10 < 3))		//f
console.log('이상 : ' + (10 >= 3))		//t
console.log('이하 : ' + (10 <= 3))		//f
console.log('같다 : ' + (10 == 3))		//f
console.log('같지않다 : ' + (10 != 3))	//t

// 3. 관계연산자
console.log('&&[and] : ' + (10>3 && 10>5))		// t and t -> t
console.log('||[or] : ' + (10>3 || 3>5))		// t or f  -> t
console.log('![부정] : ' + !(10>3))*/

/*
	문제1
		1. 국어, 영어, 수학 점수를 입력받아 3개의 변수에 저장
		2. 총점 출력, 평균 출력
*/

/*let s1 = Number(prompt('국어점수 입력'))
let s2 = Number(prompt('영어점수 입력'))
let s3 = Number(prompt('수학점수 입력'))

let 총점 = s1+s2+s3
let 평균 = (s1+s2+s3)/2
console.log('총점 : ' + (총점))
console.log('평균 : ' + (평균))*/

/*
	문제2 : prompt 함수로 반지름 입력받아서 원넓이[반지름*반지름*3.14] 출력
	문제3 : prompt 함수로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
	문제4 : prompt 함수로 정수를 입력받아 홀수 / 짝수 여부 확인 홀수이면 true 짝수이면 false
	문제5 : prompt 함수로 정수를 입력받아 7배수이면 true, 아니면 false
	문제6 : prompt 함수로 십만원단위의 금액을 입력받아 지폐 개수 세기
	문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
			결과 : true 출력 아니면 false 출력 
	문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
*/

// 문제2
//let s4 = Number(prompt('반지름'))
//console.log('원넓이 : ' + (s4*s4*3.14))

// 문제3
//let s5 = Number(prompt('실수1'))
//let s6 = Number(prompt('실수2'))
//console.log('실수2에 대한 실수1 퍼센트 : ' + parseInt((s5*100)/s6) + '%')

// 문제4
//let s7 = Number(prompt('정수'))
//console.log('입력한 정수는 홀수인가 : ' + s7%2==1)

// 문제5
//let s8 = Number(prompt('정수'))
//console.log('입력한 정수는 7의배수인가 : ' + (s8%7==0))

// 문제6 parseInt() : 몫만 남기고 나머지 버림
/*let s9 = Number(prompt('십만원단위의 금액 입력'))
let s9_1 = Math.floor(s9/100000)
let s9_2 = Math.floor(s9/10000)
let s9_3 = Math.floor(s9/1000)
let s9_4 = Math.floor(s9/100)
console.log('액수 : ' + s9 + '원')
console.log('십만원 : ' + s9_1 + '장')
console.log('만원 : ' + (s9_2-s9_1*10) + '장')
console.log('천원 : ' + (s9_3-s9_2*10) + '장')
console.log('백원 : ' + (s9_4-s9_3*10) + '개')*/

// 문제7
//let s10 = prompt('아이디 입력')
//let s10_1 = 'admin'
//let s11 = Number(prompt('비밀번호 입력'))
//console.log('아이디와 비밀번호 일치여부 : ' + (s10===s10_1) && (s11==1234))

// 문제8
//let s12 = Number(prompt('정수입력'))
//console.log('입력값은 홀수이면서 7의 배수이다  : ' + (s12%2) == 1 && (s12%7) == 0)


// 4. 대입연산자
/*let data1 = 10 // 1. = 대입 [선언과 동시에 대입 = 초기화]
data1 += 2 // vs data1 = data1 + 2
			   // 1. 10+2 --- > 12
			   // 2. data1 = 12

console.log('+=대입 후 : ' + data1) // 10 + 2 -> 12
data1 -= 5
console.log('-=대입 후 : ' + data1) // 12 - 5 -> 7
data1 *= 2
console.log('*=대입 후 : ' + data1) // 7 * 2 -> 14
data1 /= 3
console.log('/=대입 후 : ' + data1) // 14 / 3 -> 4.6666
data1 %= 3
console.log('%=대입 후 : ' + data1) // 4.666 % 3 -> 1.6666

let html = '<h3> 자바자바 </h3>'		//html 마크업 저장할 변수 선언
html += '<div> 안녕하세요</div>'		//변수에 마크업 추가
document.write( html );				//해당 변수값을 html에 출력*/


// 5. 증감연산자 [ data++, data+=1 , data = data+1]
/*let data2 = 10;
console.log( '변수 값 : ' + data2)	//10
console.log( '변수++ : ' + (data2++)) // 10 : 출력후 증가
console.log( '변수 값 : ' + data2)	// 확인 : 11
console.log( '++변수 : ' + (++data2)) // 출력전 증가 : 12

console.log( '변수-- : ' + (data2--)) // 12 : 출력후 감소
console.log( '변수 값 : ' + data2)	// 확인 : 11
console.log( '--변수 : ' + (--data2)) // 출력전 감소 : 10

// 6. 삼항연산자
let age= 38;
let 나이대 = age<=19 ? '청소년' : '성인' // 38<=19 false니까 '성인'대입
console.log('38의 나이대 : ' + 나이대)

let 점수 = 78;
let 등급 = 점수>=90 ? 'A' :		// 점수가 90점이상이면 A
 		  점수>=80 ? 'B' :		// 아니면 점수가 80점이상이면 B
    	  점수>=70 ? 'C' : 'D'	// 아니면 점수가 70점이상이면 C 그외 D
console.log('78점의 등급 : ' + 등급)*/

/*
	문제9
	- 정수를 입력받아서 홀수인지 짝수인지 출력
	문제10
	- 정수 2개를 입력받아 더 큰수를 출력
	문제11
	- 정수 3개를 입력받아 가장 킨수 를 출력
	문제12
	- 정수 3개를 입력받아 오름차순으로 출력
*/

// 문제9
/*let ex9 = Number(prompt('정수입력'))
홀짝 = ex9%2==0 ? '짝수' : '홀수'
console.log('입력한 값은 짝수인가 홀수인가 : ' + 홀짝)*/

// 문제10
/*let ex10_1 = Number(prompt('정수입력'))
let ex10_2 = Number(prompt('정수입력'))
큰수 = ex10_1>ex10_2 ? ex10_1 : ex10_2
console.log('입력1 : ' + ex10_1)
console.log('입력2 : ' + ex10_2)
console.log('입력한 값중에서 더 큰수 : ' + 큰수)*/

// 문제 11
let ex11_1 = Number(prompt('정수입력'))
let ex11_2 = Number(prompt('정수입력'))
let ex11_3 = Number(prompt('정수입력'))
console.log('입력1 : ' + ex11_1)
console.log('입력2 : ' + ex11_2)
console.log('입력3 : ' + ex11_3)
가장큰수 = ex11_1>ex11_2 && ex11_1>ex11_3 ? ex11_1 :
		ex11_2>ex11_3 ? ex11_2 : ex11_3
console.log('입력한 값중에서 가장 큰수 : ' + 가장큰수)
let max = ex11_1
max = max < ex11_2 ? ex11_2 : max
max = max < ex11_3 ? ex11_3 : max
console.log('입력한 값중에서 가장 큰수 : ' + max)
// 문제 12
중간수 = 
//1보다 2가 크고(and) 1이 3보다 작고 혹은(or)
ex11_1<ex11_2 && ex11_1>ex11_3 || 
// 1보다 3이 크고(and) 1이 2보다 작으면 1(참) 아니면
ex11_1<ex11_3 && ex11_1>ex11_2 ? ex11_1 : 
//2보다 1이 크고(and) 2가 3보다 크고 혹은(or) 
ex11_2<ex11_1 && ex11_2>ex11_3 || 
//2보다 3이 크고(and) 2가 1보다 작으면 2(참) 아니면 3(거짓)
ex11_2<ex11_3 && ex11_2>ex11_1 ? ex11_2 : ex11_3 

작은수 = ex11_1<ex11_2 && ex11_1<ex11_3 ? ex11_1 :
		ex11_2<ex11_3 ? ex11_2 : ex11_3
console.log('입력한 값을 오름차순 정렬 : ' + 작은수 +' ' + 중간수 + ' ' +가장큰수)