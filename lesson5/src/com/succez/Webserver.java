package com.succez;

import java.net.*;

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
			for (;;) {
				client = server.accept(); // 接受客户机的连接请求
				new ConnectionThread(client, i).start();
				System.out.println("i的值为"+i);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

/* ConnnectionThread类完成与一个Web浏览器的通信 */
