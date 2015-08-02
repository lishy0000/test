package com.succez;

import javax.servlet.http.HttpSession;

public class Filter {
	String filter(RequestImpl request, ResponseImpl response,SessionManage sessions){
		try{
			String k = request.getHeader("Cookie");
			String t = k.substring(11);
			Session a=sessions.getSession(t);
			return (String) a.getAttribute("name");
		}catch(Exception e){
			return null;
		}
	}

}
