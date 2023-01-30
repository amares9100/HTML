
	
qboard_print( null , null);
	
function qboard_print(qkeyword , qkey){
	
	if( qkeyword == null && qkey == null ){ 
		alert('확인')
	}
	else{  
		alert('확인2')
	}
	let html = ''
	let qboardlist = [
		{ no : 5 , title : '문의사항5' , writer : '유재석' , date : '2023-01-30' , view:325 , cpdate : '' , complete : '처리중' } , 
		{ no : 4 , title : '문의사항4' , writer : '강호동', date : '2023-01-27' , view:123 , cpdate : '' , complete : '처리중'  } , 
		{ no : 3 , title : '문의사항3' , writer : '신동엽' , date : '2023-01-25' , view:753 , cpdate : '' , complete : '처리중'  } , 
		{ no : 2 , title : '문의사항2' , writer : '서장훈' , date : '2023-01-24' , view:521 , cpdate : '2023-01-24' , complete : '완료'  } , 
		{ no : 1 , title : '문의사항1' , writer : '김희철' , date : '2023-01-23' , view:951 , cpdate : '2023-01-23' , complete : '완료' } 
	]
	
	qboardlist.forEach( ( qboardlist ) => { 
		html += `<tr>
					<td>${ qboardlist.no }</td><td><a href="qview.html">${ qboardlist.title }</a></td>
					<td>${ qboardlist.writer }</td><td>${ qboardlist.date }</td>
					<td>${ qboardlist.view }</td><td>${ qboardlist.complete }</td>
					<td>${ qboardlist.cpdate }</td> 
				</tr>`
	
	
})
	document.querySelector('.qboard').innerHTML=html

	document.querySelector('.qsearbtn').addEventListener( 'click' , (e)=>{

	let qkeyword = document.querySelector('.qkeyword').value
	
	let qkey = document.querySelector('.qkey').value
	
	qboard_print( qkeyword , qkey )
})

}




















