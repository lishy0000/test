package com.succez;

import java.io.File;

import javax.servlet.http.HttpSession;

public class LoginOutAction extends AllAction implements Action {

	@Override
	public String getUri() {
		return "web/LoginOut.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String k = request.getHeader("Cookie");
		String t = k.substring(11);
		Session a = sessions.getSession(t);
		a.removeAttribute("name");
		response.addHeader("Cookie", null);
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Load.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.addBody(filetobyte(file));

	}

}