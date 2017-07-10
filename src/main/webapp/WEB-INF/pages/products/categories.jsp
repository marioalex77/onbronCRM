<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--base href="http://demo.tecdiary.my/spos/" /-->
<title><spring:message code="categories.title"/> | <spring:message code="application.name"/></title>
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
            <script>
                $(document).ready(function() {
                    $('#fileData').dataTable({
                        "aLengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
                        "aaSorting": [[ 0, "asc" ]],
                        "iDisplayLength": 10,
                        "oTableTools": {
                            "sSwfPath": "<c:url value='/resources/media/swf/copy_csv_xls_pdf.swf'/>",
                            "aButtons": [
                                "csv",
                                "xls",
                                {
                                    "sExtends": "pdf",
                                    "sPdfOrientation": "landscape",
                                    "sPdfMessage": ""
                                },
                                "print"
                            ]
                        },
                        "oLanguage": {
                            "sSearch": "Filter: "
                        },
                        "aoColumns": [
                            null,
                            null,

                            { "bSortable": false }
                        ]
                    });
                } );
            </script>
            <h3><spring:message code="categories.container.title"/> - <spring:message code="application.name"/></h3>
            <p class="introtext"><spring:message code="categories.container.introtext"/></p>
            <spring:url value="/categoria/agregar" var="agregarUrl" />
            <table id="fileData" class="table table-striped table-bordered table-condensed table-hover" style="margin-bottom:5px;">
                <thead>
                    <tr class="active">
                        <th style="width:55px;"><spring:message code="categories.container.table.encabezado.no"/></th>
                        <th><spring:message code="categories.container.table.encabezado.name"/></th>
                        <th style="width:45px;"><spring:message code="categories.container.table.encabezado.actions"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="categoria" items="${categorias}">
                        <spring:url value="/categoria/mostrar?idCategoria=${categoria.idCategoria}" var="verUrl" />
                        <spring:url value="/categoria/borrar?idCategoria=${categoria.idCategoria}" var="borrarUrl" />
                        <spring:url value="/categoria/editar?idCategoria=${categoria.idCategoria}" var="editarUrl" />
                        <tr>
                        <td>${categoria.idCategoria}</td>
                        <td>${categoria.nombre}</td>
                        <td>
                            <div class="btn-group">
                                <a href="${verUrl}" class="tip btn btn-info btn-xs" title="<spring:message code='categories.action.show'/>">
                                    <i class="glyphicon glyphicon-eye-open"></i>
                                </a>
                                <a href="${editarUrl}" class="tip btn btn-warning btn-xs" title="<spring:message code='categories.action.update'/>">
                                    <i class="glyphicon glyphicon-edit"></i>
                                </a>
                                <a href="${borrarUrl}"
                                   onClick="return confirm('<spring:message code="categories.delete.confirm"/>')"
                                   class="tip btn btn-danger btn-xs" title="<spring:message code='categories.action.delete'/>">
                                    <i class="glyphicon glyphicon-trash"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p><a href="${agregarUrl}" class="btn btn-primary btn-sm"><spring:message code="categories.container.button.value"/></a></p>
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
