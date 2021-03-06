<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Search Books</title>
</head>
<body>
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
	
	<h1>Search Book</h1>
			
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
	<form action="search">
		<div class="form-group">
			<label>Type:</label> 
			<select name="type" class="form-control">
		    <option value="id">Id</option>
		    <option value="title">Title</option>
		    <option value="author">Author</option>
		    <option value="price">Price</option>
		    <option value="quantity">Inventory Quantity</option>
		    <option value="courses">Courses</option>
		 	</select>

			<label>Value:</label> <input type="text" name="value" class="form-control" />
			<br/>
			<button class= "button" type= "submit" value= "Submit">Submit</button>
		</div>	
	</form>
</div>

<div class="container">
	<form action="view">
		<button class= "button" type= "submit" value= "Submit">All Books</button>
	</form>
</div>


</body>
</html>