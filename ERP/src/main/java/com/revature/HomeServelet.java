package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		float amount = Float.parseFloat(request.getParameter("amount"));
		String comment  = request.getParameter("comment");
		int id = (int) session.getAttribute("id");
		
		CRUD crud = new CRUD();
		crud.CreateReq(id, amount, 2, comment);
		request.getRequestDispatcher("employee.html").forward(request, response);
	}

}
