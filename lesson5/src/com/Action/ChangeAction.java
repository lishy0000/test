package com.Action;

import com.succez.*;

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
		String k = request.getBody();
		if (k.indexOf("name") != -1) {
			k = k.substring(k.indexOf("name") + 5);
			k = "name=".concat(k);
			response.addHeader("Set-Cookie", k);
		}
		response.addrequest("HTTP/1.0", 200, "OK");
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		File file = new File("web\\Change.html");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("${name}",request.getParameter("name"));
//		byte[] result = MacroResolver.resolve(file, options);
		int leng = (int) file.length();
		response.addHeader("Content-Length", leng);
		response.sendHeader();
		response.addBody(filetobyte(file));// 发送数据，改变sql状态

	}

	@Override
	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		try {
			UserManager umg = UserManager.getSingleton();
			boolean i = umg.SelectSql(fiter).getisAdmin();
			String k = request.getHeader("Cookie");
			if (k.indexOf("name") != -1&&k.indexOf("null")==-1) {
				k = k.substring(k.indexOf("name=") + 5);
				k = k.substring(0, k.indexOf(";"));

				User user1 = new User(k, request.getParameter("password"), umg
						.SelectSql(k).getisAdmin(),
						(int) Integer.parseInt(request.getParameter("age")),
						request.getParameter("sex"),
						request.getParameter("email"),
						(int) Integer.parseInt(request.getParameter("phone")));
				umg.modifySql(user1);
				response.addHeader("Set-Cookie","name=null");
				Action action = new PrintAction();
				action.doGet(request, response, sessions, fiter, sessionid);

			} else {

				User user1 = new User(fiter, request.getParameter("password"),
						i, (int) Integer.parseInt(request.getParameter("age")),
						request.getParameter("sex"),
						request.getParameter("email"),
						(int) Integer.parseInt(request.getParameter("phone")));
				umg.modifySql(user1);
				Action action = new indexAction();
				action.doGet(request, response, sessions, fiter, sessionid);
			}
		} catch (Exception e) {
			response.addrequest("HTTP/1.0", 200, "OK");
			response.addHeader("MIME-version", "1.0");
			response.addHeader("Content-Type", "text/html;charset=utf-8");
			File file = new File("web\\Change.html");
			int leng = (int) file.length();
			response.addHeader("Content-Length", leng);
			response.sendHeader();
			response.addBody(filetobyte(file));// 发送数据，
			// 修改失败，
		}
	}

}
