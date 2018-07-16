package com.kb;


import java.util.Set;


public class Singer {

	private String singer_name;
	
	private int id;
	
	private Set<Song>songs;
	
	private String pingyin;
	
	public String getPingyin() {
		return pingyin;
	}

	public void setPingyin(String pingyin) {
		this.pingyin = pingyin;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

	public Set<Song> getSongs() {
		return songs;
	}


	
}
