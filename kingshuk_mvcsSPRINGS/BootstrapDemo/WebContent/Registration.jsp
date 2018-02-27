<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">ABC Technology</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<h2>Registration</h2>
		<form class="form-horizontal" role="form" method="post" action="BaseController">
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstname">First
					Name</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="firstname"
						placeholder="Enter first name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">Last
					Name</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="lastname"
						placeholder="Enter last name">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">Gender</label>
				<div class="col-sm-2">
					<label class="radio-inline"><input type="radio"
						name="optradio">Male</label>
				</div>
				<div class="col-sm-2">
					<label class="radio-inline"><input type="radio"
						name="optradio">Female</label>
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="skill">Skills</label>
				<div class="col-sm-4">
					<div class="checkbox"> 
					       <label><input type="checkbox"value="">C</label>
				    </div>
				    <div class="checkbox">
					      <label><input type="checkbox" value="">C++</label>
				    </div>
				    <div class="checkbox">
					      <label><input type="checkbox" value="">DotNet</label>
				    </div>
				    <div class="checkbox disabled">
					     <label><input type="checkbox" value="" disabled>SQL</label>
				    </div>

			    </div>
			 </div>
			 
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="sel1">Year of Birth</label>
				<div class="col-sm-4">
                     <select class="form-control" id="sel1">
                             <option>1990</option>
                             <option>1991</option>
                             <option>1992</option>
                             <option>1993</option>
                     </select>
				</div>
	        </div>
	        
	        <div class="form-group">
                <label class="control-label col-sm-2" for="comment">Comment:</label>
                <div class="col-sm-10">
                     <textarea class="form-control" rows="5" id="comment"></textarea>
                </div>     
                </div>
	
      <button type="submit" class="btn btn-default">Submit</button>

	</form>
	</div>


</body>
</html>