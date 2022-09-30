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

function editProduct(productId, productName, productPrice, productDescription) {
	
	var x= document.getElementById("updateForm");
	x.style.display = "block";
	
	document.getElementById("productId").value= productId;
	document.getElementById("inputName").value= productName;
	document.getElementById("price").value= productPrice;
	document.getElementById("description").value= productDescription;
}
	


</script>

</head>
<body>

<header>
<nav class="navbar navbar-dark bg-dark">
	 <a class="navbar-brand" href="index.html">
     <img src="<%=request.getContextPath()%>/images/fds_icon.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
    Food Delivery System
  </a>
	
  	<form class="form-inline">
    <a class="form-control mr-sm-2" href="logoutHotel.html">Log Out</a>
    <label class="my-2 my-sm-0 text-white">Hotel <%=request.getAttribute("hotelName") %></label>
    
  </form>
  
</nav>
</header>

<section>
<div class="container">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
<div class="form-row">
		<div class="form-group col-sm-6">
		<h3>Wel-Come Hotel</h3>
		</div>
		<div class="form-group col-sm-6">
		<h3><i><%=request.getAttribute("hotelName") %></i></h3>
		</div>
</div>
</div>
<div class="col-sm-3"></div>
</div>
</div>

<div class="container">
<div class="row">
<div class="col-sm-8">

<div class="form-group">
		<a href="showProductList.html"><button class="btn-primary" onClick="return showProductList()">Display Product</button></a>
	</div>
	
<div id="showProductList" class="form-group">
<div class="container border">
<div class="row">
<div class="col-sm border-right" style="background-color: #e6e6e6" id="name">Name</div>
<div class="col-sm border-right">Price</div>
<div class="col-sm border-right" style="background-color: #e6e6e6">Description</div>
<div class="col-sm border-right">Update</div>
</div>
</div>

<c:forEach items="${list}" var="prod">
<div class="container border">
<div class="row">

<div class="col-sm border-right"style="background-color: #e6e6e6" id="productName">${prod.productName}</div>
<div class="col-sm border-right" id="productPrice">${prod.productPrice}</div>
<div class="col-sm border-right" style="background-color: #e6e6e6" id="productDescription">${prod.productDescription}</div>
<div class="col-sm border-right" ><button class="btn-primary mr-sm-2" onClick="return editProduct('${prod.productId}','${prod.productName}','${prod.productPrice}','${prod.productDescription}')">edit</button><a class="my-2 my-sm-0" href="deleteProduct.html/${prod.productId}">delete</a></div>

</div>
</div>
</c:forEach>
</div>
<div id="updateForm" style="display: none">
<form:form method="post" action="editSave.html" modelAttribute="ProductBean">
<div class="container">
<div class="row">

<div class="form-group text-center">
	<h5>Update Form</h5>
</div>
<div class="col-sm">
<div class="form-group">
    <label for="productId">Product Id</label>
    <input type="text" class="form-control" name="productId" id="productId" required>
</div>
<div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="productName" id="inputName" required>
</div>
<div class="form-group">
	<button type="submit" class="btn btn-primary">Update</button>
</div>
</div>
<div class="col-sm">
<div class="form-group">
    <label for="price">Price</label>
    <input type="text" class="form-control" name="productPrice" id="price" required>
</div>
<div class="form-group">
    <label for="description">Description</label>
    <input type="text" class="form-control" name="productDescription" id="description" required>
</div>
<div class="form-group"><p>${updateSuccess}</p></div>
</div>

</div>
</div>
</form:form>
</div>	
</div>

<div class="col-sm-4" style="background-color: #99ffcc">
		
	<div id="showForm">
	<form:form method="post" action="addProduct.html" modelAttribute="ProductBean">
	<div class="form-group text-center">
	<h3>Add Product</h3>
	</div>
	
	<div class="form-group">
    <label for="productName">Name</label>
    <input type="text" class="form-control" name="productName" id="productName" placeholder="Enter Product Name" required>
  </div>
  
  <div class="form-group">
    <label for="productPrice">Price</label>
    <input type="text" class="form-control" name="productPrice" id="productPrice" placeholder="Enter Product Price" required>
  </div>
  
  <div class="form-group">
    <label for="productDescription">Description</label>
    <input type="text" class="form-control" name="productDescription" id="productDescription" placeholder="Enter Product Description" required>
  </div>
  
  
  <button type="submit" class="btn btn-primary" onclick="return addProductSuccess()">Add</button>
  
  
</form:form>
</div>
<div id="addProductSuccess" style="top-margin: 20px">${message}</div>		
</div>

</div>
</div>


</section>

</body>
</html>


