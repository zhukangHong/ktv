package com.kb.struts;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kb.HibTool;
import com.kb.Song;

public class DelSongServ extends Action{

	private String song_name;
	


	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		LoginActionFrom laf=(LoginActionFrom)form;
		song_name=laf.getSong_name();
	
		 Session session = null;
		  List<Song> list=null;
			try {
				song_name=	new String(song_name.trim().getBytes("ISO-8859-1"), "UTF-8"); 
				session = HibTool.getSession();
				session.beginTransaction();
				System.out.println(song_name);	
				Query query=session.createQuery(" from Song where song_name = ?0 ").setParameter(0,song_name);					
				list=null;		
			 list=query.list();
			 
			 
			 
			
					Song song=(Song)list.get(0);
					System.out.println(song.getSong_name());	
					System.out.println(song.getId());	
					song = (Song)session.get(Song.class, song.getId());
					 session.delete(song);
				
				
				
				
				session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally {
				HibTool.closeSession(session);
							
				
				
			}
			
			return mapping.findForward("delsuccess");
			
			
		/*	return	mapping.findForward("delerror");*/
		
		
		
		
		
		
	}
		
}
