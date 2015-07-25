package com.succez;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class ResponseImpl {
	PrintStream outs;

	public ResponseImpl(PrintStream outstream) {
		this.outs = outstream;

	}

	public void addrequest(String key, int status, String value) {
		outs.println(key + "" + status + "" + value);

	}

	public void addHeader(String key, String value) {
		outs.println(key + ":" + value);

	}

	public void addHeader(String key, int value) {
		outs.println(key + ":" + value);

	}

	public void addBody(String body) {
		outs.println(body);

	}

	public void addBOdy(byte[] body) {
		outs.println(body);
	}

	void sendfile(File file)throws FileNotFoundException {
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int len = (int) file.length();
			byte buf[] = new byte[len];
			try {
				in.readFully(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outs.write(buf, 0, len);
			outs.flush();
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		

	public void sendfile(String printstring)throws FileNotFoundException {
		outs.println(printstring);
	}

	void respon(File file) throws FileNotFoundException {
		String[] fileNames = file.list();
		if (fileNames == null) {
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addrequest("HTTP/1.0", 200, "OK");
			addHeader("MIME_version", "1.0");
			addHeader("Content_Type", "text/html");
			int len = (int) file.length();
			addHeader("Content_Length", len);
			outs.println("");
			System.out.println(file.getName() + "文件" + file.length());
			sendfile(file); // 如果目标是文件则发送文
		} else {
			addrequest("HTTP/1.0", 200, "OK");
			addHeader("MIME-version", "1.0");
			addHeader("Content-Type", "text/html;charset=utf-8");
			new Print(file);
			try {
				addHeader("Content-Length", Print.m().length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outs.println("");
			System.out.println(file.getName() + "目录");
			try {
				sendfile(Print.m());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 若果目标是目录则发送目录
		}
		outs.flush();
	}

	void respon(String k) throws IOException {
		File file1 = new File("error.html");
		System.out.println(k);		
		addrequest("HTTP/1.0", 404, "OK");
		addHeader("MIME-version", "1.0");
		addHeader("Content-Type", "text/html;charset=utf-8");
		int len = (int) file1.length();
		addHeader("Content-Length", len+6);
		outs.println("");
		sendfile(file1); // 发送文件
		outs.flush();
	}
}
