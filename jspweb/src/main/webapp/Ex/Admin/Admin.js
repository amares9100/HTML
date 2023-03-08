/**
 * 
 */
userlist();
function userlist(){
 	$.ajax({
		url : "/jspweb/Admin" ,
		method : "get" ,
		success : (r) =>{console.log('ajax확인')
		console.log(r)
			let html = 
						`<tr>
							<th> 회원번호 </th>
							<th> 회원아이디 </th>
							<th> 회원 이메일 </th>
							<th> 회원 이미지 </th>
							<th> 비고 </th>
						</tr>`;
			r.forEach((o , i ) => {
				// 만약에 ming가 null이면 기본프로필 사용 / 아니면 등록한 이미지 사용
				html += 
						`<tr>
							<td> ${ o.mno } </td>
							<td> ${ o.mid }</td>
							<td> ${ o.memail } </td>
							<td><img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%"></td>
							<td>  </td>
						</tr>`;
			})
			document.querySelector('.userlist').innerHTML = html;
			}
	});		
}
		
