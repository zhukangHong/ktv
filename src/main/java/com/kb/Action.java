package com.kb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface Action {
	public String execute(HttpServletRequest res,HttpServletResponse req);
	
}
