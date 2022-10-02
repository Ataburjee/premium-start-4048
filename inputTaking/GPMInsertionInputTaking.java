package com.masai.inputTaking;

import java.util.Scanner;
import com.masai.bean.GPM;
import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public class GPMInsertionInputTaking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the GPM id..");
		int mid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the GPM name..");
		String mname = sc.nextLine();
		
		System.out.println("Enter the panchayet..");
		String pan = sc.nextLine();
		
		System.out.println("Enter the Member password..");
		String pass = sc.next();
		
		GPM g = new GPM(mid, mname, pan, pass);
		
		BDOProject bp = new ProjectImpl();
		
		try {
			System.out.println(bp.allocateGPM(g));
			
		} catch (ProjectException | GPMException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================");
		
	}

}
