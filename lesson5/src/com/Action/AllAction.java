package com.Action;

import com.succez.*;
import java.io.File;

public class AllAction extends Tool implements Action {// 没有自己特定的uri时，访问文件系统
	public void doGet(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)
			throws Exception {
		String filename = request.getUri();
		filename = roadtoroad(filename);
		File file = new File(filename);
		String[] fileNames = file.list();
		response.addrequest("HTTP/1.0", 200, "OK");
		response.addHeader("MIME-version", "1.0");
		if (fileNames == null) {
			if (file.getName().endsWith("txt"))// 响应txt文件代表着其他常用类文件的响应，每种文件
				// 都有自己的"Content-Type"
				response.addHeader("Content-Type", "text/plain");
			else if (filename.endsWith("png")) // 响应非txt文件
				response.addHeader("Content-Type", "image/png"); // 如果目标是png图片则发送文
			else if (filename.endsWith("html"))
				response.addHeader("Content-Type", "text/html"); // 如果目标是png图片则发送文
			else {
			}
			int leng = (int) file.length();
			response.addHeader("Content-Length", leng);
			response.sendHeader();
			response.addBody(filetobyte(file));
		} else {// 响应文件夹
			response.addHeader("Content-Type", "text/html;charset=utf-8");
			new Print(file);
			int leng = (int) Print.m(file).length();
			response.addHeader("Content-Length", leng);
			response.sendHeader();
			response.addBody(Print.m(file));
		}

	}

	@Override
	public void doPost(RequestImpl request, ResponseImpl response,
			SessionManage sessions, String fiter, String sessionid)// 暂时不知道怎么处理
			throws Exception {
		;
	}

	@Override
	public String getUri() {
		return null;
	}

}
