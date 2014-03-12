package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.IUserInfoDAO;
import com.car.domain.UserInfo;
import com.car.service.IUserInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 用户service实现类
 * @Title: UserInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class UserInfoService implements IUserInfoService {

	private static Log log = LogFactory.getLog(UserInfoService.class);

	@Autowired
	private IUserInfoDAO userInfoDAO;
	
	@Override
	public boolean insertSelective(UserInfo userInfo) throws CarException {
		
		boolean bool = true;
		try{
			UserInfo user = new UserInfo();
			//判断登录名是否存在
			user.setLogin_name(userInfo.getLogin_name());
			int count = countByExample(user);//判断登录名是否已经存在
			if(count > 0){
				throw new CarException("1001", "登录名已存在");
			}else{
				deleteByExample(user);
			}
			userInfoDAO.insertSelective(userInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public UserInfo selectByPrimaryKey(UserInfo userInfo) {
		
		return userInfoDAO.selectByPrimaryKey(userInfo);
	}

	@Override
	public UserInfo selectByLoginAndPwd(UserInfo userInfo) {
		
		return userInfoDAO.selectByLoginAndPwd(userInfo);
	}

	@Override
	public int countByExample(UserInfo userInfo) {
		
		return userInfoDAO.countByExample(userInfo);
	}

	@Override
	public List<UserInfo> selectByExample(UserInfo userInfo) {
		
		return userInfoDAO.selectByExample(userInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(UserInfo userInfo) throws CarException {
		
		try{
			return userInfoDAO.updateByPrimaryKeySelective(userInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(UserInfo userInfo) throws CarException {
		
		try{

			return userInfoDAO.deleteByExample(userInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(UserInfo userInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = userInfoDAO.countByExample(userInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<UserInfo> list = userInfoDAO.getPageList(userInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
