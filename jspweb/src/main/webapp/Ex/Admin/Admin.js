/**
 * 
 */

let pageobject = {
	page : 1 ,
	key : "" ,
	keyword : "" ,
	type : 1 ,
	listsize : 3
}
userlist(1);
function userlist(page){
 	pageobject.page = page;
 	$.ajax({
		url : "/jspweb/Admin" ,
		method : "get" ,
		data : pageobject , 
		success : (r) =>{console.log('ajax확인')
		
		let html = 
						`<tr>
							<th width="10%"> 회원번호 </th>
							<th width="10%"> 회원아이디 </th>
							<th width="20%"> 회원 이메일 </th>
							<th width="20%"> 회원 이미지 </th>
							<th width="40%"> 비고 </th>
						</tr>`;
			r.memberlist.forEach((o , i ) => {
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
			html = '';
			// 이전 버튼
			html += page <= 1 ?
					`<button onclick="userlist(${page})" type="button"> 이전 </button>
					` : 
					`<button onclick="userlist(${page-1})" type="button"> 이전 </button>
					`;
			
			for(let i = r.startbtn ; i <=r.endbtn ; i++){
				html += `
					<button onclick="userlist(${i})" type="button"> ${i} </button>
					`
			}
			// 이후 버튼
			html += page >= r.totalpage ? 
					`<button onclick="userlist(${page})" type="button"> 다음 </button>` : 
					`<button onclick="userlist(${page+1})" type="button"> 다음 </button>`;
			
			
			document.querySelector('.pagebox').innerHTML = html;
			}
		
	});
}
function getsearch(){
	
	pageobject.key = document.querySelector('.key').value;
	pageobject.keyword = document.querySelector('.keyword').value;
	
	userlist(1);
	
}

function setsearch(){
	pageobject.key = '';
	pageobject.keyword = '';
	
	userlist(1);
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			