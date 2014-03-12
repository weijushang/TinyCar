package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IUserInfoDAO;
import com.car.domain.UserInfo;
import com.car.utils.DateUtil;

/**
 * 用户信息dao实现类
 * @Title: UserInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class UserInfoDAO extends BaseDAO implements IUserInfoDAO {

	private final String namespace = UserInfo.class.getName();

	@Override
	public void insertSelective(UserInfo userInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		userInfo.setCreate_time(date);
		userInfo.setUpdate_time(date);
		insertSelective(namespace, userInfo);
	}

	@Override
	public UserInfo selectByPrimaryKey(UserInfo userInfo) {
		
		return (UserInfo) selectByPrimaryKey(namespace, userInfo);
	}

	@Override
	public int countByExample(UserInfo userInfo) {
		
		return countByExample(namespace, userInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> selectByExample(UserInfo userInfo) {
		
		return selectByExample(namespace, userInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo userInfo) {
		
		userInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, userInfo);
	}

	@Override
	public int deleteByExample(UserInfo userInfo) {
		
		return deleteByExample(namespace, userInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getPageList(UserInfo userInfo, int pageNum, int pageSize) {
		
		return getPageList(userInfo, namespace, pageNum, pageSize);
	}

	@Override
	public UserInfo selectByLoginAndPwd(UserInfo userInfo) {
		
		return (UserInfo) getSqlMapClientTemplate().queryForObject(namespace+".selectByLoginAndPwd", userInfo);
	}

}
