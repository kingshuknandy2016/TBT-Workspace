<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
				<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
				<title>City Details Page</title>
				<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  				<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 				 <style>
					   /* Remove the navbar's default margin-bottom and rounded borders */
					   .navbar {
					     margin-bottom: 0;
					     border-radius: 0;
					   }
					   
					   /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
					   .row.content {height: 450px}
					   
					   /* Set gray background color and 100% height */
					   .sidenav {
					     padding-top: 20px;
					     background-color: #f1f1f1;
					     height: 100%;
					   }
					   
					   /* Set black background color, white text and some padding */
					   footer {
					     background-color: #555;
					     color: white;
					     padding: 15px;
					   }
					   
					   /* On small screens, set height to 'auto' for sidenav and grid */
					   @media screen and (max-width: 767px) {
					     .sidenav {
					       height: auto;
					       padding: 15px;
					     }
					     .row.content {height:auto;}
					   }
				</style>
		</head>
		<body>
		
				<nav class="navbar navbar-inverse">
				  <div class="container-fluid">
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#">SKY TECHNOLOGY</a>
				    </div>
				    <div class="collapse navbar-collapse" id="myNavbar">
				      <ul class="nav navbar-nav">
				        <li class="active"><a href="#">Home</a></li>
				        <li><a href="#">About</a></li>
				        <li><a href="#">Projects</a></li>
				        <li><a href="#">Contact</a></li>
				      </ul>
				      <ul class="nav navbar-nav navbar-right">
				        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				      </ul>
				    </div>
				  </div>
				</nav>
				  
				<div class="container-fluid text-center">
				  <div class="row content">
				    <div class="col-sm-3 sidenav">
				      <p><a href="click">Click Me</a></p>
				      <p><a href="country">Country Cities</a></p>
				      <p><a href="#">Link</a></p>
				    </div>
				    <div class="col-sm-6 text-centre">
						<div class="list-group ">
						 <c:forEach  items="${msg11}" var="countryNAME" >
						     <li class="list-group-item" ><c:out value="${countryNAME}"/></li> 
						 </c:forEach>  
						</div>
				    </div>
				    <div class="col-sm-3 sidenav">
				      <div class="well">
				        <p>ADS</p>
				      </div>
				      <div class="well">
				        <p>ADS</p>
				      </div>
				    </div>
				  </div>
				</div>
				
				<footer class="container-fluid text-center">
				  <p>@Sky Technology Ltd</p>
				</footer>

		</body>
</html>