package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	static String url = "jdbc:postgresql://localhost:5432/reimbursement_portal?currentSchema=reimbursements";
	static String username = "postgres";
	static String password = "pgAdmin";

	public static void main(String[] args) {

	}

	public String Search(String email) {
		String returnString = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement statement = connection.prepareStatement("select * from managers where email = '?'");
			statement.setNString(1, (email));
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				returnString = rs.getString("id");
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnString;

	}

}
