<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.lang.Exception"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager.css">
<title>错误页面</title>
</head>
<body class="bg">

<table border="0" align="center" width="70%"  style="padding-top:150px;">
	<tr>
		<td rowspan=2 width="180px"><%-- <IMG ID="id" src="<%=request.getContextPath()%>/images/cry.jpg"> --%></td>
		<td><!-- <h1>出错啦！！！</h1> -->
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td><h1>出错啦！！！</h1></td>
			</tr>
			<tr>
				<td>
				<%  
					Exception e = (Exception)request.getAttribute("exception");  
					out.print(e);  
				%>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		</td>
	</tr>
</table>
</body>
</html>
