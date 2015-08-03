package com.Action;
import com.succez.*;
public class PrintAction extends AllAction implements Action {
	public String getUri() {
		return "web/Print.html";
	}

	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter,String sessionid) throws Exception {
		response.addrequest("HTTP/1.0", 200, "OK");
		response.addHeader("MIME-version", "1.0");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		new Print();

		int leng = (int) Print.Printm().length();
		response.addHeader("Content-Length", leng);
		response.sendHeader();
		response.addBody(Print.Printm());
	}

}