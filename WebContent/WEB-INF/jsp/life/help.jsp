<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.car.utils.CarConfig"%>
<%@page import="com.car.utils.Constant"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png">
	<title>微网站－车生活－理财试算</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">html { overflow: hidden; } </style>
  </head>
  <body>
    <div class="container" style="padding-top:30px;">
      	<form action="" method="POST" id="frm1" name="frm1" class="form-horizontal tasi-form">
		<div class="row">
  			<div class="col-sm-12">
  				<input type="text" style="width:100%;" class="form-control" id="idx1" placeholder="输入每月收入" name="idx1" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();"/>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx2" placeholder="输入每月支出" name="idx2" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx3" placeholder="输入固定家用" name="idx3" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx4" placeholder="输入信用卡款" name="idx4" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx5" placeholder="输入水电费" name="idx5" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx6" placeholder="输入其他费用" name="idx6" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx7" placeholder="输入其他贷款" name="idx7" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12">
  				<!-- <input type="text" style="width:100%;" class="form-control" id="idx8" name="idx8" value="0" readonly> -->
  				<label class="checkbox-inline" style="padding-left:0px;">每月结余：</label><label class="checkbox-inline" style="right:0px;float:right;" id="idx8" name="idx8">0</label>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<!-- <input type="text" style="width:100%;" class="form-control" id="idx9" name="idx9" value="0" readonly> -->
  				<label class="checkbox-inline" style="padding-left:0px;">每月购车可付款：</label><label class="checkbox-inline" style="right:0px;float:right;" id="idx9" name="idx9">0</label>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<select style="width:100%;" class="form-control" id="s1" name="s1" onchange="javascript:calit();">
  					<option value="">选择贷款分期</option>
  					<option selected value='12'>12期</option>
                    <option value='24'>24期</option>
                    <option value='30'>30期</option>
                    <option value='36'>36期</option>
                    <option value='48'>48期</option>
                    <option value='60'>60期</option>
  				</select>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<!-- <input type="text" style="width:100%;" class="form-control" id="idx10" name="idx10" value="0" readonly> -->
  				<label class="checkbox-inline" style="padding-left:0px;">可贷款金额：</label><label class="checkbox-inline" style="right:0px;float:right;" id="idx10" name="idx10">0</label>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="idx11" placeholder="输入自备头款" name="idx11" onfocus="javascript:doit(this);" onblur="javascript:doit2(this);" onkeyup="javascript:calit();">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<!-- <input type="text" style="width:100%;" class="form-control" id="idx12" name="idx12" value="0" readonly> -->
  				<label class="checkbox-inline" style="padding-left:0px;">可购买车款总额：</label><label class="checkbox-inline" style="right:0px;float:right;" id="idx12" name="idx12">0</label>
  			</div>
  		</div>
  		<div class="row">
   			<div class="col-sm-12" style="padding-top:10px;padding-bottom:15px;">
	   			<button style="width:100%;" type="button" class="btn btn-default active" onclick='javascript:cleanit();'>清理重算</button>
   			</div>
   		</div>
    	</form>
  	</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
	<script type="text/javascript">
	var frm1 = document.getElementById('frm1');
	function calit(){
	    var v_idx1 = document.getElementById('idx1').value==""?0:document.getElementById('idx1').value;
	    var v_idx2 = document.getElementById('idx2').value==""?0:document.getElementById('idx2').value;
	    var v_idx3 = frm1.idx3.value==""?0:frm1.idx3.value;
	    var v_idx4 = frm1.idx4.value==""?0:frm1.idx4.value;
	    var v_idx5 = frm1.idx5.value==""?0:frm1.idx5.value;
	    var v_idx6 = frm1.idx6.value==""?0:frm1.idx6.value;
	    var v_idx7 = frm1.idx7.value==""?0:frm1.idx7.value;
	    var v_idx8 = parseFloat(v_idx1) - parseFloat(v_idx2) - parseFloat(v_idx3) - parseFloat(v_idx4) - parseFloat(v_idx5) - parseFloat(v_idx6) - parseFloat(v_idx7);
	    var v_idx9 = parseFloat(v_idx8) * 0.9;
	    var v_idx10= parseFloat(v_idx9) * parseFloat(frm1.s1.value) * 0.9;
	    var v_idx11= frm1.idx11.value==""?0:frm1.idx11.value;
	    var v_idx12= parseFloat(v_idx10) + parseFloat(v_idx11);
	    document.getElementById('idx8').innerHTML=v_idx8;
	    document.getElementById('idx9').innerHTML=v_idx9;
	    document.getElementById('idx10').innerHTML=v_idx10;
	    document.getElementById('idx12').innerHTML=v_idx12;
	  }
	  
	  function cleanit(){
	    frm1.idx1.value="";
	    frm1.idx2.value="";
	    frm1.idx3.value="";
	    frm1.idx4.value="";
	    frm1.idx5.value="";
	    frm1.idx6.value="";
	    frm1.idx7.value="";
	    document.getElementById('idx8').innerHTML="0";
	    document.getElementById('idx9').innerHTML="0";
	    document.getElementById('idx10').innerHTML="0";
	    frm1.idx11.value="";
	    document.getElementById('idx12').innerHTML="0";
	    frm1.s1.value="12";
	   	calit();
	  }
	  
	  function doit(obj1){
	    obj1.select();
	  }
	  function doit2(obj1){
	    if (obj1.value==""&&obj1.value.length == 0){
	      obj1.value = "";
	    }
	  }
	
	</script>
  </body>
</html>