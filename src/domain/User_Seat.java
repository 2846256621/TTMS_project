package domain;

public class User_Seat {
	private int utid;
	private int userid;
	private String seatid;
	private int studioid;
	
	
	public User_Seat() {
		super();
	}
	
	public User_Seat(int utid, int userid, String seatid, int studioid) {
		super();
		this.utid = utid;
		this.userid = userid;
		this.seatid = seatid;
		this.studioid = studioid;
	}
	

	public User_Seat( int userid, String seatid, int studioid) {
		super();
		this.userid = userid;
		this.seatid = seatid;
		this.studioid = studioid; 
	}
	public int getUtid() {
		return utid;
	}
	public void setUtid(int utid) {
		this.utid = utid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSeatid() {
		return seatid;
	}
	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}
	public int getStudioid() {
		return studioid;
	}
	public void setStudioid(int studioid) {
		this.studioid = studioid;
	}

}
