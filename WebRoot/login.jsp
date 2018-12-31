<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>IntelliBuy Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- -->
<script async="" src="https://www.google-analytics.com/analytics.js"></script>
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="js/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script type="text/javascript" src="https://s3.amazonaws.com/exthub/e/2/r/CA_firefox.js?cached=true"></script></head>
<body>

 <c:choose>
 	 <c:when test="${param['err'] != null}">
       <c:set var="hasErr" scope="request" value="true"/>
     </c:when>
     <c:otherwise>
     	<c:set var="hasErr" scope="request" value="false"/>
     </c:otherwise>
</c:choose>
</head>
<body>
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>Login Form</h1>
		 <div class="alert-close"> </div> 			
	</div>

	<%--
 		<c:out value="${hasErr}"/>
 	--%>
 <c:if test = "${hasErr}">
	<h1 class="text" style="color:red">Invalid username or password, please re-try again . . .</h1>
</c:if>
<c:if test = "${!hasErr}">
<!-- 	<h1 class="text">Please enter your username and password . . .</h1> -->
</c:if>
<form action="login" method="post">
	<li>
				<input id="username" name="username" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" type="text">
	</li>
				<div class="clear"> </div>
	<li>
				<input id="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" type="password">
	</li>
		<div class="clear"> </div>
	<div class="submit">
		<input type="submit" value="Log in">
		<input type="reset" value="Clear">
	    <div class="clear">  </div>	
	</div>


		</form>
		</div>					
	</div>

</body>
</html>