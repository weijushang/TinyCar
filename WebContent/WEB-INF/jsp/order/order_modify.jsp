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
	<title><c:choose><c:when test="${orderInfo.order_id==null }">在线申请新增</c:when><c:otherwise>在线申请修改</c:otherwise></c:choose></title>
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
    
    <script src="<%=request.getContextPath()%>/js/bh-provinceandcity.js"></script>
    
<style type="text/css">
html { overflow: hidden; } 
</style>
</head>
<body onload="loadProvince('province_id', 'city_id', '${orderInfo.province_id}', '${orderInfo.city_id}');">
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<a href="<%=request.getContextPath()%>/manager/order/list.htm">在线申请管理</a>-<c:choose><c:when test="${orderInfo.order_id==null }">在线申请新增</c:when><c:otherwise>在线申请修改</c:otherwise></c:choose>
				</header>
				<div class="panel-body">
					<div class="clearfix"></div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal  tasi-form">
							<input type="hidden" style="width:95%;" class="form-control" id="order_id" name="order_id" value="${orderInfo.order_id}">
							
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">客户名称：</td>
					   						<td>
					   							<input type="text" style="width:95%;" <c:if test="${orderInfo.order_id!=null }">readOnly</c:if> class="form-control" id="cust_name" name="cust_name" placeholder="输入客户名称" value="${orderInfo.cust_name}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">客户手机：</td>
					   						<td>
					   							<input type="text" style="width:95%;" <c:if test="${orderInfo.order_id!=null }">readOnly</c:if> class="form-control" id="cust_phone" name="cust_phone" placeholder="输入客户手机" value="${orderInfo.cust_phone}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">身份证号码：</td>
					   						<td>
					   							<input type="text" style="width:95%;" <c:if test="${orderInfo.order_id!=null }">readOnly</c:if> class="form-control" id="cust_card" name="cust_card" placeholder="输入身份证号码" value="${orderInfo.cust_card}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">省份：</td>
					   						<td>
					   							<select style="width:95%;" class="form-control" id="province_id" name="province_id" onchange="loadCity(this,'city_id');">
					   							</select>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">城市：</td>
					   						<td>
					   							<select style="width:95%;" class="form-control" id="city_id" name="city_id">
					   							</select>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">品牌：</td>
					   						<td>
					   							<input type="text" style="width:95%;" <c:if test="${orderInfo.order_id!=null }">readOnly</c:if> class="form-control" id="car_type_name" name="car_type_name" placeholder="输入品牌" value="${orderInfo.car_type_name}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-6" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">客户性别：</td>
					   						<td>
					   							<select style="width:95%;" class="form-control" id="cust_sex" name="cust_sex" <c:if test="${orderInfo.order_id!=null }">disabled</c:if>>
					   								<option value="00" <c:if test="${orderInfo.cust_sex==\"00\" }">selected</c:if> >女</option>
					   								<option value="01" <c:if test="${orderInfo.cust_sex==\"01\" }">selected</c:if> >男</option>
					   							</select>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-6" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">推荐人：</td>
					   						<td>
					   							<input type="text" style="width:95%;" <c:if test="${orderInfo.order_id!=null }">readOnly</c:if> class="form-control" id="expert_id" name="expert_id" placeholder="输入推荐人" value="${orderInfo.expert_id}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-6" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">申请状态：</td>
					   						<td>
					   							<select style="width:95%;" class="form-control" id="order_state" name="order_state">
					   								<option value="00" <c:if test="${orderInfo.order_state==\"00\" }">selected</c:if> >未处理</option>
					   								<option value="01" <c:if test="${orderInfo.order_state==\"01\" }">selected</c:if> >已处理</option>
					   							</select>
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
					   							<button type="button" onclick="saveObj('<%=request.getContextPath()%>/manager/order/ordersave.htm', 'thisForm', 'error_mgs');" class="btn btn-info">保存</button>
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