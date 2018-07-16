package com.kb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class ExportDB {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Singer singer=new Singer();
		singer.setPingyin("DPN");
		singer.setSinger_name("戴佩妮");	
		session.save(singer);
		
		Song song = new Song();
		song.setPingyin("NYDA");
		song.setSinger_name(singer);
		song.setSong_name("你要的爱");
		song.setType("中文");
		session.save(song);
		
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();

		}






	
	public static void insert_song(String singer_name,String singer_py,String song_py,String song_name,String song_type) {
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Singer singer=new Singer();
		singer.setPingyin(singer_py);
		singer.setSinger_name(singer_name);	
		
		Query query=session.createQuery(" from Singer where singer_name = ?0 ").setParameter(0,singer_name);					
		List<Singer> list=null;		
	 list=query.list();
	 

			if (list.isEmpty()) {
				session.save(singer);
				System.out.println("list空\n");
			}else{
			session.get(Singer.class,singer.getId());			
			//session.update(singer);						
			};
			
		
		Song song = new Song();
		song.setPingyin(song_py);
		song.setSinger_name(singer);
		song.setSong_name(song_name);
		song.setType(song_type);
		session.save(song);
		
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();

		}


	public static void insert_singer(String singer_name,String singer_py) {
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Singer singer=new Singer();
		singer.setPingyin(singer_py);
		singer.setSinger_name(singer_name);	
		session.save(singer);

		session.getTransaction().commit();
		session.close();
		sf.close();

		}




}
