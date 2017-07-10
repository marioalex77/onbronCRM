<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="http://demo.tecdiary.my/spos/" />
<title>Change Password | Simple POS</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="http://demo.tecdiary.my/spos/assets/images/favicon.ico" />
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/bootstrap.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/datatables.css" type="text/css">
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/dash.css" type="text/css">
<link rel="stylesheet" href="http://demo.tecdiary.my/spos/assets/css/non-responsive.css" type="text/css">
<script src="http://demo.tecdiary.my/spos/assets/js/jquery-1.7.2.min.js"></script>
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
<div class="navbar navbar-static-top navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand">Simple POS</a> 
    </div>
    <div class="navbar-collapse collapse navbar-inverse-collapse">
      <ul class="nav navbar-nav">
        <li class="dropdown"> <a class="dropdown-toggle tip" data-toggle="dropdown" href="#" data-placement="right" title="Language"><img src="http://demo.tecdiary.my/spos/assets/images/english.png" style="margin-top:-1px" align="middle"></a>
          <ul class="dropdown-menu" style="min-width: 60px;" role="menu" aria-labelledby="dLabel">
                        <li><a href="http://demo.tecdiary.my/spos/index.php?module=pos&view=language&lang=english"><img src="http://demo.tecdiary.my/spos/assets/images/english.png" class="language-img"> &nbsp;&nbsp;
              English              </a></li>
                      </ul>
        </li>
         
        <li><a href="http://demo.tecdiary.my/spos/index.php?module=settings" class="tip" data-placement="right" title="Home"><i class="glyphicon glyphicon-home"></i></a></li>
        <li><a href="http://demo.tecdiary.my/spos/index.php?module=settings&view=system_setting" class="tip" data-placement="right" title="Settings"><i class="glyphicon glyphicon-cog"></i></a></li>
                <li><a href="http://demo.tecdiary.my/spos/index.php?module=pos" class="tip" data-placement="right" title="POS Sale"><i class="glyphicon glyphicon-th-large"></i></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi, Admin! <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="http://demo.tecdiary.my/spos/index.php?module=auth&amp;view=change_password">Change Password</a></li>
            <li><a href="http://demo.tecdiary.my/spos/index.php?module=auth&amp;view=logout">Logout</a></li>
          </ul>
        </li>
      </ul>
      
      <div class="pull-right">
                <a href="http://codecanyon.net/item/simple-pos-point-of-sale-made-easy/3947976?ref=tecdiary" class="tip btn btn-default btn-sm pull-left external" style="padding:5px 8px; margin: 5px 5px 5px 5px;" title="<strong>Liked?</strong> Let's Purchase<br><strong>Have Suggestion?</strong> Please send email to contact@tecdiary.com" data-html="true" data-placement="bottom"> Buy Now </a>
                      
      <ul class="nav navbar-nav">
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Products          <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="index.php?module=products">
              List Products              </a></li>
            <li><a href="index.php?module=products&view=add">
              Add Product              </a></li>
            <li><a href="index.php?module=products&view=import">
              Import by CSV              </a></li>
            <li><a href="index.php?module=products&view=sheet">
              Print Barcode              </a></li>
            <li><a href="index.php?module=products&view=labels">
              Print Lablels              </a></li>    
              <li class="divider"></li>
              <li><a href="index.php?module=products&view=categories">
              List Categories              </a></li>
            <li><a href="index.php?module=products&view=add_category">
              Add Category              </a></li>
          </ul>
        </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Customers          <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="index.php?module=customers">
              List Customers              </a></li>
            <li><a href="index.php?module=customers&view=add">
              Add Customer              </a></li>
          </ul>
        </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Sales          <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="index.php?module=sales">
              List Sales              </a></li>
            <li><a href="index.php?module=sales&view=holded">
              List Opened Bills              </a></li>
          </ul>
        </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Reports          <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="index.php?module=reports&view=daily_sales">
              Daily Sales              </a></li>
            <li><a href="index.php?module=reports&view=monthly_sales">
              Monthly Sales              </a></li>
            <li><a href="index.php?module=reports">
              Sales Reports              </a></li>
              <li class="divider"></li>
              <li><a href="index.php?module=reports&view=top">
              Top Products              </a></li>
              <li><a href="index.php?module=reports&view=products">
              Products Reports              </a></li>
          </ul>
        </li> 
        </ul>
          
        </div>
    </div>
  </div>
</div>


<div class="container">
	<h3>Change Password</h3>

<form action="http://demo.tecdiary.my/spos/index.php?module=auth&view=change_password" method="post" accept-charset="utf-8"><div style="display:none">
<input type="hidden" name="csrf_pos" value="72f7b0475e76039ea70691da71dc43c9" />
</div>
<div class="row">
  <div class="col-xs-6">
   <div class="form-group">
	<label class="control-label" for="old_password">Old Password</label>
  	<input type="password" name="old" value="" id="old" class="form-control input-sm" id="old_password" />   </div>
  </div> 
</div>

<div class="row">
  <div class="col-xs-6">
   <div class="form-group">
	<label class="control-label" for="new_password">New Password</label>
  	<input type="password" name="new" value="" id="new" pattern="^.{8}.*$" class="form-control input-sm" id="new_password" />    <div class="inline-help">Please enter new password (minimum 8 characters long)</div>
   </div>
  </div>
</div>

<div class="row">
  <div class="col-xs-6">
   <div class="form-group">
	<label class="control-label" for="new_password_confirm">Confirm Password</label>
  	<input type="password" name="new_confirm" value="" id="new_confirm" pattern="^.{8}.*$" class="form-control input-sm" id="new_password_confirm" />    <div class="inline-help">Please type the new password again</div>
   </div>
  </div> 
</div>

      
      <input type="hidden" name="user_id" value="1" id="user_id"  />      <input type="submit" name="submit" value="Change Password" class="btn btn-primary btn-sm" />      
</form></div>
</div>
<div id="footer">
  <div class="container">
    <p class="credit">Copyright &copy; 2017 Simple POS v3.0 - Page rendered in 0.0097 seconds. 
    <a href="http://tecdiary.net/support/sma-guide/" target="_blank" class="tip" title="Help"><i class="icon-question-sign"></i></a>
    </p>   
  </div>
</div>
<script type="text/javascript" src="http://demo.tecdiary.my/spos/assets/js/bootstrap.min.js"></script>
<script src="http://demo.tecdiary.my/spos/assets/js/bootstrap-prettyfile.js"></script> 
<script src="http://demo.tecdiary.my/spos/assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="http://demo.tecdiary.my/spos/assets/js/jquery.dataTables.min.js"></script> 
<script type="text/javascript" charset="utf-8" src="http://demo.tecdiary.my/spos/assets/media/js/ZeroClipboard.js"></script> 
<script type="text/javascript" charset="utf-8" src="http://demo.tecdiary.my/spos/assets/media/js/TableTools.min.js"></script> 
<script type="text/javascript" src="http://demo.tecdiary.my/spos/assets/js/DT_bootstrap.js"></script>
   
</body>
</html>
