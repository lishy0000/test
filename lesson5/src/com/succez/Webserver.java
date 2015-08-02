package com.succez;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Webserver {
	public static void main(String args[]) {
		int i = 1, PORT = 8080;
		ServerSocket server = null;
		Socket client = null;
		try {
			Map<String, Action> actions = new HashMap<String, Action>(10);
			LoginUpAction loginaction = new LoginUpAction();
			actions.put(loginaction.getUri(), loginaction);
			errorAction erroraction = new errorAction();
			actions.put(erroraction.getUri(), erroraction);
			LoadAction loadaction = new LoadAction();
			actions.put(loadaction.getUri(), loadaction);
			ChangeAction ChangeAction = new ChangeAction();
			actions.put(ChangeAction.getUri(), ChangeAction);
			indexAction indexAction = new indexAction();
			actions.put(indexAction.getUri(), indexAction);
			LoginOutAction LoginOutAction = new LoginOutAction();
			actions.put(LoginOutAction.getUri(), LoginOutAction);
			PrintAction PrintAction = new PrintAction();
			actions.put(PrintAction.getUri(), PrintAction);
			DropAction DropAction = new DropAction();
			actions.put(DropAction.getUri(), DropAction);

			server = new ServerSocket(PORT);
			System.out.println("Web Server is listening on port "
					+ server.getLocalPort());
			System.out.println(server.toString());
			SessionManage sessions = new SessionManage();
			ExecutorService threadPool = Executors.newFixedThreadPool(25);
			for (;;) {
				client = server.accept(); // 接受客户机的连接请求
				threadPool.execute(new ConnectionThread(client, actions,
						sessions));
				System.out.println("i的值为" + i);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}