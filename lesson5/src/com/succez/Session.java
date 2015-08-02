package com.succez;

import java.util.HashMap;

public class Session {
	private HashMap<String, String> session;
	public Session(){
		this.session = new HashMap<String, String>(1);
	}
	public void setAttribute(String string, String parameter) {
		session.put(string, parameter);
	}

	public void removeAttribute(String string) {
		
		session.remove(string);
	}

	public String getAttribute(String string) {
		return session.get(string);
	}
	

}
