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
	<title>微网站－在线申请</title>
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
    
    <script src="<%=request.getContextPath()%>/js/bh-provinceandcity.js"></script>
    
    <style type="text/css">html { overflow: hidden; } </style>
  </head>

  <body onload="loadProvince('province_id', 'city_id');">
    <div class="container" style="padding-top:30px;">
      	<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal tasi-form">
      	<input type="hidden" id="favor_id" name="favor_id" value="${favor_id}"/>
		<div class="row">
  			<div class="col-sm-12">
  				<input type="text" style="width:100%;" class="form-control" id="cust_name" name="cust_name" placeholder="输入客户姓名"/>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:0px;">
  				<label class="radio-inline" style="padding-left:0px;">性别</label>
  				<label class="radio-inline"><input type="radio" id="cust_sex" name="cust_sex" value="01" checked>男</label>
  				<label class="radio-inline"><input type="radio" id="cust_sex" name="cust_sex" value="00">女</label>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="cust_card" name="cust_card" placeholder="输入身份证号码">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
				<select style="width:100%;" class="form-control" id="car_type" name="car_type">
					<option value="">选择品牌</option>
					<c:forEach items="${car_types}" varStatus="status" var="item" >
					<option value="${item.id}">${item.value}</option>
					</c:forEach>
				</select>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="car_price" name="car_price" placeholder="输入车价">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;">
  				<input type="text" style="width:100%;" class="form-control" id="cust_phone" name="cust_phone" placeholder="输入手机号"/>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-xs-6" style="padding-top:10px;">
				<select style="width:95%;" class="form-control" id="province_id" name="province_id" onchange="loadCity(this,'city_id');">
				</select>
  			</div>
  			<div class="col-xs-6" style="padding-top:10px;">
				<select style="width:95%;" class="form-control" id="city_id" name="city_id">
				</select>
  			</div>
  		</div>
  		<div class="row">
  			<div id="carTypeDiv" name="carTypeDiv" class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12">
  				<label class="radio-inline"  style="padding-left:0px;">
  					<input type="checkbox" id="favor_expert" name="favor_expert"/>&nbsp;是否来自转介绍
  				</label>
  			</div>
  		</div>
		<div class="col-sm-12" id="favor_expert_info" name="favor_expert_info">
  			<div class="row">
	  			<div class="col-sm-12" style="padding-top:10px;">
	  				<input type="text" style="width:100%;" class="form-control" id="name" name="name" placeholder="推荐人姓名"/>
	  			</div>
	  		</div>
	  		<div class="row">
	  			<div class="col-sm-12" style="padding-top:10px;">
	  				<input type="text" style="width:100%;" class="form-control" id="phone" name="phone" placeholder="推荐人手机号码"/>
	  			</div>
	  		</div>
	  		<div class="row">
	  			<div class="col-sm-12" style="padding-top:10px;">
	  				<input type="text" style="width:100%;" class="form-control" id="presentee_name" name="presentee_name" placeholder="被推荐人姓名"/>
	  			</div>
	  		</div>
	  		<div class="row">
	  			<div class="col-sm-12" style="padding-top:10px;">
	  				<input type="text" style="width:100%;" class="form-control" id="presentee_phone" name="presentee_phone" placeholder="被推荐人手机号码"/>
	  			</div>
	  		</div>
  		</div>
  							
  		<div class="row">
   			<div class="col-sm-12" style="padding-top:10px;">
	   			<button style="width:100%;" type="button" onclick="saveObj('<%=request.getContextPath()%>/car/order_save.htm', 'thisForm', 'error_mgs');" class="btn btn-success">确认提交</button>
   			</div>
   		</div>
   		</br></br>
    	</form>
  	</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
	<script type="text/javascript">
	//初始化品牌和车系
	setCarType(document.getElementById('car_type').value, '');
	function setTypeName(val){
		document.getElementById('car_type_name').value=val;
	}
	$(document).ready(function () {
	  	$("#favor_expert").click(function(){
	  		if(document.getElementById("favor_expert").checked){
	  			$.ajax({
	  		        cache: true,
	  		        type: "POST",
	  		        url: '<%=request.getContextPath()%>/car/introducer.htm',
	  		        timeout: 10000,
	  		        data:$('#thisForm').serialize(),// 你的formid
	  		        async: false,
	  		        error: function(request) {
	  		            alert("网络异常，请稍后再试");
	  		        },
	  		        success: function(data) {
	  		        	if(!data.success){
	  		        		document.getElementById("favor_expert").checked = false;
	  		        		document.getElementById("error_mgs").innerHTML=data.msg;
	  		        	}else{
		  		  			document.getElementById("error_mgs").innerHTML="";
		  		  			document.getElementById("favor_expert_info").innerHTML=data.msg;
	  		        	}
	  		        }
	  		    });
	  		}else{
	  			document.getElementById("favor_expert_info").innerHTML="";
	  		} 
	  	});
	});
	function setCarType(pId, sId){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url: '<%=request.getContextPath()%>/car/carType.htm',
	        timeout: 10000,
	        data:"parent_id="+pId+"&id="+sId,// 参数
	        async: false,
	        error: function(request) {
	            alert("网络异常，请稍后再试");
	        },
	        success: function(data) {
	        	if(!data.success){
	        		document.getElementById("error_mgs").innerHTML=data.msg;
	        	}else{
 		  			document.getElementById("error_mgs").innerHTML="";
 		  			document.getElementById("carTypeDiv").innerHTML=data.msg;
	        	}
	        }
	    });
	}
	</script>
  </body>
</html>