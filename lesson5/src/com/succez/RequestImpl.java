package com.succez;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RequestImpl {
	String inps;
	boolean limit;
	// uri 解析用到转义
	static String[] escape = { "%20", " ", "%22", "-" };

	// " - %22# - %23% - %25& - %26( - %28) - %29+ - %2B, - %2C/ - %2F: - %3A; -
	// %3B< - %3C= - %3D> - %3E? - %3F@ - %40\ - %5C| - %7C }

	public RequestImpl(BufferedReader is) throws IOException {
		// 将请求转换为字符串
		String k = is.readLine();
		StringBuilder t = new StringBuilder();

		while (k != null) {
			t.append(k);
			t.append("\n");
			if (k.toString().length() == 0) {
				System.out.println("已接受请求，处理中。。。。");
				break;
			}
			k = is.readLine();
		}
		inps = t.toString();
		if (inps.length() < 30)
			limit = false;
		else
			limit = true;

	}

	public String getUri() {
		if (!limit)
			return "错误调用";
		String f = inps.substring(inps.indexOf(' ') + 1);
		f = f.substring(0, f.indexOf(' '));
		try {
			if (f.charAt(0) == '/') {
				if (f.indexOf('?') != -1)
					f = f.substring(1, f.indexOf('?'));
				else
					f = f.substring(1);
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Exception:" + e);
		}
		for (int i = 0; i < escape.length; i += 2)
			f = f.replace(escape[i], escape[i + 1]);
		if (f.endsWith("dir.png"))
			f = "dir.png";
		if (f.endsWith("ioc.png"))
			f = "ioc.png";
		if (f.endsWith("txt.png"))
			f = "txt.png";
		if (f.equals(""))
			f = "index.html";
		return f;
	}

	public String getMethod() {
		if (!limit)
			return "错误调用";
		String f = inps.substring(0, 3);
		return f;

	}

	public String getHost() {
		if (!limit)
			return "错误调用";
		String f = inps;
		if (f.indexOf("Host:") == -1)
			return "";
		f = f.substring(f.indexOf('\n') + 1);
		f = f.substring(0, f.indexOf('\n'));
		f = f.substring(f.indexOf(' ') + 1);
		return f;
	}

	public List<String> getHeaders() {
		List<String> list = new ArrayList<String>();
		if (!limit)
			return list;
		String f = inps;
		String k;
		while (f.length() < 3 && f.indexOf('\n') != -1) {
			f = f.substring(f.indexOf('\n') + 1);
			k = f.substring(0, f.indexOf(':'));
			list.add(k);
		}
		return list;

	}

	public String getHeader(String key) {
		if (!limit)
			return "错误调用";
		String f = inps;
		f = f.substring(f.indexOf(key) + 1, f.indexOf('\n'));
		return f;

	}

	public String getBody() {
		if (!limit)
			return "错误调用";
		String f = inps.substring(inps.indexOf(' ') + 1);
		f = f.substring(0, f.indexOf(' '));

		if (f.indexOf('?') != -1)
			f = f.substring(f.indexOf('?'));
		else
			f = "";

		return f;

	}

	public void setStatus(int status) {
		String filename = getUri();
		File file = new File(filename);
		if (file.exists())
			status = 200;
		else
			status = 404;

	}
}
