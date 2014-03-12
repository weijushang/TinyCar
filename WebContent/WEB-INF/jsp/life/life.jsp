<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.car.utils.CarConfig"%>
<%@page import="com.car.utils.Constant"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png">
	<title>微网站-车生活</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <%-- <link href="<%=request.getContextPath()%>/css/life/style.css" rel="stylesheet"> --%>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    html { overflow: hidden; } 
    /*----------------------menu-------------------------*/
	.menu{width:100%;padding:25px 0px 0px 0;text-align:center;}
	.menu ul{list-style:none;padding:0px;margin:0px;display:inline;line-height:25px;}
	.menu ul li{list-style:none;display:inline-block;width:85px; height:125px; margin:0px 6px 5px 6px; background:url(images/icon_bg.png) no-repeat center top;}
	.menu ul li a{ font-size:14px; font-weight:bold; color:#302f2f; text-decoration:none; text-shadow:1px 1px #dcdcdc;}
	.menu ul li a img{padding:0px; width:85px; height:85px;}
    </style>
   
  </head>
  <body>

	<!-- 图表 -->
      <div class="menu">
    	<ul>
    		<c:forEach items="${image_list}" varStatus="status" var="image">
    			<li>
    				<a href="<c:choose><c:when test="${image.outer_url!=null&&outer_url!=\"\"}">${image.outer_url}</c:when><c:otherwise>javascript:;</c:otherwise></c:choose>">
    					<img src="<%=CarConfig.getString(Constant.IMAGE_URL) %>${image.file_path}${image.file_name}" border="0" alt="${image.file_alise }" title="${image.file_alise }"/>
    					${image.file_alise }
    				</a>
    			</li>
    		</c:forEach>
            <%-- <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/img/life/es.png" border="0" alt="" title=""/>二手车</a></li>
            <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/img/life/yp.png" border="0" alt="" title=""/>汽车用品</a></li>
            <li><a href="http://m.hao123.com/a/tianqi/?tn=baiduandroidtq"><img src="<%=request.getContextPath()%>/img/life/tp.png" border="0" alt="" title=""/>天气查询</a></li>
            <li><a href="http://www.hzti.com/service/qry/veh_query.aspx"><img src="<%=request.getContextPath()%>/img/life/wz.png" border="0" alt="违章查询" title="违章查询"/>违章查询</a></li>
            <li><a href="http://car.m.yiche.com/qichedaikuanjisuanqi/?from=message&isappinstalled=0"><img src="<%=request.getContextPath()%>/img/life/bx.png" border="0" alt="" title=""/>保险估算</a></li>
            <li><a href="javascript:;"><img src="<%=request.getContextPath()%>/img/life/lc.png" border="0" alt="" title=""/>理财试算</a></li>
            <li><a href="http://www.zjihw.com/Web/Weixin/allroad.aspx?from=message&isappinstalled=0"><img src="<%=request.getContextPath()%>/img/life/gs.png" border="0" alt="" title=""/>高速路况</a></li> --%>
        </ul>
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  </body>
</html>
