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
	<title><c:choose><c:when test="${favorableInfo.favor_id==null }">优惠信息新增</c:when><c:otherwise>优惠信息修改</c:otherwise></c:choose></title>
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
		var favor_editor;
		KindEditor.ready(function(K) {
			favor_editor = K.create('textarea[name="content"]', {
				resizeType : 1,
				allowImageUpload : true,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'image']
			});
		});
		
		function setdetail(){
			document.getElementById('favor_detail_str').value=favor_editor.html();
		}
	</script>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/datePicker/css/datepicker.css" type="text/css" />
    <link rel="stylesheet" media="screen" type="text/css" href="<%=request.getContextPath()%>/js/datePicker/css/layout.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/js/datepicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/js/eye.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/js/utils.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/datePicker/js/layout.js?ver=1.0.2"></script>
<style type="text/css">
html { overflow: hidden; } 
</style>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<a href="<%=request.getContextPath()%>/manager/favorable/list.htm">优惠管理</a>-<c:choose><c:when test="${favorableInfo.favor_id==null }">优惠信息新增</c:when><c:otherwise>优惠信息修改</c:otherwise></c:choose>
				</header>
				<div class="panel-body">
					<div class="clearfix"></div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm" class="form-horizontal  tasi-form" enctype="multipart/form-data">
							<input type="hidden" id="favor_id" name="favor_id" value="${favorableInfo.favor_id }">
							<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">优惠标题：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="favor_title" name="favor_title" placeholder="输入优惠标题" value="${favorableInfo.favor_title}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">标题图片上传：</td>
					   						<td><font color="red">(图片规格建议使用:640*331)</font></td>
					   					</tr>
					   					<tr height="30px">
					   						<td width="80px" align="right">&nbsp;</td>
					   						<td>
					   							<div style="width:100%;height:30px;">
						   							<input type="file" id="image_file" name="image_file" style="float:left;height:30px;">
						   							<c:if test="${favorableInfo.fileInfo!=null }">
						   							<div id="fileDiv" name="fileDiv" style="float:left;height:30px;">&nbsp;${favorableInfo.fileInfo.file_ori_name}&nbsp;<a href="javascript:$('#dfform').submit();">删除</a></div>
					   								</c:if>
					   							</div>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">顾问：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="favor_counselor" name="favor_counselor" placeholder="输入顾问" value="${favorableInfo.favor_counselor}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">顾问号码：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="favor_phone" name="favor_phone" placeholder="输入优惠标题" value="${favorableInfo.favor_phone}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">咨询号码：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="hot_line" name="hot_line" placeholder="输入咨询电话" value="${favorableInfo.hot_line}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-6" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">开始时间：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="favor_bdate" name="favor_bdate" placeholder="输入开始时间" value="${favorableInfo.favor_bdate}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		<div class="row">
					   			<div class="col-sm-6" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="30px">
					   						<td width="80px" align="right">结束时间：</td>
					   						<td>
					   							<input type="text" style="width:95%;" class="form-control" id="favor_edate" name="favor_edate" placeholder="输入结束时间" value="${favorableInfo.favor_edate}">
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
					   				<table width="100%">
					   					<tr height="40px">
					   						<td width="80px" align="right">优惠详情：</td>
					   						<td>
					   						<input type="hidden" class="form-control" id="favor_detail_str" name="favor_detail_str" style="width:95%;">
					   						<textarea name="content" style="width:95%;height:300px;visibility:hidden;">${favorableInfo.favor_detail_str}</textarea>
					   						</td>
					   					</tr>
					   				</table>
					   			</div>
					   		</div>
					   		
					   		<div id="err_msg" name="err_msg" style="margin-bottom: 10px; color: red; text-align: center;">${err_msg }</div>
							
				   			<div class="row">
					   			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;overflow:hidden;">
					   				<table width="100%">
					   					<tr height="40px">
					   						<td align="center">
					   							<button type="button" onclick="setdetail();saveFavor();" class="btn btn-info">保存</button>
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
		<input type="hidden" id="file_id" value="${favorableInfo.fileInfo.file_id }" name="file_id"/>
	</form>
	
	<!-- js placed at the end of the document so the pages load faster -->
	<%-- <script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script> --%>
	<%-- <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
	<script type="text/javascript">
	function saveFavor(){
		var thisForm = document.getElementById('thisForm');
		thisForm.action = '<%=request.getContextPath()%>/manager/favorable/favorablesave.htm';
		thisForm.method = 'POST';
		thisForm.submit();
	}
	function setTypeName(val){
		document.getElementById('car_type_name').value=val;
	}
	function initCarType(pId, sId){
		if(pId==""){
			pId = document.getElementById('car_type').value;
		};
		setCarType(pId, sId);
	}
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
	        		document.getElementById("err_msg").innerHTML=data.msg;
	        	}else{
 		  			document.getElementById("carTypeDiv").innerHTML=data.msg;
	        	}
	        }
	    });
	}
	
	$('#favor_bdate').DatePicker({
		format:'Y-m-d',
		date: $('#favor_bdate').val(),
		current: $('#favor_bdate').val(),
		starts: 1,
		position: 'r',
		onBeforeShow: function(){
			$('#favor_bdate').DatePickerSetDate($('#favor_bdate').val(), true);
		},
		onChange: function(formated, dates){
			$('#favor_bdate').val(formated);
		}
	});
	
	$('#favor_edate').DatePicker({
		format:'Y-m-d',
		date: $('#favor_edate').val(),
		current: $('#favor_edate').val(),
		starts: 1,
		position: 'r',
		onBeforeShow: function(){
			$('#favor_edate').DatePickerSetDate($('#favor_edate').val(), true);
		},
		onChange: function(formated, dates){
			if(formated!=""&&formated<$('#favor_bdate').val()){
				alert("结束时间不能小于开始时间");
			}else{
				$('#favor_edate').val(formated);
			}
		}
	});
	</script>
</body>
</html>