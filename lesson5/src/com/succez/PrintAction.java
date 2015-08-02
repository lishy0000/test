package com.succez;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class PrintAction extends AllAction implements Action {
	public String getUri() {
		return "web/Print.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter,String sessionid) throws Exception {
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		new Print();

		int leng = (int) Print.Printm().length();
		response.addHeader("Content-Length", leng);
		response.addBody(Print.Printm());
	}

}