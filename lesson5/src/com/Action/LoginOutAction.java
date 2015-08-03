package com.Action;

import java.io.File;

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
		response.addrequest("HTTP/1.0", 200, "OK");
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Load.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.sendHeader();
		response.addBody(filetobyte(file));

	}

}