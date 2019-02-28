package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    CRUD crud = new CRUD();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init()
	{
		System.out.println("servlet on");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		PrintWriter out = response.getWriter();

		if(email == null)
		{
			email = request.getParameter("email");
			String password = request.getParameter("password");
			session.setAttribute("email", email);
		}
		out.println(crud.Search(email));
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
