/**
 * 版权所有权归 <a href="http://www.permant.com">杭州科技有限公司</a>
 * author:Alvin.wyh
*/
//查询
function queryList(url){
	var thisForm = document.getElementById('thisForm');
	thisForm.method="POST";
	thisForm.action = url;
	thisForm.submit();
}

/**
 * 保存
 * @param url调用的后台url
 * @param formName对应form id
 * @param errDiv显示信息的div id
 */
function saveObj(url, formName, errDiv){
	$.ajax({
        cache: true,
        type: "POST",
        url: url,
        timeout: 10000,
        data:$('#'+formName).serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("网络异常，请稍后再试");
        },
        success: function(data) {
        	showDivResult(errDiv, data.msg);
        }
    });
}

/**
 * 显示div层最后淡出
 * @param errDiv显示信息的div id
 * @param msg显示的信息
 */
function showDivResult(errDiv, msg){

	$("#"+errDiv).fadeIn("1000");//淡入
	$("#"+errDiv).text("");// 清空数据
	$("#"+errDiv).append(msg); // 添加Html内容
	//$("#"+errDiv).fadeOut("5000");//淡出
}

/**
 * 删除
 * @param url 调用后台的url
 * @param param 参数
 * @param ele 传的值
 * @param errDiv 显示信息的div
 */
function delObject(url, param, ele){
	if(confirm("确认删除")){
		$.ajax({
            type: "get",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            url: url,//要访问的后台地址
            data: param+"="+ele,//要发送的数据
            complete :function(){$("#load").hide();},//AJAX请求完成时隐藏loading提示
            success: function(data){//data为返回的数据，在这里做数据绑定
            	var bool = data.success;
            	alert(data.msg);
            	//showDivResult(errDiv, data.msg);
            	if(bool){//删除成功
                	var tr_del = document.getElementById("tr"+ele);
                	tr_del.parentNode.removeChild(tr_del);//删除tr
            	}
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { 
                alert(errorThrown); //alert异常
        	} 
		});
	}
}