<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.car.domain.UserInfo"%>
<%@page import="com.car.utils.Constant"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="">
	<meta name="author" content="Alvin.wyh">
	<link rel="icon" type="image/ico" href="<%=request.getContextPath()%>/img/favicon.png" />
	<title><c:choose><c:when test="${typeInfo.type_id==null }">类型新增</c:when><c:otherwise>类型修改</c:otherwise></c:choose></title>
	<!-- Bootstrap core CSS -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/css/bootstrap-reset.css" rel="stylesheet">
	<!--external css-->
	<link href="<%=request.getContextPath()%>/css/font-awesome.css" rel="stylesheet" />
	
	<!-- Custom styles for this template -->
	<link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet" />
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
	<!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/js/html5shiv.js"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js"></script>
    <![endif]-->
    
<style type="text/css">
html { overflow: hidden; } 
</style>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<c:choose>
						<c:when test="${typeInfo.type_classify==\"01\" }">
							<a href="<%=request.getContextPath()%>/manager/type/list.htm?type_classify=01">常见问题类型管理</a>-<c:choose><c:when test="${typeInfo.type_id==null }">常见问题新增</c:when><c:otherwise>常见问题修改</c:otherwise></c:choose>
						</c:when>
						<c:otherwise>
							<a href="<%=request.getContextPath()%>/manager/type/list.htm?type_classify=00">新闻类型管理</a>-<c:choose><c:when test="${typeInfo.type_id==null }">新闻类型新增</c:when><c:otherwise>新闻类型修改</c:otherwise></c:choose>
						</c:otherwise>
					</c:choose>
				</header>
				<div class="panel-body">
					<div class="clearfix"></div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal  tasi-form">
							<input type="hidden" style="width:95%;" class="form-control" id="type_id" name="type_id" value="${typeInfo.type_id}">
							<input type="hidden" style="width:95%;" class="form-control" id="type_classify" name="type_classify" value="${typeInfo.type_classify}">
							<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="110px" align="right">类别名称：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="type_name" name="type_name" placeholder="输入名称" value="${typeInfo.type_name}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="110px" align="right">备注说明：</td>
					   						<td>
					   							<textarea class="form-control" id="type_remark" name="type_remark" rows="3" style="width:95%;">${userInfo.type_remark }</textarea>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		
					   		<div id="error_mgs" style="margin-bottom: 10px; color: red; text-align: center;"></div>
							
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;overflow:hidden;">
					   				<table width="100%">
					   					<tr height="40px">
					   						<td align="center">
					   							<button type="button" onclick="saveObj('<%=request.getContextPath()%>/manager/type/typesave.htm', 'thisForm', 'error_mgs');" class="btn btn-info">保存</button>
					   							<button type="button" class="btn btn-default" onclick="window.history.back()">返回</button>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
						</form>
					</div>
                	</div>
				</div>
			</section>
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
	
</body>
</html>