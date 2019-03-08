package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee 
{
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	public String password;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Employee (String Email) 
	{
		
		String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
		String username = "postgres";
		String pass = "pgAdmin";
		
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, username, pass)){
			Statement statement =  connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from employees where email = '" + Email + "'");
			
			while(rs.next())
			{
				id = rs.getInt("id");
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				email = rs.getString("email");
				password = rs.getString("password");
				rs.close();
				
				System.out.println(id+", "+first_name+", "+last_name+", "+email+", "+ password);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public Employee() 
	{
		String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
		String username = "postgres";
		String pass = "pgAdmin";
		
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, username, pass))
		{
			Statement statement =  connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from employees");
			
			while(rs.next())
			{
				int id_ = rs.getInt("id");
				String fname_ = rs.getString("first_name");
				String lname_ = rs.getString("last_name");
				String email_ = rs.getString("email");
				Employee emp = new Employee(id_, fname_, lname_, email_);
				employees.add(emp);
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Employee (int _id, String _fname, String _lname, String _email)
	{
		id = _id;
		first_name = _fname;
		last_name = _lname;
		email = _email;
	}
	
	public Employee (int _id, String _fname, String _lname, String _email, String _password)
	{
		id = _id;
		first_name = _fname;
		last_name = _lname;
		email = _email;
		password = _password;
	}
	
	public List<Employee> getEmpList()
	{
		return employees;
	}
}
