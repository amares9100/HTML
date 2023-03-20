console.log('write확인')
 $(document).ready(function() {
        $('#summernote').summernote(
			{height : 300}
		);
    });

if(memberInfo.mid == null){
	alert('로그인해주세요.')
	location.href="/jspweb/Ex/Member/login.jsp"
}




function bwrite(){
	
	let writeform = document.querySelectorAll('.writeform')[0];
	//console.log(writeform)
	let writeformData = new FormData(writeform);
	//console.log(writeformData)
	
	$.ajax({
		url : "/jspweb/BoardWrite",
		method : "post" ,
		data : writeformData ,
		contentType : false,
		processData : false,
		success : (r)=>{
			console.log(r)
			if(r== 'true'){
				alert('글쓰기 성공')
				location.href="/jspweb/Ex/index.jsp"
			}
			else{
				alert('글쓰기 실패')
			}
			
			
		}
	})
}






















