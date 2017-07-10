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
  <title><spring:message code="providers.title"/> | <spring:message code="application.name"/></title>
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
    <h3><spring:message code="providers.container.title"/> - <spring:message code="application.name"/></h3>
    <p class="introtext"><spring:message code="providers.container.introtext"/></p>
    <spring:url value="/proveedor/agregar" var="agregarUrl" />
    <table id="fileData" class="table table-striped table-bordered table-condensed table-hover" style="margin-bottom:5px;">
      <thead>
      <tr class="active">
        <th><spring:message code="label.provedor.idProveedor"/></th>
        <th><spring:message code="label.proveedor.nombre"/></th>
        <th><spring:message code="label.proveedor.nrc"/></th>
        <th><spring:message code="label.proveedor.nit"/></th>
        <th><spring:message code="label.proveedor.email"/></th>
        <th><spring:message code="label.proveedor.telefono"/></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="proveedor" items="${proveedores}">
        <spring:url value="/proveedor/mostrar?idProveedor=${proveedor.idProveedor}" var="verUrl" />
        <spring:url value="/proveedor/borrar?idProveedor=${proveedor.idProveedor}" var="borrarUrl" />
        <spring:url value="/proveedor/editar?idProveedor=${proveedor.idProveedor}" var="editarUrl" />
        <tr>
          <td>${proveedor.idProveedor}</td>
          <td>${proveedor.nombre}</td>
          <td>${proveedor.nrc}</td>
          <td>${proveedor.nit}</td>
          <td>${proveedor.email}</td>
          <td>${proveedor.telefono}</td>
          <td>
            <div class="btn-group">
              <a href="${verUrl}" class="tip btn btn-info btn-xs" title="<spring:message code='providers.action.show'/>">
                <i class="glyphicon glyphicon-eye-open"></i>
              </a>
              <a href="${editarUrl}" class="tip btn btn-warning btn-xs" title="<spring:message code='providers.action.update'/>">
                <i class="glyphicon glyphicon-edit"></i>
              </a>
              <a href="${borrarUrl}"
                 onClick="return confirm('<spring:message code="providers.delete.confirm"/>')"
                 class="tip btn btn-danger btn-xs" title="<spring:message code='providers.action.delete'/>">
                <i class="glyphicon glyphicon-trash"></i>
              </a>
            </div>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <p><a href="${agregarUrl}" class="btn btn-primary btn-sm"><spring:message code="providers.container.button.value"/></a></p>
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