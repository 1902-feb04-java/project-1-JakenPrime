package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Requests {
	int id;
	String name;
	float amount;
	String comment;
	String status;
	int statusID;
	List<Requests> requestList = new ArrayList<Requests>();
	
	public Requests(int stat)
	{
		String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
		String user = "postgres";
		String pass = "pgAdmin";
		
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, user, pass))
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery
					("select  res.id, emp.first_name || ' ' || emp.last_name as \"Name\", "
							+ "res.amount, res.comments, res.status_id from reimbursements as res "
							+ "join employees as emp on res.employee_id = emp.id where status_id = " + stat);
			while(rs.next()) 
			{
				int int_ = rs.getInt("id");
				String name_ = rs.getString("Name");
				float amount_ = rs.getFloat("amount");
				String comment_ = rs.getString("comments");
				statusID = rs.getInt("status_id");
				String status_ = null;
				switch(statusID)
				{
				case 1:status_="Approved";break;
				case 2:status_="Pending";break;
				case 3:status_="Denied";break;
				}
				Requests req = new Requests(int_,name_,amount_,comment_,status_);
				requestList.add(req);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Requests(int stat, boolean stat2)
	{
		String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
		String user = "postgres";
		String pass = "pgAdmin";
		
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, user, pass))
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery
					("select  res.id, emp.first_name || ' ' || emp.last_name as \"Name\", "
							+ "res.amount, res.comments, res.status_id from reimbursements as res "
							+ "join employees as emp on res.employee_id = emp.id where status_id != " + stat);
			while(rs.next()) 
			{
				int int_ = rs.getInt("id");
				String name_ = rs.getString("Name");
				float amount_ = rs.getFloat("amount");
				String comment_ = rs.getString("comments");
				statusID = rs.getInt("status_id");
				String status_ = null;
				switch(statusID)
				{
				case 1:status_="Approved";break;
				case 2:status_="Pending";break;
				case 3:status_="Denied";break;
				}
				Requests req = new Requests(int_,name_,amount_,comment_,status_);
				requestList.add(req);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Requests(int _id, String _name, float _amount, String _comment, String _status)
	{
		id = _id;
		name = _name;
		amount = _amount;
		comment = _comment;
		status = _status;
	}
	
	public List<Requests> getReqList(){
		return requestList;
	}
}
