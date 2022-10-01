<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Add Book</title>
<%@include file="Components/Css.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	
	 
	 <% if (session.getAttribute("loggedAdmin") != null) 
	 {%>
	 
	 <%@include file="Components/AdminNavBar.jsp"%>
	 <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<h4 class="text-center">Enter Book Details</h4>
						
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
						
					 
					
					<form name="regform" action="AddBookController" method="post" enctype="multipart/form-data" onsubmit="return validation()">
						<span id="formspan" style="color: red;"></span>
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname" >
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="author" >
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									name="price" >
							</div>
							
							
							<div class="form-group">
								<label>Upload Image</label>
							   <input type="file" name="bimg" class="form-control-file">
							</div>
							
							<div class="form-group">
								<label>Upload Book Pdf</label> 
								<input type="file"  name="bpdf" accept=".pdf,.doc"/>
							</div>
							

							<button type="submit" class="btn btn-primary">Save Book</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%}%>
	
	<%if (session.getAttribute("loggedAdmin") == null) {%>
	   <%response.sendRedirect("login.jsp");%>
	<%}%>
	
	

<script type="text/javascript">
var bname=document.forms['regform']['bname'];
var author=document.forms['regform']['author'];
var price=document.forms['regform']['price'];
var img=document.forms['regform']['bimg'];
var pdf=document.forms['regform']['bpdf'];
function validation(){
	if(bname.value!='' && author.value!='' && price.value!='' && img.value!='' && pdf.value!=''){
		return true;
	}
	else{
		document.getElementById("formspan").innerHTML="Please Fill all fields";
		return false;
	}
}
</script>	

</body>
</html>