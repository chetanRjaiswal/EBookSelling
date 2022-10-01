package com.webkorps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webkorps.entity.User;
import com.webkorps.model.UserModel;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserModel um = new UserModel();
		User user=um.loginUser(email,	 password);
		HttpSession session=request.getSession();
		if(user!=null) {
			if(user.getRole().equalsIgnoreCase("client")) {
			session.setAttribute("loggedUser",user);
			response.sendRedirect("clientDashBoard.jsp");
			}
			else{
				session.setAttribute("loggedAdmin",user);
				response.sendRedirect("adminDashBoard.jsp");
			}
		}
		else{
			session.setAttribute("errorMsg","Invalid Email or password");
			response.sendRedirect("login.jsp");
		}
		
	}

}
