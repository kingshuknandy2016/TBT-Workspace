<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="jquery-1.11.3.js" type="text/javascript">
	
</script>

<script>
	$(document).ready(function() {
		$("#tap").click(function() {
			$(this).hide();
		});
		
		$("button").click(function() {
			$("*").hide();
		});
		
		$("#p1").mousedown(function () {
			alert("onclick of mouseenter");
		});

	});


</script>


</head>
<body>
	<p id="tap">Click on me,and i will disappear</p>

	<p id="run">click on the button to hide me</p>
	<button>hide</button>
	<p id="p1">Enter this paragraph.</p>
	


</body>
</html>