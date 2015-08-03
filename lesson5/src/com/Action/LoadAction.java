package com.Action;

import java.io.File;

import com.succez.*;

public class LoadAction extends AllAction implements Action {

	@Override
	public String getUri() {

		return "Load.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		response.addrequest("HTTP/1.0", 200, "OK");
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Load.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.sendHeader();
		response.addBody(filetobyte(file));
	}

	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String name = request.getParameter("name");
		System.out.println(name + request.getParameter("password"));
		try {
			UserManager umg = UserManager.getSingleton();
			User user = umg.SelectSql(name);
			if (user != null)
				if (user.getPassword().equalsIgnoreCase(
						request.getParameter("password"))) {

					Session a = sessions.getSession(sessionid);
					a.setAttribute("name", request.getParameter("name"));// 发送数据，改变登录状态

					Action action = new indexAction();
					action.doGet(request, response, sessions,
							request.getParameter("name"), sessionid);
				} else// 密码不正确
				{
					response.addrequest("HTTP/1.0", 200, "OK");
					response.addHeader("MIME-version", "1.0");
					response.addHeader("Content-Type",
							"text/html;charset=utf-8");
					File file = new File("web\\Load.html");
					int leng = (int) file.length();
					response.addHeader("Content-Length", leng);
					response.sendHeader();
					response.addBody(filetobyte(file));
				}
			else// 查无此人请注册
			{
				response.addrequest("HTTP/1.0", 200, "OK");
				response.addHeader("MIME-version", "1.0");
				response.addHeader("Content-Type", "text/html;charset=utf-8");
				File file = new File("web\\LoginUp.html");
				int leng = (int) file.length();
				response.addHeader("Content-Length", leng);
				response.sendHeader();
				response.addBody(filetobyte(file));
			}

		} catch (Exception e) {// 登录失败，重新登录
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

}
