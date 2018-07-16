package com.kb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Queryservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String currenURI=req.getRequestURI();
		System.out.println("currenURI="+currenURI);
		String path=currenURI.substring(currenURI.indexOf("/"));
		path=path.substring(0,path.indexOf("."));
		String forwardPath = "";
		System.out.println(path);
	
		if ("/ktv/Query".equals(path)) {
			Action action = new QueryAction();
			
			//·µ»Ølist.jsp songlist<String>
			
			forwardPath = action.execute(req, res);
			System.out.println("forwardPath="+forwardPath);
			
		//	req.setAttribute("songlist", QueryAction.getSonglist());			
			req.getRequestDispatcher("list.jsp").forward(req, res);
		}else if ("/ktv/QuerySinger_Song".equals(path)) {
			Action action = new QuerySinger_Song();
		
			forwardPath = action.execute(req, res);
			System.out.println("forwardPath1="+forwardPath);			
		//	req.setAttribute("songlist", QueryAction.getSonglist());			
			req.getRequestDispatcher("list.jsp").forward(req, res);
			
		}else if ("/ktv/Q".equals(path)) {
			Action action = new QuerySong2();
		
			forwardPath = action.execute(req, res);
			System.out.println("forwardPath2="+forwardPath);			
		//	req.setAttribute("songlist", QueryAction.getSonglist());			
			req.getRequestDispatcher("list.jsp").forward(req, res);
			
		}
		
		
	}

}
