package com.succez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;

public class RequestImpl implements Request {
	private String inps;
	private InputStream is;
	private String uri;
	private String getBody;
	private HashMap<String, String> headlist;
	private HashMap<String, String> parameterlist;

	public RequestImpl(Socket client) throws IOException {
		// 将请求转换为字符串
		this.is = client.getInputStream();
		int size = is.available();
		byte[] b = new byte[size];
		is.read(b);
		String inpis = new String(b);
		inps = URLDecoder.decode(inpis, "utf-8");
		System.out.println(inps);
		String f = inps.substring(inps.indexOf(' ') + 1);
		f = f.substring(0, f.indexOf(' '));
		try {
			if (f.charAt(0) == '/') {
				if (f.indexOf('?') != -1)
					f = f.substring(1, f.indexOf('?'));
				else
					f = f.substring(1);
				if (f.equals(""))
					f = "index.html";
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		this.uri = f;
		this.getBody = getBody();
		this.headlist = getheadlist();
		this.parameterlist = parameterlist();
	}

	private HashMap<String, String> parameterlist() {
		// 暂时用不到
		return null;
	}

	private HashMap<String, String> getheadlist() {
		//暂时用不到
		return null;
	}

	public InputStream getStream() {
		return is;
	}

	public String getUri() {

		return uri;

	}

	public String getMethod() {
		if ("GET".equalsIgnoreCase(inps.substring(0, 3)))
			return "GET";
		else if ("POST".equalsIgnoreCase(inps.substring(0, 4)))
			return "POST";
		else
			return "服务器未认知的请求方式";
	}

	public String getHost() {
		return getHeader("Host");

	}

	public List<String> getHeaders() {
		List<String> list = new ArrayList<String>();
		String f = inps;
		String k;
		while (f.length() > 2 && f.indexOf("\r\n") != -1) {
			f = f.substring(f.indexOf("\r\n") + 1);
			k = f.substring(0, f.indexOf(':'));
			list.add(k);
		}
		return list;

	}

	public String getHeader(String key) {

		String f = inps;
		if (f.indexOf(key) != -1) {
			f = f.substring(f.indexOf(key) + key.length() + 1);
			f = f.substring(0, f.indexOf("\r\n"));
			return f;
		} else
			return null;

	}

	public String getBody() {
		String f = inps;
		if ("GET".equalsIgnoreCase(inps.substring(0, 3))) {
			f = inps.substring(inps.indexOf(' ') + 1);
			f = f.substring(0, f.indexOf(' '));
			if (f.indexOf('?') != -1)
				f = f.substring(f.indexOf('?') + 1);
			else
				f = "";
			return f;
		} else if ("POST".equalsIgnoreCase(inps.substring(0, 4))) {
			f = f.substring(f.indexOf("\r\n\r\n") + 4);
			return f;
		} else
			return "";

	}

	public String getVersion() {
		String f = inps.substring(inps.indexOf(' ') + 1);
		f = f.substring(f.indexOf(' ') + 1);

		return f;
	}

	public String getParameter(String key) {

		String f = getBody;
		if (f.indexOf(key) == -1)
			return null;
		f = f.substring(f.indexOf(key) + key.length() + 1);
		if (f.indexOf("&") > 0) {
			f = f.substring(0, f.indexOf("&"));
			return f;
		} else
			return f;
	}

	void seturi(String uri) {
		this.uri = uri;
	}

	@Override
	public List<String> getParameters() {
		List<String> list = new ArrayList<String>();
		String k = getBody;
		String f;
		while (k.indexOf("&") != -1) {
			f = k.substring(0, k.indexOf("=") + 1);
			list.add(f);
			k = k.substring(k.indexOf("&"));
		}
		return list;
	}

}
