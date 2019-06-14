package domain;

//数据库里存的订单内容
public class Ticket {
	
	private  int  orderid;
	private int   playid;
	private int   utid;
	private int userid;
	private int studioid;
	private int scheduleid;
	private int  allprice;
	private String ordertime;
	private int order_status;
	
	public Ticket() {
		super();
	
	}

	
	public Ticket(int playid, int utid, int userid, int studioid, int scheduleid, int allprice, String ordertime,
			int order_status) {
		super();
		this.playid = playid;
		this.utid = utid;
		this.userid = userid;
		this.studioid = studioid;
		this.scheduleid = scheduleid;
		this.allprice = allprice;
		this.ordertime = ordertime;
		this.order_status = order_status;
	}


	public Ticket(int orderid, int playid, int utid, int userid, int studioid, int scheduleid, int allprice,
			String ordertime, int order_status) {
		super();
		this.orderid = orderid;
		this.playid = playid;
		this.utid = utid;
		this.userid = userid;
		this.studioid = studioid;
		this.scheduleid = scheduleid;
		this.allprice = allprice;
		this.ordertime = ordertime;
		this.order_status = order_status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getPlayid() {
		return playid;
	}

	public void setPlayid(int playid) {
		this.playid = playid;
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

	public int getStudioid() {
		return studioid;
	}

	public void setStudioid(int studioid) {
		this.studioid = studioid;
	}

	public int getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}

	public int getAllprice() {
		return allprice;
	}

	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	
	
	
	
	
	
 
}
