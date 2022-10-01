package com.webkorps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webkorps.entity.BookDetails;
import com.webkorps.model.BookDetailsModel;

@WebServlet("/SearchBookController")
public class SearchBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBookController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String bookName = req.getParameter("booktosearch");
		//System.out.println("---->"+bookName);
		BookDetailsModel bdm = new BookDetailsModel();
	    List<BookDetails> bookList = bdm.getSearchBook(bookName);
		HttpSession session=req.getSession();
		
		if(bookList!=null && bookList.size()>0) {
			session.setAttribute("searchedBook", bookList);
			resp.sendRedirect("searchedBook.jsp");
		}
		else {
		  session.setAttribute("errorMsg", "Book not found");
		  resp.sendRedirect("clientDashBoard.jsp");
		}
		
	}

}
