<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
<title>常见问题解答</title>
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

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bh-common.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">常见问题解答</header>
				<div class="panel-body">
					<div class="clearfix">
						<table width="100%">
		   					<tr height="30px">
		   						<td width="120px" align="right">关键词：</td>
		   						<td>
		   							<form action="" method="POST" id="thisForm" name="thisForm">
			                             <input id="search_word" style="width:90%" name="search_word" class="form-control" placeholder="查询请输入关键词" value="${faqInfo.search_word }" onchange="queryList('<%=request.getContextPath()%>/faq/faq.htm')">
			                         </form>
		   						</td>
		   					</tr>
		   				</table>
                         <%-- <div class="" style="height:30px;line-height:30px;text-align:center;">
                         <form action="" method="POST" id="thisForm" name="thisForm">
                             <input id="search_word" style="width:90%" name="search_word" class="form-control" placeholder="查询请输入关键词" value="${faqInfo.search_word }" onchange="queryList('<%=request.getContextPath()%>/manager/faq/list.htm')">
                         </form>
                         </div> --%>
                     </div>
					<div class="space15">&nbsp;</div>
					<div class="space15">
						
					</div>
                    <div class="table-responsive"><!-- style="border-width:2px; border-style:solid; border-color:red;" -->
				        <dl>
					        <c:forEach items="${list}" varStatus="status" var="item">
					        	<dt style="padding:5px 5px 5px 5px;">${status.index+1}、${item.faq_request}</dt>
					        	<dd style="margin-left:30px">${item.faq_answer}</dd>
					        </c:forEach>
					        <c:if test="${count>10}">
					          	<dt>
					          		${page.pageStr}
					          	</dt>
					       	</c:if>
					   	</dl>
                	</div>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>