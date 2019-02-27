package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD 
{
	static String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
	static String username = "postgres";
	static String password = "pgAdmin";
	
	public static void main(String[] args) 
	{
//		InsertInto("Steven", "Smith", "ssmith@company.com", "stevesmith12345");
		
	}
	
//	public static void InsertInto(String fname, String lname, String email, String pass) 
//	{
//		try(Connection connection = DriverManager.getConnection(url, username, password))
//		{
//			Statement statement = connection.prepareStatement("insert into managers(first_name, last_name, email, password) values (?, ?, ?, ?)");
//			statement.addBatch(fname, lname, email, pass);
//			ResultSet rs = statement.executeQuery(statement);
//			
//			System.out.println(rs.rowInserted());
//			rs.close();
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//	}

}
