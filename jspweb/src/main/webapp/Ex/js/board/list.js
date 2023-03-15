/**
 * 
 */

 console.log('list 확인')
 
 getlist();
 function getlist(){
	 $.ajax({
		url : "/jspweb/BoardWrite",
		method : "get" ,
		data : {"type" :1},
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
			
			
			r.forEach((o , i ) => {
				
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
			}
	})
	
}

 
 /*
 
 	- PK값 넘기기
 		1. HTTP get방식의 a태그를 이용한 pk값 넘기기
 			<a href="/jspweb/Ex/board/view.jsp?bno=${o.bno}">
 			- 값 1개 : <a href="/jspweb/Ex/board/view.jsp?변수명=데이터">
 			- 값 여러개 : <a href="/jspweb/Ex/board/view.jsp?변수명=데이터&변수명=데이터&변수명=데이터....">
 
 
 
 
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 