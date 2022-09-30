<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/validationForm.js"></script>

</head>

<body>
<header> 
<div>
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
</div>
</header>
<section>
<div class="container">
<div class="row">
<div class="col-sm-3"></div>
<!-- Actual form starts here -->
<div class="col-sm-6">
<form:form name="customerSignupForm" onsubmit="return customerValidation()" method="post" action="customerRegistrationSuccess.html" commandName="CustomerBean">
	<div class="form-group text-center">
	<h3>Sign Up</h3>
	</div>
	<div class="form-row">
	<div class="form-group col-sm-6">
    <label for="exampleInputText1">Name</label>
    <input type="text" class="form-control" name="customerName" id="exampleInputText1" placeholder="Enter Name" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="exampleInputText2">Mobile Number</label>
    <input type="text" class="form-control" name="mobileNumber" id="exampleInputText2" placeholder="Enter Mobile Number" required>
  </div>
  </div>
	
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="emailAddress" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-row">
  <div class="form-group col-sm-6">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="confirmPassword">Confirm Password</label>
    <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Re-enter Password" required>
 	<small id="validatePassword" class="form-text text-muted"></small>
  </div>
  </div>
  
  <div class="form-group">
    <label for="exampleInputText3">Address Line 1</label>
    <input type="text" class="form-control" name="addressLineOne" id="exampleInputText3" placeholder="House no./ flat no./ Apartment" required>
  </div>
  
  <div class="form-group">
    <label for="exampleInputText4">Address Line 2</label>
    <input type="text" class="form-control" name="addressLineTwo" id="exampleInputText4" placeholder="Area / street / landmark" required>
  </div>
  <div class="form-row">
  <div class="form-group col-sm-6">
    <label for="exampleInputText5">City</label>
    <input type="text" class="form-control" name="city" id="exampleInputText5" placeholder="City" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="exampleInputText6">Pin-Code</label>
    <input type="text" class="form-control" name="pincode" id="exampleInputText6" placeholder="Pin Code" required>
  </div>
  </div>
  
  <button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
</form:form>
</div>
<div class="col-sm-3">

</div>
</div>
</div>
</section>
</body>
</html>