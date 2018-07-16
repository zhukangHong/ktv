package com.kb;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;





public class QuerySinger implements Action {
	private String song_name;
	static List<String> songlist = new ArrayList<String>();

	

	public static void setSonglist(List<String> songlist) {
		QuerySinger.songlist = songlist;
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

	public String execute(HttpServletRequest res, HttpServletResponse req) {
		  Session session = null;
		  List<Song> list=null;
			try {
			
				session = HibTool.getSession();
				session.beginTransaction();
				Query query=session.createQuery(" from Singer ");					
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
				System.out.println(songlist);
				res.setAttribute("songlist1", list);
				
			}
					return "/¸èÃûµã¸è.jsp";
	}

	
	public static List<Singer> getAllSinger(HttpServletRequest res, HttpServletResponse req) {
		  Session session = null;
		  List<Singer> list=null;
			try {
			
				session = HibTool.getSession();
				session.beginTransaction();
				Query query=session.createQuery(" from Singer");					
					list=null;		
				 list=query.list();		
				
				 for(Iterator<Singer>iterator=list.iterator();iterator.hasNext();){
					 Singer singer=(Singer)iterator.next();
						System.out.println(singer.getSinger_name());	
						System.out.println(singer.getId());						
				 }
					
				session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally {
				HibTool.closeSession(session);
				
				res.setAttribute("singerlist", list);
				
			}
					return list;
	}

	
	 
}
