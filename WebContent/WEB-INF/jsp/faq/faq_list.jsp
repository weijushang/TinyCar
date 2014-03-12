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
<title>常见问题列表</title>
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
				<header class="panel-heading"><a href="<%=request.getContextPath()%>/manager/faq/list.htm">常见问题管理</a>-常见问题列表</header>
				<div class="panel-body">
					<div class="clearfix">
                         <div class="btn-group">
                             <button id="editable-sample_new" class="btn btn-default" onclick="javascript:window.location.href='<%=request.getContextPath()%>/manager/faq/faqinfo.htm'">
                                 <a href="<%=request.getContextPath()%>/manager/faq/faqinfo.htm">新增常见问题<i class="fa fa-plus"></i></a>
                             </button>
                         </div>
                         <!--<div class="btn-group pull-right">
                             <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                             </button>
                             <ul class="dropdown-menu pull-right">
                                 <li><a href="#">打印</a></li>
                                 <li><a href="#">导出Excel</a></li>
                             </ul>
                         </div>-->
                     </div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						<form action="" method="POST" id="thisForm" name="thisForm">
							<%-- <input id="search_word" name="search_word" style="width:250px;float:right;margin-bottom:5px;" class="form-control" placeholder="查询输入关键词" value="${faqInfo.search_word }" onchange="queryList('<%=request.getContextPath()%>/manager/faq/list.htm')"> --%>
						</form>
					</div>
                    <div class="table-responsive"><!-- style="border-width:2px; border-style:solid; border-color:red;" -->
				        <table class="table table-bordered">
				          <thead>
				            <tr>
				              <th style="text-align:center;">#</th>
				              <th style="text-align:center;">问题</th>
				              <th style="text-align:center;">类型</th>
				              <th class="hidden-phone" style="text-align:center;">创建时间</th>
				              <th style="text-align:center;">操作</th>
				            </tr>
				          </thead>
				          <tbody>
				            <c:forEach items="${list}" varStatus="status" var="item">
							<tr id="tr${item.faq_id}" name="tr${item.faq_id}" >
								<td style="text-align:center;"><c:out value="${status.index+1}"/></td>
				              	<td style="text-align:center;"><a href="<%=request.getContextPath()%>/manager/faq/faqinfo.htm?faq_id=${item.faq_id}" title="常见问题修改">${item.faq_request}</a></td>
				              	<td style="text-align:center;">${item.type_name}</td>
				              	<td class="hidden-phone" style="text-align:center;">${item.create_time}</td>
								<td style="text-align:center;">
	                              	<a href="#" title="常见问题删除" onclick="delObject('<%=request.getContextPath()%>/manager/faq/faqdel.htm', 'faq_id', '${item.faq_id}')"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
					              </td>
							</tr>
							</c:forEach>
				          </tbody>
				          <c:if test="${count>0}">
				          <tfoot>
				          	<tr>
				          		<td colspan="5" style="word-break:break-all;">${page.pageStr}</td>
				          	</tr>
				          </tfoot>
				          </c:if>
				        </table>
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