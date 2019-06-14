package domain;

public class Manager {
	private String managername;
	private String managerpassword;
	public Manager() {
		super();
	}
	
	
	public Manager(String managername, String managerpassword) {
		super();
		this.managername = managername;
		this.managerpassword = managerpassword;
	}
	
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerpassword() {
		return managerpassword;
	}
	public void setManagerpassword(String managerpassword) {
		this.managerpassword = managerpassword;
	}
	

	

}
