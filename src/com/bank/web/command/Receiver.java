package com.bank.web.command;
import javax.servlet.http.HttpServletRequest;


public class Receiver {								// 리시버를 그냥 알바생 정도? 명령받은거 받아? 컨트롤러는?
													//컨트롤러 아래 리시버 서비스 센더... 컨트롤러는 부서!
	public static Command cmd = new Command();    //초기화

	
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
	}
}
