<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <c:choose>
        <c:when test="${usuario.idUsuario == 0}">
            <title><spring:message code="add_user.title"/> | <spring:message code="application.name"/></title>
        </c:when>
        <c:otherwise>
            <title><spring:message code="edit_user.title"/> | <spring:message code="application.name"/></title>
        </c:otherwise>
    </c:choose>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/datatables.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/dash.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/non-responsive.css'/>" type="text/css">
    <script src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>"></script>
    <script type="text/javascript">
        $(document).ready(function() {
	        $('.tip').tooltip();
            $('.alert').click(function(){ $(this).fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); });
	        window.setTimeout(function() { $(".alert").fadeTo(500, 0).slideUp(500, function(){ $(this).remove(); }); }, 8000);
        });
    </script>
</head>
<body>
    <div id="wrap">
        <jsp:include page="../navbarPOS.jsp"/>

        <div class="container">
            <c:choose>
                <c:when test="${usuario.idUsuario == 0}">
                    <h3><spring:message code="add_user.container.title"/></h3>
                </c:when>
                <c:otherwise>
                    <h3><spring:message code="edit_user.container.title"/></h3>
                </c:otherwise>
            </c:choose>
	        <p><spring:message code="add_user.introtext"/></p>
            <spring:url value="/usuario" var="actionUrl" />
            <form:form action="${actionUrl}" method="POST" modelAttribute="usuario">
                <div style="display:none">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                </div>
                <div style="display:none">
                    <form:input type="hidden" path="idUsuario"/>
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="correo" class="control-label"><spring:message code="label.usuario.email"/></label>
                            <form:input type="email" path="correo" id="correo" class="form-control input-sm"/>
                            <form:errors path="correo" cssClass="error"/>
  	                    </div>
                    </div>
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="password" class="control-label"><spring:message code="label.usuario.password"/></label>
                            <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                            <form:errors path="password" cssClass="error"/>
	                    </div>
                    </div>
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="rePassword" class="control-label"><spring:message code="label.usuario.repassword"/></label>
                            <form:input type="password" path="rePassword" id="rePassword" class="form-control input-sm"/>
                            <form:errors path="rePassword" cssClass="error"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="nombres" class="control-label"><spring:message code="label.usuario.nombres"/></label>
                            <form:input path="nombres" id="nombres" class="form-control input-sm"/>
                            <form:errors path="nombres" cssClass="error"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="primerApellido" class="control-label"><spring:message code="label.usuario.primerApellido"/></label>
                            <form:input path="primerApellido" id="primerApellido" class="form-control input-sm"/>
                            <form:errors path="primerApellido" cssClass="error"/>
	                    </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="segundoApellido" class="control-label"><spring:message code="label.usuario.segundoApellido"/></label>
                            <form:input path="segundoApellido" id="segundoApellido" class="form-control input-sm"/>
                            <form:errors path="segundoApellido" cssClass="error"/>
	                    </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="genero" class="control-label"><spring:message code="label.usuario.genero"/></label>
                            <form:radiobuttons path="genero" items="${generos}"  />
                            <form:errors path="genero" cssClass="error"/>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="estado" class="control-label"><spring:message code="label.usuario.estado"/></label>
                            <form:select path="estado" items="${estados}"  />
                            <form:errors path="estado" cssClass="error"/>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <div class="form-group">
                            <label for="rolUsuario" class="control-label"><spring:message code="label.usuario.rolUsuario"/></label>
                            <form:select path="rolUsuario" items="${roles}" multiple="true" itemValue="idRolUsuario" itemLabel="tipo" class="form-control input-sm" />
                            <form:errors path="rolUsuario" cssClass="error"/>
                        </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${usuario.idUsuario == 0}">
                        <input type="submit" name="submit" value="<spring:message code='add_user.submit'/>" class="btn btn-primary btn-sm"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" name="submit" value="<spring:message code='edit_user.submit'/>" class="btn btn-primary btn-sm" />
                    </c:otherwise>
                </c:choose>
            </form:form>
        </div>
    </div>
    <jsp:include page="../footerPOS.jsp"/>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrapPOS.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap-prettyfile.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/ZeroClipboard.js'/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/TableTools.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/DT_bootstrap.js'/>"></script>
</body>
</html>
