<%@page import="java.util.ArrayList"%>
<%@page import="com.webkorps.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.webkorps.model.BookDetailsModel"%>
<%@page import="com.webkorps.util.DataBaseUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search:Book</title>
<%@include file="Components/Css.jsp"%>
</head>
<body>
			
  <%@include file="Components/ClientNavBar.jsp" %>
	<h3 class="text-center">Client:Home</h3>
		    <%
			if (session.getAttribute("loggedUser") != null) 
			{
			%>

    	    <table class="table table-striped">
		    <thead class="p-3 mb-2 bg-info text-white">

			    <%
		     	if (session.getAttribute("successMsg") != null) {
		    	%><span style="color: green; text-align: center;"><%=session.getAttribute("successMsg")%></span>
			   <%
			    }
			    session.removeAttribute("successMsg");
			    %>

			    <%
			    if (session.getAttribute("errorMsg") != null) {
			    %><span style="color: red; text-align: center;"><%=session.getAttribute("errorMsg")%></span>
			    <%
			    }
			    session.removeAttribute("errorMsg");
			    %>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Image</th>
				<!-- <th scope="col">Pdf</th>
				 -->
				<th scope="col">Action</th>

			</tr>
		</thead>
		<tbody>
			<%
			//Connection con=DataBaseUtil.getConnection();
			//String bookName= (String) session.getAttribute("searchedBook");
			BookDetailsModel bdm = new BookDetailsModel();
			//System.out.println(bookName);
			//List<BookDetails> bookList = bdm.getSearchBook(bookName);
			List<BookDetails> bookList = (ArrayList<BookDetails>)session.getAttribute("searchedBook");
			//System.out.print(bookList);
			for (BookDetails book : bookList) {
			%>
			<tr>
				<td><%=book.getbId()%></td>
				<td><%=book.getBookName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrice()%></td>
				<td><img src="BookImgPdf/<%=book.getImg()%>"
					style="width: 50px; height: 50px;"></td>
				<%-- <td><a href="BookImgPdf/<%=book.getPdf()%>" download="file"
					style="width: 50px; height: 50px;"><b> download </b></a></td> --%>
				
				<td><a href="BuyBookController?id=<%=book.getbId()%>"
					class="btn btn-sm btn-success">Buy</a></td>
			</tr>

			<%
			}
			%>
      
		</tbody>
	</table>
            <%
			 }
			%>
			
		    <%
			if (session.getAttribute("loggedUser") == null) {
			%>
			<%response.sendRedirect("login.jsp"); %>
			<%
			 }
			%>
			
		
</body>
</html>