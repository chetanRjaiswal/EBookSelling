<%@page import="com.webkorps.entity.BookDetails"%>
<%@page import="com.webkorps.model.BookDetailsModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Edit Book</title>
<%@include file="Components/Css.jsp"%>
</head>
<body style="background-color: #f0f2f2;">

	<%
	if (session.getAttribute("loggedAdmin") != null) {
	%>

	<%@include file="Components/AdminNavBar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<h4 class="text-center">Enter Book Details</h4>

						<%
						Integer id = Integer.parseInt(request.getParameter("id"));
						BookDetailsModel bdm = new BookDetailsModel();
						BookDetails book = bdm.getBookById(id);
						%>

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

						<form name="regform" action="EditBookController" method="post"
							enctype="multipart/form-data" onsubmit="return validation()">
							<span id="formspan" style="color: red;"></span> <input
								type="hidden" class="form-control" name="id"
								value="<%=book.getbId()%>">

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname"
									value="<%=book.getBookName()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="author"
									value="<%=book.getAuthor()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									name="price" value="<%=book.getPrice()%>">
							</div>

							<div class="form-group">
								 <label>Uploaded Image</label>
								 <img
									src="BookImgPdf/<%=book.getImg()%>"
									style="width: 50px; height: 50px;">
							</div>

							<div class="form-group">
								<label>Uploaded Book Pdf</label> <a
									href="BookImgPdf/<%=book.getPdf()%>" download="file"
									style="width: 50px; height: 50px;"><b> download </b></a>
							</div>

							<button type="submit" class="btn btn-primary">Update
								Book</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>

	<%
	if (session.getAttribute("loggedAdmin") == null) {
	%>
	<%
	response.sendRedirect("login.jsp");
	%>
	<%
	}
	%>

	<script type="text/javascript">
		var bname = document.forms['regform']['bname'];
		var author = document.forms['regform']['author'];
		var price = document.forms['regform']['price'];
		var img = document.forms['regform']['bimg'];
		var pdf = document.forms['regform']['bpdf'];
		function validation() {
			if (bname.value != '' && author.value != '' && price.value != ''
					) {
				return true;
			} else {
				document.getElementById("formspan").innerHTML = "Please Fill all fields";
				return false;
			}
		}
	</script>

</body>
</html>