<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Books</title>
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
	<h1>Books</h1>
	
			
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
      <li><a class="active" href="SearchBooks.jsp"> <span>Search &nbsp</span><span>Book</span></a></li>
    </ul>
  </div>
</nav> 
 
<div class="container">
  <table class="table table-striped">
    
		<tr>
			<div >
				<th>Ids</th>
				<c:forEach items="${sid}" var="i">
					<td>${i}</td>
				</c:forEach>
			</div>
		</tr>
		
		<tr>
			<div >
				<th>Names</th>
				<c:forEach items="${sname}" var="n">
					<td>${n}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div >
				<th>Authors</th>
				<c:forEach items="${sauthor}" var="a">
					<td>${a}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="price">
				<th>Price</th>
				<c:forEach items="${sprice}" var="p">
					<td>${p}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div >
				<th>Quantity</th>
				<c:forEach items="${squantity}" var="q">
					<td>${q}</td>
				</c:forEach>
			</div>
		</tr>
		<tr>
			<div id="Courses">
				<th>Price</th>
				<c:forEach items="${scourse}" var="c">
					<td>${c}</td>
				</c:forEach>
			</div>
		</tr>
	</table>
</div>
</body>
</html>