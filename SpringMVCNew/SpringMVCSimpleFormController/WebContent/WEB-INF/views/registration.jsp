<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Page</title>
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="/SpringMVCSimpleFormController/WebContent/WEB-INF/js/registration.js"></script>
	</head>
	
	<body>
		
		<h1 style="text-align: center;">Registration Page</h1>
		
			
		
		
		<div class="container">
		    <form action="addToDatabase" method="post" class="form-horizontal" role="form">
		    	<div class="form-group">
					<label class="control-label col-lg-2" for="namefirst">First-Name:</label>
					<div class="col-sm-6"><input type="text" class="form-control" id="namefirst" 
												placeholder="Enter first name" name="firstname">
					</div>
			    </div>
			    <div class="form-group">
					<label class="control-label col-sm-2" for="namelast">Last-Name: </label>
					<div class="col-sm-6"><input type="text" class="form-control" id="namelast" 
												placeholder="Enter last name" name="lastname">
					</div>
			    </div>
			    
			    <div class="form-group">
      				<label class="control-label col-sm-2" for="userName">Username:</label>
      				<div class="col-sm-6"><input type="text" class="form-control" id="userName" 
      											placeholder="Enter Username" name="username">
      				</div>
   				 </div>
    			<div class="form-group">
     				 <label class="control-label col-sm-2" for="pwd1">Password:</label>
      				<div class="col-sm-6"><input type="password" class="form-control" id="pwd1" 
      											placeholder="Enter password" name="password">
    			    </div>
    			</div>
			    
			    <div class="form-group">
				    <label class="control-label col-sm-2" for="gen">Gender:</label>
				    <div class="col-sm-2">
					     <label class="radio-inline"><input type="radio" name="gender" id="gen">Male</label>
				   </div>
				    <div class="col-sm-2">
					     <label class="radio-inline"><input type="radio"name="gender" id="gen">Female</label>
				    </div>
				</div>
				
				<div class="form-group">        
                     <div class="col-sm-offset-2 col-sm-10">
                         <button type="submit" class="btn btn-default">Submit</button>
     				 </div>
    			</div>
    			
    			<p>If you click on me, I will disappear.</p>
				<p>Click me away!</p>
				<p>Click me too!</p>
			</form>
		</div>
	</body>
</html>