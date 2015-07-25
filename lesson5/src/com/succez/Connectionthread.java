package com.succez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class ConnectionThread extends Thread {
	public Socket client; // 连接Web浏览器的socket字
	public int counter; // 计数器

	public ConnectionThread(Socket cl, int c) {
		client = cl;
		counter = c;
	}

	public void run() // 线程体
	{
		try {
			String destIP = client.getInetAddress().toString(); // 客户机IP地址
			int destport = client.getPort(); // 客户机端口号
			System.out.println("Connection " + counter + ":connected to "
					+ destIP + " on port " + destport + ".");
			PrintStream outstream = null;
			outstream = new PrintStream(client.getOutputStream());
			BufferedReader instream = null;
			instream = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			try {
				RequestImpl requ = new RequestImpl(instream); // 读取Web浏览器提交的请求信息
				ResponseImpl resp = new ResponseImpl(outstream);
				if (requ.inps != null)
					if (requ.getMethod().equalsIgnoreCase("GET")) { // 如果是GET请求
						String filename = requ.getUri();
						File file = new File(filename);
						System.out.println(filename + " requested.");
						if (file.exists()) {
							// 若文件存在，则将文件送给Web浏览器
							// 若果目标是目录则发送目录
							try {
								resp.respon(file);
							} catch (FileNotFoundException e) {
								resp.respon("error");
								System.out.println("zheli meiyou yichang ");

							}

						} else
							resp.respon("no found");
					}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (outstream != null)
					outstream.close();
				if (instream != null)
					instream.close();
				client.close();
			}
		} catch (Exception e) {
			System.out.println("未知错误:" + e);
		}
	}

}