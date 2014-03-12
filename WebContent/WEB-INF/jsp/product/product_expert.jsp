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
	<title>微网站－贷款专家</title>
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
	<!-- <div class="header">
	<button style="margin-left:10px;margin-top:7px;" type="button" class="btn btn-primary" onclick="window.history.back();">返回</button>
	</div> -->
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <img width="100%" src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${productInfo.file_path}" alt="${productInfo.product_title}">
   	</div>
    <div class="container">
      	<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal tasi-form">
      	<input type="hidden" id="product_id" name="product_id" value="${productInfo.product_id}">
      	<input type="hidden" id="product_title" name="product_title" value="${productInfo.product_title}">
		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">姓名：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="cust_name" name="cust_name" placeholder="输入姓名">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">手机号码：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="cust_phone" name="cust_phone" placeholder="输入手机号码">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">价格：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="car_price" name="car_price" placeholder="输入车价">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		
  		<div id="error_mgs" name="error_mgs" style="margin-bottom:10px; color: red; text-align: center;"></div>
							
  		<div class="row">
   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;overflow:hidden;">
   				<table width="100%">
   					<tr height="40px">
   						<td align="center">
   							<button type="button" onclick="saveObj('<%=request.getContextPath()%>/car/credit_expert_save.htm', 'thisForm', 'error_mgs');" class="btn btn-info">预约</button>
   						</td>
   					</tr>
   				</table>
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
  </body>
</html>
