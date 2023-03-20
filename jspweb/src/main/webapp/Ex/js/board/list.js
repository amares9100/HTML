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
			let html = '';
						
			
			r.boardList.forEach((o , i ) => {
				
				html += `<div >
					<img src="/jspweb/Ex/Member/pimg/${ o.mimg == null ? 'X.jpg' : o.mimg }" class="hpimg">
					<span class="mid">${o.mid}</span>
					<span class="bdate"> ${o.bdate} </span>
				</div>
				<div>
					<div class="btitle"><a href="/jspweb/Ex/board/view.jsp?bno=${o.bno}">${o.btitle}</a></div>
				</div>
				<div class="contentbottom">
					<span><i class="far fa-eye"></i> <span class="bview">${o.bview}</span></span>
					<span><i class="far fa-thumbs-up"></i> <span class="bup">${o.bup}</span>   </span>
					<span><i class="far fa-thumbs-down"></i> <span class="bdown">${o.bdown}</span>   </span>
					<span><i class="far fa-comment-dots"></i> <span class="bview">${o.rcount}</span>   </span>
				</div>`
						
			})
			document.querySelector('.boardTable').innerHTML = html;
			//============================================================//
			html = '';
			// 이전 버튼
			html += page <= 1 ?
					`<button class="pa" onclick="getlist(${page})" type="button"> < </button>
					` : 
					`<button class="pa" onclick="getlist(${page-1})" type="button"> < </button>
					`;
			
			for(let i = r.startbtn ; i <=r.endbtn ; i++){
				html += `
					<button class="pa" onclick="getlist(${i})" type="button"> ${i} </button>
					`
			}
			// 이후 버튼
			html += page >= r.totalpage ? 
					`<button class="pa" onclick="getlist(${page})" type="button"> > </button>` : 
					`<button class="pa" onclick="getlist(${page+1})" type="button"> > </button>`;
			
			
			document.querySelector('.pagebox').innerHTML = html;
			document.querySelector('.searchcount').innerHTML = `게시글 수 : ${r.totalsize}`;
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 