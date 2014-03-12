package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.InsureInfo;
import com.car.utils.CarException;

/**
 * 优惠列表sevice接口
 * @Title: IInsureInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IInsureInfoService {
	
	/**
	 * 保存数据
	 * @param insureInfo
	 */
	boolean insertSelective(InsureInfo insureInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param insureInfo
	 * @return
	 */
	InsureInfo selectByPrimaryKey(InsureInfo insureInfo);
	
	/**
	 * 数量查询
	 * @param insureLogin
	 * @return
	 */
	int countByExample(InsureInfo insureInfo);
	
	/**
	 * 列表查询
	 * @param insureInfo
	 * @return
	 */
	List<InsureInfo> selectByExample(InsureInfo insureInfo);
	
	/**
	 * 返回分页数据
	 * @param insureInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(InsureInfo insureInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param insureInfo
	 */
	boolean updateByPrimaryKeySelective(InsureInfo insureInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param insureInfo
	 */
	boolean deleteByExample(InsureInfo insureInfo) throws CarException;
	
}
