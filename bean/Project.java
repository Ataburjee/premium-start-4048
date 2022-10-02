package com.masai.bean;

public class Project {

	private int pid;
	private String pname;
	private String pduration;
	private int budget;
	private int pyear;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(int pid, String pname, String pduration, int budget, int pyear) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pduration = pduration;
		this.budget = budget;
		this.pyear = pyear;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPduration() {
		return pduration;
	}

	public void setPduration(String pduration) {
		this.pduration = pduration;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getPyear() {
		return pyear;
	}

	public void setPyear(int pyear) {
		this.pyear = pyear;
	}

	@Override
	public String toString() {
		return "Project [Project id = " + pid + ", Project name = " + pname + ", Project duration = " + pduration + ", Budget = " + budget
				+ ", Year of this project = " + pyear + "]";
	}
	
	
	
}
