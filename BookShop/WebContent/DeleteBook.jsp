<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<%
		String msg = request.getParameter("msg");
	%>
	<%
		if (msg != null) {
	%>
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>Message!</strong>
		<%=msg%>.
	</div>
	<%
		}
	%>
	
	<h1>Delete Book</h1>
	
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
      <!-- <li class="active"><a href="#">Home</a></li> -->
      <li><a class="active" href="UploadBook.jsp"> <span>Upload &nbsp</span><span>Book</span></a></li>
      <li><a class="active" href="EditBook.jsp"> <span>Update &nbsp</span><span>Book</span></a></li>
      <li><a class="active" href="DeleteBook.jsp"> <span>Delete &nbsp</span><span>Book</span></a></li>
       <li><a class="active" href="PurchaseBook.jsp"> <span>Purchase &nbsp</span><span>Book</span></a></li>
       <form action= "BookList"><li><a class="active" href="ViewBooks.jsp" type= "submit"> <span>View &nbsp</span><span>Books</span></a></li></form>
       
    </ul>
  </div>
</nav>

<div class="container">
		<form action="Delete">
		<div class="form-group">
			<input type="hidden" name='request' value='delete' /> 
			<lebel>Book ID</lebel>
			<input type="number" name="bId" class="form-control" />
			
			<button class= "button" type= "submit" value= "Submit">Submit</button>
			</div>
		</form>
	</div>	
	
	<table>
		<tr>
			<div id="Id">
				<th>Ids</th>
				<c:forEach items="${id}" var="i">
					<td>${i}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="names">
				<th>Names</th>
				<c:forEach items="${name}" var="n">
					<td>${n}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="author">
				<th>Authors</th>
				<c:forEach items="${author}" var="a">
					<td>${a}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="price">
				<th>Price</th>
				<c:forEach items="${price}" var="p">
					<td>${p}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="quantity">
				<th>Quantity</th>
				<c:forEach items="${quantity}" var="q">
					<td>${q}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="course">
				<th>Courses</th>
				<c:forEach items="${course}" var="c">
					<td>${c}</td>
				</c:forEach>
			</div>
		</tr>
	</table>

</body>
</html>