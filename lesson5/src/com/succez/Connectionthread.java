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
	public static long beginTime;
	 public static long overTime = 3 * 1000;
	public ConnectionThread(Socket cl, int c) {
		 beginTime = System.currentTimeMillis();
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
			BufferedReader instream = null;
			instream = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			
			try {
				while(true){
					
					if((client.getInputStream().toString()!=null)){
						PrintStream outstream = null;
						outstream = new PrintStream(client.getOutputStream());
						
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

							}
						
						} else
							resp.respon("no found");
						outstream.flush();
					}
				try{
				 long nowTime = System.currentTimeMillis();
				if(requ.getHeader("Connection:").contains("close")||((nowTime - beginTime) > overTime)) break;
					}catch (Exception e) {
						
					}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				
				
				client.close();
			}
		} catch (Exception e) {
			System.out.println("未知错误:" + e);
		}
		
	}

}