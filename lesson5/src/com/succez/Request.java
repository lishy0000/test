package com.succez;

import java.util.List;


public interface Request {

	public String getUri();
	public String getMethod();
	public String getVersion();
	
	public List<String> getHeaders();
	
	public String getHeader(String key);
	
	public List<String> getParameters();
	public String getParameter(String key);
}
