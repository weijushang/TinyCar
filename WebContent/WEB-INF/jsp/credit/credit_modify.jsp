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
	<title><c:choose><c:when test="${creditExpertInfo.expert_id==null }">贷款专家预约新增</c:when><c:otherwise>贷款专家预约修改</c:otherwise></c:choose></title>
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
    
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor/lang/zh_CN.js"></script>
    <script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				resizeType : 1,
				allowImageUpload : true,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'image', 'link']
			});
		});
		
		function setdetail(){
			document.getElementById('credit_answer').value=editor.html();
		}
	</script>
	
<style type="text/css">
html { overflow: hidden; } 
</style>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<a href="<%=request.getContextPath()%>/manager/credit/list.htm">贷款专家管理</a>-<c:choose><c:when test="${creditExpertInfo.expert_id==null }">贷款专家预约新增</c:when><c:otherwise>贷款专家预约修改</c:otherwise></c:choose>
				</header>
				<div class="panel-body">
					<div class="clearfix"></div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal  tasi-form">
							<input type="hidden" style="width:95%;" class="form-control" id="expert_id" name="expert_id" value="${creditExpertInfo.expert_id}">
							<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">所属产品：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" <c:if test="${creditExpertInfo.expert_id!=null}">readonly</c:if> id="product_title" name="product_title" placeholder="输入所属产品" value="${creditExpertInfo.product_title}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">客户名称：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" <c:if test="${creditExpertInfo.expert_id!=null}">readonly</c:if> id="cust_name" name="cust_name" placeholder="输入客户名称" value="${creditExpertInfo.cust_name}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">客户号码：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" <c:if test="${creditExpertInfo.expert_id!=null}">readonly</c:if> id="cust_phone" name="cust_phone" placeholder="输入客户号码" value="${creditExpertInfo.cust_phone}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">车价：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" <c:if test="${creditExpertInfo.expert_id!=null}">readonly</c:if> id="car_price" name="car_price" placeholder="输入车价" value="${creditExpertInfo.car_price}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">预约状态：</td>
					   						<td>
					   							<select style="width:95%;" class="form-control" id="expert_state" name="expert_state">
					   								<option value="00" <c:if test="${creditExpertInfo.expert_state==\"00\"}">selected</c:if> >未处理</option>
					   								<option value="01" <c:if test="${creditExpertInfo.expert_state==\"01\"}">selected</c:if> >已处理</option>
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
					   							<button type="button" onclick="saveObj('<%=request.getContextPath()%>/manager/credit/creditsave.htm', 'thisForm', 'error_mgs');" class="btn btn-info">保存</button>
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