<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function foo() {
	
//mywindow=window.open("http://www.webdeveloper.com/forum/showthread.php?65854-Problems-closing-a-jsp-page-that-posts-to-a-servlet");
var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
// Opera 8.0+ (UA detection to detect Blink/v8-powered Opera)
var isFirefox = typeof InstallTrigger !== 'undefined';   // Firefox 1.0+
var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
// At least Safari 3+: "[object HTMLElementConstructor]"
var isChrome = !!window.chrome && !isOpera;              // Chrome 1+
var isIE = /*@cc_on!@*/false || !!document.documentMode;   // At least IE6
var output;


 if(isOpera){
	output="Opera";
}else if(isFirefox){
	output="Firefox";
}else if(isSafari){
	output="Safari";
}
else if(isChrome){
	output="Chrome";
}else if(isIE){
	output="IE";
}
 

var xhttp;
if (window.XMLHttpRequest) {
    xhttp = new XMLHttpRequest();
    } else {
    // code for IE6, IE5
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
}


xhttp.open("POST", "ControllerServlet?cat="+output, true);
xhttp.send("ControllerServlet");



}




</script>
</head>


<body onload="foo()">
<h1>hiiii</h1>

</body>
</html>