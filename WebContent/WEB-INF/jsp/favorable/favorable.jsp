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
	<title>微网站－优惠</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

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
	
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <!-- <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li> -->
          <c:forEach items="${favorable_images}" varStatus="status" var="item">
          <li data-target="#carousel-example-generic" data-slide-to="${status.index}" <c:if test="${status.index==0}">class="active"</c:if>></li>
          </c:forEach>
        </ol>
        <div class="carousel-inner">
          <%-- <div class="item active">
            <img width="100%" src="<%=request.getContextPath()%>/img/car/car_1.png" alt="First slide">
          </div>
          <div class="item">
            <img width="100%" src="<%=request.getContextPath()%>/img/car/car_2.png" alt="Second slide">
          </div> --%>
          <c:forEach items="${favorable_images}" varStatus="status" var="item">
          <div class="item <c:if test="${status.index==0}">active</c:if>" >
            <img width="100%" src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${item.file_path}${item.file_name}" alt="${status.index+1}"/>
          </div>
          </c:forEach>
        </div>
        <c:if test="${favorable_images!=null && fn:length(favorable_images)>0 }">
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
        </c:if>
	</div>



    <div class="container">

      <div class="row">
        <table class="table">
          <c:forEach items="${list}" varStatus="status" var="item">
          <tr>
            <td style="vertical-align:middle;">
            	<div style="margin:2px 2px 2px 2px;width:116px;height:62px;text-align:center;line-height:55px;border-width:1px; border-style:solid; border-color:silver;">
            	<a href="<%=request.getContextPath()%>/car/favorable_detail.htm?favorable_id=${item.favor_id }">
            	<img src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${item.file_path}" alt="" width="112px" height="58px">
            	</a>
            	</div>
            </td>
            <td>
            	<h5><a href="<%=request.getContextPath()%>/car/favorable_detail.htm?favorable_id=${item.favor_id }">${item.favor_title }</a></h5>
            	<table border=0 width="100%">
            		<tr>
            			<td>${fn:substring(item.update_time,0,10) }</td>
            			<td align="right">
            			<%-- <button type="button" class="btn btn-primary btn-xs" onclick="window.location.href='<%=request.getContextPath()%>/car/favorable_expert.htm?favorable_id=${item.favor_id}'">优惠专家</button> --%>
            			</td>
            		</tr>
            	</table>
            </td>
          </tr>
          </c:forEach>
          <form action="" method="POST" id="thisForm" name="thisForm"></form>
          <c:if test="${count>10}">
          	<tr>
          		<td colspan="2" style="word-break:break-all;">${page.pageStr}</td>
          	</tr>
          </c:if>
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
