package com.succez;

import com.Action.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

class ConnectionThread extends Thread {
	public Socket client; // 连接Web浏览器的socket字
	private long beginTime;
	private Map<String, Action> actions;
	private static long OVERTIME = 20 * 10000;
	private static long maxtime;
	private SessionManage sessions;

	public ConnectionThread(Socket cl, Map<String, Action> actions,
			SessionManage sessions) {
		maxtime = 0;
		client = cl;
		this.actions = actions;
		this.sessions = sessions;
	}

	public void run() // 线程体
	{

		try {
			while (true) {

				int i = client.getInputStream().available();
				if (i == 0) {// 等待最长时间
					if (maxtime < OVERTIME * 350)
						maxtime = maxtime + 50;
					else {
						System.out.println("等待超时");
						break;
					}
					Thread.sleep(50);
				} else {
					maxtime = 0;
					beginTime = System.currentTimeMillis();// 响应开始时的时间
					RequestImpl requ = new RequestImpl(client); // 读取Web浏览器提交的请求信息
					ResponseImpl resp = new ResponseImpl(client);
					String iou = requ.getUri();
					System.out.println(iou);
					String sessionid = sessions.execute(requ, resp, sessions);
					Filter filer = new Filter();
					filer.dofilter(requ, resp, sessions);
					String fiter = filer.filter;

					Action action = actions.get(requ.getUri());
					if (action == null) {
						action = new AllAction();
					}
					try {
						if ("GET".equals(requ.getMethod())) {
							action.doGet(requ, resp, sessions, fiter, sessionid);
						} else {
							action.doPost(requ, resp, sessions, fiter,
									sessionid);
						}
					} catch (Exception e) {
						action = new errorAction();
						action.doGet(requ, resp, sessions, fiter, sessionid);
					}

					try {
						long nowTime = System.currentTimeMillis();// 处理时无响应时时间控制
						if (requ.getHeader("Connection:").contains("close")
								|| ((nowTime - beginTime) > OVERTIME))
							break;
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (Exception e) {
			System.out.println("未知错误:" + e);
		} finally {
			try {
				System.out.println("socket关闭");
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}