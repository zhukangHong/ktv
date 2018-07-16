package com.kb.servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface Action {
	public String excute(HttpServletRequest res,HttpServletResponse req);
	
}
