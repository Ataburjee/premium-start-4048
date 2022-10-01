package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.GPM;
import com.masai.bean.Project;
import com.masai.bean.Worker;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;
import com.masai.connection.DBConn;
import com.mysql.cj.xdevapi.Result;

public class ProjectImpl implements BDOProject{

	@Override
	public String allocateProjects(Project project) {
		
		String projects = "No project available..";
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = 
					conn.prepareStatement("insert into BDO_project(pname, pduration, budget, pyear) "
							+ "values (?,?,?,?)");
			ps.setString(1, project.getPname());
			ps.setString(2, project.getPduration());
			ps.setInt(3, project.getBudget());
			ps.setInt(4, project.getPyear());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				projects = "New project updated successfully";
			}
			
		} catch (SQLException e) {
			projects = e.getMessage();
		}
		
		return projects;
	}

	boolean flag = false;
	@Override
	public boolean BDOLoginCred(String username, String password) throws ProjectException {
        boolean login = false;
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps =
					conn.prepareStatement("select * from BDOLogin where usename=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("WOHOO ! Login Successfully Mr/Mrs. " + username);
				login = true;
			}
			else {
				throw new ProjectException("Invalid username or password !");
			}
			
			
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
		
		return login;
	}
	@Override
	public List<Project> getAllProject() throws ProjectException {
		List<Project> list = new ArrayList<>();
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from BDO_Project");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("pid");
				String name = rs.getString("pname");
				String pdura = rs.getString("pduration");
				int bud = rs.getInt("budget");
				int year = rs.getInt("pyear");
				
				Project project = new Project(id, name, pdura, bud, year);
				list.add(project);
				
			}
			
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
		
		return list;
	}
	@Override
	public String allocateGPM(GPM gpm) throws ProjectException, GPMException {
		
        String gpmreturn = "Id is not available on BDO...!";
	    
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from BDO_Project where pid=?");
			ps.setInt(1, gpm.getMid());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("insert into GPM values (?, ?, ?, ?)");
				
				ps2.setInt(1, gpm.getMid());
				ps2.setString(2, gpm.getMname());
				ps2.setString(3, gpm.getPanchayet());
				ps2.setString(4, gpm.getPassword());
				
				int x = ps2.executeUpdate();
				
				if(x>0) {
					gpmreturn = "GPM(Gram Panchayet Member) updated succssfully .";
				}
				else
					throw new GPMException("Not updated...!");
				
			}
			
		} catch (Exception e) {
			throw new ProjectException("GPM id " + gpm.getMid() + " already exist...!");
		}
		
		
		return gpmreturn;
	}
	@Override
	public List<GPM> getAllGPM() throws GPMException {
		
        List<GPM> list = new ArrayList<>();
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from GPM");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("mid");
				String name = rs.getString("mname");
				String pan = rs.getString("panchayet");
				String pass = rs.getString("password");
				
				GPM gpm = new GPM(id, name, pan, pass);
				list.add(gpm);
				
			}
			
		} catch (Exception e) {
			throw new GPMException(e.getMessage());
		}
		
		return list;
	}
	
	int getProjectId;
	@Override
	public boolean GPMLoginCred(int userId, String password) throws GPMException,ProjectException {

		 boolean login = false;
			
			try(Connection conn = DBConn.provideConnection()) {
				
				PreparedStatement ps =
						conn.prepareStatement("select * from GPM where mid=? and password=?");
				
				ps.setInt(1, userId);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					System.out.println("WOHOO ! Login Successfully ");
					login = true;
				}
				else {
					throw new ProjectException("Invalid username or password !");
				}
				
				
			} catch (Exception e) {
				throw new GPMException(e.getMessage());
			}
			
			return (login);
			
	}
	@Override
	public String assignEmployeeToProject(Worker worker) {
		String workers = "No project available..";
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = 
					conn.prepareStatement("insert into worker(wname, wages,day_worked,pid) "
							+ "values (?,?,?,?)");
			ps.setString(1, worker.getWname());
			ps.setInt(2, worker.getWages());
			ps.setInt(3, worker.getDay_worked());
			ps.setInt(4, worker.getPid());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				workers = "New employee updated successfully";
			}
			
		} catch (SQLException e) {
			workers = e.getMessage();
		}
		
		return workers;
	}
	
	@Override
	public List<Worker> getAllEmployee() throws EmployeeException {
		List<Worker> list = new ArrayList<>();
		
		try(Connection conn = DBConn.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from worker");
//			ps.setInt(1, getId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				int id = rs.getInt("wid");
				String name = rs.getString("wname");
				int wages = rs.getInt("wages");
				int totalDays = rs.getInt("day_worked");
				int pid = rs.getInt("pid");
				
				Worker wor = new Worker(id, name, wages, totalDays, pid);
				
				list.add(wor);
				
			}
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return list;
	}
	
	
}
