<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Delivery System</title>

<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

</head>
<body>
<header>
<nav class="navbar navbar-dark bg-dark">
	<a class="navbar-brand" href="index.html">
     <img src="<%=request.getContextPath()%>/images/fds_icon.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
    Food Delivery System
  </a>
  	<form class="form-inline">
    <a class="form-control mr-sm-2" href="hotel.html">Hotel</a>
    <a class="form-control my-2 my-sm-0" href="customer.html">Customer</a>
  </form> 
</nav>
</header>

<section>
<div class="container">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">

<h1>Hotel Registration Successful.....!</h1>
</div>
<div class="col-sm-3"></div>
</div>
</div>
</section>
</body>
</html>