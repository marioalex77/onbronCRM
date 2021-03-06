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
    <title><spring:message code="show_provider.title"/> | <spring:message code="application.name"/></title>
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
        <h3><spring:message code="show_provider.container.title"/></h3>

        <p><spring:message code="show_provider.introtext"/></p>
        <div class="row">
            <div class="col-xs-12">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.provedor.idProveedor"/></b></div>
                    <div class="control-label">${proveedor.idProveedor}</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.proveedor.nombre"/></b></div>
                    <div class="control-label">${proveedor.nombre}</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.proveedor.nrc"/></b></div>
                    <div class="control-label">${proveedor.nrc}</div>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.proveedor.nit"/></b></div>
                    <div class="control-label">${proveedor.nit}</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.proveedor.email"/></b></div>
                    <div class="control-label">${proveedor.email}</div>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="control-label"><b><spring:message code="label.proveedor.telefono"/></b></div>
                    <div class="control-label">${proveedor.telefono}</div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../footerPOS.jsp"/>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrapPOS.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-prettyfile.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-datepicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/ZeroClipboard.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/resources/js/TableTools.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/DT_bootstrap.js'/>"></script>
</body>
</html>