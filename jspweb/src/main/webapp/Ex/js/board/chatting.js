
// js에서 제공하는 클래스 WebSocket(ws://url)
// 소캣 객체 만들기
//let 클라이언트 = new WebSocket('ws://');
// 서버소캣 생성자에서 해당 서버소캣의 경로 확인 통신

//자바 서버소캣
//클래스 생성우 서버소캣 만들기
//@ServerEndpoint("/사용할주소")
// 클라이언트 서버소캣(앤드포인트)로 접속했을때

// JSP				JAVA
//onopen() 	-> 		@OnOpen : 클라이언트 소켓이 접속했을때 매핑(연결)
//send() 	-> 		@OnMessage
//onMessage <-		session.getBasicRemote().sendText('보낼 메시지');
//onclose   <-		@OnClose


let contentbox = document.querySelector('.contentbox')
let 클라이언트 = null;
if(memberInfo.mid==null){
	alert('로그인이 필요합니다.');
	location.href="/jspweb/Ex/Member/login.jsp";
}
else{ 
	클라이언트 = new WebSocket('ws://localhost:8080/jspweb/chatting/'+memberInfo.mid);
	클라이언트.onopen = function(e){onopen(e);}
	클라이언트.onmessage = function(e){pushOnMessage(e);}
	클라이언트.onclose = function(e){close(e)}
}
	
	

console.log(클라이언트)



function onopen(e){
	contentbox.innerHTML += `<div class="alarm">
						<span>채팅방에 입장하셨습니다.</span>
					</div>`
}


function ssend(){
	console.log('send')
	let msgbox = document.querySelector('.msgbox').value;
	// 메세지 전송
	클라이언트.send(msgbox);
	msgbox = document.querySelector('.msgbox').value = '';
}

 document.addEventListener('keyup' , (y)=>{
	  console.log(y.key)
	  if(y.key == 'Enter')ssend();
	  
 })

//서버가 보낸 메시지 받기
function pushOnMessage(e){
	console.log(e)
	console.log(e.data)
	console.log(JSON.parse(e.data));//문자열json을 객체json으로 변경
	let data = JSON.parse(e.data)
	//보낸
	if(data.frommid == memberInfo.mid){
		contentbox.innerHTML +=`<div class="sendcontent">
						<div class="date">${data.time}</div>
						<div class="content">${data.msg}</div>
					</div>`
	}
	//받은
	else{
		contentbox.innerHTML +=`<div class="tocontent">
						<span><img src="/jspweb/Ex/Member/pimg/${ data.frommimg == null ? 'X.jpg' : data.frommimg }" class="hpimg"></span>
						<div class="rcontent">
							<div class="name">${data.frommid}</div>
							<div class="contentdate">
								<div class="content">${data.msg}</div>
								<div class="date">${data.time}</div>
							</div>
						</div>
					</div>`
	}
	//--------스크롤 최하단으로 내기리-------
	//let contentbox = document.querySelector('.contentbox')
	//let top = contentbox.scrollTop;
	//console.log(top)
	let height = contentbox.scrollHeight;
	//console.log(height)
	contentbox.scrollTop = height;
}


// 연결이 끊겼을때(페이지 전환/F5)

function close(e){
	console.log('연결해제')
	
}
































