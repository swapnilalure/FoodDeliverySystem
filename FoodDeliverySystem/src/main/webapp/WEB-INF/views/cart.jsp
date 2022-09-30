<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Food Delivery System </title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/hotelDashboard.js"></script>

<script type="text/javascript">

function updatecartSave(){
	
// 	var x=document.getElementById("textPricePerProduct").value;
// 	var y=document.getElementById("quantity").value;
// 	var price= x*y;
// 	document.getElementById("textprice").value= price;
	
// 	alert("Product Quantity: "+y+" product Price: "+price )

	var pqId= document.getElementById("pqId").value;
	var quantity= document.getElementById("quantity").value;
	document.getElementById("updateSave").href="editCartSave.html/"+pqId+"/"+quantity;
	
	
}

function editCart(pqId, productName, quantity, pricePerProduct, productId, price){
	
	var x= document.getElementById("updateCart");
	x.style.display = "block";
	
	
	console.log(quantity, pricePerProduct, productId, price)
	
	document.getElementById("productName").innerHTML= productName;
	document.getElementById("quantity").value= quantity;
	document.getElementById("textProductName").value= productName;
	document.getElementById("pqId").value= pqId;
	document.getElementById("textPrice").value= price;
	document.getElementById("textPricePerProduct").value= pricePerProduct;
	document.getElementById("textProductId").value= productId;
	
	
}

function minusQuantity(){
	document.getElementById("quantity").stepDown();
}

function addQuantity(){
	document.getElementById("quantity").stepUp();
}

</script>

</head>
<body>

<header>

<nav class="navbar navbar-dark bg-dark" style="margin-bottom: 20px;">
	 <a class="navbar-brand" href="index.html">
     <img src="<%=request.getContextPath()%>/images/fds_icon.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
    Food Delivery System
  </a>
	
  	<form class="form-inline">
    <a class="form-control mr-sm-2" href="logoutCustomer.html">Log Out</a>
    <label class="my-2 my-sm-0 text-white">Hello <%=request.getAttribute("customerName") %></label>
    
  </form>
  
</nav>
</header>

<section>

<div class="contaier">
<div class="row">
<div class="col-sm-1"></div>

<div class="col-sm-10">

<!--    Display Cart -->
   
<div class="form-group">
<h1>Your Order is:</h1>
</div>

<!--     Title Column -->

<div class="container">
<div class="row">
<div class="col-sm">Product Name</div>
<div class="col-sm">Quantity</div>
<div class="col-sm">Amount</div>
<div class="col-sm">Update Cart</div>
</div>
</div>

<!--        List of Products -->

<c:forEach items="${list}" var="prod">
<div class="container">
<div class="row">
<div class="col-sm">${prod.productName}</div>
<div class="col-sm">${prod.quantity}</div>
<div class="col-sm">${prod.price}</div>
<div class="col-sm">
<a href="deleteCart.html/${prod.pqId}"><button class="btn-primary">Delete</button></a>
</div>
</div> 
</div>
</c:forEach>


</div>

<div class="col-sm-1"></div>

</div>


</div>


</section>

</body>
</html>