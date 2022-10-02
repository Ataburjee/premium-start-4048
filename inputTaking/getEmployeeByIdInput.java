package com.masai.inputTaking;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Worker;
import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.EmployeeException;

public class getEmployeeByIdInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id");
		int id = sc.nextInt();
		
		BDOProject b = new ProjectImpl();
		try {
			List<Worker> list =b.getAllEmployeeById(id);
			list.forEach(s->{
			     System.out.println("Name : "+s.getWname());
			     System.out.println("ID is : "+s.getWid());
			     System.out.println("Wages : "+s.getWages());
			     System.out.println("Total day worked : "+s.getDay_worked());
			     System.out.println("Project Id : "+s.getPid());
			     System.out.println("========================================");
			});
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
