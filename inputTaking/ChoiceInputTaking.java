package com.masai.inputTaking;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.GPM;
import com.masai.bean.Project;
import com.masai.bean.Worker;
import com.masai.dao.BDOProject;
import com.masai.dao.ProjectImpl;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public class ChoiceInputTaking {

	public static void main(String[] args) {
		
		BDOProject bdo = new ProjectImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice !");
		
		System.out.println("Press 1 - BDO (Block Development Officer)");
		System.out.println("Press 2 - Gram Panchayat member");
		System.out.println("Press 3 - Exit!");
		
		int choice = sc.nextInt();
		
		if(choice == 1) {
			
			System.out.println("Please log in to your account !");
			if(BDOLogin.main(args)) {
				
				while(true) {
		
				System.out.println("1. Create a project");
				System.out.println("2. View List Of Project");
				System.out.println("3. Allocate  Project to GPM");
				System.out.println("4. View all the GPM");
				System.out.println("5. See List of Employee working on that Project and their wages");
				System.out.println("6. View List of employee by Panchayet-wise");
				System.out.println("7. View total expanditure GPM wise");
				System.out.println("8. Exit !");
				int ch = sc.nextInt();
				
				if(ch==1) {
					ProjectsInputTaking.main(args);
				}
				else if(ch==2) {
					try {
						int i=1;
						List<Project> l = bdo.getAllProject();
						
//						for(Object s:l) {
//							System.out.println(i++ + ". " + s);
//							System.out.println("=========================================================");
//						}
						
						l.forEach(s -> {
							System.out.println("Project Name : "+s.getPname());
							System.out.println("Project Id : "+s.getPid());
							System.out.println("Project Duration : "+s.getPduration());
							System.out.println("Project Budget : "+s.getBudget());
							System.out.println("================================================");
						});
						
					} catch (ProjectException e) {
						System.out.println(e.getMessage()); 
					}
				}
				else if(ch==3) {
					GPMInsertionInputTaking.main(args);
				}
				else if(ch==4) {
					try {
						int j = 1;
						List<GPM> gp = bdo.getAllGPM();
						for(GPM g:gp) {
							System.out.println(j++ + ". " + g);
							System.out.println("===========================================================");
				
						}
					} catch (GPMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(ch==5) {
					try {
						
						int j = 1;
						List<Worker> gp = bdo.getAllEmployee();
						for(Worker g:gp) {
							System.out.println(j++ + ". " + g);
							System.out.println("==========================================================");
				
						}
					} catch (EmployeeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(ch==6) {
					getEmployeeByIdInput.main(args);
				}
				else if(ch==7) {
					List<GPM> gp;
					try {
						gp = bdo.getAllGPM();
					int totalExp = 0;
					for(GPM g:gp) {
					    int mid = g.getMid();
					    int totalWages=0;
						int totalDays=0;
						int Expanditure = 0;
						String pan = g.getPanchayet();
						try {
							List<Worker> w = bdo.getAllEmployeeById(mid);
							
							for(Worker x:w) {
								totalDays += x.getDay_worked();
								totalWages += x.getWages();
								Expanditure += totalDays*totalWages;
								
							}
							
							
						} catch (EmployeeException e) {
							
							System.out.println(e.getMessage());
						}
						totalExp += Expanditure;
						System.out.println("FOR THE PANCHAYET "+pan);
						System.out.println("Expanditure for the GPM is : "+Expanditure);
						System.out.println("==============================================");
					}
					
					System.out.println("===========================================");
					
					System.out.println("The Total Expanditure is : "+totalExp);
					
					System.out.println("===========================================");
					
				} catch (GPMException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else if(ch==8) {
					break;
				}
				}
			}
		}
		
		else if(choice==2) {
			System.out.println("Please log in to your account !");
			
			if(GPMLogin.main(args)) {
				
				int t=GPMLogin.fid;
				
				while(true) {
		
				System.out.println("1. Assign Employee to a Project");
				System.out.println("2. View the Details of Employee");
				System.out.println("3. View total number of days Employee worked in That "
						+ "project and also their wages");
				System.out.println("4. Exit !");

				int ch = sc.nextInt();
				
				if(ch==1) {
					EmployeeInsertionInputTaking.main(args);		
				}
				else if(ch==2) {
					
//					2. View the Details of Employee
//					3. View total number of days Employee worked in a project and also their wages
					
					
					try {
						List<Worker> w = bdo.getAllEmployeeById(t);
						
						w.stream().forEach(s -> {
							
							System.out.println("Employee Id : "+s.getWid());
							System.out.println("Employee Name : "+s.getWname());
							System.out.println("Total worked days : "+s.getDay_worked());
							System.out.println("employee wages : "+s.getWages());
							System.out.println("Project Id : "+s.getPid());
							System.out.println("========================================");
							
						});
						
					} catch (EmployeeException e) {
						
						System.out.println(e.getMessage());
					}
					
				}
				
				else if(ch==3) {
					
					int totalWages=0;
					int totalDays=0;
					int totalExpanditure = 0;
					
					try {
						List<Worker> w = bdo.getAllEmployeeById(t);
						
						for(Worker x:w) {
							totalDays += x.getDay_worked();
							totalWages += x.getWages();
							totalExpanditure += totalDays*totalWages;
							
						}
						
						System.out.println("Total Days worked : "+totalDays);
						System.out.println("Total wages per day : "+totalWages);
						System.out.println("The Total Expanditure is : "+totalExpanditure);
						System.out.println("==============================================");
						
					} catch (EmployeeException e) {
						
						System.out.println(e.getMessage());
					}
				}
				else {
					break;
				}
				
		        }
				
			}
			
		}

		System.out.println("Thank you !");
	}
		
}
