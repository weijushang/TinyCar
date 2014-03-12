package com.car.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.car.domain.CarType;
import com.car.service.ICarTypeService;
import com.car.utils.CarConfig;
import com.car.utils.Constant;

/**
 * 获取汽车品牌接口实现服务
 * 
 * @Title: CarTypeService.java
 * @author wangyh
 * @date 2014-2-28 下午1:56:50
 * @Description:
 */
public class CarTypeService implements ICarTypeService {

	private static Log log = LogFactory.getLog(CarTypeService.class);
	
	@Override
	public List<CarType> getCarTypeList() {

		// 如果开关为false则返回测试数据
		if ("false".equals(CarConfig.getString(Constant.CAR_TYPE_SWITCH))) {
			log.info("获取车型测试数据");
			return getParentTypeList();
		}
		String result = httpClientGet(CarConfig.getString(Constant.CAR_TYPE_QUERY_URL));
		log.info("通过url获取车型数据："+result);
		if(result!=null){
			//json格式返回list对象
			List<CarType> list = JSON.parseArray(result, CarType.class);
			return list;
		}
		return null;
	}
	
	@Override
	public List<CarType> getCarTypeListByPid(Integer parentId) {

		// 如果开关为false则返回测试数据
		if ("false".equals(CarConfig.getString(Constant.CAR_TYPE_SWITCH))) {
			log.info("获取子车型测试数据");
			return getTypeListFromPid(parentId);
		}
		String result = httpClientGet(CarConfig.getString(Constant.CAR_TYPE_QUERY_SONS_URL)+parentId);
		log.info("通过url获取子车型数据："+result);
		if(result!=null){
			//json格式返回list对象
			List<CarType> list = JSON.parseArray(result, CarType.class);
			return list;
		}
		return null;
	}
	
	private String httpClientGet(String url) {
		log.info("通过http获取车型/品牌数据");
		// 创建GET方法的实例
		GetMethod getMethod = null;
		String result = null;
		try {
			// 构造HttpClient的实例
			HttpClient httpClient = new HttpClient();
			getMethod = new GetMethod(url);
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				log.info("调用url失败: "+getMethod.getStatusLine());
				return null;
			}
			// 读取内容
			result = getMethod.getResponseBodyAsString();
			
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			log.error("调用url异常", e);
		} catch (IOException e) {
			// 发生网络异常
			log.error("网络异常", e);
		} catch (Exception e) {
			// 发生其他异常
			log.error("系统异常", e);
		} finally {
			// 释放连接
			if(getMethod!=null)
				getMethod.releaseConnection();
		}
		// 返回内容
		return result;
	}

	/**
	 * 测试数据
	 * @return
	 */
	private static List<CarType> getParentTypeList() {
		List<CarType> list = new ArrayList<CarType>();
		CarType carType1 = new CarType();
		carType1.setId(1);
		carType1.setValue("雷克萨斯");
		list.add(carType1);
		CarType carType2 = new CarType();
		carType2.setId(2);
		carType2.setValue("路虎");
		list.add(carType2);
		CarType carType3 = new CarType();
		carType3.setId(3);
		carType3.setValue("上海汽车－名爵 MG");
		list.add(carType3);
		CarType carType4 = new CarType();
		carType4.setId(4);
		carType4.setValue("保时捷");
		list.add(carType4);
		return list;
	}
	private static List<CarType> getTypeListFromPid(Integer parentId) {
		List<CarType> list = new ArrayList<CarType>();
		if(parentId == 1){
			CarType carType1 = new CarType();
			carType1.setId(100);
			carType1.setValue("雷克萨斯ES系列");
			list.add(carType1);
			CarType carType2 = new CarType();
			carType2.setId(101);
			carType2.setValue("雷克萨斯GS系列");
			list.add(carType2);
			CarType carType3 = new CarType();
			carType3.setId(102);
			carType3.setValue("雷克萨斯IS系列");
			list.add(carType3);
			CarType carType4 = new CarType();
			carType4.setId(103);
			carType4.setValue("雷克萨斯LS系列");
			list.add(carType4);
		}else if(parentId == 4){
			CarType carType1 = new CarType();
			carType1.setId(113);
			carType1.setValue("保时捷Boxster");
			list.add(carType1);
			CarType carType2 = new CarType();
			carType2.setId(114);
			carType2.setValue("保时捷Cayman");
			list.add(carType2);
			CarType carType3 = new CarType();
			carType3.setId(115);
			carType3.setValue("保时捷Panamera");
			list.add(carType3);
			CarType carType4 = new CarType();
			carType4.setId(116);
			carType4.setValue("保时捷911");
			list.add(carType4);
		}
		return list;
	}

	public static void main(String[] args) {
		String listString = JSON.toJSONString(getParentTypeList());
		log.info(listString);
		List<CarType> list = JSON.parseArray(listString, CarType.class);
		log.info(((CarType)list.iterator().next()).getValue());
	}
}
