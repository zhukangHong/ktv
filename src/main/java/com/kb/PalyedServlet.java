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

public class PalyedServlet implements Action{
	private String song_name;
	static List<String> songlist = new ArrayList<String>();

	
	public static List<String> removeDuplicateWithOrder(List<String> list) {    
	    Set<String> set = new HashSet<String>();    
	     List<String> newList = new ArrayList<String>();    
	   for (Iterator<String> iter = list.iterator(); iter.hasNext();) {    
		   String element = iter.next();    
	         if (set.add(element))    
	            newList.add(element);    
	      }     
	     list.clear();    
	     list.addAll(newList);    
	     return newList;
	 }   
	
	
	public static void rmSong(String song) {
		songlist.remove(songlist.indexOf(song));
	}
	public static String subhz(String str){
	  for (int index = 0;index<=str.length()-1;index++){
		   //将字符串拆开成单个的字符
		   String w=str.substring(index);
		   if((w.compareTo("\u4e00")>0&&w.compareTo("\u9fa5")<0) || (w.compareTo("\u0041")>0 && w.compareTo("\u005a")<0) || (w.compareTo("\u0061")>0 && w.compareTo("\u007a")<0)){// \u4e00-\u9fa5 中文汉字的范围
		   return w;		
		   }		   
		   }
	  return null;
	}
	public static void setSonglist(List<String> songlist) {
		SelectAction.songlist = songlist;
	}

	public static List<String> getSonglist() {
		return   removeDuplicateWithOrder(songlist);
	}
	
	public static void setSong(String song) {
		songlist.add(song) ;
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
				
			
					return "/播放点歌.jsp";
	}
	
}

