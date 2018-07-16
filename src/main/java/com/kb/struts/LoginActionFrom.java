package com.kb.struts;

import org.apache.struts.action.ActionForm;

public class LoginActionFrom extends ActionForm {
	private String username;
	private String password;
	private String song_name;
	private String singer_name;
	private String singer_py;
	
	
	public String getSinger_py() {
		return singer_py;
	}
	public void setSinger_py(String singer_py) {
		this.singer_py = singer_py;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
