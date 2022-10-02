package com.masai.inputTaking;

import java.util.Scanner;

import com.masai.bean.Project;
import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;

public class ProjectsInputTaking {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the project name..");
		String pname = sc.nextLine();
		
		System.out.println("Enter the project duration..");
		String dura = sc.nextLine();
		
		System.out.println("Enter the project budget..");
		int bud = sc.nextInt();
		
		System.out.println("Enter the year of the project..");
		int year = sc.nextInt();
		
		Project pr = new Project();
		pr.setPname(pname);
		pr.setPduration(dura);
		pr.setBudget(bud);
		pr.setPyear(year);
		
		BDOProject bdo = new ProjectImpl();
		String finalBdo = bdo.allocateProjects(pr);
		

		System.out.println(finalBdo);
		
		//sc.close();
		
	}

}
