package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class JoinCommand extends MoveCommand  {

	public JoinCommand(HttpServletRequest request) throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
	}

}
