<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="Components/Css.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="Components/IndexNavBar.jsp"%>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Registration Page</h4>
						
						<%
						if(session.getAttribute("successMsg") !=null)
						{
						%><span style="color: green;"><%=session.getAttribute("successMsg")%></span>
						<%
						}
						session.removeAttribute("successMsg");
						%>
						
						
						<%
						if(session.getAttribute("errorMsg") !=null)
						{
						%><span style="color: red;"><%=session.getAttribute("errorMsg")%></span>
						<%
						}
						session.removeAttribute("errorMsg");
						%>
						<form action="RegisterController" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uname" >
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email" >
							</div>

							<div>
								<label>Select role</label> <select
									class="form-control form-control-sm" name="role">
									
									<option value="admin">admin</option>
									<option value="client">client</option>
								</select>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="password" >
							</div>

							<button type="submit" class="btn btn-primary">Register</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>