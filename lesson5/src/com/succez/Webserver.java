package com.succez;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Webserver {
	public static void main(String args[]) {
		int i = 1, PORT = 8080;
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Web Server is listening on port "
					+ server.getLocalPort());
			System.out.println(server.toString());
			ExecutorService threadPool = Executors.newFixedThreadPool(2);  
			for (;;) {
				client = server.accept(); // 接受客户机的连接请求
				threadPool.execute(new ConnectionThread(client,i));
				System.out.println("i的值为"+i);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}