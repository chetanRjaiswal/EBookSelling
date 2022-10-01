package com.webkorps.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.webkorps.entity.BookDetails;
import com.webkorps.entity.User;
import com.webkorps.model.BookDetailsModel;

@WebServlet("/AddBookController")
@MultipartConfig
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookName=req.getParameter("bname");
		String author= req.getParameter("author");
		String price=req.getParameter("price");
		Part part1=req.getPart("bimg");	
		String fileName=part1.getSubmittedFileName();
		Part part2=req.getPart("bpdf");
		String pdfName=part2.getSubmittedFileName(); 
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("loggedAdmin");

		if((!(bookName.equals("")) && !(author.equals("")) && !(price.equals(""))))
		{

			BookDetails b=new BookDetails(bookName, author, price,fileName, pdfName, user.getEmail());

			BookDetailsModel bdm=new BookDetailsModel();
			boolean flag=bdm.addBook(b);


			if(flag) {
				//System.out.println("book added");
				String path=getServletContext().getRealPath("")+"BookImgPdf";
				File f=new File(path);
				part1.write(path+File.separator +fileName);
				part2.write(path+File.separator+pdfName);

				session.setAttribute("successMsg","Book added Successfully");
				resp.sendRedirect("addBooks.jsp");
			}
			else {
				session.setAttribute("errorMsg","unable to add book");
				resp.sendRedirect("addBooks.jsp");
			}
		}	
		else {
			session.setAttribute("errorMsg","Please Enter Book Details");
			resp.sendRedirect("addBooks.jsp");
		}
	}

}
