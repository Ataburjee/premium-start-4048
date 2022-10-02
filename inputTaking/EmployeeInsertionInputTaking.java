package com.masai.inputTaking;

import java.util.Scanner;

import com.masai.bean.GPM;
import com.masai.bean.Worker;
import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public class EmployeeInsertionInputTaking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Employee name..");
		String wname = sc.nextLine();
		
		System.out.println("Enter the Employee wages..");
		int wages = sc.nextInt();
		
		System.out.println("Enter the total days worked by the employee..");
		int totalDay = sc.nextInt();
		
		System.out.println("Enter the project id..");
		int pid = sc.nextInt();
		
		Worker w = new Worker();
		w.setWname(wname);
		w.setWages(wages);
		w.setDay_worked(totalDay);
		w.setPid(pid);
		
		BDOProject bp = new ProjectImpl();
		
		System.out.println(bp.assignEmployeeToProject(w));
		
		System.out.println("===========================================");
	
	}

}
