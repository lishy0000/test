package com.Action;

import com.succez.*;

public class LoginOutAction extends AllAction implements Action {

	@Override
	public String getUri() {
		return "web/LoginOut.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {

		Session a = sessions.getSession(sessionid);
		a.removeAttribute("name");
		Action action = new LoadAction();
		action.doGet(request, response, sessions, fiter, sessionid);

	}

}