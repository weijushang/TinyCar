package com.car.dao;

import java.util.List;

import com.car.domain.UserInfo;

/**
 * 用户dao接口
 * @Title: IUserInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IUserInfoDAO {
	
	/**
	 * 保存数据
	 * @param userInfo
	 */
	void insertSelective(UserInfo userInfo);
	
	/**
	 * 主键单条查询
	 * @param userInfo
	 * @return
	 */
	UserInfo selectByPrimaryKey(UserInfo userInfo);
	
	/**
	 * 数量查询
	 * @param userInfo
	 * @return
	 */
	int countByExample(UserInfo userInfo);
	
	/**
	 * 列表查询
	 * @param userInfo
	 * @return
	 */
	List<UserInfo> selectByExample(UserInfo userInfo);
	
	/**
	 * 返回分页数据
	 * @param userInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<UserInfo> getPageList(UserInfo userInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param userInfo
	 */
	int updateByPrimaryKeySelective(UserInfo userInfo);
	
	/**
	 * 条件删除
	 * @param userInfo
	 */
	int deleteByExample(UserInfo userInfo);
	
	/**
	 * 用户名和密码查询
	 * @param userInfo
	 * @return
	 */
	UserInfo selectByLoginAndPwd(UserInfo userInfo);
	
}
