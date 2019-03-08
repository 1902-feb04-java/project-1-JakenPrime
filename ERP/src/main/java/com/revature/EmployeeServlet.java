package com.revature;

import java.io.IOException;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public void init()
	{
		
 	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		int ID = (int) session.getAttribute("id");
		
		Reimburse reimburse = new Reimburse(ID);
		
		String json = new Gson().toJson(reimburse.getList());
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp = new Employee();
		String json = new Gson().toJson(emp.getEmpList());
		response.getWriter().write(json);
	}

}
