package com.kb;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;







public class QuerySinger_Song  implements Action {
	private String singer_name;
	static List<String> songlist = new ArrayList<String>();
	
	

	public static void setSonglist(List<String> songlist) {
		QuerySinger_Song.songlist = songlist;
	}

	public static List<String> getSonglist() {
		return songlist;
	}

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

	
	
	
	
	public String execute(HttpServletRequest res, HttpServletResponse req) {
		  Session session = null;
		  List<Singer> singerlist=null;
		  Set<Song> songset=null;
			try {
			singer_name=res.getParameter("singer_name");				
				session = HibTool.getSession();
				session.beginTransaction();
				System.out.println(singer_name);
				 singer_name = new String(singer_name.getBytes("iso-8859-1"),"UTF-8");
				Query query=session.createQuery(" from Singer where singer_name like ?0").setParameter(0, singer_name+"%");
				singerlist=null;		
				singerlist=query.list();
				 
				/* 
				 for(Iterator<Singer>iterator=list.iterator();iterator.hasNext();){
						Singer singer=(Singer)iterator.next();
						System.out.println("∏Ë ÷√˚◊÷"+singer.getSinger_name());	
						//System.out.println(singer);						
						
				}
				 */
				 
				 Singer singer=session.load(Singer.class,singerlist.get(0).getId());				 
				  songset=singer.getSongs();
			for(Iterator<Song>iterator=songset.iterator();iterator.hasNext();){
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
				List<Song> songlist = new ArrayList<Song>(songset);
				res.setAttribute("songlist1", songlist);
				
			}
					return "/list.jsp";
	}
	
	
	 
}
