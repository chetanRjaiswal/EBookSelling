package com.webkorps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetBuyBookController")
public class GetBuyBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetBuyBookController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userEmail=req.getParameter("uemail");
		HttpSession session=req.getSession();
		session.setAttribute("userEmail", userEmail);
		resp.sendRedirect("buyedBooks.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
