<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png">

    <title>微网站-手机网站</title>

    <!-- Bootstrap core CSS -->
   <%--  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="<%=request.getContextPath()%>/css/type.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<div>
	<iframe width="100%" id="mainFrame" name="mainFrame" src="<%=request.getContextPath()%>/car/favorable.htm" frameborder=0 border=0 marginwidth=0 marginheight=0 scrolling="auto" allowtransparency="yes"></iframe>
	</div>
    <div class="navigation">
		<a id="favorable" class="selected" href="javascript:getIframe('<%=request.getContextPath()%>/car/favorable.htm');"><img src="<%=request.getContextPath()%>/img/nav/favorable_on.png" alt="优惠"><em class="under-icon-text">优惠</em></a>
	    <a id="product" href="javascript:getIframe('<%=request.getContextPath()%>/car/product.htm');"><img src="<%=request.getContextPath()%>/img/nav/product.png" alt="产品"><em class="under-icon-text">产品</em></a>
	    <a id="life" href="javascript:getIframe('<%=request.getContextPath()%>/car/life.htm');"><img src="<%=request.getContextPath()%>/img/nav/life.png" alt="车生活"><em class="under-icon-text">车生活</em></a>
	    <a id="news" href="javascript:getIframe('<%=request.getContextPath()%>/car/news.htm');"><img src="<%=request.getContextPath()%>/img/nav/news.png" alt="新闻"><em class="under-icon-text">新闻</em></a>
	    <a id="contact" href="javascript:getIframe('<%=request.getContextPath()%>/car/contact.htm');"><img src="<%=request.getContextPath()%>/img/nav/contact.png" alt="联系我们"><em class="under-icon-text">联系我们</em></a>
	</div> 
  </body>
  
  <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bh-index.js"></script>
</html>
