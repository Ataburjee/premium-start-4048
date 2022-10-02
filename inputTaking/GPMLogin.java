package com.masai.inputTaking;

import java.util.Scanner;

import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public class GPMLogin {
	static int fid;
	public static boolean main(String[] args) {
		boolean s = false;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your userId !");
		int uid = sc.nextInt();
		
		System.out.println("Enter your password !");
		String pass = sc.next();
		
		BDOProject login = new ProjectImpl();
		
		try {
			fid = uid;
			s= login.GPMLoginCred(uid, pass);
			//login.isTrue();
			
		} catch (ProjectException e) {
			
			System.out.println(e.getMessage());
			
		} catch (GPMException e) {
			
			System.out.println(e.getMessage());
		}
		return s;
	}

}

