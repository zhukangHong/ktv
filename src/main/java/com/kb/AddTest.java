package com.kb;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kb.hibernate.User;

import junit.framework.TestCase;

public class AddTest extends TestCase {
		
	public void testSave(){
	
		
Configuration cfg=new Configuration().configure();
		
		//创建sessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=null;
		try {
			session=factory.openSession();
			//开启事务
			 session.beginTransaction();
			 
			 
			 Singer singer=new Singer();
			 
			//singer=(Singer) session.get(Singer.class, 8);
				singer.setSinger_name("linkin park");	
				singer.setPingyin("Linkin Park");			
				session.save(singer);
				
			 
			 
			 Song song=new Song();
				song.setSong_name("numb");
				song.setSinger_name(singer);
				song.setPingyin("numb");
				song.setType("英文");
				session.save(song);
				
				
				
				
				
			//提交事务
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			if (session!=null) {
				if (session.isOpen()) {
					session.close();

				}
			}
		
		}
		
		
	
	}
	
	
	public void testUpdate(){		
			
	Configuration cfg=new Configuration().configure();
			
			//创建sessionFactory
			SessionFactory factory=cfg.buildSessionFactory();
			
			Session session=null;
			try {
				session=factory.openSession();
				//开启事务
				 session.beginTransaction();
				 
				 
				 Singer singer=new Singer();
					singer.setSinger_name("陈学冬");	
					singer.setPingyin("CXD");			
					singer=	(Singer) session.get(Singer.class, 4);
					singer.setPingyin("CXD");
				 
				
				 Song song=new Song();
					song.setSong_name("不再见");
					song.setSinger_name(singer);
					song.setPingyin("BZJ");
					song.setType("中文");
					session.save(song);
					
				
					
					
					
				//提交事务
				session.getTransaction().commit();
				
				
			} catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			}finally {
				if (session!=null) {
					if (session.isOpen()) {
						session.close();

					}
				}
			
			}
			
			
		
		}
		
	
	public void testL1(){		
		
		Configuration cfg=new Configuration().configure();
				
				//创建sessionFactory
				SessionFactory factory=cfg.buildSessionFactory();
				
				  Session session = null;
				  List<Singer> list=null;
				  Set<Song> songset=null;
				try {
					session=factory.openSession();
					//开启事务
					 session.beginTransaction();
				String	 singer_name="周杰伦";
					 
					 Query query=session.createQuery(" from Singer where singer_name like ?0")
								.setParameter(0, singer_name+"%");
							list=null;		
						 list=query.list();
						 
						 
						 for(Iterator<Singer>iterator=list.iterator();iterator.hasNext();){
								Singer singer=(Singer)iterator.next();
								System.out.println("歌手名字"+singer.getSinger_name());	
								//System.out.println(singer);						
								
						}
						 
						 
						 Singer singer=session.load(Singer.class,8);				 
						  songset=singer.getSongs();
					for(Iterator<Song>iterator=songset.iterator();iterator.hasNext();){
							Song song=(Song)iterator.next();
							System.out.println(song.getSong_name());	
							System.out.println(song.getId());						
							
					}
							
					 
					 
					 
					 
					
					
						
						
						
					//提交事务
					session.getTransaction().commit();
					
					
				} catch (Exception e) {
					session.getTransaction().rollback();
					e.printStackTrace();
				}finally {
					if (session!=null) {
						if (session.isOpen()) {
							session.close();

						}
					}
				
				}
				
				
			
			}
			
	
	
	
	
	
	
}
