package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request)throws Exception {
		
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//id = request.getParameter("id");
		//pw = request.getParameter("pw");
		param.setId(id);
		param.setPw(pw);
		CustomerBean cust = service.login(param);
		String page = "";
		if(cust == null) {
			page = "login";
		}else {
			page = "mypage";
		}
		System.out.println("page="+page);
		
		request.setAttribute("customer",cust);
		Receiver.cmd.setPage(page);
		System.out.println("로그인 후 갈 페이지: "+Receiver.cmd.getView());
	}
}
