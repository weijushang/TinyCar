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
	<title>微网站－优惠详情</title>
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
    
    <style type="text/css">
    html { overflow: hidden; }
    </style>
  </head>

  <body>
	<!-- <div class="header">
	<button style="margin-left:10px;margin-top:7px;" type="button" class="btn btn-primary" onclick="window.history.back();">返回</button>
	</div> -->
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <img width="100%" src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${favorableInfo.file_path}">
   	</div>
    <div class="container">

      <div class="row">
        <h4>${favorableInfo.favor_title}</h4>
        <table border=0 width="100%">
       		<tr>
       			<td>发布时间：${favorableInfo.update_time}</td>
       			<td align="right"><%-- <button type="button" class="btn btn-primary btn-xs"  onclick="window.location.href='<%=request.getContextPath()%>/car/favorable_expert.htm?favorable_id=${favorableInfo.favor_id}'">优惠专家</button> --%></td>
       		</tr>
       	</table>
       	<p>${favorableInfo.favor_detail_str}</p>
       	</br>
       	</br>
       	<table border=0 width="100%">
       		<tr>
       			<td>顾问：${favorableInfo.favor_counselor}</td>
       			<td style="vertical-align:middle;" align="right" rowspan="2">
       			<c:if test="${favorableInfo.hot_line!=null&&favorableInfo.hot_line!=\"\" }">
       			<a href="tel:${favorableInfo.hot_line}">
       			<button type="button" class="btn btn-primary">电话咨询</button>
       			</a>
       			</c:if>
       			</td>
       		</tr>
       		<tr>
       			<td>电话：<a href="tel:${favorableInfo.favor_phone}">${favorableInfo.favor_phone}</a></td>
       		</tr>
       	</table>
      </div>
  	</div> <!-- /container -->
  	
  	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
  </body>
</html>
