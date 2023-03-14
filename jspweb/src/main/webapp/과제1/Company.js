console.log('a');

function print(){
	
	$.ajax({
		url : "/Company" ,
		method : "get" ,
		success : (r) =>{console.log('ajax확인')
		console.log(r)
			let html = 
						`<tr>
							<th> 사원번호 </th>
							<th> 사원사진 </th>
							<th> 사원명 </th>
							<th> 직급 </th>
							<th> 고용형태 </th>
							<th> 부서 </th>
							<th> 입사일 </th>
							<th> 퇴사일 </th>
							<th> 퇴사사유 </th>
							<th> 비고 </th>
						</tr>`;
			r.forEach((o , i ) => {
				//<img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%">
				html += 
						`<tr>
							<td> ${}</td>
							<td><img src="/jspweb/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%"></td>
							<td> ${}</td>
							<td> ${}</td>
							<td> ${}</td>
							<td> ${}</td>
							<td> ${}</td>
							<td> ${}</td>
							<td> ${}</td>
							<td> <button type="button" onclick="upDate()">수정</button><button type="button" onclick="del()">삭제</button></td>
						</tr>`;
			})
			document.querySelector('.print').innerHTML = html;
			}
	});	
}