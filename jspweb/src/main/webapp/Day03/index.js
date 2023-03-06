/**
 * 
 */

function doPOST(){
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "post" ,
		success : (result ) => {}
		
	})
	
}
 
function doGet(){
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "get" ,
		success : (result ) => {}
		
	})
	
}

function doPUT(){
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "put" ,
		success : (result ) => {}
		
	})
	
}
 
function doDELETE(){
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "delete" ,
		success : (result ) => {}
		
	})
	
}
//--------------------------------------------

function onwrite(){
	console.log('onwrite확인')
	
	let info = {
		content : document.querySelector('.content').value ,
		writer : document.querySelector('.writer').value
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "post" ,
		data : info ,
		success : (result ) => {
			console.log('ajax응답')
			if(result == 'true'){
			alert('등록되었습니다.');
			document.querySelector('.content').value = '';
			document.querySelector('.writer').value = '';
			print();
			}
			else{alert('등록실패');}
		}
		
		
	})
}
print();
function print(){
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "get" ,
		success : ( r )=>{ 
			console.log( 'get 응답 성공 ');	console.log( r );
			// 1. 테이블 제목 구성 
			let html = 
						`<tr>
							<th> 번호 </th>
							<th> 제목 </th>
							<th> 작성자 </th>
							<th> 비고 </th>
						</tr>`;
			// 2. 테이블 내용 구성 
			r.forEach( (o,i) => {
				html += 
						`<tr>
							<td> ${ o.bno } </td>
							<td> ${ o.bcontent }</td>
							<td> ${ o.bwriter } </td>
							<td><button type="button" onclick="update(${o.bno})">수정</button>/
								<button type="button" onclick="del(${o.bno})">삭제</button></td>
						</tr>`;
				
			});
			// 3. 구성된 html 대입 
			document.querySelector('.print').innerHTML = html;
					
		}
	})
}

function update(bno){
	let content = prompt('수정할 내용을 입력하세요');
	
	let update = {
		content : content ,
		bno : bno
	}
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "put" ,
		data : update ,
		success : (result ) => {
			console.log('put :');console.log(result);
			print();
		}
		
	})
	
}

function del(bno) {
	console.log(bno)
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "delete" ,
		data : {"bno" : bno },
		success : (result ) => {
			print();
			
		}
	});		
}

//============================================================================

function product(){
	console.log('product확인')
	
	let info = {
		pname : document.querySelector('.pname').value ,
		pprice : document.querySelector('.pprice').value
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Product" ,
		method : "post" ,
		data : info ,
		success : (result ) => {
			console.log('ajax응답')
			if(result == 'true'){
			alert('등록되었습니다.');
			document.querySelector('.pname').value = '';
			document.querySelector('.pprice').value = '';
			onlist();
			}
			else{alert('등록실패');}
		}
		
		
	})
}

onlist();
function onlist(){
	$.ajax({
		url : "/jspweb/Product" ,
		method : "get" ,
		success : ( result )=>{ 
			console.log( 'get 응답 성공 ');	console.log( result );
			let html = 
						`<tr>
							<th> 번호 </th>
							<th> 제품 </th>
							<th> 가격 </th>
						</tr>`;
			
			result.forEach( (o,i) => {
				html += 
						`<tr>
							<td> ${ o.pno } </td>
							<td> ${ o.pname }</td>
							<td> ${ o.pprice } </td>
							<td><button type="button" onclick="p_update(${o.pno})">수정</button>/
								<button type="button" onclick="p_del(${o.pno})">삭제</button></td>
						</tr>`;
				
			});
			// 3. 구성된 html 대입 
			document.querySelector('.pprint').innerHTML = html;
					
		}
	})
}


function p_update(pno){
	console.log(pno);
	let pname = prompt('수정할 제품이름을 입력하세요');
	let pprice = prompt('수정할 가격을 입력하세요');
	let update = {
		pname : pname ,
		pno : pno ,
		pprice : pprice
	}
	
	$.ajax({
		url : "/jspweb/Product" ,
		method : "put" ,
		data : update ,
		success : (result ) => {
			console.log('put :');console.log(result);
			onlist();
		}
		
	})
}

function p_del(pno){
	console.log(pno);
	$.ajax({
		url : "/jspweb/Product" ,
		method : "delete" ,
		data : {"pno" : pno },
		success : (result ) => {
			onlist();
			
		}
	});	
}


































