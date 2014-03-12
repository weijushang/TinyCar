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
	<title>微网站－公司新闻</title>
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

    <div class="container">
      <div class="row">
        <table class="table" width="100%">
          <c:forEach items="${list}" varStatus="status" var="item">
          <tr>
            <td style="vertical-align:middle;">
           		<c:if test="${item.file_path!=null&&item.file_path!=\"\" }">
            	<div style="margin:2px 2px 2px 2px;width:116px;height:62px;text-align:center;line-height:55px;border-width:1px; border-style:solid; border-color:silver;">
            	<a href="<%=request.getContextPath()%>/car/news_detail.htm?news_id=${item.news_id }">
            	<img src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${item.file_path}" alt="" width="112px" height="58px">
            	</a>
           		</c:if>
            	</div>
            </td>
            <td>
            	<h5>[${item.type_name }]&nbsp;&nbsp;
            		<c:choose>
            			<c:when test="${item.outer_url==null||item.outer_url==\"\" }"><a href="<%=request.getContextPath()%>/car/news_detail.htm?news_id=${item.news_id }">${item.news_title}</a></c:when>
            			<c:otherwise>
            			<c:choose>
            				<c:when test="${fn:startsWith(item.outer_url, 'http://')}"><a href="${item.outer_url}">${item.news_title}</a></c:when>
            				<c:otherwise><a href="http://${item.outer_url}">${item.news_title}</a></c:otherwise>
            			</c:choose>
            			</c:otherwise>
            		</c:choose>
            	</h5>
            	<table border=0 width="100%">
            		<tr>
            			<td>${fn:substring(item.update_time,0,10) }</td>
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
