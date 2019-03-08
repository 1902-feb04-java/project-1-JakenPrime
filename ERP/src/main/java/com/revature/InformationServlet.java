package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		String fname = (String) session.getAttribute("first_name");
		String lname = (String) session.getAttribute("last_name");
		int id = (int)session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		String password = (String)session.getAttribute("password");
		
		Employee emp = new Employee(id,fname,lname,email,password);
		
		String json = new Gson().toJson(emp);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		String password = request.getParameter("password");
		session.setAttribute("password", password);
		int id = (int)session.getAttribute("id");
		
		CRUD crud = new CRUD();
		crud.UpdatePass(id, password);
		request.getRequestDispatcher("employee.html").forward(request, response);
		
	}

}
