<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.car.domain.UserInfo" %>
<%@page import="com.car.utils.Constant" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie6 ie" lang="en" dir="ltr"> <![endif]-->
<!--[if IE 7]>    <html class="ie7 ie" lang="en" dir="ltr"> <![endif]-->
<!--[if IE 8]>    <html class="ie8 ie" lang="en" dir="ltr"> <![endif]-->
<!--[if gt IE 8]> <!--> <html class="not-ie" lang="zh-CN"> <!--<![endif]-->
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png" type="image/vnd.microsoft.icon" />
	<title>微网站－主页面</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css_jSwG9w4cG5lBtHscGZIvJylNmUMmftT5lolfVvsWjcY.css" media="all" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css_TsVRTbLFUpEZAfw-_bWPJu840QT523CPjUVJ5MRWfyk.css" media="all" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css_sw_bI6nMVZy5T59IE7AfXlyQmmy7Jfsrida2TWGNdKg.css" media="all" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css_TADBuXPPmrbFPyk6hDkPf84uFQkeNTvGKIQWxMUpw28.css" media="all" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js_Bua3V7s16xhn2yjwAWIH8Q0UCvf3SgluOlYdKTEQLZ0.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js_R9UbiVw2xuTUI0GZoaqMDOdX0lrZtgX-ono8RVOUEVc.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js__kgjFnuZBbsFrnhv-u2YH7E4Q9-UgvfNK_e8LvQqUBM.js"></script>
	  
	<!-- IE Fix for HTML5 Tags -->
	<!--[if lt IE 9]>
	  <script src="<%=request.getContextPath()%>/js/trunk/html5.js"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- Web Fonts  -->
	<link href='<%=request.getContextPath()%>/css/family.css' rel='stylesheet' type='text/css'>
	
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','<%=request.getContextPath()%>/js/analytics.js','ga');
	
	  ga('create', 'UA-46829255-1', 'refaktorthemes.com');
	  ga('send', 'pageview');
	</script>
	<% 
		UserInfo user = (UserInfo) session.getAttribute(Constant.CAR_USER_SESSION) ;
	%>
</head>
<body class="html front not-logged-in no-sidebars page-node page-node- page-node-50 node-type-view-page" >
	<div id="mobile-nav">
		<i class="icon-reorder"></i>
		<a href="<%=request.getContextPath()%>/mainframe.htm" title="集和汽车" rel="集和汽车" class="mobile-logo">
			<img src="<%=request.getContextPath()%>/img/logo-small.png" alt="集和汽车" />
		</a>
	</div>
	<header>
  		<div id="logo">
			<a href="<%=request.getContextPath()%>/mainframe.htm" title="集和汽车" rel="集和汽车">
	      		<img src="<%=request.getContextPath()%>/img/logo.png" alt="集和汽车" />
	    	</a>
		</div>
	    <div id="name-and-slogan" class="hidden">
			<h1 id="site-name" class="hidden">
            	<a href="#" title="集和汽车" rel="home"><span>集和汽车</span></a>
          	</h1>
            <div id="site-slogan" class="hidden">集和汽车</div>
    	</div> <!-- /#name-and-slogan -->
		<nav>
			<ul>
				<!-- menu -->
				<li>
					<a href="javascript:;">产品服务管理</a>
					<ul>
						<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/product/list.htm');">产品信息管理</a></li>
						<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/credit/list.htm');">预约保险管理</a></li>
						<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/order/list.htm');">在线申请管理</a></li>
						<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/settle/list.htm');">结清预约管理</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:getIframe('<%=request.getContextPath()%>/manager/favorable/list.htm');">优惠信息管理</a>
				</li>
				<li>
					<a href="javascript:;">新闻管理</a>
					<ul>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/type/list.htm?type_classify=00');">新闻类型管理</a></li>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/news/list.htm');">新闻管理</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">图片管理</a>
					<ul>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/file/file_index.htm');">广告图片管理</a></li>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/life/life_index.htm');">图标管理</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">常见问题管理</a>
					<ul>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/type/list.htm?type_classify=01');">常见问题类型管理</a></li>
						<li><a href="javascript:;getIframe('<%=request.getContextPath()%>/manager/faq/list.htm');">常见问题管理</a></li>
					</ul>
				</li>
			</ul>	  
		</nav>
  		<div class="region region-sidebar-secondary">
	    	<div id="block-block-1" class="block block-block widget">
	        	<h6>欢迎您：<%=user.getUser_name() %></h6>
	        	<div class="content">
	        	<div class="view view-portfolio-filters view-id-portfolio_filters view-display-id-block view-dom-id-3f0025c31937b1a228d0d06b815c49d7">
		      	<div class="view-content">
		      	<ul class="filters">
				  	<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/user/user_modify.htm');">用户信息修改</a></li>
					<li><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/user/user_modifypwd.htm');">用户密码修改</a></li>
					<li><a href="javascript:;" onclick="if(confirm('是否退出？')){window.location.href='<%=request.getContextPath()%>/logout.htm'}">退出</a></li>
				</ul>
				</div>
				</div>
				</div>
				<p>上一次登录时间：<%=user.getLast_time() %></br>
				上一次登录地址：<%=user.getLast_ip() %></br></p>
			</div>
		</div>
  		<!-- <div class="region region-sidebar-secondary">
			<div id="block-block-2" class="block block-block widget">
		    	<h6>版权所有</h6>
		      	<div class="social">
					<a href="http://www.permant.com">杭州本恒科技有限公司</a>
				</div>
			</div>
		</div> -->
	</header>
	<div class="content-wrapper">
		<div id="loader"></div>
		<div class="tabs"></div>
        <div class="region region-content">
    		<div id="block-system-main" class="block block-system">
				<div class="content">
    				<div id="node-50" class="node node-view-page node-promoted clearfix" about="#" typeof="sioc:Item foaf:Document">
						<div class="content"></div>
					</div>  
				</div>
			</div>
			<div id="block-views-portfolio-block-block" class="block block-views">
  				<div class="content">
  					<div class="row" style="text-align:right;height:50px;margin-right:15px;line-height:50px;">
  						<div style="float:right;z-index:0;padding-right:10px;"><font size="10"><a href="javascript:;" onclick="if(confirm('是否退出？')){window.location.href='<%=request.getContextPath()%>/logout.htm'}" title="退出">退出</a></font></div>
  						<div style="float:right;z-index:0;padding-right:10px;"><font size="10"><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/user/user_modify.htm');" title="信息修改">信息修改</a></font></div>
  						<div style="float:right;z-index:0;padding-right:10px;"><font size="10"><a href="javascript:;" onclick="getIframe('<%=request.getContextPath()%>/manager/user/user_modifypwd.htm');" title="密码修改">密码修改</a></font></div>
  						<div style="float:right;z-index:0;padding-right:10px;"><font size="10">欢迎您：</font><font size="10" color="red"><%=user.getUser_name() %></font></div>
  					</div>
    				<iframe width="100%" id="mainFrame" name="mainFrame" src="<%=request.getContextPath()%>/car/contact.htm" frameborder=0 border=0 marginwidth=0 marginheight=0 scrolling="auto" allowtransparency="yes"></iframe>
  				</div>
			</div>
  		</div>
	</div>		
</body>
<script type="text/javascript">
	function getIframe(url){
	  document.getElementById('mainFrame').src=url;
	  //判断，如果点击后隐藏
	  var wSize = document.body.clientWidth;
      if (wSize <= 600) {
    	  document.getElementById("mobile-nav").click();
      }
	}
	
	function reinitIframe(){
		var iframe = document.getElementById("mainFrame");
		try{
			var bHeight = document.body.clientWidth;
			var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
			var height = Math.max(bHeight, dHeight);
			iframe.height = height;
		}catch (ex){}
	}
	window.setInterval("reinitIframe()", 200);
</script>
</html>