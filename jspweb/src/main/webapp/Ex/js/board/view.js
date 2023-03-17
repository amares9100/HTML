/**
 * 
 */
console.log('view 확인')
getBoard();

function getBoard(){
	let bno = document.querySelector('.bno').innerHTML;
	console.log(bno)
	
	$.ajax({
		url : "/jspweb/BoardWrite" ,
		method : "get" ,
		data : {"type" :2, "bno" : bno},
		success : (r)=>{
			console.log(r)
			
			
			document.querySelector('.infobox').innerHTML = `${r.bdate} / ${r.bview} /<button type="button" onclick="bIncrease(2)">${r.bup}</button> /<button type="button" onclick="bIncrease(3)">${r.bdown}</button>`;
			document.querySelector('.pimgbox').innerHTML = r.mid;
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

























