package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	static String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
	static String user = "postgres";
	static String pass = "pgAdmin";

	public void CreateReq(int _empID, float _amount, int _status, String _comment)
	{
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, user, pass))
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("insert into reimbursements (employee_id, amount, status_id, comments) values"
					+ "("+_empID+","+ _amount+","+_status+",'"+_comment+"')");
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdatePend(int _id, int _status)
	{
		int id = _id;
		int status = _status;
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, user, pass))
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("update reimbursements set status_id = "+status+" where id ="+id);
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdatePass(int _id, String _password)
	{
		int id = _id;
		String password = _password;
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try(Connection connection = DriverManager.getConnection(url, user, pass))
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("update employees set password = '"+password+"' where id ="+id);
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
