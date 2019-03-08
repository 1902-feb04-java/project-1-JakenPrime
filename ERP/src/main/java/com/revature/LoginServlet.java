package com.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("servlet started");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = null;
		String password = null;

		email = request.getParameter("email");
		password = request.getParameter("password");
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		Employee emp = new Employee(email);
		
		session.setAttribute("first_name",emp.first_name);
		session.setAttribute("last_name", emp.last_name);
		session.setAttribute("id", emp.id);

		
		if (password.equals(emp.password)) {
			request.getRequestDispatcher("employee.html").forward(request, response);
		} else if (password.equals("")) {
			response.sendRedirect("http://localhost:8080/ERP/");
			session.invalidate();
		} else if (password.equals(emp.password) == false) {
			response.sendRedirect("http://localhost:8080/ERP/");
			session.invalidate();
		}
		
	}

}
