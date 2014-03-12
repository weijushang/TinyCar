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
	<title><c:choose><c:when test="${productInfo.product_id==null }">产品信息新增</c:when><c:otherwise>产品信息修改</c:otherwise></c:choose></title>
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
			document.getElementById('product_detail_str').value=editor.html();
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
					<a href="<%=request.getContextPath()%>/manager/product/list.htm">产品管理</a>-<c:choose><c:when test="${productInfo.product_id==null }">产品信息新增</c:when><c:otherwise>产品信息修改</c:otherwise></c:choose>
				</header>
				<div class="panel-body">
					<div class="clearfix"></div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal  tasi-form" enctype="multipart/form-data">
							<input type="hidden" style="width:95%;" class="form-control" id="product_id" name="product_id" value="${productInfo.product_id}">
							<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">产品标题：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="product_title" name="product_title" placeholder="输入产品标题" value="${productInfo.product_title}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">顾问：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="p_counselor" name="p_counselor" placeholder="输入顾问" value="${productInfo.p_counselor}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">顾问电话：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="phone_call" name="phone_call" placeholder="输入顾问电话" value="${productInfo.phone_call}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">咨询电话：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="hot_line" name="hot_line" placeholder="输入咨询电话" value="${productInfo.hot_line}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="40px">
					   						<td width="120px" align="right">产品详情：</td>
					   						<td>
					   						<input type="hidden" class="form-control" id="product_detail_str" name="product_detail_str" style="width:95%;">
					   						<textarea name="content" style="width:95%;height:300px;visibility:hidden;">${productInfo.product_detail_str}</textarea>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="120px" align="right">图片上传：</td>
					   						<td><font color="red">(图片规格建议使用:640*331)</font></td>
					   					</tr>
					   					<tr height="30px">
					   						<td width="120px" align="right">&nbsp;</td>
					   						<td>
					   							<div style="width:100%;height:30px;">
						   							<input type="file" id="image_file" name="image_file" style="float:left;height:30px;">
						   							<c:if test="${productInfo.fileInfo!=null }">
						   							<div id="fileDiv" name="fileDiv" style="float:left;height:30px;">&nbsp;${productInfo.fileInfo.file_ori_name}&nbsp;<a href="javascript:$('#dfform').submit();">删除</a></div>
					   								</c:if>
					   							</div>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div id="err_msg" style="margin-bottom: 10px; color: red; text-align: center;">${err_msg }</div>
							
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;overflow:hidden;">
					   				<table width="100%">
					   					<tr height="40px">
					   						<td align="center">
					   							<button type="button" onclick="setdetail();saveProduct();" class="btn btn-info">保存</button>
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
	<iframe id="targetFrame" name="targetFrame" style="display:none;"></iframe>
	<form action="<%=request.getContextPath()%>/manager/file/filedel.htm" method="POST" id="dfform" name="dfform" target="targetFrame">
		<input type="hidden" id="file_id" value="${productInfo.fileInfo.file_id }" name="file_id"/>
	</form>
	
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
	<script type="text/javascript">
	function saveProduct(){
		var thisForm = document.getElementById('thisForm');
		thisForm.action = '<%=request.getContextPath()%>/manager/product/productsave.htm';
		thisForm.method = 'POST';
		thisForm.submit();
	}
	</script>
	
</body>
</html>