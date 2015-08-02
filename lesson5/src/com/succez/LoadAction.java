package com.succez;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

public class LoadAction extends AllAction implements Action {

	@Override
	public String getUri() {

		return "Load.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter,String sessionid) throws Exception {
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Load.html");
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.addBody(filetobyte(file));
	}

	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String name = request.getParameter("name");
		System.out.println(name + request.getParameter("password"));
		try {
			User user = SelectSql(name);
			if (user != null)
				if (user.getPassword().equalsIgnoreCase(
						request.getParameter("password"))) {
					
						
						String k = UUID.randomUUID().toString();
						sessions.getMp().put(k,
								sessions.createSession(request, k));
						String tk = "sessionid=".concat(k);
						// if(request.getParameter("Cookie").indexOf(sessionid)>0)
						response.addHeader("Set-Cookie", tk);
						

					
				
					
					Session a = sessions.getSession(k);
					a.setAttribute("name", request.getParameter("name"));// 发送数据，改变登录状态

					Action action = new indexAction();
					action.doGet(request, response, sessions,
							request.getParameter("name"), sessionid);
				} else// 密码不正确
				{

					response.addHeader("MIME-version", "1.0");
					response.addHeader("Content-Type",
							"text/html;charset=utf-8");
					File file = new File("web\\Load.html");
					int leng = (int) file.length();
					response.addHeader("Content-Length", leng);
					response.addBody(filetobyte(file));
				}
			else// 查无此人请注册
			{

				response.addHeader("MIME-version", "1.0");
				response.addHeader("Content-Type", "text/html;charset=utf-8");
				File file = new File("web\\LoginUp.html");
				int leng = (int) file.length();
				response.addHeader("Content-Length", leng);
				response.addBody(filetobyte(file));
			}

		} catch (Exception e) {// 登录失败，重新登录

			response.addHeader("MIME-version", "1.0");
			response.addHeader("Content-Type", "text/html;charset=utf-8");
			File file = new File("web\\Load.html");
			int leng = (int) file.length();
			response.addHeader("Content-Length", leng);
			response.addBody(filetobyte(file));

		}

	}

}
