package com.masai.inputTaking;

import java.util.Scanner;

import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.ProjectException;

public class BDOLogin {

	public static boolean main(String[] args) {
		boolean s = false;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username !");
		String uname = sc.next();
		
		System.out.println("Enter your password !");
		String pass = sc.next();
		
		BDOProject login = new ProjectImpl();
		
		try {
			s= login.BDOLoginCred(uname, pass);
			//login.isTrue();
			
		} catch (ProjectException e) {
			
			e.printStackTrace();
		}
		return s;
	}

}
