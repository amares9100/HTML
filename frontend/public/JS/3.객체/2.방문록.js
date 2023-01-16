/*


 
*/

let b_list = []
function on(){
	
	let name = document.querySelector('.name').value
	let text = document.querySelector('.text').value
	let pw = document.querySelector('.pw').value
	let board = {writer : name , content : text, pass: pw}
	console.log(board)
	// 객체를 배열에 저장
	b_list.push(board)
	console.log(b_list)
	
	출력();
}

function del(i){
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	if(비밀번호 == b_list[i].pass){
		b_list.splice(i , 1)
		alert('삭제성공')
		출력();
	}
	else{alert('삭제실패')}
}

function 출력(){
	// 출력
	let html = `<tr><th>번호</th><th>내용</th><th>작성자</th><th>비고</th><th>수정</th></tr>`;
		// 반복문 이용 배열호출
	for(let i = 0 ; i<b_list.length ; i++){
		html += `<tr><th>${i+1}</th><th>${b_list[i].writer}</th><th>${b_list[i].content}</th><th><button onclick="del(${i})" type="button">게시글삭제</button></th><th><button onclick="fix(${i})" type="button">수정</button></th></tr>`;
	}
	document.querySelector('.table1').innerHTML=html;
}

//-수정버튼 클릭시 비밀번호 입력받아 일치하면 새로운 내용 [prompt] 입력받고 출력

function fix(i){
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	if(비밀번호 == b_list[i].pass){
	let fix1 = prompt('수정할 내용')	
		b_list[i].content = fix1;
		alert('수정성공')
		출력();
	}
	else{alert('수정실패')}
	
}

