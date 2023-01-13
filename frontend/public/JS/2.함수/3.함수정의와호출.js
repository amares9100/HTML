/*

*/

// 1. 인수x 반환x함수
function 함수1(){ // function s
	//function : 함수 선언시 사용되는 키워드
		// 함수1 : 함수이름[식별자] 동일한 파일내에서는 중복이름 불가
			// () : 인수 정의하는 곳
				// { } : 함수가 호출되면 실행 되는 구역
				
	alert('함수1 실행 됨')			
		
} // function e

// 1. 함수 호출
함수1()

// 2. 인수o 반환o 함수
function 함수2( x, y){
	// ( x, y) : 인수 2개를 받는 함수
	alert('함수2 실행 됨')
	if( x+y > 10) {return x+y;}
}

let result = 함수2(3, 5) // 리턴값을 변수에 저장
alert('함수2 실행 값 : ' + result)

// 3. 인수o 반환x
function 함수3( x, y, z){
	let result = x + y + z
	alert('함수3 실행 됨 : ' + result)
}
함수3(3, 5 , 7)

// 4. 인수x 반환o
function 함수4(){
	let result = 3+5+8
	return result;
}

let result2 = 함수4()
alert('함수4 실행 됨 : ' + result2)


