package com.Action;

import java.io.File;
import com.succez.*;

public class errorAction extends AllAction implements Action {

	@Override
	public String getUri() {

		return "web/error.html";
	}

	@Override
	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {

		File file1 = new File("web\\error.html");

		response.addrequest("HTTP/1.0", 404, "OK");
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		int leng = (int) file1.length();
		response.addHeader("Content-Length", leng);
		response.sendHeader();
		response.addBody(filetobyte(file1)); // 发送文件

		response.GetPrintStream().flush();
	}

	@Override
	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		;
	}

}
