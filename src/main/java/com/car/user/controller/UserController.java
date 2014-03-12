package com.car.user.controller;

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
import com.car.utils.CarException;
import com.car.utils.Constant;
import com.car.utils.MD5;

/**
 * 用户信息
 * @Title: UserInfoController.java
 * @author wangyh
 * @date 2014-2-24 上午11:55:25
 * @Description: 
 */
@Controller
@RequestMapping("/manager/user")
public class UserController extends BaseController{

	
	private static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private IUserInfoService userInfoService;
	
	/**
	 * 用户信息修改页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/user_modify.htm")
	public String userModify(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		log.info("进入用户信息修改页面");
		//获取用户信息
		request.setAttribute("userInfo", getSessionUserInfo(request));
		
		return "/user/user_modify";
	}
	
	/**
	 * 用户信息修改
	 * @param userInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/usersave.htm")
	public void modify(UserInfo userInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入用户信息修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = userInfoService.updateByPrimaryKeySelective(userInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}else{
				//修改后将数据重新保存到session中
				userInfo = userInfoService.selectByPrimaryKey(userInfo);
				request.getSession().setAttribute(Constant.CAR_USER_SESSION, userInfo);
			}
		} catch (CarException e) {
			log.error("修改user用户信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 用户密码修改页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/user_modifypwd.htm")
	public String userModifyPwd(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		log.info("进入用户密码修改页面");
		
		return "/user/user_modifypwd";
	}
	
	/**
	 * 密码修改
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/savepwd.htm")
	public void savePwd(UserInfo userInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入用户密码修改");
		boolean bool = true;
		String message = "密码修改成功";
		try {
			if(StringUtils.isBlank(userInfo.getNew_pwd())
						|| StringUtils.isBlank(userInfo.getConfirm_pwd())){
				bool = false;
				message = "新密码不能为空";
			}else{
				if(!userInfo.getNew_pwd().equals(userInfo.getConfirm_pwd())){
					bool = false;
					message = "两次输入的密码不一致";
				}
			}
			//如果是修改自己的密码
			UserInfo sessionUser = getSessionUserInfo(request);
			if(userInfo.getUser_id()==null || sessionUser.getUser_id().compareTo(userInfo.getUser_id()) == 0){
				if(StringUtils.isBlank(userInfo.getLogin_pwd())){
					bool = false;
					message = "原密码不能为空";
				}
				if(bool){
					UserInfo user = new UserInfo();
					user.setLogin_name(sessionUser.getLogin_name());
					user.setLogin_pwd(MD5.encrypt(userInfo.getLogin_pwd()));
					user = userInfoService.selectByLoginAndPwd(user);//用来判断原密码是否正确
					if(user==null){//加密后的密码
						bool = false;
						message = "原密码错误";
					}else{
						userInfo.setUser_id(user.getUser_id());
					}
				}
			}
			if(bool){//验证之后
				userInfo.setLogin_pwd(MD5.encrypt(userInfo.getNew_pwd()));//设置加密密码
				bool = userInfoService.updateByPrimaryKeySelective(userInfo);
				if(!bool){
					bool = false;
					message = "密码修改失败";
				}
			}
		} catch (CarException e) {
			log.error("用户密码修改异常"+e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
}
