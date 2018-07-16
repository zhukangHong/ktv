package com.kb;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;





public class QueryAction implements Action {
	private String song_name;
	static List<String> songlist = new ArrayList<String>();
	private int songid;

	

	public static void setSonglist(List<String> songlist) {
		QueryAction.songlist = songlist;
	}

	public static List<String> getSonglist() {
		return songlist;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	
	
	public static boolean isNumeric(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	}
	

	public String execute(HttpServletRequest res, HttpServletResponse req) {
		  Session session = null;
		  List<Song> list=null;
			try {
			song_name=	res.getParameter("song_name");			
			if (isNumeric(song_name)) {
				songid=Integer.parseInt(song_name) ;
			}else {
				songid=0;
			}

				session = HibTool.getSession();
				session.beginTransaction();
				System.out.println(song_name);
				
				Query query=session.createQuery(" from Song where pingyin like ?0 or id like ?1")
						.setParameter(0, song_name+"%").setParameter(1, songid);
				
			/*	Query query=session.createQuery(" from Song where  id like ?0")
						.setParameter(0, Integer.parseInt(song_name));
				*/
					list=null;		
				 list=query.list();
				
			for(Iterator<Song>iterator=list.iterator();iterator.hasNext();){
					Song song=(Song)iterator.next();
					System.out.println(song.getSong_name());	
					System.out.println(song.getId());						
					
			}
					
					
				session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally {
				HibTool.closeSession(session);
			
				res.setAttribute("songlist1", list);
				
			}
					return "/list.jsp";
	}
	
	
	 
}
