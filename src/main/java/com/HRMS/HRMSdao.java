package com.HRMS;
import java.sql.*;

public class HRMSdao {
					
		Connection con; 

		void connect() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver"); 		// Loading JDBC Driver.
			 con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/santech", "root", "111999");		//Connection established from database. 					
										}

		
		
			int newEmployee(employee obj) throws Exception {
			
			String query = "select * from employee where ePhone = ' " + obj.ePhone + " ' ";
			Statement st = con.createStatement();
			ResultSet se = st.executeQuery(query);							
			
			if (se.next()) {
				return -1;
						} 
			else {
				String query2 = ("INSERT into employee(eName,ePhone,eSalary,eLocation,eDesignation) values(?,?,?,?,?);");
				
				PreparedStatement p = con.prepareStatement(query2);
				
				p.setString(1, obj.eName);				//Inserting New employee details to the database.
				p.setString(2, obj.ePhone);
				p.setInt(3, obj.eSalary);
				p.setString(4, obj.eLocation);
				p.setString(5, obj.eDesignation);
				
				int count = p.executeUpdate();		//it will return 1 because 1 row will be updated in the database.
				return count;				//count variable is returned to main method.
					}		
			
					}

		    int removeEmployee(int eId) throws Exception {
			Statement ds = con.createStatement();
			
			//Checking whether employee details match in the database or not.
			ResultSet rs = ds.executeQuery("select * from employee where eId="+eId);
			if(rs.next()) {
				rs.close();
				
				
				
				
				Statement s = con.createStatement();
				
				//Deleting employee row from the table.
				int count = s.executeUpdate("DELETE from employee WHERE eId = "+eId);		
				return 1;
					}
				else {
				return 0;
					}
		    		}

		         	public int increaseSalary(int eId, int hike) throws Exception {
		        	 Statement st = con.createStatement();
		        	 ResultSet rs = st.executeQuery("select * from employee where eId ="+eId);
			
		        	 if(rs.next()) {
		             Statement s = con.createStatement();
					
					 
		             	int count = s.executeUpdate("update employee SET eSalary=eSalary+((eSalary*" + hike + ")/100) where eId=" + eId);
						return count;		
		        	 			}
		        	 else 
		        	 		{
		        		 return 0;
		        	 		}
		}
	}

