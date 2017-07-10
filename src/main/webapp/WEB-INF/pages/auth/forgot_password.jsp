<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <title><spring:message code="forgot.title"/> | <spring:message code="application.name"/></title>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" charset="utf-8">
    <script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
    <style>
		.container {
			width: 100%;
			max-width: 100%;
		}
		.container.padded > .row {
			margin: 0;
		}
		.padded {
			padding: 15px;
		}
		.separate-sections {
			margin: 0;
			list-style: none;
			padding-bottom: 5px;
		}
		.separate-sections > li, .separate-sections > div {
			margin-bottom: 15px !important;
		}
		.separate-sections > li:last-child, .separate-sections > div:last-child {
			margin-bottom: 0px;
		}
		i {
			margin: 0 10px;
		}
	</style>
</head>

<body>
<div class="container">
    <div class="col-md-4 col-md-offset-4" id="login-box">
		<div class="padded" style="text-align:center;margin-top: 40px;">
            <img src="<c:url value='/resources/images/logo.png'/>" alt="Mario's Bistro POS"/>
			<div class="panel panel-warning" style="margin-top: 20px;">
				<div class="panel-heading">Forgot Password?</div>
					<div class="panel-body" style="padding-bottom:0;">
						<p>Please enter your email address so we can send you an email to reset your password</p>
						<form action="index.php?module=auth&view=forgot_password" method="post" accept-charset="utf-8" class="separate-sections">
                            <div style="display:none">
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            </div>
							<div class="input-group"> 
								<span class="input-group-addon"> 
									<i class="glyphicon glyphicon-envelope"></i>
								</span> 
								<input type="text" name="email" value="" id="email" class="form-control" placeholder="Email" autofocus="autofocus" /> 
							</div>
							<div class="row">
								<div class="col-md-12">
									<button type="submit" class="btn btn-success btn-block">Submit
										<i class="glyphicon glyphicon-log-in"></i> 
									</button>
								</div>
								<div class="col-md-12"> 
									<a href="login.jsp" class="btn btn-default btn-block">
										<i class="glyphicon glyphicon-circle-arrow-left"></i>Back to Login Page
									</a>
								</div>
							</div>
						</form>          <!--<a href="sign_up.html">Don't have an account? <strong>Sign Up</strong></a> -->
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">&copy; 2017 Marios Bistro POS 
						<a href="#" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-hand-right"></i> Facebook</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {

		$('.alert').click(function(){ $(this).fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); });
	//window.setTimeout(function() { $('.alert').alert('close') }, 4000);
	window.setTimeout(function() { $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); }, 5000);

});
</script>
</body>
</html>
