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
				console.log(result);
				document.querySelector('.getData').innerHTML = result;
					
				
				
			}
		});
}
































