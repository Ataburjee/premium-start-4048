package com.masai.bean;

public class Worker {

	private int wid;
	private String wname;
	private int wages;
	private int day_worked;
	private int pid;
	
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}


	public Worker(int wid, String wname, int wages, int day_worked, int pid) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.wages = wages;
		this.day_worked = day_worked;
		this.pid = pid;
	}


	public int getWid() {
		return wid;
	}


	public void setWid(int wid) {
		this.wid = wid;
	}


	public String getWname() {
		return wname;
	}


	public void setWname(String wname) {
		this.wname = wname;
	}


	public int getWages() {
		return wages;
	}


	public void setWages(int wages) {
		this.wages = wages;
	}


	public int getDay_worked() {
		return day_worked;
	}


	public void setDay_worked(int day_worked) {
		this.day_worked = day_worked;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	@Override
	public String toString() {
		return "worker [wid=" + wid + ", wname=" + wname + ", wages=" + wages + ", day_worked=" + day_worked + ", pid="
				+ pid + "]";
	}
	
	
}
