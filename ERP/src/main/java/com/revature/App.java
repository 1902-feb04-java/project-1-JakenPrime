package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:postgresql://localhost:5432:reimbursement_portal";
        String username = "postgres";
        String password = "pgAdmin";
                
        try(Connection connection = DriverManager.getConnection(url, username, password))
        {
        	Statement statement = connection.createStatement();
        	ResultSet rs = statement.executeQuery("select * from managers");
        	while(rs.next())
        	{
        		System.out.println(rs.getString("id"));
        		System.out.println(rs.getString("first_name"));
        		System.out.println(rs.getString("last_name"));      		
        	}
        	rs.close();
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
    }
}
