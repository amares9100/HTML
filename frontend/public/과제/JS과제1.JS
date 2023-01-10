

/*과제1 : 학번[8자리]입력후 로그인버튼 클릭시 배열에 존재하면 
	로그인 성공출력 / 아니면 로그인 실패

	조건1. studentArray = [ '20230110' , '20230109' , '20230108' ]
	조건2. 입력<input>사용해서 학번 입력받기
	조건3. 로그인 <buttom>사용해서 로그인 이벤트 실행*/
	
// 과제1
let studentArray = ['20230110' , '20230109' , '20230108']

function student(){ // 함수 s
	
let student = document.querySelector('.student') 
let studentvalue = student.value;
// 입력값과 배열 비교
let sindex = studentArray.indexOf( studentvalue )

let slength = studentvalue.length
console.log(studentvalue.length)

if (studentvalue.search(/\s/) != -1) {
            alert("비밀번호는 공백 없이 입력해주세요.");
            return false;
}
else if (slength != 8) {
            alert("학번은 8자리수입니다.");
            return false;
}
else if(sindex == -1 ){ alert('로그인실패');
			return false;
}
else{alert('로그인성공')}

} // 함수 e

// -------------과제1 e --------------

// -------------과제2-----------------

function join(){
	
	let join = document.querySelector('.join')
	
	


let joinvalue = join.value;
console.log('joinvalue : ' + joinvalue)

let jlength = joinvalue.length
console.log('jlength : ' + jlength)

let join1 = studentArray.indexOf(joinvalue)



if (joinvalue.search(/\s/) != -1) {
            alert("비밀번호는 공백 없이 입력해주세요.");
            return false;
}
else if (jlength != 8) {
            alert("학번은 8자리수입니다.");
            return false;
}
else if(join1 != -1 ){ alert('등록된 번호입니다.');
			return false;
}
else{alert('등록성공')
	studentArray.push(join.value)

}

}
















