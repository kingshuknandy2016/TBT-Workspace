<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/practice.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    
    <script type="text/javascript">
    

    </script>
    
    
    
</head>
<body>
<script type="text/javascript" src="custom.js"></script>
<div class="wrapper" id="wrapper">
		<div class="google-header-bar">
			
		</div>
		<div class="signuponepage main content clearfix">
	    	<h1>Create your ABC Account</h1>
	    	
			<div class="clearfix">
					  <div class="sign-up">
							  <div class="signup-box">
									  <form class="createaccount-form" id="createaccount" name="createaccount" action="" method="post">
											  <input type="hidden" name="service" id="service" value="mail">
											  <input type="hidden" name="continue" id="continue" value="/mail/">
											  <input type="hidden" name="ltmpl" id="ltmpl" value="default">
											  <input type="hidden" name="timeStmp" id="timeStmp" value="1467630120882">
											  <input type="hidden" name="secTok" id="secTok" value=".AG5fkS_nnkPu71S-U9Ej27qMZi2viLkZ6A==">
											  <input type="hidden" name="dsh" id="dsh" value="-5905730796759059807">
											  <input type="hidden" name="ktl" id="ktl" value="A">
											  <input type="hidden" name="ktf" id="ktf" value="FirstName LastName GmailAddress Passwd PasswdAgain RecoveryEmailAddress ">
											  <input type="hidden" id="_utf8" name="_utf8" value="☃">
											  <input type="hidden" name="bgresponse" id="bgresponse" value="js_disabled">
											  <div class="form-element multi-field name" id="name-form-element">
													  <fieldset>
															  <legend><strong>Name</strong></legend>
															  <label id="firstname-label" class="firstname">
																	  <strong>First name</strong>
																	  <input type="text" value="" name="FirstName" id="FirstName" spellcheck="false" n="1">
																	  <span class="placeholder-text" id="firstname-placeholder">First</span>
															  </label>
															  <label id="lastname-label" class="lastname">
																	  <strong>Last name</strong>
																	  <input type="text" value="" name="LastName" id="LastName" spellcheck="false" n="2">
																	  <span class="placeholder-text" id="lastname-placeholder">Last</span>
															  </label>
													  </fieldset>
													  <div class="infomsg" id="name-infomessage">
													  </div>
													  <div role="alert" class="errormsg" id="errormsg_0_FirstName">
													  </div>
													<!--   <span role="alert" class="errormsg" id="errormsg_0_FirstName">
													  </span> -->
													  <span role="alert" class="errormsg" id="errormsg_0_LastName">
													  </span>
											  </div>
											  <div class="form-element email-address" id="gmail-address-form-element">
													  <label id="gmail-address-label">
															  <strong>Choose your username</strong>
															  <input type="text" maxlength="30" autocomplete="off" name="GmailAddress" id="GmailAddress" value="" spellcheck="false" n="3">
															  <span class="atgmail">@gmail.com</span>
													  </label>
													  <div class="infomsg" id="gmail-address-infomessage">
													  You can use letters, numbers, and periods.
													  </div>
													  <div id="username-errormsg-and-suggestions">
															  <span role="alert" class="errormsg" id="errormsg_0_GmailAddress">
															  </span>
															  <div id="EmailAddressExistsError" style="display: none">
															  This email address already corresponds to a Google Account. Please 
															  			<a href="/go.php?u=JJk%2F7gEnFS1HXskZEb69DfocFE7AUtgqvhq56JouHQwlQO%2BrQnf3wjps2chvMqKug9wj8AixTvz%2FQPWeuVSEX2fkHmpOpsq4uDtv%2FOrnvIgVlS7w%2FV77MrIswR3XEnCWm6b%2FWZ%2Bpm1Y%2BWU9Hj30PqdBZD61xN8bPnaLf%2BYKq3A0VkFTdNSv7abs%3D&amp;b=5">sign in</a> or, if you forgot your password, <a href="/go.php?u=JJk%2F7gEnFS1HXskZEb69DfocFE7AUtgqvxqo8YUoCgEpROmwE2CnzyFrw9Rkeq%2Fnn9gkpUjVWI%2BcV4H95nOAUiDvX2JGpcj6vnphtrWE468RmGKunkrOcbM%2F2gjbTHjKn6uwWQ%3D%3D&amp;b=5">reset it</a>.
															  </div>
															  <div class="username-suggestions" id="username-suggestions">
															  </div>
													  </div>
											  </div>
											  <div class="form-element" id="password-form-element">
													  <label id="password-label">
															  <strong>Create a password</strong>
															  <input type="password" name="Passwd" id="Passwd" n="4">
													  </label>
													  <div class="infomsg" id="password-infomessage">
															  <div class="password-strength">
																	  <p>
																		  <strong>Password strength:</strong>
																		  <span id="passwdRating"></span>
																	  </p>
																	  <div class="meter" id="passwdBar">
																	  	  <span id="strength-bar"></span>
																	  </div>
															  </div>
															  <div>
															  Use at least 8 characters. Don’t use a password from another site, or something too obvious like your pet’s name. <a id="PasswdLink" target="_blank" href="/go.php?u=JJk%2F7hMxBjJdQslEWLa9BfEVXwPMUJpkjhyk6505C28rSfWyGGa3n3w1g401Z6bnksI%3D&amp;b=5">Why?</a>
															  </div>
													  </div>
													  <span role="alert" class="errormsg" id="errormsg_0_Passwd">
													  </span>
											  </div>
											  <div class="form-element" id="confirm-password-form-element">
													  <label id="confirm-password-label">
															  <strong>Confirm your password</strong>
															  <input type="password" name="PasswdAgain" id="PasswdAgain" n="5">
													  </label>
													  <span role="alert" class="errormsg" id="errormsg_0_PasswdAgain">
													  </span>
											  </div>
											  <div class="form-element multi-field birthday" id="birthday-form-element">
													  <fieldset>
															  <legend><strong id="BirthdayLabel">Birthday</strong></legend>
															  <label id="month-label" class="month">
																	  <span id="BirthMonthHolder">
																			  <select id="BirthMonth" name="BirthMonth">
																			  <option value="" disabled="disabled">Month</option>
																					  <option value="01">
																					  January</option>
																					  <option value="02">
																					  February</option>
																					  <option value="03">
																					  March</option>
																					  <option value="04">
																					  April</option>
																					  <option value="05">
																					  May</option>
																					  <option value="06">
																					  June</option>
																					  <option value="07">
																					  July</option>
																					  <option value="08">
																					  August</option>
																					  <option value="09">
																					  September</option>
																					  <option value="10">
																					  October</option>
																					  <option value="11">
																					  November</option>
																					  <option value="12">
																					  December</option>
																			  </select>
																	  		 <div class="goog-flat-menu-button-dropdown"></div>
																	  </span>
															  </label>
															  <label id="day-label" class="day">
																	  <strong>Day</strong>
																	  <input type="text" maxlength="2" value="" name="BirthDay" id="BirthDay">
																	  <span class="placeholder-text" id="birthday-placeholder">Day</span>
															  </label>
															  <label id="year-label" class="year">
																	  <strong>Year</strong>
																	  <input type="text" maxlength="4" value="" name="BirthYear" id="BirthYear">
																	  <span class="placeholder-text" id="birthyear-placeholder">Year</span>
															  </label>
													  </fieldset>
													  <span role="alert" class="errormsg" id="errormsg_0_BirthMonth">
													  </span>
													  <span role="alert" class="errormsg" id="errormsg_0_BirthDay">
													  </span>
													  <span role="alert" class="errormsg" id="errormsg_0_BirthYear">
													  </span>
											  </div>
											  <div class="form-element" id="gender-form-element">
													  <label id="gender-label">
															  <strong id="GenderLabel">Gender</strong>
															  <div id="GenderHolder">
																	  <select id="Gender" name="Gender">
																			  <option value="" disabled="disabled">I am...</option>
																			  <option value="FEMALE">
																			  Female</option>
																			  <option value="MALE">
																			  Male</option>
																			  <option value="OTHER">
																			  Other</option>
																	  </select>
																	  <div class="goog-flat-menu-button-dropdown"></div>
															  </div>
													  </label>
													  <span role="alert" class="errormsg" id="errormsg_0_Gender">
													  </span>
											  </div>
											  <div class="form-element" id="phone-form-element">
													  <label id="phone-label" for="RecoveryPhoneNumber">
													  <strong id="RecoveryPhoneNumberLabel">Mobile phone</strong>
													  </label>
													  <input type="hidden" value="NL" name="RecoveryPhoneCountry" id="RecoveryPhoneCountry">
													  <input type="tel" tabindex="0" name="RecoveryPhoneNumber" id="RecoveryPhoneNumber" value="">
													  <div class="infomsg" id="phone-infomessage">
														  Your phone number helps us with things like keeping your account secure. For example, we can send you a text message to help you access your account if you ever forget your password.
													  </div>
													  <span role="alert" class="errormsg" id="errormsg_0_RecoveryPhoneNumber">
													  </span>
											  </div>
											  <div class="form-element recovery-email" id="recovery-email-form-element">
													  <label id="recovery-email-label">
															  <strong>Your current email address</strong>
															  <input type="text" name="RecoveryEmailAddress" id="RecoveryEmailAddress" value="" spellcheck="false" n="6">
													  </label>
													  <div class="infomsg" id="recovery-email-infomessage">
													 			 We will use this address for things like keeping your account secure, helping people find you, and sending notifications. You always have control over this functionality through your Account Settings.
													  </div>
													  <span role="alert" class="errormsg" id="errormsg_0_RecoveryEmailAddress">
													  </span>
											  </div>
											  <input type="hidden" name="SkipCaptcha" id="SkipCaptcha" value="yes">
											  <div class="form-element" id="country-code-form-element">
													  <label id="country-code-label">
															  <strong id="CountryCodeLabel">Location</strong>
															  <div id="CountryCodeHolder">
																	  <select id="CountryCode" name="CountryCode">
																			  <option value="AF">
																			  Afghanistan (‫افغانستان‬‎)
																			  </option>
																			  <option value="AX">
																			  Åland Islands (Åland)
																			  </option>
																	  </select>
																	  <div class="goog-flat-menu-button-dropdown"></div>
															  </div>
															  <div class="infomsg" id="country-code-infomessage">
															  Your country or territory of residence.
															  </div>
															  <span role="alert" class="errormsg" id="errormsg_0_CountryCode">
															  </span>
													  </label>
											  </div>
											  <div class="form-element terms-of-service" id="termsofservice-form-element">
													  <label id="termsofservice-label">
															  <input type="checkbox" value="yes" name="TermsOfService" id="TermsOfService">
															  <span id="terms-of-service-label">
															  		<strong>I agree to the Google <a target="_blank" id="TosLink" href="/go.php?u=JJk%2F7gEnFS1HXskZEb69DfocFE7AUtgquTCYoZ8iG30Ea6CtESn9wg%3D%3D&amp;b=5">Terms of Service</a> and <a target="_blank" id="PrivacyLink" href="/go.php?u=JJk%2F7gEnFS1HXskZEb69DfocFE7AUtgquTCYoZ8iG30Ea6CtESn9wmh1xdR8bqmjytgioF4%3D&amp;b=5">Privacy Policy</a></strong>
															  </span>
													  </label>
													  <span role="alert" class="errormsg" id="errormsg_0_TermsOfService">
													  </span>
											  </div>
											  <div class="form-element" id="extra-tos"></div>
											  <input type="hidden" name="timeStmp2" id="timeStmp2" value="1467630120882">
											  <input type="hidden" name="secTok2" id="secTok2" value=".AG5fkS8bboqj3FfQstxiWI9W3a2qVuXtGw==">
											  <div class="form-element nextstep-button">
											  		   <input id="submitbutton" onClick="Submit()" name="submitbutton" type="submit" value="Register" class="g-button g-button-submit">
											  </div>
							  </form>
					  </div>
					  <p class="why-information"><a target="_blank" href="/go.php?u=JJk%2F7hMxBjJdQslEWLa9BfEVXwPMUJpkjhyk6505C28rSfWyGGa3nXk2hI84O%2FWym5E1uw%3D%3D&amp;b=5">Learn more</a> about why we ask for this information.</p>
			  </div>
			  <div class="side-content">
					  <h2>
					  		One account is all you need
					  </h2>
					  <p>
					  		One free account gets you into everything Google.
					  </p>
					  <div class="logo-strip"></div>
					  <h2>
					       Take it all with you
					  </h2>
					  <p>
						  Switch between devices, and pick up wherever you left off.
					  </p>
					 <div class="devices-icon"></div>
			  </div>
			  </div>
		</div>
		
</div>
	
</body>
</html>