package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.UserInfo;
import com.car.utils.CarException;

/**
 * 用户sevice接口
 * @Title: IUserInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IUserInfoService {
	
	/**
	 * 保存数据
	 * @param userInfo
	 */
	boolean insertSelective(UserInfo userInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param userInfo
	 * @return
	 */
	UserInfo selectByPrimaryKey(UserInfo userInfo);
	
	/**
	 * 用户名或email和密码查询
	 * @param userInfo
	 * @return
	 */
	UserInfo selectByLoginAndPwd(UserInfo userInfo);
	
	/**
	 * 数量查询
	 * @param userLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(UserInfo userInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param userInfo
	 */
	boolean updateByPrimaryKeySelective(UserInfo userInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param userInfo
	 */
	boolean deleteByExample(UserInfo userInfo) throws CarException;
	
}
