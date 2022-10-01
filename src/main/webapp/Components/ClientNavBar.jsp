<%@page import="com.webkorps.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      
	<a class="navbar-brand"
		style="margin-right: 50px; margin-left: 50px;"
		href="clientDashBoard.jsp">Home</a>
		
		<% 
		 //System.out.print(session.getAttribute("loggedUser"));	
		 User user=(User) session.getAttribute("loggedUser");
		 
		%>
		
 	 <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<form class="form-inline my-2 my-lg-0" action="SearchBookController" method="post">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Enter Book Name" aria-label="Search" name="booktosearch">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
				style="color: white;">Search</button>
		</form>
	 </div>
	 <%
	 if(session.getAttribute("loggedUser")!=null)
	 {
	 %>
	<a class="navbar-brand"
		style="margin-right: 500px; margin-left: 50px;"
		href="GetBuyBookController?uemail=<%=user.getEmail()%>"><button class="btn btn-outline-success my-2 my-sm-0" 
				style="color: white;">view buyed Books</button></a>
	<a class="navbar-brand"
		style="margin-right: 5px; margin-left: 5px;"
		href="#"><button class="btn btn-outline-success my-2 my-sm-0" 
				style="color: white;"><%=user.getEmail()%></button></a>
	
	<%} %>		
	<a class="navbar-brand"
		style="margin-right: 5px; margin-left: 5px;"
		href="ClientLogoutController">Logout</a>
		
</nav>

</body>
</html>