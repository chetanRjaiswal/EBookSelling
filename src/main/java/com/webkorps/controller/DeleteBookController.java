package com.webkorps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webkorps.model.BookDetailsModel;


@WebServlet("/DeleteBookController")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBookController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id= Integer.parseInt(req.getParameter("id"));
		BookDetailsModel bdm=new BookDetailsModel();
		Boolean flag=bdm.deleteBookById(id);
		HttpSession session=req.getSession();
		if(flag) {
			session.setAttribute("successMsg", "Book Deleted Successfully");
			resp.sendRedirect("viewBooks.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Unable to Delete Book");
			resp.sendRedirect("viewBooks.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
