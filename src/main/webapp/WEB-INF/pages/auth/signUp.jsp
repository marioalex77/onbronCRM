<%--
  Created by IntelliJ IDEA.
  User: maguzman
  Date: 12/05/2017
  Time: 09:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <title><spring:message code="signUp.title"/> | <spring:message code="application.name"/></title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" media="screen" charset="utf-8">
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
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
    <spring:url value="/registrarse" var="actionUrl" />
    <spring:url value="/login" var="login" />
    <spring:url value="/" var="home" />
    <div class="container">
        <div class="col-md-4 col-md-offset-4" id="login-box">
            <div class="padded" style="text-align:center;margin-top: 40px;">
                <img src="<c:url value='/resources/images/logo.png'/>" alt="Mario's Bistro POS"/>
                <div class="panel panel-warning" style="margin-top: 20px;">
                    <div class="panel-heading"><h3><spring:message code='signUp.container.title'/></h3>
                    <h4><spring:message code="signUP.container.subtitle"/></h4></div>
                    <div class="panel-body" style="padding-bottom:0;">
                        <form:form action="${actionUrl}" method="POST" modelAttribute="usuario" class="separate-sections">
                            <div style="display:none">
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            </div>
                            <div style="display:none">
                                <form:input type="hidden" path="idUsuario" id="idUsuario"/>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                </span>
                                <spring:message code='label.signUp.email' var="correoExample"/>
                                <form:input path="correo" id="nombre" class="form-control"
                                            placeholder="${correoExample}"/>
                                <div class="has-error">
                                    <form:errors path="correo" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </span>
                                <spring:message code='label.signUp.password' var="passwordExample"/>
                                <form:input type="password" path="password" id="nombre" class="form-control"
                                            placeholder="${passwordExample}"/>
                                <div class="has-error">
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                <spring:message code='label.signUp.repassword' var="rePasswordExample"/>
                                <form:input type="password" path="rePassword" id="rePassword" class="form-control"
                                       placeholder="${rePasswordExample}" />
                                <div class="has-error">
                                    <form:errors path="rePassword" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
                                <spring:message code='label.signUp.nombres' var="nombresExample"/>
                                <form:input path="nombres" id="nombres" class="form-control"
                                            placeholder="${nombresExample}"/>
                                <div class="has-error">
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
                                <spring:message code='label.signUp.primerApellido' var="papellidoexample"/>
                                <form:input path="primerApellido" id="primerApellido" class="form-control"
                                            placeholder="${papellidoexample}"/>
                                <div class="has-error">
                                    <form:errors path="primerApellido" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
                                <spring:message code='label.signUp.segundoApellido' var="sapellidoexample"/>
                                <form:input path="segundoApellido" id="segundoApellido" class="form-control"
                                            placeholder="${sapellidoexample}"/>
                                <div class="has-error">
                                    <form:errors path="segundoApellido" cssClass="error"/>
                                </div>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
                                <spring:message code='label.signUp.genero' var="generoexample"/>
                                <form:select path="genero" items="${generos}" id="genero" multiple="false"
                                             class="form-control" placeholder="${generoexample}"/>
                                <div class="has-error">
                                    <form:errors path="genero" cssClass="error"/>
                                </div>
                            </div>
                            <div style="display:none">
                                <form:input type="hidden" path="estado" id="estado" value="ACTIVO"/>
                                <form:input type="hidden" path="rolUsuario" id="rolUsuario" value="3"/>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <spring:message code='signUp.submit' var="submittxt"/>
                                    <form:button type="submit" value="${submittxt}" class="btn btn-success btn-block">
                                         <i class="glyphicon glyphicon-floppy-saved"></i>
                                    </form:button>
                                </div>
                                <div class="col-md-12">
                                    <a href="${login}" class="btn btn-default btn-block">
                                        <i class="glyphicon glyphicon-log-in"></i><spring:message code='signUp.cancelar'/></a>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">&copy; 2017 <spring:message code="application.company"/> <a href="#" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-hand-right"></i> Facebook</a> </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
</body>
</html>
