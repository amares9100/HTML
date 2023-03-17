console.log('write확인')

if(memberInfo.mid == null){
	alert('로그인해주세요.')
	location.href="/jspweb/Ex/Member/login.jsp"
}

let bno = document.querySelector('.bno').value;
console.log(bno)


//수정할 게시물 출력
getboard();
function getboard(){
	$.ajax({
		url : "/jspweb/BoardWrite",
		method : "get" ,
		data : {"type" : 2 , 
				"bno" : bno} ,
		success : (r)=>{
			console.log(r)
			
			document.querySelector('.btitle').value = r.btitle;
			document.querySelector('.bcontent').value = r.bcontent;
			document.querySelector('.oldbfile').innerHTML = r.bfile;
			
			
			let cnoSelect = document.querySelector('.cno');
			for(let i = 0 ; i <cnoSelect.options.length ; i++){
				if(cnoSelect.options[i].value == r.cno){
					cnoSelect.options[i].selected = true;
				}
			}
		}
	})
}




// 게시물 수정
function bupdate(){
	
	let writeform = document.querySelectorAll('.writeform')[0];
	//console.log(writeform)
	let updateformData = new FormData(writeform);
	//console.log(writeformData)
	updateformData.set('bno' , bno);
	
	$.ajax({
		url : "/jspweb/BoardWrite",
		method : "put" ,
		data : updateformData ,
		contentType : false,
		processData : false,
		success : (r)=>{
			console.log(r)
			if(r== 'true'){
				alert('글수정 성공')
				location.href="/jspweb/Ex/index.jsp"
			}
			else{
				alert('글수정 실패')
			}
			
			
		}
	})
}






















