console.log('js열림');

console.log( memberInfo );

// 1. header.js에서 ajax 동기식으로 회원정보 가져온 상태  [ memeberInfo ]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src=`/jspweb/Ex/Member/pimg/${memberInfo.mimg == null ? 'X.jpg'  : memberInfo.mimg}`;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;

// 조건추가 : 만약 로그인이 안되어있으면 불가능
if(memberInfo.mid == null){
	alert('로그인이 필요합니다');
	location.href="/jspweb/Ex/Member/login.jsp"
}


// 회원탈퇴
function del(){
	console.log('확인');
	
	$.ajax({
		url : "/jspweb/Ex/Member",
		method : "delete" ,
		data : {"mpwd" : document.querySelector('.mpwd').value} ,
		success : (r)=>{
			if(r=='true'){
				alert('탈퇴성공');
				location.href="/jspweb/Ex/index.jsp";
			}
			else{alert('비밀번호가 다릅니다')}
		}
	})
}

