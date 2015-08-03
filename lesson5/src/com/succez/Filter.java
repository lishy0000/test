package com.succez;


public class Filter {
	String filter;
	void dofilter(RequestImpl request, ResponseImpl response,SessionManage sessions){
		try{
			String k = request.getHeader("Cookie");
			k = k.substring(k.indexOf("sessionid"));
			String t = k.substring(11);
		Session a=sessions.getSession(t);
		this.filter= (String) a.getAttribute("name");
		if(filter==null)request.seturi("Load.html");
		}catch(Exception e){
			request.seturi("Load.html");
		}
		
	}
	
}
