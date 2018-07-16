package com.kb.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAction implements Action {

	public String excute(HttpServletRequest res, HttpServletResponse req) {
		System.out.println("---------add----------");
		return "adduser.jsp";
	}

}
