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
<div class="col-sm-3">


</div>
<!-- Actual form starts here -->
<div class="col-sm-6">
<form:form name="hotelSignupForm" method="post"  action="hotelRegistrationSuccess.html" commandName="HotelBean">
	<div class="form-group text-center">
	<h3>Sign Up</h3>
	</div>
	<div class="form-row">
	<div class="form-group col-sm-6">
    <label for="hotelName">Hotel Name</label>
    <input type="text" class="form-control" id="hotelName" name="hotelName" placeholder="Enter Hotel Name" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="mobileNumber">Mobile Number</label>
    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="Enter Mobile Number" required>
  </div>
  </div>
	
  <div class="form-group">
    <label for="emailAddress">Email address</label>
    <input type="email" class="form-control" id="emailAddress" name="emailAddress" aria-describedby="emailHelp" placeholder="Enter email" required>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-row">
  <div class="form-group col-sm-6">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="confirmPassword">Confirm Password</label>
    <input onblur="return passValidation()" type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-enter Password"  required>
  	<small for="validatePassword" id="validatePassword"  name="validatePassword" class="form-text text-muted">validatePassword</small>
  </div>
  </div>
  
  <div class="form-group">
    <label for="address">Address Line 1</label>
    <input type="text" class="form-control" id="address" name="address" placeholder="Area / street / landmark" required>
  </div>
  
  <div class="form-row">
  <div class="form-group col-sm-6">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city" name="city" placeholder="City" required>
  </div>
  
  <div class="form-group col-sm-6">
    <label for="pincode">Pin-Code</label>
    <input type="text" class="form-control" id="pincode" name="pincode" placeholder="Pin Code" required>
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

<footer>
</footer>



</body>
</html>