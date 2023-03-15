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
			
			
			document.querySelector('.infobox').innerHTML = `${r.bdate} / ${r.bview} / ${r.bup} / ${r.bdown}`;
			document.querySelector('.pimgbox').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			if(r.bfile == null){
				document.querySelector('.bfile').innerHTML = '첨부파일 없음';
			}
			else{
				document.querySelector('.bfile').innerHTML = `${r.bfile}<button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`;
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
































