/**
 * 
 */

console.log(memberInfo)


console.log('view 확인')
let bno = document.querySelector('.bno').innerHTML;
getBoard();

console.log(bno)
function getBoard(){
	$.ajax({
		url : "/jspweb/BoardWrite" ,
		method : "get" ,
		data : {"type" :2, "bno" : bno},
		success : (r)=>{
			console.log(r)
			
			document.querySelector('.mimg').innerHTML = `<img src="/jspweb/Ex/Member/pimg/${ r.mimg == null ? 'X.jpg' : r.mimg }" class="hpimg">`
			document.querySelector('.bdate').innerHTML =  r.bdate
			document.querySelector('.vud').innerHTML = `/ ${r.bview} /<button type="button" onclick="bIncrease(2)"><i class="far fa-thumbs-up">${r.bup}</i>${r.bup}</button> /<button type="button" onclick="bIncrease(3)"><i class="far fa-thumbs-down">${r.bdown}</i>${r.bdown}</button>`;
			document.querySelector('.mid').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			if(r.bfile == null){
				document.querySelector('.bfile').innerHTML = '첨부파일 없음';
			}
			else{
				document.querySelector('.bfile').innerHTML = `${r.bfile}<button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`;
				}
			
			if(memberInfo.mid == r.mid){
				html = `<button onclick="bdel(${r.bno})" type="button">삭제</button>
						<button onclick="bupdate(${r.bno})" type="button">수정</button>`;
				document.querySelector('.c_box').innerHTML =html;
			}
		}
	})
	
}

function bdownload(bfile){
	console.log('bfile : ' + bfile)
	
	location.href="/jspweb/filedownloade?bfile="+bfile;
	
	/*
	$.ajax({
		url : "/jspweb/Filedownload" , 
		method : "get" , 
		data : {"bfile" : bfile} , 
		success : (r)=>{
			console.log(r)
			
			
		}
	})
	*/
}

// 조회수 , 좋아요 , 싫어요 카운트
bIncrease(1);
function bIncrease(type){
	let bno = document.querySelector('.bno').innerHTML;
	
	
	$.ajax({
		url : "/jspweb/Boardview" , 
		method : "get" , 
		data : {"type" : type,
				"bno" : bno} , 
		success : (r)=>{
			console.log(r)
			getBoard();
			
		}
	})
}


function bdel(bno){
	$.ajax({
		url : "/jspweb/Boardview" , 
		method : "delete" , 
		data : {"bno" : bno} , 
		success : (r)=>{
			console.log(r)
			location.href ="/jspweb/Ex/index.jsp"
		}
	})
}

function bupdate(bno){
	location.href="/jspweb/Ex/board/update.jsp?bno="+bno;
}


// 댓글쓰기
function rwrite(){
	let rcontent = document.querySelector('.rcontent').value;
	$.ajax({
		url : "/jspweb/Ex/Reply" , 
		method : "post" , 
		data : {"bno" : bno , 
				"rcontent" : rcontent , 
				"type" : 1} , 
		success : (r)=>{
			console.log(r)
			if(r == "true"){
				alert('댓글작성 성공')
			document.querySelector('.rcontent').value = ''
				// jquery : 특정 div만 새로고침[랜더링]
				// $('.replylistbox').load( location.href+' .replylistbox');
				// js : 현재페이지 새로고침[랜더링]
				location.reload();
			}
			else{alert('댓글작성 실패')}
		}
	})
}

getReplyList();
function getReplyList(){
	let html = '';
	$.ajax({
		url : "/jspweb/Ex/Reply" , 
		method : "get" , 
		data : {"bno" : bno ,
				"type" : 1 } , 
		success : (r)=>{
			console.log(r)
			
			r.forEach(( o , i ) => {
				
					html += `<div >
								<span><img src="/jspweb/Ex/Member/pimg/${ o.mimg == null ? 'X.jpg' : o.mimg }" class="hpimg"></span>
								<span> ${o.mid}</span>
								<span> ${o.rdate}</span><br>
								<span>${o.rcontent}</span>
								<button onclick="rerewrite(${o.rno})" type="button">댓글달기</button>
								<div class="rereplybox${o.rno}">
								
								</div>
							</div>`;
			
				
							
				
			})
			document.querySelector('.R_reply').innerHTML = html;
			}
			
		
	})
	
}


function replyview(rno){
	let html = `
				<div class="replywritebox"> </div>
				<textarea class="rrcontent${rno}"> </textarea>
				<button type="type" onclick="rrwirte( ${rno} )"> 대댓글작성 </button>
				`
	document.querySelector('.replyviewbox'+rno).innerHTML = html;
	console.log(rno)
}

function rrwirte( rno ){
	// bno , mno , rrcontnet , rindex(상위댓글번호) , type
	$.ajax({
		url : "/jspweb/Ex/Reply" , 
		method : "post" , 
		data : { 
			"type" : 2 , "bno":bno , "rindex":rno , 
			"rcontent" : document.querySelector('.rrcontent'+rno).value } ,
		success : (r) => {
			console.log( r )
			location.reload();
			
			
		}
	})
} // end 


function rerewrite(rno){
	console.log('rere확인')
	$.ajax({
		url : "/jspweb/Ex/Reply" , 
		async : 'false',	// 동기식 통신  
		method : "get" , 
		data : { 
			"type" : 2 , "bno":bno , "rindex":rno
			} ,
		success : (r) => {
			console.log( 'rere : ' + r )
			
			let html = ''
			r.forEach( ( o )=>{ // 대댓글 html 구성 
				html += `--------------------------
					<div>
						<span><img src="/jspweb/Ex/Member/pimg/${ o.mimg == null ? 'X.jpg' : o.mimg }" class="hpimg"> </span>
						<span>${ o.mid} </span>
						<span>${ o.rdate} </span><br>
						<span>${ o.rcontent} </span>
					</div>
					`
			 } );
		  	html += `
				<div class="replywritebox">
				<textarea class="rrcontent${rno} rcontent, recon"> </textarea>
				<button type="type" onclick="rrwirte( ${rno} )" class="rwri"> 답글 작성 </button>
				</div>`
			document.querySelector('.rereplybox'+rno ).innerHTML = html;
		}  // success end 
			
		
	})
}

if(memberInfo.mid == null){
	document.querySelector('.rcontent').disabled= true;
	document.querySelector('.rcontent').value = '로그인후 작성가능합니다.';
	document.querySelector('.rwrite').disabled= true;
}
else{
	document.querySelector('.rcontent').disabled= false;
	document.querySelector('.rwrite').disabled= false;
}













