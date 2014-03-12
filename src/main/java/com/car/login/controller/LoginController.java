package com.car.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.base.BaseController;
import com.car.domain.UserInfo;
import com.car.service.IUserInfoService;
import com.car.utils.Constant;
import com.car.utils.DateUtil;
import com.car.utils.MD5;

/**
 * 登录相关
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class LoginController extends BaseController{

	
	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	/**
	 * 登录首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入登录页面");
		return "/login/login";
	}
	
	/**
	 * 退出登录页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/logout.htm")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("退出登录页面");
		//注销后将session取消
		removeSessionUser(request);
		return "/login/login";
	}
 
	/**
	 * 登录
	 * @param login_name 用户名
	 * @param login_pwd 用户密码
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/mainframe.htm")
	public String mainframe(String login_name, String login_pwd, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("登录");
		//判断是否登录
		if(islogined(request, response)){
			return "/login/mainframe";
		}
		if(StringUtils.isBlank(login_name)||StringUtils.isBlank(login_pwd)){//
			request.setAttribute("error_msg", "用户名或密码不能为空");
			return "/login/login";
		}else{
			UserInfo userInfo = new UserInfo();
			userInfo.setLogin_name(login_name);
			userInfo.setLogin_pwd(MD5.encrypt(login_pwd));
			userInfo = userInfoService.selectByLoginAndPwd(userInfo);
			if(userInfo == null){
				request.setAttribute("error_msg", "用户名或密码错误");
				return "/login/login";
			}else{
				request.getSession().setAttribute(Constant.CAR_USER_SESSION, userInfo);
				try{
					UserInfo user = new UserInfo();
					user.setUser_id(userInfo.getUser_id());
					user.setLast_time(DateUtil.getCurrentDateTime());//更新最近一次登录时间
					user.setLast_ip(getRemortIP(request));//上一次登录的地址
					userInfoService.updateByPrimaryKeySelective(user);
				}catch(Exception e){
					log.error("登录保存上一次登录时间异常", e);
				}
			}
		}
		return "/login/mainframe";
	}
}
