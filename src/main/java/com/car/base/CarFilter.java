package com.car.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.domain.UserInfo;
import com.car.utils.Constant;

/**
 * 过滤器，用来判断是否已经登录
 * @Title: MonitorFilter.java
 * @author wangyh
 * @date 2013-12-29 下午5:21:53
 * @Description: 
 */
public class CarFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpSession session = request.getSession();
		//获取session是否过期或者是否已经登录
		UserInfo userInfo = (UserInfo) session.getAttribute(Constant.CAR_USER_SESSION);
		String path = request.getRequestURI();
		if(userInfo == null && path.indexOf("/manager/") > 0){//如果过期或者未登录则跳转到登录界面
			response.sendRedirect(request.getContextPath()+"/login.htm");
			return ;
		}
		//正常跳转
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
