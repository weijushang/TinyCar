package com.car.dao;

import java.util.List;

import com.car.domain.SettleInfo;

/**
 * 结清预约dao接口
 * @Title: ISettleInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface ISettleInfoDAO {
	
	/**
	 * 保存数据
	 * @param settleInfo
	 */
	void insertSelective(SettleInfo settleInfo);
	
	/**
	 * 主键单条查询
	 * @param settleInfo
	 * @return
	 */
	SettleInfo selectByPrimaryKey(SettleInfo settleInfo);
	
	/**
	 * 数量查询
	 * @param settleInfo
	 * @return
	 */
	int countByExample(SettleInfo settleInfo);
	
	/**
	 * 列表查询
	 * @param settleInfo
	 * @return
	 */
	List<SettleInfo> selectByExample(SettleInfo settleInfo);
	
	/**
	 * 返回分页数据
	 * @param settleInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<SettleInfo> getPageList(SettleInfo settleInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param settleInfo
	 */
	int updateByPrimaryKeySelective(SettleInfo settleInfo);
	
	/**
	 * 条件删除
	 * @param settleInfo
	 */
	int deleteByExample(SettleInfo settleInfo);
	
}
