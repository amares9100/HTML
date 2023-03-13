if(memberInfo.mid == null){
	alert('로그인해주세요.');
	location.href="/jspweb/Ex/index.jsp"
}

document.querySelector('.mimg').src=`/jspweb/Ex/Member/pimg/${memberInfo.mimg == null ? 'X.jpg'  : memberInfo.mimg}`;
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').value = memberInfo.memail;


function setUpdate(){
	
	// 첨부파일 없을때
	/*
	let info = {
		'mpwd' : document.querySelector('.mpwd').value ,
		'newmpwd' : document.querySelector('.newmpwd').value ,
		'memail' : document.querySelector('.memail').value 
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Ex/Member",
		method : "put" ,
		data : info ,
		success : (r)=>{
			console.log(r)
		}
	})
	*/
	//첨부파일이 있을때
	
	let updateForm = document.querySelectorAll('.updateform')[0];
	let updateFormData = new FormData(updateForm);
	let defaultimg = document.querySelector('.defaultimg').checked;
	
	updateFormData.set("defaultimg" , defaultimg);
	console.log(defaultimg)
	
		

	
	
	$.ajax({
		url : "/jspweb/Ex/Member",
		method : "put" ,
		data : updateFormData ,
		contentType : false,
		processData : false,
		success : (r)=>{
			console.log(r)
			if( r =='true'){
				alert('수정성공');
				location.href="/jspweb/Ex/Member/logout.jsp"
			}else{
				alert('수정실패');
			}
			
			
		}
	})
		
}





































