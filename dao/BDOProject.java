package com.masai.dao;

import java.util.List;

import com.masai.bean.GPM;
import com.masai.bean.Project;
import com.masai.bean.Worker;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public interface BDOProject {
	
	public boolean BDOLoginCred(String username, String password) throws ProjectException;
	
	public String allocateProjects(Project project);

	public List<Project> getAllProject() throws ProjectException;
	
//	public String allocateGPM(int mid, String mname, String panchayet, String password) 
//			throws ProjectException, GPMException;
	
	public String allocateGPM(GPM gpm) throws ProjectException, GPMException;
	
	public List<GPM> getAllGPM() throws GPMException;
	
	public boolean GPMLoginCred(int userId, String password) throws ProjectException, GPMException;
	
	public String assignEmployeeToProject(Worker worker);
	
	public List<Worker> getAllEmployee() throws EmployeeException;
	
	public List<Worker> getAllEmployeeById(int id) throws EmployeeException;
	
	//public void panchayetwiseTotaldaysAndWages(int id);
	
}
