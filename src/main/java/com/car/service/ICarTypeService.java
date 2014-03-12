package com.car.service;

import java.util.List;

import com.car.domain.CarType;


/**
 * 车型数据sevice接口
 * @Title: ICarTypeService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface ICarTypeService {
	
	/**
	 * 获取汽车品牌列表
	 * @return
	 */
	List<CarType> getCarTypeList();

	/**
	 * 通过父id获取数据
	 * @param parentId
	 * @return
	 */
	List<CarType> getCarTypeListByPid(Integer parentId);
}
