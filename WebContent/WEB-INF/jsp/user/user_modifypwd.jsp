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
<title>用户密码修改页面</title>
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
				<header class="panel-heading">用户密码修改</header>
				<div class="panel-body">
					<div class="adv-table">
						<div class="clearfix"></div>
						<div class="space15"></div>
					</div>
					<form class="form-horizontal tasi-form" method="post" id="thisForm" name="thisForm">
						<input type="hidden" id="user_id" name="user_id" value="${user_id}">
						<div style="width: 250px; position: relative; margin: 0 auto; text-align: center;">
							
							<div class="row" style="padding-top:10px;">
								<div class="col-sm-12">
									<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">原密码：</td>
					   						<td>
												<input type="text" class="form-control" placeholder="输入原密码" id="login_pwd" name="login_pwd">
					   						</td>
					   					</tr>
					   				</table>
								</div>
							</div>
							<div class="row" style="padding-top:10px;">
								<div class="col-sm-12">
									<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">新密码：</td>
					   						<td>
												<input type="text" class="form-control" placeholder="输入新密码" id="new_pwd" name="new_pwd">
					   						</td>
					   					</tr>
					   				</table>
								</div>
							</div>
							<div class="row" style="padding-top:10px;">
								<div class="col-sm-12">
									<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">确认密码：</td>
					   						<td>
												<input type="text" class="form-control" placeholder="再次输入新密码" id="confirm_pwd" name="confirm_pwd">
					   						</td>
					   					</tr>
					   				</table>
								</div>
							</div>
							<div id="error_mgs" style="margin-top:10px;margin-bottom:10px; color: red; text-align: center;"></div>
							<div class="row" style="padding-top:10px;">
								<button type="button" onclick="saveObj('<%=request.getContextPath()%>/manager/user/savepwd.htm', 'thisForm', 'error_mgs');" class="btn btn-info">保存</button>
							</div>
						</div>
					</form>
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