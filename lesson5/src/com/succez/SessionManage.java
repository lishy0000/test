package com.succez;

import java.util.HashMap;
import java.util.UUID;

public class SessionManage extends Tool {

	private static HashMap<String, Session> sessions = new HashMap<String, Session>(
			100);

	public String execute(RequestImpl request, ResponseImpl response,
			SessionManage sessions) {
		// request cookie
		if (request.getHeader("Cookie") != null
				&& request.getHeader("Cookie").indexOf("sessionid") > 0) {
			String k = request.getHeader("Cookie");
			k = k.substring(k.indexOf("sessionid"));
			String t = k.substring(11);
			if (getSession(t) != null)
				return t;
		}

		return null;

	}

	public Session createSession(RequestImpl request, String sessionid) {
		Session ab = new Session();

		return ab;
	}

	public Session getSession(String sessionid) {
		Session sessins = sessions.get(sessionid);
		return sessins;
	}

	public void dropSession(String sessionid) {
		sessions.remove(sessionid);

	}
	public  HashMap<String, Session> getMp(){
		return sessions;
	}

}
