package Ex.Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import Ex.Model.DTO.ClientDto;
import Ex.Model.DTO.MessageDto;

// 서버소캣 만들기
@ServerEndpoint("/chatting/{mid}") // 경로상에 {}는 매개변수 => /경로/{매개변수}/{매개변수2}...
public class Chatting {

	// 접속한 클라이언트명단[목록]
	
	public static ArrayList<ClientDto> list = new ArrayList<>();
	
	
	@OnOpen // 접속 // 매개변수 가져오기 @PathParam("매개변수명") String 변수명
	public void OnOpen(Session session , @PathParam("mid") String mid) {
		System.out.println("소캣들어옴");
		System.out.println(session);
		
		list.add(new ClientDto(session, mid));
		System.out.println(list.toString());
	}
	
	@OnClose
	public void OnClose(Session session) {
		System.out.println("소켓연결해제");
		
		for(ClientDto dto : list) {
			if(dto.getSession() == session) {
				list.remove(dto);
			}
		}
		
	}
	
	// 클라이언트 소켓이 메세지를 보냈을때[서버가 메세지를 받았을때]
	@OnMessage
	public void OnMessage(Session session , String msg) throws IOException {
		System.out.println("클라이언트메세지를 서버가 받음.");
		System.out.println(msg);
		
		MessageDto messageDto = new MessageDto(session, msg);
		//보낼자료 json으로 형변환
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(messageDto);
		
		
		
		// 현재 서버소켓과 연결된 클라이언트 소켓 모두에게 받은 내용물 전달
		for(ClientDto dto : list) {
			//서버가 클라이언트 소켓에 메세지를 보냄
			dto.getSession().getBasicRemote().sendText(json);
		}
		
		
	}
}
