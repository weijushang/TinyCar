<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

    <title>微网站-后台系统登录页面</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
		<form class="form-signin" role="form" method="POST" action="<%=request.getContextPath()%>/mainframe.htm">
	        <h2 class="form-signin-heading">微网站后台登录</h2>
	        <c:if test="${error_msg!=null }">
    		<div style="text-align:center;padding-top:5px;padding-bottom:5px;color:red;">${error_msg}</div>
    		</c:if>
	        <input type="text" id="login_name" name="login_name" class="form-control" placeholder="输入用户名" required autofocus>
	        <input type="password" id="login_pwd" name="login_pwd" class="form-control" placeholder="输入密码" required>
	        <label class="checkbox">
	          <input type="checkbox" value="remember-me"> 记住我
	        </label>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
	  	</form>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  </body>
</html>
