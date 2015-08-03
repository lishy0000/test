package com.succez;

import java.util.HashMap;
import java.util.UUID;

import com.Action.Tool;

public class SessionManage extends Tool {

	private static HashMap<String, Session> sessions = new HashMap<String, Session>(
			100);

	public String execute(RequestImpl request, ResponseImpl response,
			SessionManage sessions) {
		// request cookie
		if (request.getHeader("Cookie") != null
				&& request.getHeader("Cookie").indexOf("sessionid") >= 0) {
			String k = request.getHeader("Cookie");
			k = k.substring(k.indexOf("sessionid"));
			String t = k.substring(10);
			Session a=sessions.getSession(t);
			if(a==null)
			sessions.getMp().put(t, sessions.createSession(request, t));
			return t;
		} else {
			String k = UUID.randomUUID().toString();
			sessions.getMp().put(k, sessions.createSession(request, k));
			String tk = "sessionid=".concat(k);
			// if(request.getParameter("Cookie").indexOf(sessionid)>0)
			response.addHeader("Set-Cookie",tk);
			return k;
		}

	}

	public Session createSession(RequestImpl request, String sessionid) {
		synchronized (Session.class) {
			Session ab = new Session();
			return ab;
		}
	}

	public Session getSession(String sessionid) {
		Session sessins = sessions.get(sessionid);
		return sessins;
	}

	public void dropSession(String sessionid) {
		sessions.remove(sessionid);

	}

	public HashMap<String, Session> getMp() {
		return sessions;
	}

}
