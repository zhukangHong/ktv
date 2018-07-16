package com.kb;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;





public class SelectAction implements Action {
	private String song_name;
	static List<String> songlist = new ArrayList<String>();

	
	
	public static void rmSong(String song) {
		song=song.trim();
		System.out.println("歌名:"+song);
		System.out.println("歌名index:"+songlist.indexOf(song));
		System.out.println("list:"+songlist);		
		songlist.remove(songlist.indexOf(song));
	}
	
	

	public static void setSonglist(List<String> songlist) {
		SelectAction.songlist = songlist;
	}

	public static List<String> getSonglist() {
		return songlist;
	/*	List<String> songlist7 = new ArrayList<String>();
		songlist7.add("成功");
		return songlist7;
		*/
		
	}
	
	public static void setSong(String song) {
		if (!song.equals("null")) {
			song=song.trim();
			songlist.add(song) ;
		}
		
	}
	
	public static void ClearSong() {
		songlist.clear();
	}
	
	
	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String execute(HttpServletRequest res, HttpServletResponse req) {
		
				res.setAttribute("songlist1", songlist);
				
			
					return "/选择点歌.jsp";
	}
	
	
	 
}
