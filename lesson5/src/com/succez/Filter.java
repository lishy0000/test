package com.succez;


public class Filter {
	String filter=null;
	void dofilter(RequestImpl request, ResponseImpl response,SessionManage sessions, String sessionid){
		try{
			if(!request.getUri().endsWith("LoginUp.html"))
			{
			
		Session a=sessions.getSession(sessionid);
		this.filter= (String) a.getAttribute("name");
		if(filter==null)request.seturi("Load.html");
			}
		}catch(Exception e){
			request.seturi("Load.html");
		}
		
		
	}
	
}
