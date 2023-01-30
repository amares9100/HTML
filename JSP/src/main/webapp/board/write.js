
let 게시물임시저장소 = []

function board_write(){
	// 1. 입력받는 데이터를 객체화
	let board = {
		title : document.querySelector('.btitle').value ,
		content : document.querySelector('.bcontent').value ,
		writer : document.querySelector('.bwriter').value  ,
		password : document.querySelector('.bpassword').value
	}
	console.log(board)
	
// 첨부파일 있을경우
// 1, 입력양식 form 가져와서 하나의 객체화 가져오기	
//	let writeform = document.querySelector('.writeform')
//	let formdata = new FormData(writeform) ; 
//	console.log(writeform)
//	console.log(formdata)
	
	
	// 2. JAVA에게 데이터를 전송후 전송된 결과를 받는다
		게시물임시저장소.push(board)
	// 3. 결과에 따른 이벤트
	let result = true;
	if(result){
		alert('글쓰기성공'); location.href = 'list.html';
	}else{alert('글쓰기실패')}
}
/*
location.href = 'list.html'   - 페이지 전환



 */









$(document).ready(function() {
  $('#summernote').summernote({height : 300 , lang: 'ko-KR'});
});