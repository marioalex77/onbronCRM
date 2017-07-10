<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%--
  Created by Mario Alexander Guzmán
  Date: 03/05/2017
  Time: 09:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/categoria/agregar" var="agregarCategoria" />
<spring:url value="/categoria" var="listarCategoria" />
<spring:url value="/usuario/agregar" var="agregarUsuario" />
<spring:url value="/usuario" var="listarUsuario" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/proveedor/agregar" var="agregarProveedor" />
<spring:url value="/proveedor" var="listarProveedor" />
<spring:url value="/impuesto/agregar" var="agregarImpuesto" />
<spring:url value="/impuesto" var="listarImpuesto" />
<spring:url value="/producto/agregar" var="agregarProducto" />
<spring:url value="/producto" var="listarProducto" />
<spring:url value="/cliente/agregar" var="agregarCliente" />
<spring:url value="/cliente" var="listarCliente" />
<spring:url value="/tipoFactura/agregar" var="agregarTipoFactura" />
<spring:url value="/tipoFactura" var="listarTipoFactura" />
<spring:url value="/tipoPago/agregar" var="agregarTipoPago" />
<spring:url value="/tipoPago" var="listarTipoPago" />

<div class="navbar navbar-static-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><spring:message code="application.name"/></a>
        </div>
        <div class="navbar-collapse collapse navbar-inverse-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle tip" data-toggle="dropdown" href="#" data-placement="right" title="<spring:message code="application.language.title"/>">
                        <img src="<c:url value='/resources/images/english.png'/>" style="margin-top:-1px" align="middle">
                    </a>
                    <ul class="dropdown-menu" style="min-width: 60px;" role="menu" aria-labelledby="dLabel">
                        <li>
                            <a href="?lang=en">
                                <img src="<c:url value='/resources/images/english.png'/>" class="language-img">
                                 &nbsp;&nbsp; <spring:message code="application.language.english.title"/>
                            </a>
                            <a href="?lang=es">
                                <img src="<c:url value='/resources/images/spanish.png'/>" class="language-img">
                                &nbsp;&nbsp; <spring:message code="application.language.spanish.title"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#settings" class="tip" data-placement="right" title="Home">
                        <i class="glyphicon glyphicon-home"></i>
                    </a>
                </li>
                <li  class="dropdown">
                    <a class="dropdown-toggle tip" data-toggle="dropdown" href="#" data-placement="right" title="<spring:message code="application.menu.settings.settings"/>">
                        <i class="glyphicon glyphicon-cog"></i>
                    </a>
                    <ul class="dropdown-menu" style="min-width: 60px;" role="menu" aria-labelledby="dLabel">
                        <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                            <li>
                                <a href="${listarTipoFactura}"><spring:message code="application.menu.settings.listinvoicetype"/></a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                            <li>
                                <a href="${agregarTipoFactura}"><spring:message code="application.menu.settings.addinvoicetype"/></a>
                            </li>
                        </sec:authorize>
                        <li class="divider"></li>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                            <li>
                                <a href="${listarTipoPago}"><spring:message code="application.menu.settings.listpaymenttype"/></a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                            <li>
                                <a href="${agregarTipoPago}"><spring:message code="application.menu.settings.addpaymenttype"/></a>
                            </li>
                        </sec:authorize>
                    </ul>
                </li>
                <li>
                    <a href="#pos" class="tip" data-placement="right" title="POS Sale">
                        <i class="glyphicon glyphicon-th-large"></i>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi, ${loggedinuser}! <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Change Password</a></li>
                        <li><a href="${logoutUrl}"><spring:message code="application.menu.logout"/></a></li>
                    </ul>
                </li>
            </ul>
            <div class="pull-right">
                <ul class="nav navbar-nav">
                    <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Products<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${listarProducto}"><spring:message code="application.menu.products.listproducts"/> </a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${agregarProducto}"><spring:message code="application.menu.products.addproducts"/></a></li>
                                </sec:authorize>
                                <!--li><a href="index.php?module=products&view=import">Import by CSV</a></li-->
                                <!--li><a href="index.php?module=products&view=sheet">Print Barcode</a></li-->
                                <!--li><a href="index.php?module=products&view=labels">Print Lablels</a></li-->
                                <li class="divider"></li>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${listarCategoria}"><spring:message code="application.menu.products.listcategories"/></a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${agregarCategoria}"><spring:message code="application.menu.products.addcategories"/></a></li>
                                </sec:authorize>
                                <li class="divider"></li>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${listarProveedor}"><spring:message code="application.menu.products.listproviders"/></a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${agregarProveedor}"><spring:message code="application.menu.products.addproviders"/></a></li>
                                </sec:authorize>
                                <li class="divider"></li>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${listarImpuesto}"><spring:message code="application.menu.products.listtaxes"/></a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('SUPER')">
                                    <li><a href="${agregarImpuesto}"><spring:message code="application.menu.products.addtaxes"/></a></li>
                                </sec:authorize>
                            </ul>
                        </li>
                    </sec:authorize>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Customers<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('USUARIO') or hasRole('ADMIN') or hasRole('SUPER')">
                                <li><a href="${listarCliente}"><spring:message code="application.menu.customers.listcustomers"/></a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('USUARIO') or hasRole('ADMIN') or hasRole('SUPER')">
                                <li><a href="${agregarCliente}"><spring:message code="application.menu.customers.addcustomers"/></a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sales<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#sales">List Sales</a></li>
                            <li><a href="#salesHolded">List Opened Bills</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#reports/daily_sales">Daily Sales</a></li>
                            <li><a href="#reports/monthly_sales">Monthly Sales</a></li>
                            <li><a href="#reports">Sales Reports</a></li>
                            <li class="divider"></li>
                            <li><a href="#reports/top">Top Products</a></li>
                            <li><a href="#reports/products">Products Reports</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Users<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('SUPER')or hasRole('ADMIN')">
                                <li><a href="${listarUsuario}"><spring:message code="application.menu.auth.listusers"/></a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('SUPER')">
                                <li><a href="${agregarUsuario}"><spring:message code="application.menu.auth.addusers"/></a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>