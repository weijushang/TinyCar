<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh-CN" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="zh-CN" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="zh-CN"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png">
	<title>微网站－图片上传</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<%=request.getContextPath()%>/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/js/3.7.0/html5shiv.min.js"></script>
      <script src="<%=request.getContextPath()%>/js/1.3.0/respond.min.js"></script>
    <![endif]-->

	<style type="text/css">
	.bs-example {
	  position: relative;
	  padding: 45px 15px 15px;
	  margin: 0 -15px 15px;
	  background-color: #fafafa;
	  box-shadow: inset 0 3px 6px rgba(0,0,0,.05);
	  border-color: #e5e5e5 #eee #eee;
	  border-style: solid;
	  border-width: 1px 0;
	}
	/* Echo out a label for the example */
	.bs-example:after {
	  content: "图片管理";
	  position: absolute;
	  top:  15px;
	  left: 15px;
	  font-size: 12px;
	  font-weight: bold;
	  color: #bbb;
	  text-transform: uppercase;
	  letter-spacing: 1px;
	}
	.imageDiv{border:1px dashed #000;height:213px;width:320px;margin:5px 5px 5px 5px;text-align:center;line-height:213px;}
	
	html { overflow: hidden; } 
	</style>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading"><a href="<%=request.getContextPath()%>/manager/file/file_index.htm">图片管理</a></header>
				<div class="panel-body">
					<!-- <div class="clearfix">
                         <div class="btn-group"></div>
                     </div> -->
					<!-- <div class="space15">&nbsp;</div> -->
					<!-- <div class="space15"></div> -->
                    <div class="table-responsive">
						<form action="<%=request.getContextPath()%>/manager/file/uploadImages.htm" method="post" id="form-validate" name="form-validate" enctype="multipart/form-data">
						<label for="review_field" class="required">优惠或产品列表广告图片上传(640*270)</label>
						<div class="input-box" style="width:95%">
							<fieldset style="border : 1px solid #84A24A;text-align:left;COLOR:#84A24A;FONT-SIZE:12px;font-family: Verdana;padding:5px;">
								<input type="button" value="添加图片" id="btnAdd" onclick="selectAttachment();">&nbsp;
								<div id="attachmentList" style="margin:3px 0px 0px 0px;padding:4px 3px 4px 3px;background-color:#DEEBC6;border:1px solid #84A24A;">
								<c:forEach items="${image_list}" varStatus="status" var="item">
								<span id="_attachment1000${status.index}" title="${item.file_ori_name }">${item.file_ori_name }&nbsp;&nbsp;<select onchange="changeType(this, '${item.file_id }')" style="width:60px"><option value="03" <c:if test="${item.file_type==\"03\"}">selected</c:if>>优惠</option><option value="04" <c:if test="${item.file_type==\"04\"}">selected</c:if>>产品</option></select>&nbsp;<a href="javascript:deleteFile('1000${status.index}', '${item.file_id }')"><font color="blue">删除</font></a><br></span>
								</c:forEach>
								</div>
								<div id="inputDiv" name="inputDiv">
									<input type="file" style="display:none;" onchange="addAttachmentToList();" id="_upfile0" name="image_files">
								</div>
                			<div style="padding-top:10px;padding-bottom:10px;color:red;text-align:center;font-size:14px;" id="err_div0" name="err_div0">${err_div0 }</div>
                	 		<button type="submit" class="button" title="提交" name="tsave" id="tsave"><span><span>提交</span></span></button>
							</fieldset>
						</div>
						</form>	
					</div>
				</div>
			</section>
		</div>
	</div>
</body>
	<iframe id="targetFrame" name="targetFrame" style="display:none;"></iframe>
	<form action="<%=request.getContextPath()%>/manager/file/filedel.htm" method="POST" id="dfform" name="dfform" target="targetFrame">
		<input type="hidden" id="file_id" name="file_id"/>
	</form>

	<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/prototype.js"></script>
<script type="text/javascript">
function saveImages(url){
	
	var form = $jq('#form-validate');
	form.action = url;
	form.submit();

}

function XmlResponse(originalRequest){
	var result = originalRequest.responseText;
	//$jq('#err_div0').html(result);
	document.getElementById('err_div0').innerHTML=result;
}

function showDivResult(result){
	$jq('#err_div').html(result);	
}
	
	var i = 0; // 用来动态生成span,upfile的id
	function addAttachmentToList(){
	    
	  // 动态创建附件信息栏并添加到附件列表中
	  var span = document.createElement('span');
	  span.id = '_attachment' + i;
	  span.innerHTML = extractFileName(event.srcElement.value) + '&nbsp;&nbsp;<select id="file_type" name="file_type" style="width:60px"><option value="03">优惠</option><option value="04">产品</option></select>&nbsp;<a href="javascript:delAttachment(' + (i++) + ')"><font color="blue">删除</font></a><br/>';
	  span.title = event.srcElement.value;
	  //span.style.padding="15px 15px 15px 5px";
	  G('attachmentList').appendChild(span);
	    
	  // 显示附件列表并变换添加附件按钮文本
	  if (G('attachmentList').style.display == 'none')
	  {
		  G('btnAdd').value = '继续添加';
		  G('attachmentList').style.display = '';
	  }
	}

	function selectAttachment(){
	  // 动态创建上传控件并与span对应
	  if(!G('_upfile'+i)){
		  var upfile = '<input type="file" style="display:none;" onchange="addAttachmentToList();" id="_upfile'+i+'" name="image_files">';
		  document.getElementById('inputDiv').insertAdjacentHTML('beforeEnd', upfile);
	  }
	  G('_upfile'+i).click();
	}

	function extractFileName(fn)
	{
	  return fn.substr(fn.lastIndexOf('\\')+1);
	}

	function findAttachment(fn){
	  var o = G('attachmentList').getElementsByTagName('span');
	  for(var i=0;i<o.length;i++)
	  if (o[i].title == fn) return true;
	  return false;
	}

	function delAttachment(id)
	{
	  G('attachmentList').removeChild(G('_attachment'+id));
	  document.getElementById('inputDiv').removeChild(G('_upfile'+id));
	  
	  // 当附件列表为空则不显示并且变化添加附件按钮文本
	  if (G('attachmentList').childNodes.length == 0){
		  G('btnAdd').value = '添加图片';
		  G('attachmentList').style.display = 'none';
	  }
	    
	}

	function G(id){
	  return document.getElementById(id);
	}
	
	//修改序号
	function changeType(ele, fid){
		
		new Ajax.Request('<%=request.getContextPath()%>/manager/file/updatefiletype.htm',
				{method:'post',
			parameters:'file_type='+ele.value+"&file_id="+fid,
			onComplete:XmlResponse});
	}
	
	var span_id;
	//删除
	function deleteFile(ele, id){
		span_id = ele;
		new Ajax.Request('<%=request.getContextPath()%>/manager/file/deletefile.htm',
				{method:'post',
			parameters:'file_id='+id,
			onComplete:deleteResponse});
	}
	function deleteResponse(originalRequest){
		var result = originalRequest.responseText;
		if(!isNaN(result)){
		 	document.getElementById('err_div0').innerHTML="文件删除成功";
			delAttachment(span_id);
		}else{
			document.getElementById('err_div0').innerHTML=result;
		}
	}
	
	var div_id;
	//删除
	function deleteAndShow(ele, id, divId){
		if(confirm("是否删除图片？")){
			span_id = ele;
			div_id = divId;
			new Ajax.Request('<%=request.getContextPath()%>/manager/file/deletefile.htm',
					{method:'post',
				parameters:'file_id='+id,
				onComplete:deleteRes});
		}
	}
	function deleteRes(originalRequest){
		var result = originalRequest.responseText;
		if(!isNaN(result)){
			$jq('#'+div_id).html("文件删除成功");
			$jq('#'+span_id).remove();
		}else{
			$jq('#'+div_id).html(result);
		}
	}
</script>
</html>
