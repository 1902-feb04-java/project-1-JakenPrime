package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee 
{
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	public String password;
	
	public Employee (String Email) 
	{
		
		String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
		String username = "postgres";
		String pass = "pgAdmin";
		
		try(Connection connection = DriverManager.getConnection(url, username, pass)){
			Statement statement =  connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from managers where email = 'mhawk@company.com'");
			
			while(rs.next())
			{
				id = rs.getInt("id");
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				email = rs.getString("email");
				pass = rs.getString("password");
				rs.close();
				
				System.out.println(id+", "+first_name+", "+last_name+", "+email+", "+pass);
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
}
