
<%@page import="com.webkorps.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      
	<a class="navbar-brand"
		style="margin-right: 50px; margin-left: 50px;"
		href="adminDashBoard.jsp">Home</a>
		
	
	<a class="navbar-brand"
		style="margin-right: 100px; margin-left: 50px;"
		href="addBooks.jsp">Add Book</a>
		

	<a class="navbar-brand"
		style="margin-right: 100px; margin-left: 50px;"
		href="viewBooks.jsp">View Books</a>
	
	
	<%
	 //System.out.print(session.getAttribute("loggedUser"));	
	 User user=(User) session.getAttribute("loggedAdmin");
	 if(user!=null){
	%>
	     <a class="navbar-brand"
		style="margin-right: 50px; margin-left: 400px;"
		href="#"><button class="btn btn-outline-success my-2 my-sm-0" 
				style="color: white;"><%=user.getEmail()%></button></a>
	<%}
	%>
	
	<a class="navbar-brand"
		style="margin-right: 100px; margin-left: 50px;"
		href="AdminLogout">Logout</a>
		
</nav>