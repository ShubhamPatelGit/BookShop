<%@page import="java.util.ArrayList"%>
<%@page import="com.pojos.BookPojo"%>
<%@page import="com.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
			
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
	
	<%
		BookDao bd = new BookDao();
		ArrayList<BookPojo> books = bd.viewBooks();
		
		ArrayList<Integer> id = new ArrayList();
		ArrayList<String> name = new ArrayList();
		ArrayList<String> author = new ArrayList();
		ArrayList<Integer> price = new ArrayList();
		ArrayList<Integer> quantity = new ArrayList();
		ArrayList<String> course = new ArrayList();
		for(BookPojo book: books){
			id.add(book.getbId());
			name.add(book.getbName());
			author.add(book.getbAuthor());
			price.add(book.getbPrice());
			quantity.add(book.getbQuantity());
			course.add(book.getbCourse());
		}
	%>
	
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