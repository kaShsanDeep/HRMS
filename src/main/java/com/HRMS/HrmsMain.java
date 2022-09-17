package com.HRMS;

import java.util.Scanner;

public class HrmsMain {

	public static void main(String[] args)  throws Exception {
				Scanner sc = new Scanner(System.in);         			//Scanner object created.
				HRMSdao hrd = new HRMSdao();									//HRMSDao method created.
				hrd.connect();											
				employee emp = new employee();							//emp object created using employee class.
				System.out.println("**** Welcome to Human resource managemet system  ****");
				
				System.out.println(" Press 1 : add Employee \n Press 2 : increase Salary of the Employee \n Press 3 : Remove an Employee \n ");
				int sk = sc.nextInt();
			switch (sk) {	
				//using switch for choosing   cases
				case 1 -> {		
					//New employee details adding here.
					System.out.println("Enter the details of New wmployee");
					System.out.println("Enter  Employee Name:-");
				    emp.eName = sc.next();
					System.out.println("Enter Phone number:-");
					emp.ePhone = sc.next();
					System.out.println("Enter Salary:-");
					emp.eSalary = sc.nextInt();
					System.out.println("Enter location:-");
					emp.eLocation = sc.next();
					System.out.println("Enter  Designation:-");
					emp.eDesignation = sc.next();
					
					
					
					int var1 = hrd.newEmployee(emp);   //calling newEmployee methodss
					if (var1 == 1)
						System.out.println("Employee added Successfully.");
					//Checking if employee already exist in the company.
					else
						System.out.println("Employee already exist");
							}
				
				
				 case 2 -> {												// hike to the employee.
					int amount, id;
					//Employee id as input.
					System.out.print("Enter Employee Id:-");
					id = sc.nextInt();					
					 
					
					System.out.print("Enter percentage(%) to give salary hike:-");
					amount = sc.nextInt();	
					
					
					int var3 = hrd.increaseSalary(id, amount);     //increaseSalary method is called here. 
				       
					if (var3 == 1)
						System.out.println("salary is increased.");
					
					//checking if employee exist in the company.
					
					else
						System.out.println("Employee does not exist.");
				 		}
				 
				 
				case 3 ->{		
					//Removing employee from the database.
					int eid;
					System.out.print("Enter Employee Id:-");
					eid = sc.nextInt();	
					
					
					int var4 = hrd.removeEmployee(eid);		
					
					if (var4==1)
						System.out.println("Employee removed successfully.");
					//checking whether employee exist in the company or not.
					else
						System.out.println("Employee doesn't exist");
						}

						}
				sc.close();	//Scanner object closed.
				}
		}
	
	
	
	
	
	
	
	
