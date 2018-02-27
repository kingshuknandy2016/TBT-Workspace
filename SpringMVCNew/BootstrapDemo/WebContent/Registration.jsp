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
<title>Registration:1</title>
</head>
<body>

<div class="container">
		<h2>Registration</h2>
		<form class="form-horizontal" role="form" action="Registration2.jsp" >
			<div class="form-group">
				<label class="control-label col-sm-2" for="name1">
					Name</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="name1"
						placeholder="Enter first name" name="firstname">
						
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email1">Email</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="email1"
						placeholder="Enter last name" name="email">
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
                

	
	
                          <div class="form-group">        
                 				 <div class="col-sm-offset-2 col-sm-10">
        							<button type="submit" class="btn btn-default">Next</button>
     							 </div>
   							 </div> 
                 
                     
                </div>

	</form>
	</div>

</body>
</html>