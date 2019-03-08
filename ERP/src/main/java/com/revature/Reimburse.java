package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Reimburse 
{
	public int id;
	public float amount;
	public String status;
	public String comment;
	public boolean manager;
	public List<Reimburse> reimburseList = new ArrayList<Reimburse>();
	
	public Reimburse(int empId) 
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
					("select  res.id, res.amount, res.comments, res.status_id, "
							+ "emp.manager from reimbursements as res join employees as emp on res.employee_id = emp.id where employee_id = " + empId);
			
			while (rs.next())
			{
				int id_ = rs.getInt("id");
				float amount_ = rs.getFloat("amount");
				String comment_ = rs.getString("comments");
				int statusid_ = rs.getInt("status_id");
				String status_ = null;
				switch(rs.getInt("status_id"))
				{
				case 1:status_="Approved";break;
				case 2:status_="Pending";break;
				case 3:status_="Denied";break;
				}
				boolean manager_ = rs.getBoolean("manager");
				Reimburse rb = new Reimburse(id_, amount_, statusid_, status_, comment_, manager_);
				reimburseList.add(rb);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Reimburse(int _id, float _amount,int _statusid, String _status, String _comment, boolean _manager)
	{
		id = _id;
		amount = _amount;
		status = _status;
		comment = _comment;
		manager = _manager;
	}
	
	public List<Reimburse> getList() {
		return reimburseList;
	}
		
	
	
}
