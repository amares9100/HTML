//console.log('확인용');
/* 
		$.ajax({ 
			url : "" , 
			method : "" , 
			data : { 매개변수명 : 데이터 } , 
			success : function( result ){
				
			}
		});
*/


function ex1(){
	
	// 변수10개 ---> 객체{ } 1개
	let info = {
	data1 : document.querySelector('.data1').value ,
	data2 : document.querySelector('.data2').value ,
	data3 : document.querySelector('.data3').value ,
	data4 : document.querySelector('.data4').value ,
	data5 : document.querySelector('.data5').value ,
	data6 : document.querySelector('.data6').value ,
	data7 : document.querySelector('input[name="data7"]:checked').value , // 라디오버튼에서 체크된 value값 가져옴
	data8 : document.querySelector('.data8').checked ,				// 체크여부 -> [True / false]
	data9 : document.querySelector('.data9').value ,
	data10 : document.querySelector('.data10').value
	}
	
	console.log(info); // data7 외에 전부 문자열.. [ 추후 형변환 필요 ]
	$.ajax({ 
			url : "/jspweb/Ex2" , // 서블릿 주소
			method : "post" , // 메소드 방식
			data : info , // 보낼 데이터 
			success : function( result ){ // 받을 데이터
				console.log(result);
				if(result){
					alert('등록성공');getData();
				}
				else {alert('등록실패')}
				
			}
		});
}
getData();
function getData(){
	$.ajax({ 
			url : "/jspweb/Ex2" , // 서블릿 주소
			method : "get" , // 메소드 방식
			success : function( result ){ // 받을 데이터
				//console.log(result);
				//document.querySelector('.getData').innerHTML = result;
				let html =`<table border="1">
								<tr>
									<th> data1</th><th> data2</th><th> data3</th><th> data4</th>
									<th> data5</th><th> data6</th><th> data7</th><th> data8</th>
									<th> data9</th><th> data10</th>
								</tr>`
							
							
						
				result.forEach((o,i) =>{
					
					html+=	`<tr>
								<td> ${o.data1}</td><td> ${o.data2}</td><td> ${o.data3}</td><td> ${o.data4}</td>
								<td> ${o.data5}</td><td> ${o.data6}</td><td> ${o.data7}</td><td> ${o.data8}</td>
								<td> ${o.data9}</td><td> ${o.data10}</td>
							</tr>`
				})
				html+= `</table>`
				document.querySelector('.getData').innerHTML = html;
			}
		});
}

function ex2(){
	
	// 변수10개 ---> 객체{ } 1개
	let info2 = {
	qdata1 : document.querySelector('.qdata1').value ,
	qdata2 : document.querySelector('.qdata2').value ,
	qdata3 : document.querySelector('.qdata3').value ,
	qdata4 : document.querySelector('.qdata4').value ,
	qdata5 : document.querySelector('.qdata5').value ,
	qdata6 : document.querySelector('input[name="qdata6"]:checked').value ,
	qdata7 : document.querySelector('.qdata7').checked ,	
	qdata8 : document.querySelector('.qdata8').value ,
	qdata9 : document.querySelector('.qdata9').value ,

	}
	
	$.ajax({ 
			url : "/jspweb/Ex" , // 서블릿 주소
			method : "post" , // 메소드 방식
			data : info2 , // 보낼 데이터 
			success : function( result ){ // 받을 데이터
				console.log(result);
				if(result){
					alert('등록성공');getqData();
				}
				else {alert('등록실패')}
				
			}
		});
}
getqData();
function getqData(){
	$.ajax({ 
			url : "/jspweb/Ex" , // 서블릿 주소
			method : "get" , // 메소드 방식
			success : function( result ){ // 받을 데이터
				console.log(result);
				//document.querySelector('.getData').innerHTML = result;
				let html =`<table border="1">
								<tr>
									<th>이름</th><th>전화번호</th><th>키</th><th>나이</th>
									<th> 등록일자</th><th>성별</th><th>개인정보동의</th><th>사는지역</th>
									<th>자기소개</th>
								</tr>`
							
							
						
				result.forEach((o,i) =>{
					
					html+=	`<tr>
								<td> ${o.qdata1}</td><td> ${o.qdata2}</td><td> ${o.qdata3}</td><td> ${o.qdata4}</td>
								<td> ${o.qdata5}</td><td> ${o.qdata6}</td><td> ${o.qdata7}</td><td> ${o.qdata8}</td>
								<td> ${o.qdata9}</td>
							</tr>`
				})
				html+= `</table>`
				document.querySelector('.getData2').innerHTML = html;
			}
		});
}






























