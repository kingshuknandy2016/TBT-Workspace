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

<h2>Horizontal form: control states</h2>
  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="col-sm-2 control-label">Focused</label>
      <div class="col-sm-10">
        <input class="form-control" id="focusedInput" type="text" value="Click to focus...">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-sm-2 control-label">Disabled</label>
      <div class="col-sm-10">
        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled>
      </div>
    </div>
    <fieldset disabled>
      <div class="form-group">
        <label for="disabledTextInput" class="col-sm-2 control-label">Disabled input and select list (Fieldset disabled)</label>
        <div class="col-sm-10">
          <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
        </div>
      </div>
      <div class="form-group">
        <label for="disabledSelect" class="col-sm-2 control-label"></label>
        <div class="col-sm-10">
          <select id="disabledSelect" class="form-control">
            <option>Disabled select</option>
          </select>
        </div>
      </div>
    </fieldset>
    <div class="form-group has-success has-feedback">
      <label class="col-sm-2 control-label" for="inputSuccess">Input with success and glyphicon</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputSuccess">
        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
      </div>
    </div>
    <div class="form-group has-warning has-feedback">
      <label class="col-sm-2 control-label" for="inputWarning">Input with warning and glyphicon</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputWarning">
        <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
      </div>
    </div>
    <div class="form-group has-error has-feedback">
      <label class="col-sm-2 control-label" for="inputError">Input with error and glyphicon</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputError">
        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
      </div>
    </div>
  </form>
  
  
<div class="container">
  <h2>Inline form: control states</h2>
  <form class="form-inline" role="form">
    <div class="form-group">
      <label for="focusedInput">Focused</label>
      <input class="form-control" id="focusedInput" type="text">
    </div>
    <div class="form-group">
      <label for="inputPassword">Disabled</label>
      <input class="form-control" id="disabledInput" type="text" disabled>
    </div>
    <div class="form-group has-success has-feedback">
      <label for="inputSuccess2">Input with success</label>
      <input type="text" class="form-control" id="inputSuccess2">
      <span class="glyphicon glyphicon-ok form-control-feedback"></span>
    </div>
    <div class="form-group has-warning has-feedback">
      <label for="inputWarning2">Input with warning</label>
      <input type="text" class="form-control" id="inputWarning2">
      <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
    </div>
    <div class="form-group has-error has-feedback">
      <label for="inputError2">Input with error</label>
      <input type="text" class="form-control" id="inputError2">
      <span class="glyphicon glyphicon-remove form-control-feedback"></span>
    </div>
  </form>
</div> 

</body>
</html>