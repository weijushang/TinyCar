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

    <title>微网站-产品服务</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/navbar.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/carousel.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/sticky-footer-navbar.css" rel="stylesheet">

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

      <!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>">微网站</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath()%>">首页</a></li>
            <li  class="active" class="dropdown">
            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">产品服务 <b class="caret"></b></a>
            	<ul class="dropdown-menu">
                <li><a href="<%=request.getContextPath()%>/insure/insure.htm">汽车保险--预约保险</a></li>
              </ul>
            </li>
            <li><a href="#">优惠列表</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">车生活 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">二手车</a></li>
                <li><a href="#">汽车产品</a></li>
                <li><a href="#">常用工具</a></li>
              </ul>
            </li>
            <li><a href="<%=request.getContextPath()%>/news/news.htm">新闻动态</a></li>
            <li><a href="<%=request.getContextPath()%>/contact/contact.htm">联系我们</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>

      <!-- content -->
      <div class="row">
        <div class="col-md-4" style="padding:5px 5px 5px 5px;">
          <h2>保险一</h2>
          <p>网上买车险，自主选择保障方案，灵活又方便，保费全透明，支付更安心，商业车险还能多省15%！</p>
          <p><a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#myModal">预约 &raquo;</a></p>
        </div>
        <div class="col-md-4" style="padding:5px 5px 5px 5px;">
          <h2>保险二</h2>
          <p>在线支付保费满2500元获100元话费！</br>在线支付保费满3000元可获200元话费！</br>在线支付保费满4000元可获300元油卡！</br>更多好礼请点击立即参与查看</p>
          <p><a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#myModal">预约 &raquo;</a></p>
       </div>
        <div class="col-md-4" style="padding:5px 5px 5px 5px;">
          <h2>保险三</h2>
          <p>为您提供乘坐飞机、火车（含地铁、轻轨）、轮船或者汽车等各种公共交通工具期间的意外身故、残疾、烧伤保障，让您出行无忧。</p>
          <p><a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#myModal">预约 &raquo;</a></p>
        </div>
      </div>
      
      <!-- sample modal content -->
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <div style="width:100%;text-align:center">保险一</div>
          </div>
          <div class="modal-body">
            <div class="row">
            	<div class="col-md-12">
            		<table width="100%">
            			<tr>
            				<td width="90px" align="right">姓名：</td>
            				<td><input type="text" class="form-control" style="width:95%"/></td>
            			</tr>
            		</table>
            	</div>
            </div>
			<div class="row">
            	<div class="col-md-12">
            		<table width="100%">
            			<tr>
            				<td width="90px" align="right">手机号码：</td>
            				<td><input type="text" class="form-control" style="width:95%"/></td>
            			</tr>
            		</table>
            	</div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary">预约</button>
          </div>

        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
   </div> <!-- /container -->

	<div id="footer">
      <div class="container">
        <p class="text-muted">版权所有.</p>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/1.10.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  </body>
</html>
