<%@page import="com.webkorps.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Profile</title>
<%@include file="Components/Css.jsp"%>
<style type="text/css">
a{
  text-decoration: none;
  color:black;
}
a:hover{
 text-decoration: none;
 color:black;
}
.back-img{
background: url("img/b.jpg");
height: 90vh;
width:100%;
background-size: cover;
background-repeat: no-repeat;
}
</style>
</head>
<body>
	
	<%if(session.getAttribute("loggedAdmin")!=null) {%>
    <%@include file="Components/AdminNavBar.jsp"%>
    <div class="container-fluid back-img">
	  <h2 class="text-center">Admin Profile</h2>
	</div>
	<%}%>
	
	<%if(session.getAttribute("loggedAdmin")==null){%>
	<%response.sendRedirect("login.jsp"); %>
	<%}%>
	
</body>
</html>