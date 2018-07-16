package com.kb;



public class Song {
		private String song_name;
		
		private Singer singer_name;
		
		private String pingyin;
		
		private int id;
		
		private String type;
		
		public String getSong_name() {
			return song_name;
		}
		public void setSong_name(String song_name) {
			this.song_name = song_name;
		}
		
		public Singer getSinger_name() {
			return singer_name;
		}
		public void setSinger_name(Singer singer_name) {
			this.singer_name = singer_name;
		}
		public String getPingyin() {
			return pingyin;
		}
		public void setPingyin(String pingyin) {
			this.pingyin = pingyin;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

		
}
