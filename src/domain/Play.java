package domain;

public class Play {
	private int playid;
	private String playname;
	private  String  director;
	private String actor;
	private String playtype;
	private String country;
	private String  language;
	private int duration;
	private String introduction;
	private String picture;
	
	public Play() {
		super();
		
	}
	public Play(int playid, String playname, String director, String actor, String playtype, String country,
			String language, int duration, String introduction,String picture) {
		super();
		this.playid = playid;
		this.playname = playname;
		this.director = director;
		this.actor = actor;
		this.playtype = playtype;
		this.country = country;
		this.language = language;
		this.duration = duration;
		this.introduction = introduction;
		this.picture=picture;
	}
	
	public Play(int playid, String playname, String director, String actor, String playtype, String country,
			String language, int duration, String introduction) {
		super();
		this.playid = playid;
		this.playname = playname;
		this.director = director;
		this.actor = actor;
		this.playtype = playtype;
		this.country = country;
		this.language = language;
		this.duration = duration;
		this.introduction = introduction;
	}
	
	public Play( String playname, String director, String actor, String playtype, String country,
			String language, int duration, String introduction) {
		super();
		
		this.playname = playname;
		this.director = director;
		this.actor = actor;
		this.playtype = playtype;
		this.country = country;
		this.language = language;
		this.duration = duration;
		this.introduction = introduction;
	}
	public int getPlayid() {
		return playid;
	}
	public void setPlayid(int playid) {
		this.playid = playid;
	}
	public String getPlayname() {
		return playname;
	}
	public void setPlayname(String playname) {
		this.playname = playname;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPlaytype() {
		return playtype;
	}
	public void setPlaytype(String playtype) {
		this.playtype = playtype;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		  this.language = language;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
	
	

}
