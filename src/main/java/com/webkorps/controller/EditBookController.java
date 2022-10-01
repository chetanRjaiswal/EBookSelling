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
import com.webkorps.model.BookDetailsModel;

@WebServlet("/EditBookController")
@MultipartConfig
public class EditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public EditBookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer id=Integer.parseInt(req.getParameter("id"));
		String bookName=req.getParameter("bname");
		String author= req.getParameter("author");
		String price=req.getParameter("price");
	    String status= req.getParameter("status");
//		Part part1=req.getPart("bimg");
//		String imgName= part1.getSubmittedFileName();
//		Part part2 = req.getPart("bpdf");
//		String pdfName=part2.getSubmittedFileName();
		
		BookDetails b=new BookDetails();
		b.setBookName(bookName);
		b.setAuthor(author);
		b.setPrice(price);
		b.setStatus(status);
//		b.setImg(imgName);
//		b.setPdf(pdfName);
		b.setEmail("admin");
		
	    BookDetailsModel bdm= new BookDetailsModel();
	    Boolean flag=bdm.updateBookById(id, b);
	    HttpSession session=req.getSession();
	    if(flag)
	    {
//		String path=getServletContext().getRealPath("")+"BookImgPdf";
//		System.out.println(path);
//		File f = new File(path);
//		part1.write(path+File.separator+imgName);
//		part2.write(path+File.separator+pdfName);
//		
		session.setAttribute("successMsg","Book Updated successfully");
		resp.sendRedirect("viewBooks.jsp");
	    }
	    else {
	    session.setAttribute("errorMsg", "Unable to Updated Book");
	    resp.sendRedirect("editBook.jsp");
	    }
		
	}

}
