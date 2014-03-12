package com.car.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.domain.UserInfo;
import com.car.utils.CarConfig;
import com.car.utils.Constant;

/**
 * 
 * @Title: BaseController.java
 * @author wangyh
 * @date 2013-12-29 下午5:12:51
 * @Description: 提供一些基础的公共方法
 */
public class BaseController {
	
	/**
	 * alert返回信息
	 * @param response
	 * @param msg
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	protected void alertMsg(HttpServletResponse response, String msg) throws UnsupportedEncodingException, IOException{
		
		String script = "<script>parent.showDivResult('"+msg+"');</script>";
		response.getOutputStream().write(script.getBytes("utf-8"));
		
	}
	/**
	 * 返回的json串
	 * @param bool
	 * @param message
	 * @return
	 */
	protected String toJson(boolean bool, String message) {
		StringBuffer res = new StringBuffer("{\"success\":");
		res.append(bool);
		res.append(",\"msg\":\"");
		res.append(message);
		res.append("\"}");
		return res.toString();
	}
	
	/**
	 * 返回给页面
	 * @param response
	 * @param bool
	 * @param message
	 * @throws IOException
	 */
	protected void returnResult(HttpServletResponse response, boolean bool, String message) throws IOException{
		response.setContentType("text/json; charset=utf-8") ;
		response.getWriter().write(toJson(bool, message));
	}

	/**
	 * 获取用户的session
	 * 
	 * @param request
	 * @return
	 */
	protected UserInfo getSessionUserInfo(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session
				.getAttribute(Constant.CAR_USER_SESSION);
		// 判断是否已经登录，已登录则跳转
		if (userInfo != null) {
			return userInfo;
		}
		return null;
	}

	/**
	 * 删除session user
	 * 
	 * @param request
	 */
	protected void removeSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.CAR_USER_SESSION);
		session.invalidate();
	}

	/**
	 * 用来判断是否已经登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected boolean islogined(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		UserInfo userInfo = getSessionUserInfo(request);
		if (userInfo == null) {
			return false;
		}
		return true;
	}
	
	public String image_url;
	//图片url
	public String getImage_url() {
		return CarConfig.getString(Constant.IMAGE_URL);
	}
	
	/**
	 * 获取客户端真实ip
	 * @param request
	 * @return
	 */
	public String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}
}
