/**
 * 版权所有权归 <a href="http://www.permant.com">杭州科技有限公司</a>
 * author:Alvin.wyh
*/
$(document).ready(function () {
  	$("#favorable").click(function() { 
		$(this).addClass('selected');
		$(this).parent().parent().find('#product, #life, #news, #contact').removeClass('selected');
		$(this).find('img').attr("src", "img/nav/favorable_on.png");
		$("#favorable").find('img').attr("src", "img/nav/favorable_on.png");
		$("#product").find('img').attr("src", "img/nav/product.png");
		$("#life").find('img').attr("src", "img/nav/life.png");
		$("#news").find('img').attr("src", "img/nav/news.png");
		$("#contact").find('img').attr("src", "img/nav/contact.png");
	});
  	$("#product").click(function() { 
		$(this).addClass('selected');
		$(this).parent().parent().find('#favorable, #life, #news, #contact').removeClass('selected');
		$("#favorable").find('img').attr("src", "img/nav/favorable.png");
		$("#product").find('img').attr("src", "img/nav/product_on.png");
		$("#life").find('img').attr("src", "img/nav/life.png");
		$("#news").find('img').attr("src", "img/nav/news.png");
		$("#contact").find('img').attr("src", "img/nav/contact.png");
	});
  	$("#life").click(function() { 
		$(this).addClass('selected');
		$(this).parent().parent().find('#favorable, #product, #news, #contact').removeClass('selected');
		$("#favorable").find('img').attr("src", "img/nav/favorable.png");
		$("#product").find('img').attr("src", "img/nav/product.png");
		$("#life").find('img').attr("src", "img/nav/life_on.png");
		$("#news").find('img').attr("src", "img/nav/news.png");
		$("#contact").find('img').attr("src", "img/nav/contact.png");
	});
  	$("#news").click(function() { 
		$(this).addClass('selected');
		$(this).parent().parent().find('#favorable, #product, #life, #contact').removeClass('selected');
		$("#favorable").find('img').attr("src", "img/nav/favorable.png");
		$("#product").find('img').attr("src", "img/nav/product.png");
		$("#life").find('img').attr("src", "img/nav/life.png");
		$("#news").find('img').attr("src", "img/nav/news_on.png");
		$("#contact").find('img').attr("src", "img/nav/contact.png");
	});
  	$("#contact").click(function() { 
		$(this).addClass('selected');
		$(this).parent().parent().find('#favorable, #product, #life, #news').removeClass('selected');
		$("#favorable").find('img').attr("src", "img/nav/favorable.png");
		$("#product").find('img').attr("src", "img/nav/product.png");
		$("#life").find('img').attr("src", "img/nav/life.png");
		$("#news").find('img').attr("src", "img/nav/news.png");
		$("#contact").find('img').attr("src", "img/nav/contact_on.png");
	});
});
function getIframe(url){
	document.getElementById('mainFrame').src=url;
};
function reinitIframe(){
	var iframe = document.getElementById("mainFrame");
	try{
		var bHeight = document.body.clientWidth;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height = height+30;
	}catch (ex){}
};
window.setInterval("reinitIframe()", 200);