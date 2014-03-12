package com.car.type.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.base.BaseController;
import com.car.base.Page;
import com.car.domain.TypeInfo;
import com.car.service.ITypeInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 新闻/faq类型
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class TypeController extends BaseController{

	
	private static Log log = LogFactory.getLog(TypeController.class);
	
	@Autowired
	private ITypeInfoService typeInfoService;
	
	/**
	 * 新闻/faq类型列表
	 * @param typeInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/type/list.htm")
	public String list(TypeInfo typeInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入新闻/faq类型列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = typeInfoService.getPageList(typeInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<TypeInfo> list = null;
		if(count > 0){
			list = (List<TypeInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<TypeInfo>();
		}
		request.setAttribute("typeInfo", typeInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/type/type_list";
	}
	
	/**
	 * 删除新闻/faq类型
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/type/typedel.htm")
	public void typeDel(@RequestParam("type_id") BigDecimal type_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入新闻/faq类型删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(type_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				TypeInfo typeInfo = new TypeInfo();
				typeInfo.setType_id(type_id);
				bool = typeInfoService.deleteByExample(typeInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除新闻/faq类型异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改type新闻/faq类型页面
	 * @param type_id
	 * @param classify
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/type/typeinfo.htm")
	public String typeinfo(BigDecimal type_id, String classify, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			TypeInfo typeInfo = new TypeInfo();
			if(type_id == null){
				log.info("进入新增新闻/faq类型页面");
				request.getSession().removeAttribute("typeInfo");
				typeInfo.setType_classify(classify);
			}else{
				log.info("进入新闻/faq类型修改页面");
				typeInfo.setType_id(type_id);
				typeInfo = typeInfoService.selectByPrimaryKey(typeInfo);
			}
			request.setAttribute("typeInfo", typeInfo);
		}
		return "/type/type_modify";
	}
	
	/**
	 * 新闻/faq类型保存
	 * @param typeInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/type/typesave.htm")
	public void typeSave(TypeInfo typeInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		if(typeInfo!=null && typeInfo.getType_id()!=null){//修改
			modify(typeInfo, request, response);
		}else{//否则新增type新闻/faq类型
			add(typeInfo, request, response);
		}
	}
	
	/**
	 * 修改新闻/faq类型
	 * @param typeInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(TypeInfo typeInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入新闻/faq类型修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = typeInfoService.updateByPrimaryKeySelective(typeInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改新闻/faq类型异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * 新闻/faq类型新增
	 * @param typeInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(TypeInfo typeInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入新闻/faq类型新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			typeInfo.setType_id(new BigDecimal(Constant.HEADER_ID_FAQ+System.currentTimeMillis()));
			bool = typeInfoService.insertSelective(typeInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增新闻/faq类型异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
}
