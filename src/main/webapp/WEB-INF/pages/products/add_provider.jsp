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
        <c:when test="${proveedor.idProveedor == 0}">
            <title><spring:message code="add_provider.title"/> | <spring:message code="application.name"/></title>
        </c:when>
        <c:otherwise>
            <title><spring:message code="edit_provider.title"/> | <spring:message code="application.name"/></title>
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
                <c:when test="${proveedor.idProveedor == 0}">
                    <h3><spring:message code="add_provider.container.title"/></h3>
                </c:when>
                <c:otherwise>
                    <h3><spring:message code="edit_provider.container.title"/></h3>
                </c:otherwise>
            </c:choose>
	        <p><spring:message code="add_provider.introtext"/></p>
            <spring:url value="/proveedor" var="actionUrl" />
            <form:form action="${actionUrl}" method="POST" modelAttribute="proveedor">
                <div style="display:none">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                </div>
                <div style="display:none">
                    <form:input type="hidden" path="idProveedor"/>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="nombre" class="control-label"><spring:message code="label.proveedor.nombre"/></label>
                            <form:input path="nombre" id="nombre" class="form-control input-sm"/>
                            <form:errors path="nombre" cssClass="nombre"/>
  	                    </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="nrc" class="control-label"><spring:message code="label.proveedor.nrc"/></label>
                            <form:input path="nrc" id="nrc" class="form-control input-sm"/>
                            <form:errors path="nrc" cssClass="error"/>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="nit" class="control-label"><spring:message code="label.proveedor.nit"/></label>
                            <form:input path="nit" id="nit" class="form-control input-sm"/>
                            <form:errors path="nit" cssClass="error"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="email" class="control-label"><spring:message code="label.proveedor.email"/></label>
                            <form:input path="email" id="email" class="form-control input-sm"/>
                            <form:errors path="email" cssClass="error"/>
	                    </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="telefono" class="control-label"><spring:message code="label.proveedor.telefono"/></label>
                            <form:input path="telefono" id="telefono" class="form-control input-sm"/>
                            <form:errors path="telefono" cssClass="error"/>
	                    </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${proveedor.idProveedor == 0}">
                        <input type="submit" name="submit" value="<spring:message code='add_provider.submit'/>" class="btn btn-primary btn-sm"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" name="submit" value="<spring:message code='edit_provider.submit'/>" class="btn btn-primary btn-sm" />
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
