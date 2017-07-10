<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
	<title><spring:message code="pos.title"/> |<spring:message code="application.name"/></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrapPOS.css'/>" type="text/css" charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/posajax.css'/>" type="text/css" charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/non-responsive.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/print.css'/>" type="text/css" media="print">
    <script src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>"></script>
    <script src="<c:url value='/resources/js/purl.js'/>"></script>
    <style>
        .btn-product {
            background: #EEE;
            border:1px solid #EEE;
            border-bottom: 0;
        }
        .btn-con .btn-default{
            height: 43px;
        }
    </style>
	<script type="text/javascript">
		$(document).ready(function() {
		});
    </script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="../navbarPOS.jsp"/>
        <div class="container">
            <div id="wrapper">
                <div id="content">
                    <div class="c1">
                        <div class="pos">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <p>Logged In Successfully</p>
                            </div>
                            <div id="pos">
                                <form action="http://demo.tecdiary.my/spos/index.php?module=pos" method="post"
                                      accept-charset="utf-8">
                                    <div style="display:none">
                                        <input type="hidden" name="csrf_pos" value="b7e583082aa77179d11972373f01aeb0" />
                                    </div>
                                    <div class="well well-sm" id="leftdiv">
                                        <div id="lefttop">
                                            <input name="code" id="scancode" class="form-control input-sm"
                                                   placeholder="Barcode Scanner" style="margin-bottom: 10px;" />
                                        </div>
                                        <!---Recibo Imprimible-->
                                        <div id="printhead">
                                            <h2><strong>Simple POS</strong></h2>
                                            <p> My Shop Lot, Shopping Mall,<br> Post Code, City</p>
                                            <p>Date: 29/03/2017</p>
                                        </div>
                                        <div id="print">
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                   class="table table-striped table-condensed table-hover miantable"
                                                   style="margin:5px 0 0 0;">
                                                <thead>
                                                    <tr class="success">
                                                        <th style="width: 9%" class="satu">X</th>
                                                        <th>Product</th>
                                                        <th style="width: 12%">Qty</th>
                                                        <th style="width: 24%">Price</th>
                                                        <th style="width:19px; padding:0;">&nbsp;</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                            <div id="prodiv">
                                                <div id="protbldiv" class="nano">
                                                    <div class="content">
                                                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                               class="table table-striped table-condensed table-hover protable"
                                                               id="saletbl" style="margin:0;">
                                                            <tbody>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div style="clear:both;"></div>
                                                </div>
                                            </div>
                                            <div style="clear:both;"></div>
                                            <div id="totaldiv">
                                                <table id="totaltbl" class="table table-striped table-condensed totals"
                                                       style="margin-bottom:10px;">
                                                    <tbody>
                                                        <tr class="success">
                                                            <td width="25%">Total Items</td>
                                                            <td><span id="count">0</span></td>
                                                            <td width="25%">Total</td>
                                                            <td class="text_right" colspan="2"><span id="total">0</span></td>
                                                        </tr>
                                                        <tr class="success">
                                                            <td width="25%">Discount
                                                                <a href="#" id="add_discount" style="color:#FFF;font-size:0.80em">
                                                                    <i class="glyphicon glyphicon-pencil"></i>
                                                                </a>
                                                            </td>
                                                            <td><span id="ds_con">0</span></td>
                                                            <td width="25%">Tax
                                                                 <a href="#" id="add_tax" style="color:#FFF; font-size:0.80em">
                                                                     <i class="glyphicon glyphicon-pencil"></i>
                                                                 </a>
                                                            </td>
                                                            <td class="text_right">
                                                                <span id="ts_con">0</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="success">
                                                            <td colspan="2">Total Payable</td>
                                                            <td class="text_right" colspan="2">
                                                                <span id="total-payable">0</span>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div id="botbuttons" style="text-align:center;">
                                            <button type="button" class="btn btn-danger" id="cancel"
                                                    style="width:90px;">Cancel</button>
                                            <!--<button type="button" class="btn btn-warning" id="print"
                                                    onClick="window.print();return false;">Print</button>-->
                                            <button type="button" class="btn btn-info" id="hold"
                                                    style="width:90px;">Hold</button>
                                            <button type="button" class="btn btn-success" id="payment"
                                                    style="margin-right:0; width:180px;">Payment</button>
                                        </div>
                                        <input type="hidden" name="customer" id="customer" value="3" />
                                        <input type="hidden" name="inv_tax" id="tax_val" value="13" />
                                        <input type="hidden" name="inv_discount" id="discount_val" value="0" />
                                        <input type="hidden" name="rpaidby" id="rpaidby" value="cash"
                                               style="display: none;" />
                                        <input type="hidden" name="count" id="total_item" value="" />
                                        <input type="hidden" name="delete_id" id="is_delete" value="" />
                                        <input type="hidden" name="hold_ref" id="hold_ref" value="" />
                                        <input type="hidden" name="paid_val" id="paid_val" value="" />
                                        <input type="hidden" name="cc_no_val" id="cc_no_val" value="" />
                                        <input type="hidden" name="cc_holder_val" id="cc_holder_val" value="" />
                                        <input type="hidden" name="cheque_no_val" id="cheque_no_val" value="" />
                                        <span id="hidesuspend"></span>
                                        <input type="submit" id="submit" value="Submit Sale" style="display: none;" />
                                    </div>
                                </form>
                                <div id="cp">
                                    <div id="slider">
                                        <div class="btn-category">
                                            <!--Para cada categoria-->
                                            <button type="button" class="btn btn-default" value="1"
                                                    id="category-1">Fast Food</button>
                                            <button type="button" class="btn btn-default" value="2"
                                                    id="category-2">Tea Time</button>
                                        </div>
                                        <div style="clear:both;"></div>
                                    </div>
                                    <div style="clear:both;"></div>
                                    <div id="ajaxproducts">
                                        <div class="btn-product clearfix">
                                            <div id="proajax">
                                                <div>
                                                    <!--Para cada producto-->
                                                    <button type="button" data-name="Web Traffic Genius Pro"
                                                            id="product-1922" type="button" value='2749'
                                                            class="btn btn-prni">
                                                        <img src="http://demo.tecdiary.my/spos/assets/uploads/thumbs/PrtScr_capture.png"
                                                             alt="Web Traffic Genius Pro"
                                                             style="width: 75px; height: 75px;">
                                                        <span>Web Traffic Genius Pro</span>
                                                    </button>
                                                    <button type="button" data-name="ABC-Wednesday"
                                                            id="product-19251" type="button" value='DESIGNATED_SURVIVOR'
                                                            class="btn btn-prni">
                                                        <img src="http://demo.tecdiary.my/spos/assets/uploads/thumbs/no_image.png"
                                                             alt="ABC-Wednesday" style="width: 75px; height: 75px;">
                                                        <span>ABC-Wednesday</span>
                                                    </button>
                                                    <!--tienen que completar 24 botones-->
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                    <button type="button" class="btn btn-prni hov" value='0'/>
                                                </div>
                                                <div style="clear:both;"></div>
                                            </div>
                                            <div class="btn-con">
                                                <button id="previous" type="button" class="btn btn-default"
                                                        style='z-index:10002;'>
                                                    <i class="glyphicon glyphicon-chevron-left"></i>
                                                </button>
                                                <button id="next" type="button" class="btn btn-default"
                                                        style='z-index:10003;'>
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style="clear:both;"></div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div class="alert alert-warning">
            <p>Please do not use the nulled version as there are no security and version updates available,
                possible code exploits, no software support. These issues make running a nulled version very risky
                and extremely unsafe to your server and business.</p>
        </div>
    </div>

    <jsp:include page="../footerPOS.jsp"/>
    <div id="loading" style="display: none;">
        <div class="blackbg"></div>
        <div class="loader">
            <img src="<c:url value='/resources/images/loader.gif'/>" alt="" />
        </div>
    </div>
    <div class="modal fade" id="saleModal" tabindex="-1" role="dialog" aria-labelledby="saleModalLabel" aria-hidden="true"></div>
    <div class="modal fade" id="opModal" tabindex="-1" role="dialog" aria-labelledby="opModalLabel" aria-hidden="true"></div>
    <!--Para pagar-->
    <div class="modal fade" id="payModal" tabindex="-1" role="dialog" aria-labelledby="payModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="glyphicon glyphicon-remove"></i>
                    </button>
                    <h4 class="modal-title" id="payModalLabel">Payment</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped" style="margin-bottom:0;">
                        <tbody>
                            <tr>
                                <td width="50%">Customer
                                    <a href="#" class="btn btn-primary btn-xs showCModal">
                                        <i class="glyphicon glyphicon-plus-sign"></i>
                                            Add Customer
                                    </a>
                                </td>
                                <td width="50%">
                                    <span class="inv_cus_con">
                                        <select class="form-control pcustomer"
                                                style="padding: 2px !important; height: auto !important;">
                                            <!-- para cada cliente-->
                                            <option value="3">Walk-in Client</option>
                                            <option value="4">joe</option>
                                            <option value="313">Annomymous</option>
                                        </select>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>Total Payable Amount:</td>
                                <td>
                                    <span style="background: #FFFF99; padding: 5px 10px; text-weight: bold; color: #000;">
                                        <span id="twt"></span>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>Total Purchased Items:</td>
                                <td>
                                    <span style="background: #FFFF99; text-weight: bold; padding: 5px 10px; color: #000;">
                                        <span id="fcount"></span>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>Paid by:</td>
                                <td>
                                    <!--Para cada tipo de pago!-->
                                    <select name="paid_by" id="paid_by" class="form-control"
                                            style="padding: 2px !important; height: auto !important;">
                                        <option value="cash">Cash</option>
                                        <option value="CC">Credit Card</option>
                                        <option value="Cheque">Cheque</option>
                                    </select>
                                </td>
                            </tr>
                            <tr class="pcash">
                                <td>Paid:</td>
                                <td>
                                    <input type="text" id="paid-amount" class="form-control"
                                           style="padding: 2px !important; height: auto !important;" />
                                </td>
                            </tr>
                            <tr class="pcash">
                                <td>Return Change:</td>
                                <td>
                                    <span style="background: #FFFF99; padding: 5px 10px; text-weight: bold; color: #000;"
                                          id="balance"></span>
                                </td>
                            </tr>
                            <tr class="pcc" style="display:none;">
                                <td>Credit Card No:</td>
                                <td>
                                    <input type="text" id="pcc" class="form-control"
                                           style="padding: 2px !important; height: auto !important;" />
                                </td>
                            </tr>
                            <tr class="pcc" style="display:none;">
                                <td>Credit Card Holder:</td>
                                <td>
                                    <input type="text" id="pcc_holder" class="form-control"
                                           style="padding: 2px !important; height: auto !important;" />
                                </td>
                            </tr>
                            <tr class="pcheque" style="display:none;">
                                <td>Cheque No:</td>
                                <td>
                                    <input type="text" id="cheque_no" class="form-control"
                                           style="padding: 2px !important; height: auto !important;" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button class="btn btn-success" id="submit-sale">Submit</button>
                </div>
            </div>
        </div>
    </div>
    <!--Modificar el precio o cantidad de un producto seleccionado-->
    <div class="modal fade" id="proModal" tabindex="-1" role="dialog" aria-labelledby="proModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="glyphicon glyphicon-remove"></i>
                    </button>
                    <h4 class="modal-title" id="proModalLabel">Payment</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="rwNo" value="">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="oPrice" class="control-label">Current Price</label>
                                <input type="text" class="form-control input-sm" id="oPrice" disabled="disabled">
                            </div>
                            <div class="form-group">
                                <label for="nPrice" class="control-label">New Price</label>
                                <input type="text" class="form-control input-sm kbp-input" id="nPrice"
                                       onClick="this.select();" placeholder="New Price">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="oQuantity" class="control-label">Current Quantity</label>
                                <input type="text" class="form-control input-sm" id="oQuantity" disabled="disabled">
                            </div>
                            <div class="form-group">
                                <label for="nQuantity" class="control-label">New Quantity</label>
                                <input type="text" class="form-control input-sm kbq-input" id="nQuantity"
                                       onClick="this.select();" placeholder="Current Quantity">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button class="btn btn-success" id="update-row">Update</button>
                </div>
            </div>
        </div>
    </div>
    <!--Agregar un cliente-->
    <div class="modal fade" id="customerModal" tabindex="-1" role="dialog" aria-labelledby="proModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="glyphicon glyphicon-remove"></i>
                    </button>
                    <h4 class="modal-title" id="proModalLabel">Add Customer</h4>
                </div>
                <div class="modal-body">
                    <div id="customerError"></div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="nombres" class="control-label"><spring:message code="label.cliente.nombres"/></label>
                                <form:input path="nombres" id="cnames" class="form-control input-sm"/>
                                <form:errors path="nombres" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label for="primerApellido" class="control-label"><spring:message code="label.cliente.primerApellido"/></label>
                                <form:input path="primerApellido" id="clastname" class="form-control input-sm"/>
                                <form:errors path="primerApellido" cssClass="error"/>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label for="segundoApellido" class="control-label"><spring:message code="label.cliente.segundoApellido"/></label>
                                <form:input path="segundoApellido" id="cmotherslastname" class="form-control input-sm"/>
                                <form:errors path="segundoApellido" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label for="genero" class="control-label"><spring:message code="label.cliente.genero"/></label>
                                <form:radiobuttons path="genero" items="${generos}" id="cgender"  />
                                <form:errors path="genero" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label for="email" class="control-label"><spring:message code="label.cliente.email"/></label>
                                <form:input type="email" path="email" id="cemail" class="form-control input-sm"/>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label for="telefono" class="control-label"><spring:message code="label.cliente.telefono"/></label>
                                <form:input  path="telefono" id="cphone" class="form-control input-sm"/>
                                <form:errors path="telefono" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="show_m" value="">
                </div>
                <spring:url value="/cliente/" var="add_customer_url"/>
                <div class="modal-footer" style="margin-top:0;">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button class="btn btn-success" id="add-customer">Add Customer</button>
                </div>
            </div>
        </div>
    </div>
    <!--Al presionar el boton hold-->
    <div class="modal fade" id="susModal" tabindex="-1" role="dialog" aria-labelledby="susModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="glyphicon glyphicon-remove"></i>
                    </button>
                    <h4 class="modal-title" id="susModalLabel">Save to Opened Bills</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped" style="margin-bottom:0;">
                        <tbody>
                            <tr>
                                <td width="50%">Customer
                                    <a href="#" class="btn btn-primary btn-xs showCModal">
                                        <i class="glyphicon glyphicon-plus-sign"></i>Add Customer</a>
                                </td>
                                <td width="50%">
                                    <span class="inv_cus_con">
                                        <!--Para cada cliente-->
                                        <select class="form-control pcustomer"
                                                style="padding: 2px !important; height: auto !important;">
                                            <option value="3">Walk-in Client</option>
                                            <option value="4">joe</option>
                                            <option value="313">Annomymous</option>
                                        </select>
                                    </span>
                                </td>
                            </tr>
                            <tr class="pcash">
                                <td>Hold Bill Ref:</td>
                                <td>
                                    <input type="text" name="hold_v" value="" class="form-control input-sm" id="hold_ref_v" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button class="btn btn-success" id="submit-hold">Submit</button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.bxslider.min.js'/>"></script>
    <!--script type="text/javascript" src="http://demo.tecdiary.my/spos/smlib/js/ui/jquery.ui.core.js"></script-->
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.keyboard.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootbox.js'/>"></script>
    <script type="text/javascript">
        var KB = 1;
        var DTIME = 1;
        var count = 1;
        var total = 0;
        var an = 1;
        var rt = 1;
        var ids = new Array();
        var p_page = 0;
        var page = 0;
        var cat_id = 19;
        var sproduct_name;
        var slast;
        var total_cp = 2;
        $(document).ready(function(){
            add_row();
            loadProducts();
            //Cuando se hace click en el lapiz de agregar descuento
            $("#add_discount").click(function(){
                var dval=$('#discount_val').val();
                bootbox.dialog({
                    message:"<input type='text' class='form-control input-sm' id='get_ds' " +
                    "onClick='this.select();' value='"+dval+"'>" +
                    "</input>",
                    title:"Discount (5 or 5%)",
                    buttons:{
                        main:{
                            label:"Update",
                            className:"btn-primary btn-sm",
                            callback:function(){
                                var ds=$('#get_ds').val();
                                if(ds.length!=0){
                                    $('#discount_val').val(ds);
                                    if(ds.indexOf("%")!==-1){
                                        var pds=ds.split("%");
                                        if(!isNaN(pds[0])){
                                            var discount=(total*parseFloat(pds[0]))/100;
                                            var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ds_con").text(discount.toFixed(2));
                                            $("#total-payable").text(grand_total)
                                        }else{
                                            $('#get_ds').val('0');
                                            $('#discount_val').val('0');
                                            var g_total=(total+parseFloat($('#ts_con').text()));
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ds_con").text('0.00');
                                            $("#total-payable").text(grand_total)
                                        }
                                    }else{
                                        if(!isNaN(ds)&&ds!=0){
                                            var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ds_con").text(parseFloat(ds).toFixed(2));
                                            $("#total-payable").text(grand_total)
                                        }else{
                                            $('#get_ds').val('0');
                                            $('#discount_val').val('0');
                                            var g_total=(total+parseFloat($('#ts_con').text()));
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ds_con").text('0.00');
                                            $("#total-payable").text(grand_total)
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
                return false
            });
            //Cuando se hace click en el lapiz de agregar impuesto
            $("#add_tax").click(function(){
                var tval=$('#tax_val').val();
                bootbox.dialog({
                    message:"<input type='text' class='form-control input-sm' id='get_ts' " +
                    "onClick='this.select();' value='"+tval+"'></input>",
                    title:"Tax Rate (5 or 5%)",
                    buttons:{
                        main:{
                            label:"Update",
                            className:"btn-primary btn-sm",
                            callback:function(){
                                var ts=$('#get_ts').val();
                                if(ts.length!=0){
                                    $('#tax_val').val(ts);
                                    if(ts.indexOf("%")!==-1){
                                        var pts=ts.split("%");
                                        if(!isNaN(pts[0])){
                                            var tax=(total*parseFloat(pts[0]))/100;
                                            var g_total=(total+tax)-parseFloat($('#ds_con').text());
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ts_con").text(tax.toFixed(2));
                                            $("#total-payable").text(grand_total)
                                        }else{
                                            $('#get_ts').val('0');
                                            $('#tax_val').val('0');
                                            var g_total=(total)-parseFloat($('#ds_con').text());
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ts_con").text('0');
                                            $("#total-payable").text(grand_total)
                                        }
                                    }else{
                                        if(!isNaN(ts)&&ts!=0){
                                            var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ts_con").text(parseFloat(ts).toFixed(2));
                                            $("#total-payable").text(grand_total)
                                        }else{
                                            $('#get_ts').val('0');
                                            $('#tax_val').val('0');
                                            var g_total=(total)-parseFloat($('#ds_con').text());
                                            grand_total=parseFloat(g_total).toFixed(2);
                                            $("#ts_con").text('0');
                                            $("#total-payable").text(grand_total)
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
                return false
            });
            //Cuando se hace click en el cuadro de dialogo modal boton Add Customer
            $("#add-customer").click(function(){
                var newCustomer=new Array();
                newCustomer[0]=$('#cnames').val();
                newCustomer[1]=$('#clastname').val();
                newCustomer[2]=$('#cmotherslastname').val();
                newCustomer[3]=$('#gender').val();
                newCustomer[4]=$('#cemail').val();
                newCustomer[5]=$('#cphone').val();
                $.ajax({
                    type:"post",
                    async:false,
                    url:"${add_customer_url}",
                    data: {csrf_pos:"${_csrf.token}",data:newCustomer},
                    dataType:"json",
                    success:function(data){
                        result=data.msg;
                        cu=data.c;
                        $('#customer').val(data.cid);
                        },
                    error:function(){
                        bootbox.alert('<em>customer_request_failed</em>');
                        result=false;
                        return false
                    }
                });
                if(result=='Customer Successfully Added'){
                    $('.inv_cus_con').html(cu);
                    $('#customerModal').modal('hide');
                    $('#cnames').val('');
                    $('#clastname').val('');
                    $('#cmotherslastname').val('');
                    $('#cgender').val('');
                    $('#cemail').val('');
                    $('#cPhone').val('');
                    bootbox.alert('Customer Successfully Added')
                }else{
                    var error=$('<div class=\"alert alert-danger\"></div>');
                    error.html("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>"+result);
                    error.appendTo("#customerError");
                    return false
                }
            });
            $("#payModal").on('click','.showCModal',function(){
                $('#payModal').modal('hide');
                $('#show_m').val('pay');
                $('#customerModal').modal('show');
                return false
            });
            $("#susModal").on('click','.showCModal',function(){
                $('#susModal').modal('hide');
                $('#show_m').val('sus');
                $('#customerModal').modal('show');
                return false
            });
            $('#customerModal').on('hide.bs.modal',function(){
                if($('#show_m').val()=='pay'){$('#payModal').modal('show')}
                if($('#show_m').val()=='sus'){$('#susModal').modal('show')}
            });
            $('#opModal').bind().on('click','a',function(){
                var pg=$.url($(this).attr("href")).param("per_page");
                $.get('http://demo.tecdiary.my/spos/index.php?module=pos&view=ob_page&per_page='+pg,function(data){
                    $(".html_con").html(data.pd);
                    $(".page_con").html(data.page)
                },"json");
                return false
            });
            $('.sus_sale').live('click',function(e){
                var sid=$(this).attr("id");
                if(an>1){
                    bootbox.confirm("<strong>You will loss current sale data.</strong> <br>Are you sure to leave the page?",function(gotit){
                        if(gotit==false){
                            return true
                        }else{
                            window.location.href="http://demo.tecdiary.my/spos/index.php?module=pos&suspend_id="+sid
                        }
                    })
                }else{
                    window.location.href="http://demo.tecdiary.my/spos/index.php?module=pos&suspend_id="+sid
                }
                return false
            });
            $('a').each(function(){
                $(this).click(function(e){
                    var href=$(this).attr("href");
                    if((href!='#'&&an>1)&&!$(this).hasClass("external")){
                        e.preventDefault();
                        bootbox.confirm("<strong>You will loss current sale data.</strong> <br>Are you sure to leave the page?",function(gotit){
                            if(gotit==false){
                                return true
                            }else{
                                window.location.replace(href)
                            }
                        })
                    }
                })
            });
            $('.btn-category').bxSlider({
                minSlides:5,
                maxSlides:5,
                slideWidth:600,
                slideMargin:0,
                ticker:false,
                infiniteLoop:false,
                hideControlOnEnd:true,
                mode:'horizontal'});
            if(KB==1){
                $('.kb-text').keyboard({
                    autoAccept:true,
                    alwaysOpen:false,
                    openOn:'click',
                    usePreview:false,
                    display:{'bksp':"\u2190",'accept':'return','default':'ABC','meta1':'.?123','meta2':'#+='},
                    layout:'custom',
                    customLayout:{
                        'default':['q w e r t y u i o p {bksp}',
                            'a s d f g h j k l {enter}',
                            '{s} z x c v b n m , . {s}',
                            '{meta1} {space} {meta1} {accept}'],
                        'shift':['Q W E R T Y U I O P {bksp}',
                            'A S D F G H J K L {enter}',
                            '{s} Z X C V B N M ! ? {s}',
                            '{meta1} {space} {meta1} {accept}'],
                        'meta1':['1 2 3 4 5 6 7 8 9 0 {bksp}',
                            '- / : ; ( ) \u20ac & @ {enter}',
                            '{meta2} . , ? ! \' " {meta2}',
                            '{default} {space} {default} {accept}'],
                        'meta2':['[ ] { } # % ^ * + = {bksp}',
                            '_ \\ | ~ &lt; &gt; $ \u00a3 \u00a5 {enter}',
                            '{meta1} . , ? ! \' " {meta1}',
                            '{default} {space} {default} {accept}']
                    }
                })
            }
            $('.tip').tooltip();
            $('.alert').click(function(){
                $(this).fadeTo(500,0).slideUp(500,function(){
                    $(this).remove()
                })
            });
            window.setTimeout(function(){
                $(".alert").fadeTo(500,0).slideUp(500,function(){
                    $(this).remove()
                })
            },6000);
            function loadProducts(){
                $('button[id^="category"]').click(function(){
                    if(cat_id!=$(this).val()){
                        $('#loading').show();
                        cat_id=$(this).val();
                        $.ajax({
                            type:"get",
                            url:"index.php?module=pos&view=ajaxproducts",
                            data:{category_id:cat_id,per_page:'n'},
                            dataType:"html",
                            success:function(data){
                                $('#proajax').empty();
                                var newPrs=$('<div></div>');
                                newPrs.html(data);
                                newPrs.appendTo("#proajax")
                            }
                        }).done(function(){
                            add_row();
                            $.ajax({
                                type:"get",
                                async:false,
                                url:"index.php?module=pos&view=total_cp",
                                data:{category_id:cat_id},
                                dataType:"html",
                                success:function(data){total_cp=data}
                            });
                            p_page='n';
                            $('#loading').hide()
                        })
                    }
                })
            }
            $('#next').click(function(){
                if(p_page=='n'){
                    p_page=0
                }
                p_page=p_page+24;
                if(total_cp>=24&&p_page<total_cp){
                    $('#loading').show();
                    $.ajax({
                        type:"get",
                        url:"index.php?module=pos&view=ajaxproducts",
                        data:{category_id:cat_id,per_page:p_page},
                        dataType:"html",
                        success:function(data){
                            $('#proajax').empty();
                            var newPrs=$('<div></div>');
                            newPrs.html(data);
                            newPrs.appendTo("#proajax")
                        }
                    }).done(function(){
                        add_row();
                        $('#loading').hide()
                    })
                }else{
                    p_page=p_page-24
                }
            });
            $('#previous').click(function(){
                if(p_page=='n'){
                    p_page=0
                }
                if(p_page!=0){
                    $('#loading').show();
                    p_page=p_page-24;
                    if(p_page==0){
                        p_page='n'
                    }
                    $.ajax({
                        type:"get",
                        url:"index.php?module=pos&view=ajaxproducts",
                        data:{category_id:cat_id,per_page:p_page},
                        dataType:"html",
                        success:function(data){
                            $('#proajax').empty();
                            var newPrs=$('<div></div>');
                            newPrs.html(data);
                            newPrs.appendTo("#proajax")
                        }
                    }).done(function(){
                        add_row();
                        $('#loading').hide()
                    })
                }
            });
            $('button[id^="category"]').click(function(){
                $('#loading').show();
                cat_id=$(this).val();
                $.ajax({
                    type:"get",
                    url:"index.php?module=pos&view=ajaxproducts",
                    data:{category_id:cat_id,per_page:'n'},
                    dataType:"html",
                    success:function(data){
                        $('#proajax').empty();
                        var newPrs=$('<div></div>');
                        newPrs.html(data);
                        newPrs.appendTo("#proajax")
                    }
                }).done(function(){
                    add_row();
                    p_page='n';
                    $('#loading').hide()
                })
            });
            $("#saletbl").on("click",'button[class^="del_row"]',function(){
                var delID=$(this).attr('id');
                var dl_id=delID.split("-");
                var rw_no=dl_id[1];
                var p1=$('#price-'+rw_no);
                var q1=$('#quantity-'+rw_no);
                var row_price=parseFloat(p1.val()*q1.val());
                var row_quantity=parseInt(q1.val());
                total=total-row_price;
                current=parseFloat(total).toFixed(2);
                count=count-row_quantity;
                var ds=$('#discount_val').val();
                if(ds.indexOf("%")!==-1){
                    var pds=ds.split("%");
                    var discount=(total*parseFloat(pds[0]))/100;
                    var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                    $("#ds_con").text(discount.toFixed(2))
                }else{
                    var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                    $("#ds_con").text(parseFloat(ds).toFixed(2))
                }
                var ts=$('#tax_val').val();
                if(ts.indexOf("%")!==-1){
                    var pts=ts.split("%");
                    var tax=(total*parseFloat(pts[0]))/100;
                    var g_total=(total+tax)-parseFloat($('#ds_con').text());
                    $("#ts_con").text(tax.toFixed(2))
                }else{
                    var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                    $("#ts_con").text(parseFloat(ts).toFixed(2))
                }
                grand_total=parseFloat(g_total).toFixed(2);
                $("#total-payable").text(grand_total);
                $("#total").text(current);
                $("#count").text(count-1);
                an--;
                row_id=$("#row_"+rw_no);
                row_id.remove()
            });
            $("#saletbl").on("click",'.prod_name',function(){
                var rw=$(this).attr('id');
                var pn=$(this).attr('data-name');
                $('#proModalLabel').text(pn);
                $('#rwNo').val(rw);
                $('#oPrice').val($('#price-'+rw).val());
                $('#oQuantity').val($('#quantity-'+rw).val());
                $('#nPrice').val($('#price-'+rw).val());
                $('#nQuantity').val($('#quantity-'+rw).val());
                $('#proModal').modal();
                return false
            });
            $("#update-row").click(function(){
                var rw=$('#rwNo').val();
                var op=parseFloat($('#price-'+rw).val());
                var oq=parseInt($('#quantity-'+rw).val());
                var np=parseFloat($('#nPrice').val());
                var nq=parseInt($('#nQuantity').val());
                var row_price=op;
                var row_quantity=oq;
                total=total-(op*oq);
                total=total+(np*nq);
                current=parseFloat(total).toFixed(2);
                count=count-oq;
                count=count+nq;
                var ds=$('#discount_val').val();
                if(ds.indexOf("%")!==-1){
                    var pds=ds.split("%");
                    var discount=(total*parseFloat(pds[0]))/100;
                    var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                    $("#ds_con").text(discount.toFixed(2))
                }else{
                    var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                    $("#ds_con").text(parseFloat(ds).toFixed(2))
                }
                var ts=$('#tax_val').val();
                if(ts.indexOf("%")!==-1){
                    var pts=ts.split("%");
                    var tax=(total*parseFloat(pts[0]))/100;
                    var g_total=(total+tax)-parseFloat($('#ds_con').text());
                    $("#ts_con").text(tax.toFixed(2))
                }else{
                    var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                    $("#ts_con").text(parseFloat(ts).toFixed(2))
                }
                grand_total=parseFloat(g_total).toFixed(2);
                $('#price-'+rw).val(np);
                $('#quantity-'+rw).val(nq);
                if($('#proModalLabel').text().length>13){
                    pName=$('#proModalLabel').text().substring(0,13)+'..'
                }else{
                    pName=$('#proModalLabel').text()
                }
                $("#total-payable").text(grand_total);
                $("#total").text(current);
                $("#count").text(count-1);
                $('#price_'+rw).text((np*nq).toFixed(2));
                $('#'+rw).text(pName+' @ '+np.toFixed(2));
                $('#proModal').modal('hide');
                return false
            });
            if(KB==1){
                $("#saletbl").on("focus",".keyboard",function(){
                    key_pad()
                });
                $('.kbp-input').keyboard({
                    restrictInput:true,
                    preventPaste:true,
                    autoAccept:true,
                    alwaysOpen:false,
                    openOn:'click',
                    layout:'costom',
                    display:{
                        'a':'\u2714:Accept (Shift-Enter)',
                        'accept':'Accept:Accept (Shift-Enter)',
                        'b':'\u2190:Backspace',
                        'bksp':'Bksp:Backspace',
                        'c':'\u2716:Cancel (Esc)',
                        'cancel':'Cancel:Cancel (Esc)',
                        'clear':'C:Clear'},
                    position:{
                        of:$('.ui-kbnum'),
                        my:'center top',
                        at:'center top',
                        at2:'center bottom'
                    },
                    usePreview:false,
                    customLayout:{
                        'default':['1 2 3 {clear}',
                            '4 5 6 .',
                            '7 8 9 0',
                            '{accept} {cancel}']
                    }
                });
                $('.kbq-input').keyboard({
                    restrictInput:true,
                    preventPaste:true,
                    autoAccept:true,
                    alwaysOpen:false,
                    openOn:'click',
                    layout:'costom',
                    display:{
                        'a':'\u2714:Accept (Shift-Enter)',
                        'accept':'Accept:Accept (Shift-Enter)',
                        'b':'\u2190:Backspace',
                        'bksp':'Bksp:Backspace',
                        'c':'\u2716:Cancel (Esc)',
                        'cancel':'Cancel:Cancel (Esc)',
                        'clear':'C:Clear'
                    },
                    position:{
                        of:null,
                        my:'center top',
                        at:'center top',
                        at2:'center bottom'
                    },
                    usePreview:false,
                    customLayout:{
                        'default':['1 2 3 {b}',
                            '4 5 6 {clear}',
                            '7 8 9 0',
                            '{accept} {cancel}']
                    }
                });
                function key_pad(){
                    $('.keyboard').keyboard({
                        restrictInput:true,
                        preventPaste:true,
                        autoAccept:true,
                        alwaysOpen:false,
                        openOn:'click',
                        layout:'costom',
                        display:{
                            'a':'\u2714:Accept (Shift-Enter)',
                            'accept':'Accept:Accept (Shift-Enter)',
                            'b':'\u2190:Backspace',
                            'bksp':'Bksp:Backspace',
                            'c':'\u2716:Cancel (Esc)',
                            'cancel':'Cancel:Cancel (Esc)',
                            'clear':'C:Clear'
                        },
                        position:{
                            of:null,
                            my:'center top',
                            at:'center top',
                            at2:'center bottom'
                        },
                        usePreview:
                            false,
                        customLayout:{
                            'default':['1 2 3 {b}',
                                '4 5 6 {clear}',
                                '7 8 9 0',
                                '{accept} {cancel}']
                        },
                        beforeClose:function(e,keyboard,el,accepted){
                            var before_qty=parseInt(keyboard.originalContent);
                            var after_qty=parseInt(el.value);
                            var row_id=$(this).attr('id');
                            var sp_id=row_id.split("-");
                            var id_no=sp_id[1];
                            var p='#price-'+id_no;
                            var p1='#price_'+id_no;
                            var product_price=parseFloat($.trim($(p).val()));
                            var row_price=parseFloat($.trim($(p1).text()));
                            var gross_total=after_qty*product_price;
                            gross_total=parseFloat(gross_total).toFixed(2);
                            var b_count=(count-before_qty);
                            var a_count=(b_count+after_qty);
                            count=a_count;
                            var b_total=(total-row_price);
                            var a_total=(parseFloat(b_total)+parseFloat(gross_total));
                            total=a_total;
                            $(p1).empty();
                            $(p1).append(gross_total);
                            current=parseFloat(total).toFixed(2);
                            var ds=$('#discount_val').val();
                            if(ds.indexOf("%")!==-1){
                                var pds=ds.split("%");
                                var discount=(total*parseFloat(pds[0]))/100;
                                var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                                $("#ds_con").text(discount.toFixed(2))
                            }else{
                                var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                                $("#ds_con").text(parseFloat(ds).toFixed(2))
                            }
                            var ts=$('#tax_val').val();
                            if(ts.indexOf("%")!==-1){
                                var pts=ts.split("%");
                                var tax=(total*parseFloat(pts[0]))/100;
                                var g_total=(total+tax)-parseFloat($('#ds_con').text());
                                $("#ts_con").text(tax.toFixed(2))
                            }else{
                                var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                                $("#ts_con").text(parseFloat(ts).toFixed(2))
                            }
                            grand_total=parseFloat(g_total).toFixed(2);
                            $("#total-payable").text(grand_total);
                            $("#total").text(current);
                            $("#count").text(count-1)
                        }
                    })
                }
            }
            else{
                function key_pad(){}
                var before_qty,after_qty;
                $(".nkb-input").live("focus",function(){
                    before_qty=parseInt($(this).val())
                });
                $(".nkb-input").live("change",function(e){
                    after_qty=parseInt($(this).val());
                    var row_id=$(this).attr('id');
                    var sp_id=row_id.split("-");
                    var id_no=sp_id[1];
                    var p='#price-'+id_no;
                    var p1='#price_'+id_no;
                    var product_price=parseFloat($.trim($(p).val()));
                    var row_price=parseFloat($.trim($(p1).text()));
                    var gross_total=after_qty*product_price;
                    gross_total=parseFloat(gross_total).toFixed(2);
                    var b_count=(count-before_qty);
                    var a_count=(b_count+after_qty);
                    count=a_count;
                    var b_total=(total-row_price);
                    var a_total=(parseFloat(b_total)+parseFloat(gross_total));
                    total=a_total;
                    $(p1).empty();
                    $(p1).append(gross_total);
                    current=parseFloat(total).toFixed(2);
                    var ds=$('#discount_val').val();
                    if(ds.indexOf("%")!==-1){
                        var pds=ds.split("%");
                        var discount=(total*parseFloat(pds[0]))/100;
                        var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                        $("#ds_con").text(discount.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                        $("#ds_con").text(parseFloat(ds).toFixed(2))
                    }
                    var ts=$('#tax_val').val();
                    if(ts.indexOf("%")!==-1){
                        var pts=ts.split("%");
                        var tax=(total*parseFloat(pts[0]))/100;
                        var g_total=(total+tax)-parseFloat($('#ds_con').text());
                        $("#ts_con").text(tax.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                        $("#ts_con").text(parseFloat(ts).toFixed(2))
                    }
                    grand_total=parseFloat(g_total).toFixed(2);
                    $("#total-payable").text(grand_total);
                    $("#total").text(current);
                    $("#count").text(count-1)
                })
            }
            $(document).bind('keypress',function(e){
                if(e.keyCode==13){
                    e.preventDefault();
                    return false
                }
            });
            function add_row(){
                $('button[id^="product"]').click(function(){
                    if(count>=1000){
                        bootbox.alert("You have reached the quanrity limit 999.");
                        return false
                    }
                    if(an>=51){
                        bootbox.alert("Max Allowed Reached! Please add payment for this and open new bill for all next items. Thank you!");
                        $('#loading').hide();
                        var divElement=document.getElementById('protbldiv');
                        divElement.scrollTop=divElement.scrollHeight;
                        return false
                    }
                    $('#loading').show();
                    var v=$(this).val();
                    $.ajax({
                        type:"get",
                        async:false,
                        url:"index.php?module=pos&view=price",
                        data:{code:v},
                        dataType:"json",
                        success:function(data){
                            item_price=parseFloat(data).toFixed(2)
                        }
                    });
                    var leng=$(this).attr('id').length;
                    var last=$(this).attr('id').substr(leng-4);
                    var pric='price'+last;
                    var quan='quantity'+last;
                    var code='code'+last;
                    var pr_name=$(this).attr('data-name');
                    var prod_name=$.trim(pr_name);
                    if(prod_name.length>13){
                        pName=prod_name.substring(0,13)+'..'
                    }else{
                        pName=prod_name
                    }
                    var rcount=count;
count=rt;
                    var newTr=$('<tr id="row_'+count+last+'"></tr>');
                    newTr.html('<td class="satu" style="width: 9%;">' +
                        '<button class="del_row" id="del-'+count+last+'" value="'+item_price+'">' +
                        '<i class="glyphicon glyphicon-remove-circle"></i>' +
                        '</button></td><td style="width: 53%;">' +
                        '<input type="hidden" class="code" name="product'+count+'" value="'+prod_name+'" id="product-'+count+last+'">' +
                        '<button type="button" class="btn btn-warning btn-block btn-xs prod_name tip text-left" data-name="'+prod_name+'" id="'+count+last+'">'+
                        pName+' @ '+item_price+'</button><span class="printspan">'+prod_name+'</span></td><td style="width: 12%; text-align:center;">' +
                        '<input class="keyboard nkb-input" name="quantity'+count+'" type="text" value="1" id="quantity-'+count+last+
                        '" onclick="this.select();" autocomplete="off"></td><td style="width: 26%;" class="text-right">' +
                        '<input type="hidden" class="price" name="price'+count+'" value="'+item_price+'" id="price-'+count+last+
                        '"><span id="price_'+count+last+'">'+item_price+'</span></td>');
                    newTr.appendTo("#saletbl");
                    total+=parseFloat(item_price);
                    current=parseFloat(total).toFixed(2);
                    var ds=$('#discount_val').val();
                    if(ds.indexOf("%")!==-1){
                        var pds=ds.split("%");
                        var discount=(total*parseFloat(pds[0]))/100;
                        var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                        $("#ds_con").text(discount.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                        $("#ds_con").text(parseFloat(ds).toFixed(2))
                    }
                    var ts=$('#tax_val').val();
                    if(ts.indexOf("%")!==-1){
                        var pts=ts.split("%");
                        var tax=(total*parseFloat(pts[0]))/100;
                        var g_total=(total+tax)-parseFloat($('#ds_con').text());
                        $("#ts_con").text(tax.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                        $("#ts_con").text(parseFloat(ts).toFixed(2))
                    }
                    grand_total=parseFloat(g_total).toFixed(2);
                    count=rcount;
                    $("#total-payable").text(grand_total);
                    $("#total").text(current);
                    $("#count").text(count);
                    count++;
                    rt++;
                    an++;
                    var divElement=document.getElementById('protbldiv');
                    divElement.scrollTop=divElement.scrollHeight;
                    $('#loading').hide()
                })
            }
            $('#scancode').keydown(function(e){
                if(e.keyCode==13){
                    if(count>=1000){
                        bootbox.alert("You have reached the quanrity limit 999.");
                        return false
                    }
                    if(an>=51){
                        bootbox.alert("Max Allowed Reached! Please add payment for this and open new bill for all next items. Thank you!");
                        $('#loading').hide();
                        var divElement=document.getElementById('protbldiv');
                        divElement.scrollTop=divElement.scrollHeight;
                        return false
                    }
                    $('#loading').show();
                    var v=$(this).val();
                    $.ajax({
                        type:"get",
                        async:false,
                        url:"index.php?module=pos&view=scan_product",
                        data:{code:v},
                        dataType:"json",
                        success:function(data){
                            if(data==null){
                                bootbox.alert('Request Failed, Please check your code and try again!');
                                item_price=false
                            }else{
                                item_price=parseFloat(data.item_price).toFixed(2);
                                sproduct_name=data.product_name;
                                slast=data.last
                            }
                        },
                        error:function(){
                            bootbox.alert('Request Failed, Please check your code and try again!');
                            item_price=false
                        }
                    });
                    if(item_price==false){
                        $(this).val('');
                        $('#loading').hide();
                        return false
                    }
                    if(sproduct_name.length>13){
                        pName=sproduct_name.substring(0,13)+'..'
                    }else{
                        pName=sproduct_name
                    }
                    var rcount=count;
                    count=rt;
                    var newTr=$('<tr id="row_'+count+slast+'"></tr>');
                    newTr.html('<td class="satu" style="width: 9%;"><button class="del_row" id="del-'+count+slast+
                        '" value="'+item_price+'"><i class="glyphicon glyphicon-remove-circle"></i></button></td>' +
                        '<td style="width: 53%;"><input type="hidden" class="code" name="product'+count+'" value="'+
                        sproduct_name+'" id="product-'+count+slast+'"><button type="button" ' +
                        'class="btn btn-warning btn-block btn-xs prod_name tip text-left" data-name="'+
                        sproduct_name+'" id="'+count+slast+'">'+pName+' @ '+item_price+'</button><span class="printspan">'+
                        sproduct_name+'</span></td><td style="width: 12%; text-align:center;">' +
                        '<input class="keyboard nkb-input" name="quantity'+count+'" type="text" value="1" id="quantity-'+count+
                        slast+'" onclick="this.select();" autocomplete="off"></td><td style="width: 26%;" class="text-right">' +
                        '<input type="hidden" class="price" name="price'+count+'" value="'+item_price+'" id="price-'+count+slast+
                        '"><span id="price_'+count+slast+'">'+item_price+'</span></td>');
                    newTr.appendTo("#saletbl");
                    total+=parseFloat(item_price);
                    current=parseFloat(total).toFixed(2);
                    var ds=$('#discount_val').val();
                    if(ds.indexOf("%")!==-1){
                        var pds=ds.split("%");
                        var discount=(total*parseFloat(pds[0]))/100;
                        var g_total=(total+parseFloat($('#ts_con').text()))-discount;
                        $("#ds_con").text(discount.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat(ds);
                        $("#ds_con").text(parseFloat(ds).toFixed(2))
                    }
                    var ts=$('#tax_val').val();
                    if(ts.indexOf("%")!==-1){
                        var pts=ts.split("%");
                        var tax=(total*parseFloat(pts[0]))/100;
                        var g_total=(total+tax)-parseFloat($('#ds_con').text());
                        $("#ts_con").text(tax.toFixed(2))
                    }else{
                        var g_total=(total+parseFloat(ts))-parseFloat($('#ds_con').text());
                        $("#ts_con").text(parseFloat(ts).toFixed(2))
                    }
                    grand_total=parseFloat(g_total).toFixed(2);
                    count=rcount;
                    $("#total-payable").text(grand_total);
                    $("#total").text(current);
                    $("#count").text(count);
                    count++;
                    rt++;
                    an++;
                    var divElement=document.getElementById('protbldiv');
                    divElement.scrollTop=divElement.scrollHeight;
                    $(this).val('');
                    $('#loading').hide();
                    e.preventDefault();
                    return false
                }
            });
            $("#cancel").click(function(){
                bootbox.confirm("Are you sure to canncel the sale?",function(result){
                    if(result==true){
                        $("#saletbl").empty();
                        count=1,total=0,tax_value=0,an=1;
                        $("#ds_con").text('0');
                        $('#ts_con').text('0');
                        $("#total-payable").text('0.00');
                        $("#total").text('0.00');
                        $("#count").text(count-1)
                    }
                })
            });
            $("#payment").click(function(){
                $("#pay").empty();
                var g_total=(total+parseFloat($('#ts_con').text()))-parseFloat($('#ds_con').text());
                twt=parseFloat(g_total).toFixed(2);
                count=count-1;
                if(isNaN(twt)||twt=='0.00'){
                    bootbox.alert('Please add product to sale first');
                    count=count+1;
                    return false
                }
                twt=parseFloat(twt).toFixed(2);
                $('#twt').text(twt);
                $('#fcount').text(count);
                $('#payModal').modal();
                count=count+1;
                $('#total_item').val(count);
                $('.pcustomer').change(function(){
                    $('#customer').val($(this).val())
                });
                $('#paid-amount').change(function(){
                    $('#paid_val').val($(this).val())
                });
                $('#pcc').change(function(){
                    $('#cc_no_val').val($(this).val())
                });
                $('#pcc_holder').change(function(){
                    $('#cc_holder_val').val($(this).val())
                });
                $('#cheque_no').change(function(){
                    $('#cheque_no_val').val($(this).val())
                });
                $("#paid_by").change(function(){
                    var p_val=$(this).val();
                    $('#rpaidby').val(p_val);
                    if(p_val=='cash'){
                        $('.pcheque').hide();
                        $('.pcc').hide();
                        $('.pcash').show();
                        $('input[id^="paid-amount"]').keydown(function(e){
                            paid=$(this).val();
                            if(e.keyCode==13){
                                if(paid<total){
                                    bootbox.alert('Paid amount is less than payable amount');
                                    return false
                                }
                                $("#balance").empty();
                                var balance=paid-twt;
                                balance=parseFloat(balance).toFixed(2);
                                $("#balance").append(balance);
                                e.preventDefault();
                                return false
                            }
                        })
                    }
                    else if(p_val=='CC'){
                        $('.pcheque').hide();
                        $('.pcash').hide();
                        $('.pcc').show()
                    }
                    else if(p_val=='Cheque'){
                        $('.pcc').hide();
                        $('.pcash').hide();
                        $('.pcheque').show()
                    }else{
                        $('.pcheque').hide();
                        $('.pcc').hide();
                        $('.pcash').hide()
                    }
                });
                if(KB==1){
                    $('#paid-amount, kb-input').keyboard({
                        restrictInput:true,
                        preventPaste:true,
                        autoAccept:true,
                        alwaysOpen:false,
                        openOn:'click',
                        layout:'costom',
                        display:{
                            'a':'\u2714:Accept (Shift-Enter)',
                            'accept':'Accept:Accept (Shift-Enter)',
                            'b':'\u2190:Backspace',
                            'bksp':'Bksp:Backspace',
                            'c':'\u2716:Cancel (Esc)',
                            'cancel':'Cancel:Cancel (Esc)',
                            'clear':'C:Clear'
                        },
                        position:{
                            of:null,
                            my:'center top',
                            at:'center top',
                            at2:'center bottom'
                        },
                        usePreview:false,
                        customLayout:{
                            'default': ['1 2 3 {clear}','4 5 6 .','7 8 9 0','{accept} {cancel}']
                        },
                        beforeClose:function(e,keyboard,el,accepted){
                            var paid=parseFloat(el.value);
                            if(paid<twt){
                                bootbox.alert('Paid amount is less than payable amount');
                                $(this).val('');
                                return false
                            }
                            $("#balance").empty();
                            var balance=paid-twt;
                            balance=parseFloat(balance).toFixed(2);
                            $("#balance").append(balance)                                                                                                        }
                    })
                }else{
                      $("#payModal").on("change",'#paid-amount',function(){
                          var paid=parseFloat($(this).val());
                          if(paid<twt){
                              bootbox.alert('Paid amount is less than payable amount');
                              $(this).val('');
                              return false
                          }
                          $("#balance").empty();
                          var balance=paid-twt;
                          balance=parseFloat(balance).toFixed(2);
                          $("#balance").append(balance)
                      })
                }
                $('#submit-sale').click(function(){
                    $('#submit').trigger('click')
                })
            });
            $('#hold').click(function(){
                if(count<=1){
                    bootbox.alert('Plesae add product before saving bill');
                    return false
                }
                suspend=$('<span></span>');
                suspend.html('<input type="hidden" name="suspend" value="yes" />');
                suspend.appendTo("#hidesuspend");
                $('#total_item').val(count);
                $('#susModal').modal();
                $('.pcustomer').change(function(){
                    $('#customer').val($(this).val())
                });
                $('#hold_ref_v').change(function(){
                    $('#hold_ref').val($(this).val())
                });
                $('#submit-hold').click(function(){
                    if($('#hold_ref_v').val()!=''){
                        $('#submit').trigger('click')
                    }else{
                        bootbox.alert('Please type the hold bill referebce');
                        return false
                    }
                })
            });
        });
        if(DTIME){
            function sivamtime(){
                now=new Date();
                var month_names=new Array();
                month_names[month_names.length]="January";
                month_names[month_names.length]="February";
                month_names[month_names.length]="March";
                month_names[month_names.length]="April";
                month_names[month_names.length]="May";
                month_names[month_names.length]="June";
                month_names[month_names.length]="July";
                month_names[month_names.length]="August";
                month_names[month_names.length]="September";
                month_names[month_names.length]="October";
                month_names[month_names.length]="November";
                month_names[month_names.length]="December";
                var day_names=new Array();
                day_names[day_names.length]="Sunday";
                day_names[day_names.length]="Monday";
                day_names[day_names.length]="Tuesday";
                day_names[day_names.length]="Wednesday";
                day_names[day_names.length]="Thursday";
                day_names[day_names.length]="Friday";
                day_names[day_names.length]="Saturday";
                hour=now.getHours();
                min=now.getMinutes();
                sec=now.getSeconds();
                if(min<=9){
                    min="0"+min
                }
                if(sec<=9){
                    sec="0"+sec
                }
                if(hour>12){
                    hour=hour-12;
                    add="PM"
                }else{
                    hour=hour;
                    add="AM"
                }
                if(hour==12){
                    add="PM"
                }
                time=day_names[now.getDay()]+", "+
                    now.getDate()+" "+month_names[now.getMonth()]+" "+
                    now.getFullYear()+", "+
                    ((hour<=9)?"0"+hour:hour)+
                    ":"+min+":"+sec+" "+add;
                if(document.getElementById){
                        document.getElementById('cur-time').innerHTML=time
                }else if(document.layers){
                    document.layers.theTime.document.write(time);
                    document.layers.theTime.document.close()
                }
                setTimeout("sivamtime()",1000)
            }
            window.onload=sivamtime
        }
    </script>
</body>
</html>
