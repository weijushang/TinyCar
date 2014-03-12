package com.car.contact.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.base.BaseController;

/**
 * 联系我们
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class ContactController extends BaseController{

	
	private static Log log = LogFactory.getLog(ContactController.class);

	/**
	 * 联系我们首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/contact.htm")
	public String contact(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入联系我们首页");
		
		return "/contact/contact";
	}
}
