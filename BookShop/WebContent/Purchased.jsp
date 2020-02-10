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
	//	String total = request.getParameter("total");
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
	
	<h1>Purchase Book</h1>
		
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
      <li><a class="active" href="ViewBooks.jsp"> <span>View &nbsp</span><span>Books</span></a></li>
    </ul>
  </div>
</nav>

<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book Author</th>
        <th>Book Price(Single copy)</th>
        <th>Book Quantity(remaining)</th>
        <th>Book Course</th>
        <th>Total price</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${id}</td>
        <td>${name }</td>
        <td>${author }</td>
        <td>${price }</td>
        <td>${quantity }</td>
        <td>${course }</td>
        <td>${total }</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>