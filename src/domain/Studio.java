package domain;

public class Studio {
	
	private int studioid    ; 
	private String studioname ;
	private int rowcount;
	private int colcount;
	
	
	public Studio() {
		super();
		
	}

	public Studio(int studioid, String studioname, int rowcount, int colcount) {
		super();
		this.studioid = studioid;
		this.studioname = studioname;
		this.rowcount = rowcount;
		this.colcount = colcount;
	}
	
	public Studio(String studioname, int rowcount, int colcount) {
		super();
		this.studioname = studioname;
		this.rowcount = rowcount;
		this.colcount = colcount;
	}
	
	public int getStudioid() {
		return studioid;
	}
	public void setStudioid(int studioid) {
		this.studioid = studioid;
	}
	public String getStudioname() {
		return studioname;
	}
	public void setStudioname(String studioname) {
		this.studioname = studioname;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public int getColcount() {
		return colcount;
	}
	public void setColcount(int colcount) {
		this.colcount = colcount;
	}
	
	
	
	
	
	
	

}
