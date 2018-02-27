<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Example Page Header</h1>
		</div>
		<h1>Bootstrap Page</h1>
		<h1>
			<mark>Check</mark>
			My First <small>Bootstrap Page</small>
		</h1>
		<p>
			The <abbr title="World Health Organization">WHO</abbr> was founded in
			1948.
		</p>
		<div class="row">
			<div class="col-sm-2" style="background-color: lavender;">.col-sm-4</div>
			<div class="col-sm-4" style="background-color: lavenderblush;">.col-sm-4</div>
			<div class="col-sm-6" style="background-color: lavender;">.col-sm-4</div>
		</div>
		<div class="row">
			<div class="col-sm-2" style="background-color: lavender;">.col-sm-4</div>
			<div class="col-sm-4" style="background-color: lavenderblush;">.col-sm-4</div>
			<div class="col-sm-6" style="background-color: lavender;">.col-sm-4</div>
		</div>
		<div class="row">
			<div class="col-sm-2" style="background-color: lavender;">.col-sm-4</div>
			<div class="col-sm-4" style="background-color: lavenderblush;">.col-sm-4</div>
			<div class="col-sm-6" style="background-color: lavender;">.col-sm-4</div>
		</div>

		<h1>Description Lists</h1>
		<p>The dl element indicates a description list:</p>
		<dl>
			<dt>Coffee</dt>
			<dd>- black hot drink</dd>
			<dt>Milk</dt>
			<dd>- white cold drink</dd>
		</dl>

		<h1>Code Snippets</h1>
		<p>Inline snippets of code should be embedded in the code element:</p>
		<p>
			The following HTML elements:
			<code>span</code>
			,
			<code>section</code>
			, and
			<code>div</code>
			defines a section in a document.
		</p>


		<h1>Keyboard Inputs</h1>
		<p>To indicate input that is typically entered via the keyboard,
			use the kbd element:</p>
		<p>
			Use
			<kbd>ctrl + p</kbd>
			to open the Print dialog box.
		</p>

		<h1>Multiple Code Lines</h1>
		<p>For multiple lines of code, use the pre element:</p>
		<pre class="pre-scrollable">
package com.spi.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

public class SpiProjectLogin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 1; i++) {
			
			WebDriver driver=new FirefoxDriver();
			driver.get("http://www.spiproject.com/spiproject/");
			Thread.sleep(2000);  
			
			
			driver.manage().window().maximize() ;
			WebElement username=driver.findElement(By.xpath("//input[@id='Login1_UserName']"));
			username.sendKeys("kingshuk.nandy");
			
			WebElement password=driver.findElement(By.xpath("//input[@id='Login1_Password']"));
			password.sendKeys("9007438097.kingshuk");
			
			WebElement button1=driver.findElement(By.xpath("//input[@id='Login1_LoginButton']"));
			button1.click();
			
			Thread.sleep(10000);
		
			WebElement button2=driver.findElement(By.xpath("//a[text()='Reports']"));
			button2.click();
			
			
			
			driver.findElement(By.id("ctl00_body_MyProjectsDropDown")).click();
			//Action 
			Actions action = new Actions(driver);
			
			WebElement drop= driver.findElement(By.id("ctl00_body_MyProjectsDropDown")).findElement(By.xpath("//option[2]"));
			action.doubleClick(drop).perform();
			
			WebElement button3=driver.findElement(By.linkText("Project Access Card Report"));
			button3.click();
			
		}
		
		
	}

}
         </pre>

		<h2>Contextual Colors</h2>
		<p>Use the contextual classes to provide "meaning through colors":</p>
		<p class="text-muted">This text is muted.</p>
		<p class="text-primary">This text is important.</p>
		<p class="text-success">This text indicates success.</p>
		<p class="text-info">This text represents some information.</p>
		<p class="text-warning">This text represents a warning.</p>
		<p class="text-danger">This text represents danger.</p>

		<h2>Contextual Backgrounds</h2>
		<p>Use the contextual background classes to provide "meaning
			through colors":</p>
		<p class="bg-primary">This text is important.</p>
		<p class="bg-success">This text indicates success.</p>
		<p class="bg-info">This text represents some information.</p>
		<p class="bg-warning">This text represents a warning.</p>
		<p class="bg-danger">This text represents danger.</p>

		<h2>Basic Table</h2>
		<p>The .table class adds basic styling (light padding and only
			horizontal dividers) to a table:</p>
		<table class="table table-hover table-bordered table-condensed">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>Name</th>
					<th>Designation</th>
					<th>Salary</th>
					<th>Project</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>4576</td>
					<td>Kingshuk</td>
					<td>Trainee</td>
					<td>14000</td>
					<td>Bealls</td>
				</tr>
				<tr>
					<td>Mary</td>
					<td>Moe</td>
					<td>mary@example.com</td>
				</tr>
				<tr>
					<td>July</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
			</tbody>
		</table>


		<h2>Contextual Classes</h2>
		<p>Contextual classes can be used to color table rows or table
			cells. The classes that can be used are: .active, .success, .info,
			.warning, and .danger.</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>John</td>
					<td>Doe</td>
					<td>john@example.com</td>
				</tr>
				<tr class="danger">
					<td>Mary</td>
					<td>Moe</td>
					<td>mary@example.com</td>
				</tr>
				<tr class="info">
					<td>July</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
			</tbody>
		</table>

		<h2>Rounded Corners</h2>
		<p>The .img-rounded class adds rounded corners to an image (not
			available in IE8):</p>
		<img src="download.jpg" class="img-responsive" alt="Cinque Terre"
			width="304" height="236">

		<div class="row">
			<div class="col-md-4"">
				<a href="pulpitrock.jpg" class="thumbnail">
					<p>Pulpit Rock: A famous tourist attraction in Forsand,
						Ryfylke, Norway.</p> <img src="download.jpg" alt="Pulpit Rock"
					style="width: 150px; height: 150px" class="img-circle">
				</a>
			</div>
			<div class="col-md-4">
				<a href="images.jpg" class="thumbnail">
					<p>Moustiers-Sainte-Marie: Considered as one of the "most
						beautiful villages of France".</p> <img src="images.jpg"
					alt="Moustiers Sainte Marie" style="width: 150px; height: 150px"
					class="img-circle">
				</a>
			</div>
			<div class="col-md-4">
				<a href="download (1).jpg" class="thumbnail">
					<p>The Cinque Terre: A rugged portion of coast in the Liguria
						region of Italy.</p> <img src="download (1).jpg" alt="Cinque Terre"
					style="width: 150px; height: 150px" class="img-circle">
				</a>
			</div>
		</div>

		<h2>Responsive Embed</h2>
		<div class="embed-responsive embed-responsive-16by9">
			<iframe class="embed-responsive-item"
				src="http://www.mkyong.com/tutorials/java-xml-tutorials/"></iframe>
		</div>

		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>

		<div class="well">Basic Well</div>
		<div class="well well-sm">Small Well</div>
		<div class="well well-lg">Large Well</div>

		<h2>Alerts</h2>
		<div class="alert alert-success">
			<strong>Success!</strong> This alert box could indicate a successful
			or positive action.
		</div>
		<div class="alert alert-info">
			<strong>Info!</strong> This alert box could indicate a neutral
			informative change or action.
		</div>
		<div class="alert alert-warning">
			<strong>Warning!</strong> This alert box could indicate a warning
			that might need attention.
		</div>
		<div class="alert alert-danger">
			<strong>Danger!</strong> This alert box could indicate a dangerous or
			potentially negative action.
		</div>

		<h2>Alerts</h2>
		<p>The a element with class="close" and data-dismiss="alert" is
			used to close the alert box.</p>
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong> This alert box could indicate a successful
			or positive action.
		</div>
		<div class="alert alert-info">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Info!</strong> This alert box could indicate a neutral
			informative change or action.
		</div>
		<div class="alert alert-warning">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Warning!</strong> This alert box could indicate a warning
			that might need attention.
		</div>
		<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Danger!</strong> This alert box could indicate a dangerous or
			potentially negative action.
		</div>

		<h2>Button Styles</h2>
		<button type="button" class="btn btn-default">Default</button>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-link">Link</button>

		<h2>Button Tags</h2>
		<a href="#" class="btn btn-info" role="button">Link Button</a>
		<button type="button" class="btn btn-info">Button</button>
		<input type="button" class="btn btn-info" value="Input Button">
		<input type="submit" class="btn btn-info" value="Submit Button">

		<h2>Button Sizes</h2>
		<button type="button" class="btn btn-primary btn-lg">Large</button>
		<button type="button" class="btn btn-primary btn-md">Medium</button>
		<button type="button" class="btn btn-primary btn-sm">Small</button>
		<button type="button" class="btn btn-primary btn-xs">XSmall</button>

		<h2>Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-block">Button1</button>
		<button type="button" class="btn btn-default btn-block">Button2</button>

		<h2>Large Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-lg btn-block">Button1</button>
		<button type="button" class="btn btn-default btn-lg btn-block">Button2</button>

		<h2>Small Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-sm btn-block">Button1</button>
		<button type="button" class="btn btn-default btn-sm btn-block">Button2</button>

		<h2>Button States</h2>
		<button type="button" class="btn btn-primary">Primary Button</button>
		<button type="button" class="btn btn-primary active">Active
			Primary</button>
		<button type="button" class="btn btn-primary disabled">Disabled
			Primary</button>
		<br />

		<div class="btn-group">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>

		<h2>Button Groups - Set Sizes</h2>
		<p>Add class .btn-group-* to size all buttons in a button group.</p>
		<h3>Large Buttons:</h3>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h3>Extra Small Buttons:</h3>
		<div class="btn-group btn-group-xs">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>

		<h2>Vertical Button Group</h2>
		<div class="btn-group-vertical">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		
		 <h2>Justified Button Groups</h2>
  <div class="btn-group btn-group-justified">
    <a href="#" class="btn btn-primary">Apple</a>
    <a href="#" class="btn btn-primary">Samsung</a>
    <a href="#" class="btn btn-primary">Sony</a>
  </div>
  
  <h2>Nesting Button Groups</h2>
  <p>Nest button groups to create drop down menus:</p>
  <div class="btn-group">
    <button type="button" class="btn btn-primary">Apple</button>
    <button type="button" class="btn btn-primary">Samsung</button>
    <div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Sony <span class="caret"></span></button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">Tablet</a></li>
        <li><a href="#">Smartphone</a></li>
      </ul>
    </div>
  </div>
  
  <h2>Split Buttons</h2>
  <div class="btn-group">
    <button type="button" class="btn btn-primary">Sony</button>
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="#">Tablet</a></li>
      <li><a href="#">Smartphone</a></li>
    </ul>
    
    <h2>Glyphicon Examples</h2>
  <p>Envelope icon: <span class="glyphicon glyphicon-pencil"></span></p>    
  <p>Envelope icon as a link:
    <a href="#"><span class="glyphicon glyphicon-envelope"></span></a>
  </p>
  <p>Search icon: <span class="glyphicon glyphicon-search"></span></p>
  <p>Search icon on a button:
    <button type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
  </p>
  <p>Search icon on a styled button:
    <button type="button" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
  </p>
  <p>Print icon: <span class="glyphicon glyphicon-print"></span></p>      
  <p>Print icon on a styled link button:
    <a href="#" class="btn btn-success btn-lg">
      <span class="glyphicon glyphicon-print"></span> Print 
    </a>
  </p> 
  </div>

<h2>Badges</h2>
  <a href="#">News <span class="badge">5</span></a><br>
  <a href="#">Comments <span class="badge">10</span></a><br>
  <a href="#">Updates <span class="badge">2</span></a>
  
  <h2>Badges on Buttons</h2>
  <button type="button" class="btn btn-primary">Primary <span class="badge">7</span></button>
  <button type="button" class="btn btn-success">Success <span class="badge">3</span></button>    
  <button type="button" class="btn btn-danger">Danger <span class="badge">5</span></button>     
  
  
  <h1>Example <span class="label label-default">New</span></h1>
  <h2>Example <span class="label label-default">New</span></h2>
  <h3>Example <span class="label label-default">New</span></h3>
  <h4>Example <span class="label label-default">New</span></h4>
  <h5>Example <span class="label label-default">New</span></h5>
  <h6>Example <span class="label label-default">New</span></h6>
  
  
  <h2>Contextual Label Classes</h2>
  <p>Contextual classes can be used to color the label.</p>  
  <span class="label label-default">Default Label</span>
  <span class="label label-primary">Primary Label</span>
  <span class="label label-success">Success Label</span>
  <span class="label label-info">Info Label</span>
  <span class="label label-warning">Warning Label</span>
  <span class="label label-danger">Danger Label</span>
  
  
  <h2>Basic Progress Bar</h2>
  <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
      <span class="sr-only">70% Complete</span>
    </div>
  </div>

 <h2>Colored Progress Bars</h2>
  <p>The contextual classes colors the progress bars:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
      40% Complete (success)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%">
      50% Complete (info)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width:60%">
      60% Complete (warning)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
      70% Complete (danger)
    </div>
  </div>
  
  
  <h2>Striped Progress Bars</h2>
  <p>The .progress-bar-striped class adds stripes to the progress bars:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
      40% Complete (success)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%">
      50% Complete (info)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width:60%">
      60% Complete (warning)
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
      70% Complete (danger)
    </div>
  </div>

 <h2>Animated Progress Bar</h2>
  <p>The .active class animates the progress bar:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
      40%
    </div>
  </div>
  
   <h2>Stacked Progress Bars</h2>
  <p>Create a stacked progress bar by placing multiple bars into the same div with class .progress:</p> 
  <div class="progress">
    <div class="progress-bar progress-bar-success" role="progressbar" style="width:40%">
      Free Space
    </div>
    <div class="progress-bar progress-bar-warning" role="progressbar" style="width:10%">
      Warning
    </div>
    <div class="progress-bar progress-bar-danger" role="progressbar" style="width:20%">
      Danger
    </div>
  </div>
  
   <h2>Pagination</h2>
  <p>The .pagination class provides pagination links:</p>                  
  <ul class="pagination">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li><br/>
    
     <h2>Pagination - Active State</h2>
  <p>Add class .active to let the user know which page he/she is on:</p>
  <ul class="pagination">
    <li><a href="#">1</a></li>
    <li class="active"><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>
  
  <h2>Pagination - Disabled State</h2>
  <p>Add class .disabled if a page for some reason is disabled:</p>
  <ul class="pagination">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li class="disabled"><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>
  
  
  <h2>Pagination - Sizing</h2>
  <p>Add class .pagination-lg for larger blocks or .pagination-sm for smaller blocks:</p>
  <ul class="pagination pagination-lg">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>

  <ul class="pagination pagination-sm">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>
  
  <h2>Breadcrumbs</h2>
  <p>The .breadcrumb class indicates the current page's location within a navigational hierarchy:</p>                  
  <ul class="breadcrumb">
    <li><a href="#">Home</a></li>
    <li><a href="#">Private</a></li>
    <li><a href="#">Pictures</a></li>
    <li class="active">Vacation</li>        
  </ul>
  
  <h2>Pager</h2>
  <p>The .pager class provides previous and next buttons (links):</p>                  
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
  
  <h2>Pager</h2>
  <p>The .previous and .next classes align each link to the sides of the page:</p>                  
  <ul class="pager">
    <li class="previous"><a href="#">Previous</a></li>
    <li class="next"><a href="#">Next</a></li>
  </ul>
  
  <h2>Basic List Group</h2>
  <ul class="list-group">
    <li class="list-group-item">First item</li>
    <li class="list-group-item">Second item</li>
    <li class="list-group-item">Third item</li>
  </ul>
  
   <h2>List Group With Badges</h2>
  <ul class="list-group">
    <li class="list-group-item"><span class="badge">12</span> New</li>
    <li class="list-group-item"><span class="badge">5</span> Deleted</li>  
    <li class="list-group-item"><span class="badge">3</span> Warnings</li>  
  </ul>
  
  <h2>List Group With Linked Items</h2>
  <div class="list-group">
    <a href="#" class="list-group-item">First item</a>
    <a href="#" class="list-group-item">Second item</a>
    <a href="#" class="list-group-item">Third item</a>
  </div>
  
  <h2>Active Item in a List Group</h2>
  <div class="list-group">
    <a href="#" class="list-group-item active">First item</a>
    <a href="#" class="list-group-item">Second item</a>
    <a href="#" class="list-group-item">Third item</a>
  </div>
  
  <h2>List Group With a Disabled Item</h2>
  <div class="list-group">
    <a href="#" class="list-group-item disabled">First item</a>
    <a href="#" class="list-group-item">Second item</a>
    <a href="#" class="list-group-item">Third item</a>
  </div>
  
  <h2>List Group With Contextual Classes</h2>
  <ul class="list-group">
    <li class="list-group-item list-group-item-success">First item</li>
    <li class="list-group-item list-group-item-info">Second item</li>
    <li class="list-group-item list-group-item-warning">Third item</li>
    <li class="list-group-item list-group-item-danger">Fourth item</li>
  </ul>
  <h2>Linked Items With Contextual Classes</h2>
  <div class="list-group">
    <a href="#" class="list-group-item list-group-item-success">First item</a>
    <a href="#" class="list-group-item list-group-item-info">Second item</a>
    <a href="#" class="list-group-item list-group-item-warning">Third item</a>
    <a href="#" class="list-group-item list-group-item-danger">Fourth item</a>
  </div>
  
   <h2>List Group With Custom Content</h2>
  <div class="list-group">
    <a href="#" class="list-group-item active">
      <h4 class="list-group-item-heading">First List Group Item Heading</h4>
      <p class="list-group-item-text">List Group Item Text</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Second List Group Item Heading</h4>
      <p class="list-group-item-text">List Group Item Text</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Third List Group Item Heading</h4>
      <p class="list-group-item-text">List Group Item Text</p>
    </a>
  </div>
  
  <h2>Basic Panel</h2>
  <div class="panel panel-default">
    <div class="panel-body">A Basic Panel</div>
  </div>
  
  <h2>Panel Heading</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Panel Heading</div>
    <div class="panel-body">Panel Content</div>
  </div>
  
  <h2>Panel Footer</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Panel Heading</div>
    <div class="panel-body">Panel Content</div>
    <div class="panel-footer">Panel Footer</div>
  </div>
  
   <h2>Panel Group</h2>
  <p>The panel-group class clears the bottom-margin. Try to remove the class and see what happens.</p>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">Panel Header</div>
      <div class="panel-body">Panel Content</div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">Panel Header</div>
      <div class="panel-body">Panel Content</div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">Panel Header</div>
      <div class="panel-body">Panel Content</div>
    </div>
  </div>
  
  <h2>Panels with Contextual Classes</h2>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">Panel with panel-default class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-primary">
      <div class="panel-heading">Panel with panel-primary class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-success">
      <div class="panel-heading">Panel with panel-success class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-info">
      <div class="panel-heading">Panel with panel-info class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-warning">
      <div class="panel-heading">Panel with panel-warning class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-danger">
      <div class="panel-heading">Panel with panel-danger class</div>
      <div class="panel-body">Panel Content</div>
    </div>
  </div>
  
  
  <h2>Dropdowns</h2>
  <p>The .dropdown class is used to indicate a dropdown menu.</p>
  <p>Use the .dropdown-menu class to actually build the dropdown menu.</p>
  <p>To open the dropdown menu, use a button or a link with a class of .dropdown-toggle and data-toggle="dropdown".</p>                                          
  <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </div>
  
  
  <h2>Dropdowns</h2>
  <p>The .divider class is used to separate links inside the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
   <h2>Dropdowns</h2>
  <p>The .disabled class is used to disable an item in the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li class="disabled"><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
   <h2>Dropdowns</h2>
  <p>Add the .dropdown-menu-right class to .dropdown-menu to right-align the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu dropdown-menu-right">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
  <h2>Dropdowns</h2>
  <p>The .dropup class makes the dropdown menu expand upwards instead of downwards:</p>
  <div class="dropup">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropup Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
  
  <h2>Dropdowns</h2>
  <p>The .dropdown class is used to indicate a dropdown menu.</p>
  <p>Use the .dropdown-menu class to actually build the dropdown menu.</p>                                          
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">HTML</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
      <li role="presentation" class="divider"></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
    </ul>
  </div>
  
    <h2>Simple Collapsible</h2>
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Simple collapsible</button>
  <div id="demo" class="collapse">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
  </div>
  
  <h2>Simple Collapsible</h2>
  <a href="#demo1" class="btn btn-info" data-toggle="collapse">Simple collapsible</a>
  <div id="demo1" class="collapse">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
  </div>
  
  
  
  <h2>Collapsible Panel</h2>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Collapsible panel</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">Panel Body</div>
        <div class="panel-footer">Panel Footer</div>
      </div>
    </div>
  </div>
  
  
   <h2>Collapsible List Group</h2>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2">Collapsible list group</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item">One</li>
          <li class="list-group-item">Two</li>
          <li class="list-group-item">Three</li>
        </ul>
        <div class="panel-footer">Footer</div>
      </div>
    </div>
  </div>
  
  
  
  <h2>Accordion Example</h2>
  <p><strong>Note:</strong> The <strong>data-parent</strong> attribute makes sure that all collapsible elements under the specified parent will be closed when one of the collapsible item is shown.</p>
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Collapsible Group 1</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse in">
        <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Collapsible Group 2</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Collapsible Group 3</a>
        </h4>
      </div>
      <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
      </div>
    </div>
  </div> 
  
  <h3>Inline List</h3>
  <ul class="list-inline">
    <li><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  
   <h3>Tabs</h3>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  
  <h3>Tabs With Dropdown Menu</h3>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Submenu 1-1</a></li>
        <li><a href="#">Submenu 1-2</a></li>
        <li><a href="#">Submenu 1-3</a></li>                        
      </ul>
    </li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  <h3>Pills</h3>
  <ul class="nav nav-pills">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  
  <h3>Vertical Pills</h3>
  <ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  
  <h3>Vertical Pills</h3>
  <div class="row">
    <div class="col-md-3">
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div class="col-md-3"> 
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div class="col-md-3"> 
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div class="col-md-3">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Menu 1</a></li>
        <li><a href="#">Menu 2</a></li>
        <li><a href="#">Menu 3</a></li>
      </ul>
    </div>
    <div class="clearfix visible-lg"></div>
  </div>
  
   <h3>Pills With Dropdown Menu</h3>
  <ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Submenu 1-1</a></li>
        <li><a href="#">Submenu 1-2</a></li>
        <li><a href="#">Submenu 1-3</a></li>                        
      </ul>
    </li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  <h3>Centered Tabs</h3>
  <ul class="nav nav-tabs nav-justified">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  <br>
  <h3>Centered Pills</h3>
  <ul class="nav nav-pills nav-justified">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">Menu 1</a></li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
  
  <h2>Dynamic Tabs</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home123">Home</a></li>
    <li><a data-toggle="tab" href="#menu111">Menu 1</a></li>
    <li><a data-toggle="tab" href="#menu222">Menu 2</a></li>
    <li><a data-toggle="tab" href="#menu333">Menu 3</a></li>
  </ul>

  <div class="tab-content">
    <div id="home123" class="tab-pane fade in active">
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu111" class="tab-pane fade">
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu222" class="tab-pane fade">
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu333" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
  
  
  
  
  
   <h2>Dynamic Pills</h2>
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="pill" href="#home99">Home</a></li>
    <li><a data-toggle="pill" href="#menu199">Menu 1</a></li>
    <li><a data-toggle="pill" href="#menu299">Menu 2</a></li>
    <li><a data-toggle="pill" href="#menu399">Menu 3</a></li>
  </ul>
  
  <div class="tab-content">
    <div id="home99" class="tab-pane fade in active">
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu199" class="tab-pane fade">
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu299" class="tab-pane fade">
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu399" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
  
  
		<blockquote>

			<p>From</p>
			<footer>Kingshuk</footer>
		</blockquote>

	</div>




</body>
</html>