package com.succez;

import java.io.File;

import javax.servlet.http.HttpSession;

public class LoginUpAction extends AllAction implements Action {

	@Override
	public String getUri() {
		return "web/LoginUp.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter) throws Exception {
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\LoginUp.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.addBody(filetobyte(file));
	}

	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String name = request.getParameter("name");
		try {
			User user = SelectSql(name);
			if (user == null) {
				System.out.println((int) Integer.parseInt(request
						.getParameter("age")));
				User user1 = new User(name, request.getParameter("password"),
						false, (int) Integer.parseInt(request
								.getParameter("age")),
						request.getParameter("sex"),
						request.getParameter("email"),
						(int) Integer.parseInt(request.getParameter("phone")));
				AddSql(user1);
				// 发送数据，改变登录状态,注册成功
				String tk = "sessionid=".concat(sessionid);
				response.addHeader("Set-Cookie", tk);
				Session a = sessions.getSession(sessionid);
				a.setAttribute("name", request.getParameter("name"));
				Action action = new indexAction();
				action.doGet(request, response, sessions, fiter, sessionid);
			}

		} catch (Exception e) {

			response.addHeader("MIME-version", "1.0");
			response.addHeader("Content-Type", "text/html;charset=utf-8");
			File file = new File("web\\LoginUp.html");
			int leng = (int) file.length();
			response.addHeader("Content-Length", leng);
			response.addBody(filetobyte(file));
			// 注册失败重新注册
		}
	}

}
