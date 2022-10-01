<%@page import="java.sql.Connection"%>
<%@page import="com.webkorps.util.DataBaseUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<%@include file="Components/Css.jsp" %>

<style type="text/css">
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
	<%@include file="Components/IndexNavBar.jsp" %>
	<div class="container-fluid back-img">
	  <h2 class="text-center">Online Book Store</h2>
	</div>
</body>
</html>