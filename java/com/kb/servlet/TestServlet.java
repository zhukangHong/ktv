package com.kb.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String currenURI=req.getRequestURI();
		System.out.println("currenURI="+currenURI);
		String path=currenURI.substring(currenURI.indexOf("/"));
		path=path.substring(0,path.indexOf("."));
		
		System.out.println(path);
		String forwardPath="";
		if (path.equals("/WebMaven/query")) {
			Action queryAction=new QueryAction();
			forwardPath= queryAction.excute(req, res);
		}
		else if (path.equals("/WebMaven/adduser")){
			Action addAction=new AddAction();
			forwardPath= addAction.excute(req, res);
		}
		req.getRequestDispatcher(forwardPath).forward(req, res);
	}

}
