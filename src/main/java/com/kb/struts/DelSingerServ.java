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
import com.kb.Singer;
import com.kb.Song;

public class DelSingerServ extends Action{

	private String singer_name;
	


	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		LoginActionFrom laf=(LoginActionFrom)form;
		singer_name=laf.getSinger_name();
	
		 Session session = null;
		  List<Singer> list=null;
			try {
				singer_name=new String(singer_name.trim().getBytes("ISO-8859-1"), "UTF-8"); 
				session = HibTool.getSession();
				session.beginTransaction();
				System.out.println(singer_name);	
				Query query=session.createQuery(" from Singer where singer_name = ?0 ").setParameter(0,singer_name);					
				list=null;		
			 list=query.list();
			 
			 
			 
			
					Singer singer=(Singer)list.get(0);
					System.out.println(singer.getSinger_name());	
					System.out.println(singer.getId());	
					singer = (Singer)session.get(Singer.class, singer.getId());
					 session.delete(singer);
				
				
				
				
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
