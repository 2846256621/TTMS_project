package domain;

public class Seat {
	
	private int seatid;
	private int seatrow;
	private int seatcol;
	private int seatstatus;
	private int studioid;
	
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Seat(int seatrow, int seatcol, int status, int studioid) {
		super();
		this.seatrow = seatrow;
		this.seatcol = seatcol;
		this.seatstatus = status;
		this.studioid = studioid;
	}


	public int getSeatid() {
		return seatid;
	}
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
	public int getSeatrow() {
		return seatrow;
	}
	public void setSeatrow(int seatrow) {
		this.seatrow = seatrow;
	}
	public int getSeatcol() {
		return seatcol;
	}
	public void setSeatcol(int seatcol) {
		this.seatcol = seatcol;
	}
	public int getSeatstatus() {
		return seatstatus;
	}
	public void setSeatstatus(int status) {
		this.seatstatus = status;
	}
	public int getStudioid() {
		return studioid;
	}
	public void setStudioid(int studioid) {
		this.studioid = studioid;
	}
	
	

}
