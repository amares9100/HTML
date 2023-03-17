/**
 * 
 */
let pageobject = {
	page : 1 ,
	key : "" ,
	keyword : "" ,
	type : 1 ,
	cno : document.querySelector('.cno').value ,
	listsize : 3
}
 console.log(pageobject.listsize)
 
 
 
 let cnamehtml = '';
 if(pageobject.cno == 1){cnamehtml = '공지사항';}
 if(pageobject.cno == 2){cnamehtml = '커뮤니티';}
 if(pageobject.cno == 3){cnamehtml = 'QnA';}
 if(pageobject.cno == 4){cnamehtml = '노하우';}
document.querySelector('.cname').innerHTML = cnamehtml;
 
 getlist(1);
 function getlist(page){
	 pageobject.page = page;
	 $.ajax({
		url : "/jspweb/BoardWrite",
		method : "get" ,
		data : pageobject,
		success : (r)=>{
			console.log(r)
			let html = 
						`<tr>
							<th width="10%"> 번호 </th>
							<th width="30%"> 제목 </th>
							<th width="10%"> 작성자 </th>
							<th width="20%"> 작성일 </th>
							<th width="10%"> 조회수 </th>
							<th width="10%"> 좋아요 </th>
							<th width="10%"> 싫어요 </th>
						</tr>`;
			
			
			r.boardList.forEach((o , i ) => {
				
				html += 
						`<tr>
							<td>${o.bno}</td>
							<td><a href="/jspweb/Ex/board/view.jsp?bno=${o.bno}">${o.btitle}</a></td>
							<td>${o.mid}</td>
							<td>${o.bdate}</td>
							<td>${o.bview}</td>
							<td>${o.bup}</td>
							<td>${o.bdown}</td>
						</tr>`;
			})
			document.querySelector('.boardTable').innerHTML = html;
			//============================================================//
			html = '';
			// 이전 버튼
			html += page <= 1 ?
					`<button onclick="getlist(${page})" type="button"> 이전 </button>
					` : 
					`<button onclick="getlist(${page-1})" type="button"> 이전 </button>
					`;
			
			for(let i = r.startbtn ; i <=r.endbtn ; i++){
				html += `
					<button onclick="getlist(${i})" type="button"> ${i} </button>
					`
			}
			// 이후 버튼
			html += page >= r.totalpage ? 
					`<button onclick="getlist(${page})" type="button"> 다음 </button>` : 
					`<button onclick="getlist(${page+1})" type="button"> 다음 </button>`;
			
			
			document.querySelector('.pagebox').innerHTML = html;
			document.querySelector('.searchcount').innerHTML = `출력 게시물수 : ${r.totalsize}`;
			}
	})
	
}



function getsearch(){
	
	pageobject.key = document.querySelector('.key').value;
	pageobject.keyword = document.querySelector('.keyword').value;
	
	getlist(1);
	
}

function setsearch(){
	pageobject.key = '';
	pageobject.keyword = '';
	
	getlist(1);
}
 
 function listsize(){
	 pageobject.listsize = document.querySelector('.printkey').value;
	 getlist(1);
 }
 
 /*
 
 	- PK값 넘기기
 		1. HTTP get방식의 a태그를 이용한 pk값 넘기기
 			<a href="/jspweb/Ex/board/view.jsp?bno=${o.bno}">
 			- 값 1개 : <a href="/jspweb/Ex/board/view.jsp?변수명=데이터">
 			- 값 여러개 : <a href="/jspweb/Ex/board/view.jsp?변수명=데이터&변수명=데이터&변수명=데이터....">
 
 
 
 
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 