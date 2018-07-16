package com.kb;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;





public class QuerySong2 implements Action {
	private String song_name;
	static List<Song> songlist ;

	

	public static void setSonglist(List<Song> songlist) {
		QuerySong2.songlist = songlist;
	}

	public static List<Song> getSonglist() {
		return songlist;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String execute(HttpServletRequest res, HttpServletResponse req) {		 
			try {
				
			Song song=new Song();	
			String str=res.getParameter("name");			
			str = new String(str.getBytes("iso-8859-1"),"UTF-8");
			System.out.println("Ω”+ ‰£∫"+str);
			song.setSong_name(str);
			songlist= new ArrayList<Song>();
			songlist.add(song);
			
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
		
				res.setAttribute("songlist1", songlist);
				
			}
					return "/list.jsp";
	}

	
	 
}
