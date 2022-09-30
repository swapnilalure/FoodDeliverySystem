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

function increment(id) 
{
     document.getElementById(id).stepUp();
}
	   
function decrement(id) 
{
	  document.getElementById(id).stepDown();
}
 function cart(productId, productName, productPrice)
 {
	     
	   var qty= document.getElementById(productId).value;
	   var price= qty*productPrice;
	   
	   document.getElementById("qty"+productId).value= qty;
   	   document.getElementById("tprice"+productId).value= price;
	   
	   
	   if(qty>0){
		   
		   alert("Order is: "+productName+" Quantity: "+qty+" and price: "+price)
		   
// 		   document.getElementById("label1"+productId).innerHTML= productName;
// 		   document.getElementById("label2"+productId).innerHTML= qty;
// 		   document.getElementById("label3"+productId).innerHTML= price;
		   
// 		   document.getElementById("qty"+productId).value= qty;
// 	   	   document.getElementById("tprice"+productId).value= price;
		   
		   return true;
	   }
	   else{
		   alert("you have to place at least one quantity to place the order");
		   return false;
	   }
		   		   
}

function hotelDetails(hotelId, hotelName){
	console.log(hotelId);
	console.log(hotelName);
	document.getElementById("hotel").innerHTML= hotelName;
	document.getElementById("url"+hotelId).href="showProductListCustomer.html?hotelId="+hotelId;
	
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
    <a class="form-control mr-sm-2" href="logoutHotel.html">Log Out</a>
    <label class="my-2 my-sm-0 text-white">Hello <%=request.getAttribute("customerName") %></label>
    
  </form>
  
</nav>
</header>

<!-- Hotel Display -->

<section style="display: ${hotelDisplay}">
<div class="container">
<div class="row">
<div class="col-sm-3">
<a href="${btnLink}"><button class="btn-primary form-group">${btnDisp}</button></a>
</div>

<div class="col-sm-6">
<div class="container">
<div class="row">
<c:forEach items="${hotels}" var="hotel">

<div class="col-sm-4" style="margin-bottom: 20px"><a href="javascript:" onClick="return hotelDetails('${hotel.hotelId}', '${hotel.hotelName}')" id="url${hotel.hotelId}"> ${hotel.hotelName} </a></div>

</c:forEach>
</div>
</div>
</div>

<div class="col-sm-3"></div>
</div>
</div>

</section>

<!-- Product Display -->

<section style="display: ${productDisplay}">
<div class="form-group">
<div class="container">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">

<h1>Wel-Come to Hotel</h1><h1 id="hotel"></h1>

<div class="form-group"><a href="showCart.html/${customerId}"><button class="btn-primary">show cart</button></a></div> 

<div class="container border">
<div class="row">
<div class="col-sm border-right">Name</div>
<div class="col-sm border-right">Price</div>
<div class="col-sm border-right">Description</div>
<div class="col-sm border-right">Order</div>
<div class="col-sm border-right">Action</div>
</div>
</div>
<div class="form-group">

<c:forEach items="${list}" var="prod">
<div class="container border">
<div class="row">
<div class="col-sm border-right"> ${prod.productName}</div>
<div class="col-sm border-right"> ${prod.productPrice}</div>
<div class="col-sm border-right"> ${prod.productDescription}</div>
<div class="col-sm border-right">
	<button class="btn-primary col-sm" onClick="return decrement(${prod.productId})">-</button>
	<input type="number" name="quantity${prod.productId}" class="col-sm" id="${prod.productId}" min=0 max=10 value=0>
	<button class="btn-primary col-sm" onClick="return increment(${prod.productId})">+</button>
</div>
<div class="col-sm border-right">

<form:form method="post" action="addCart.html/${customerId}/${hotelId}" modelAttribute="productQuantityBean">
<input type="hidden" value="${prod.productId}" id="pId${prod.productId}" name="productId">
<input type="hidden" value="${prod.productName}" id="pname${prod.productId}" name="productName">
<input type="hidden" id="qty${prod.productId}" name="quantity">
<input type="hidden" value="${prod.productPrice}" id="pprice${prod.productId}" name="pricePerProduct">
<input type="hidden" id="tprice${prod.productId}" name="price">


<button type="submit" class="btn-primary" onClick="return cart('${prod.productId}', '${prod.productName}', '${prod.productPrice}')">ADD</button>
</form:form>
</div>
</div>
</div>
</c:forEach>
</div>






</div>

<div class="col-sm-1"></div>
</div>
</div>
</div>

</section>



</body>
</html>




									
									
									