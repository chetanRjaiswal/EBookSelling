package com.webkorps.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webkorps.entity.User;
import com.webkorps.model.UserModel;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String role=request.getParameter("role");
		String password=request.getParameter("password");

		//matching email pattern
		Pattern mail=Pattern.compile("@gmail.com");
		Matcher match=mail.matcher(email);

		HttpSession session= request.getSession();
		//System.out.println("name------"+name);
		if(name!="" && email!="" && role!="" && password !="" )
		{
			if(match.find())
			{
				User user=new User();
				user.setName(name);
				user.setEmail(email);
				user.setRole(role);
				user.setPassword(password);

				UserModel um = new UserModel();
				Boolean flag = um.registerUser(user);

				if(flag) {
					session.setAttribute("successMsg","Registered Successfully");
					response.sendRedirect("login.jsp");
				}else {
					session.setAttribute("errorMsg","Email already exist or try again");
					response.sendRedirect("register.jsp");
				}
			}
			else
			{
				session.setAttribute("errorMsg","Enter Valid Email");
				response.sendRedirect("register.jsp");	
			}
		}
		else {
			session.setAttribute("errorMsg","Please fill out each fields");
			response.sendRedirect("register.jsp");
		}
	}

}
