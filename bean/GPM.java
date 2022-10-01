package com.masai.bean;

public class GPM {

	private int mid;
	private String mname;
	private String panchayet;
	private String password;
	
	public GPM() {
		// TODO Auto-generated constructor stub
	}

	public GPM(int mid, String mname, String panchayet, String password) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.panchayet = panchayet;
		this.password = password;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPanchayet() {
		return panchayet;
	}

	public void setPanchayet(String panchayet) {
		this.panchayet = panchayet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GPM [Member id = " + mid + ", Member name = " + mname + ", Panchayet name = " + panchayet + ", password = " + password + "]";
	}
	
	 
	
}
