package com.succez;

import java.io.File;

public class ChangeAction extends AllAction implements Action {

	@Override
	public String getUri() {

		return "web/Chang.html";
	}

	@Override
	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String k = request.getHeader("Cookie");
		if (k.indexOf("name:") > 0) {
			k = k.substring(k.indexOf("name:") + 5);
			k = "name=".concat(k);
			response.addHeader("Set-Cookie", k);
		}
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Change.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.addBody(filetobyte(file));// 发送数据，改变sql状态

	}

	@Override
	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String k = request.getHeader("Cookie");
		if (k.indexOf("name:") > 0) {
			k = k.substring(k.indexOf("name=") + 5);

			User user1 = new User(k, request.getParameter("password"),
					SelectSql(fiter).getisAdmin(),
					(int) Integer.parseInt(request.getParameter("age")),
					request.getParameter("sex"), request.getParameter("email"),
					(int) Integer.parseInt(request.getParameter("phone")));
			modifySql(user1);
			Action action = new PrintAction();
			action.doGet(request, response, sessions, fiter, sessionid);
		} else {
			try {
				User user1 = new User(fiter, request.getParameter("password"),
						false, (int) Integer.parseInt(request
								.getParameter("age")),
						request.getParameter("sex"),
						request.getParameter("email"),
						(int) Integer.parseInt(request.getParameter("phone")));
				modifySql(user1);
				Action action = new indexAction();
				action.doGet(request, response, sessions, fiter, sessionid);

			} catch (Exception e) {
				response.addHeader("MIME-version", "1.0");
				response.addHeader("Content-Type", "text/html;charset=utf-8");
				File file = new File("web\\Change.html");
				int leng = (int) file.length();
				response.addHeader("Content-Length", leng);
				response.addBody(filetobyte(file));// 发送数据，
				// 修改失败，
			}
		}

	}

}
