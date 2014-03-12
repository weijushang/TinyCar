package com.car.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MyMultipartResolver extends CommonsMultipartResolver {
	
	@Override
	public boolean isMultipart(HttpServletRequest request){
		String path = request.getRequestURI();
		if(path.indexOf("/kindeditor/") > 0){
			return false;
		}else{
			return super.isMultipart(request);
		}
	}
}
