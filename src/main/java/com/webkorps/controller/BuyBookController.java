package com.webkorps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webkorps.entity.User;
import com.webkorps.model.BookDetailsModel;

@WebServlet("/BuyBookController")
public class BuyBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public BuyBookController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session= req.getSession();
		User user= (User)session.getAttribute("loggedUser");
		//System.out.println(user.getEmail());
		if(user!=null)
		{
		  String userEmail=user.getEmail();
		  Integer bid=Integer.parseInt(req.getParameter("id"));
		   //System.out.println(bid);
		  BookDetailsModel bdm=new BookDetailsModel();
		  if(bdm.buyBooks(userEmail, bid)) {
		   session.setAttribute("ordersuccMsg","Book Buyed Successfully");
		   resp.sendRedirect("clientDashBoard.jsp");
		  }else {
			session.setAttribute("orderfailMsg", "unable to Buy Book");
			resp.sendRedirect("clientDashBoard.jsp");
		  }
		}
		else {
			resp.sendRedirect("login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
