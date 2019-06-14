package domain;

public class Schedule {
	
	private int scheduleid;
	private  String  date;
	private int studioid;
	private int price;
	private int playid;
	private String begintime;
	private String studioname;     //数据库里没有也可以写这个变量
	private String playname;
	
	public Schedule() {
		super();
	}
	
	public Schedule(int scheduleid, String date, int studioid, int price, int playid, String begintime) {
		super();
		this.scheduleid = scheduleid;
		this.date = date;
		this.studioid = studioid;
		this.price = price;
		this.playid = playid;
		this.begintime = begintime;
	}
	 public Schedule(int scheduleid,String date, int studioid, int price, int playid) {
		
		this.date = date;
		this.studioid = studioid;
		this.price = price;
		this.playid = playid;
       }
	public Schedule(String date, int studioid, int price, int playid, String begintime) {
		
		this.date = date;
		this.studioid = studioid;
		this.price = price;
		this.playid = playid;
		this.begintime = begintime;
	}
   
	public int getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStudioid() {
		return studioid;
	}
	public void setStudioid(int studioid) {
		this.studioid = studioid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPlayid() {
		return playid;
	}
	public void setPlayid(int playid) {
		this.playid = playid;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getStudioname() {
		return studioname;
	}

	public void setStudioname(String studioName) {
		this.studioname = studioName;
	}

	public String getPlayname() {
		return playname;
	}

	public void setPlayname(String playname) {
		this.playname = playname;
	}
	
	

}
