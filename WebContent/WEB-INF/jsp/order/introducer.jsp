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
	<title>微网站－介绍人信息</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">html { overflow: hidden; } </style>
  </head>

  <body>
      	<input type="hidden" id="expert_id" name="expert_id" value="${favorableInfo.expert_id}">
		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">推荐人姓名：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="cust_name" name="cust_name" value="${favorExpertInfo.cust_name}">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">推荐人号码：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="cust_phone" name="cust_phone" value="${favorExpertInfo.cust_phone}">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">被推荐人姓名：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="presentee_name" name="presentee_name" value="${favorExpertInfo.presentee_name}">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-12" style="padding-top:10px;padding-left:0px;padding-right:0px;">
  				<table width="100%">
  					<tr height="30px">
  						<td width="120px" align="right">被推荐人号码：</td>
  						<td>
  							<input type="text" style="width:95%;" class="form-control" id="presentee_phone" name="presentee_phone" value="${favorExpertInfo.presentee_phone}">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</div>
  </body>
</html>
