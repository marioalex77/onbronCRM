<%--
  Created by IntelliJ IDEA.
  User: maguzman
  Date: 11/05/2017
  Time: 02:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Bienvenido</title>
</head>
<body>
    <c:url var="loginPage" value="/login" />
    Bienvenido a la pagina de inicio
    Favor iniciar sesion <a href="${loginPage}">aqui</a>
</body>
</html>
