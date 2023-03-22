package Ex.Model.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import Ex.Controller.Admin.Chatting;
import Ex.Model.DAO.MemberDao;

public class MessageDto {
	//private Session session;	//보낸세션
	private String frommid;		//보낸아이디
	private String frommimg;	//보낸아이디의 프로필이미지
	private String msg;			//보낸메시지
	private String time;		//보낸시간
	
	
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	//클라이언트에게 메시지 전송할대 사용하는 생성자
	public MessageDto(Session session, String msg) {
		super();
		//this.session = session;
		//메시지를 보낸 클라이언트 세션을 통해서 회원아이디 얻기
		for(ClientDto dto : Chatting.list) {
			if(dto.getSession() == session) {
				this.frommid = dto.getMid();
			}
		}
		
		this.frommimg = MemberDao.getInstance().getMember(this.frommid).getMimg();
		this.msg = msg;
		this.time = new SimpleDateFormat("aa hh:mm").format(new Date());
	}


	


	public String getFrommid() {
		return frommid;
	}


	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}


	public String getFrommimg() {
		return frommimg;
	}


	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
