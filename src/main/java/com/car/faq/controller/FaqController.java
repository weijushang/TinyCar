package com.car.faq.controller;

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
import com.car.domain.FaqInfo;
import com.car.domain.TypeInfo;
import com.car.service.IFaqInfoService;
import com.car.service.ITypeInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 常见问题
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class FaqController extends BaseController{

	
	private static Log log = LogFactory.getLog(FaqController.class);

	@Autowired
	private IFaqInfoService faqInfoService;
	
	@Autowired
	private ITypeInfoService typeInfoService;
	/**
	 * 常见问题首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/car/faq.htm")
	public String faq(FaqInfo faqInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入常见问题首页");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = faqInfoService.getPageList(faqInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<FaqInfo> list = null;
		if(count > 0){
			list = (List<FaqInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<FaqInfo>();
		}
		request.setAttribute("faqInfo", faqInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		
		return "/faq/faq";
	}
	
	/**
	 * 常见问题列表
	 * @param faqInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/faq/list.htm")
	public String list(FaqInfo faqInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入常见问题列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = faqInfoService.getPageList(faqInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<FaqInfo> list = null;
		if(count > 0){
			list = (List<FaqInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<FaqInfo>();
		}
		request.setAttribute("faqInfo", faqInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/faq/faq_list";
	}
	
	/**
	 * 删除常见问题
	 * @param faq
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/faq/faqdel.htm")
	public void faqDel(@RequestParam("faq_id") BigDecimal faq_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入常见问题删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(faq_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				FaqInfo faqInfo = new FaqInfo();
				faqInfo.setFaq_id(faq_id);
				bool = faqInfoService.deleteByExample(faqInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除常见问题异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改faq常见问题页面
	 * @param faq_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/faq/faqinfo.htm")
	public String faqinfo(BigDecimal faq_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(faq_id == null){
				log.info("进入新增faq常见问题页面");
				request.getSession().removeAttribute("faqInfo");
			}else{
				log.info("进入faq常见问题修改页面");
				FaqInfo faqInfo = new FaqInfo();
				faqInfo.setFaq_id(faq_id);
				faqInfo = faqInfoService.selectByPrimaryKey(faqInfo);
				//转化为字符串
				if(faqInfo!=null && faqInfo.getFaq_answer()!=null){
					faqInfo.setFaq_answer_str(new String(faqInfo.getFaq_answer(), "UTF-8"));
				}
				request.getSession().setAttribute("faqInfo", faqInfo);
			}
			//新闻类型
			TypeInfo typeInfo = new TypeInfo();
			typeInfo.setType_classify(Constant.TYPE_CLASSIFY_FAQ);
			List<TypeInfo> types = typeInfoService.selectByExample(typeInfo);
			request.setAttribute("type_list", types);
		}
		return "/faq/faq_modify";
	}
	
	/**
	 * faq常见问题保存
	 * @param faqInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/faq/faqsave.htm")
	public void faqSave(FaqInfo faqInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		//转化
		String faq_answer_str = faqInfo.getFaq_answer_str();
		if(faq_answer_str!=null && !"".equals(faq_answer_str)){
			faqInfo.setFaq_answer(faq_answer_str.getBytes());
		}
		if(faqInfo!=null && faqInfo.getFaq_id()!=null){//修改
			modify(faqInfo, request, response);
		}else{//否则新增faq常见问题
			add(faqInfo, request, response);
		}
	}
	
	/**
	 * 修改faq常见问题
	 * @param faqInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(FaqInfo faqInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入faq常见问题修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = faqInfoService.updateByPrimaryKeySelective(faqInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改faq常见问题异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * faq常见问题新增
	 * @param faqInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(FaqInfo faqInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入faq常见问题新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			faqInfo.setFaq_id(new BigDecimal(Constant.HEADER_ID_FAQ+System.currentTimeMillis()));
			bool = faqInfoService.insertSelective(faqInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增faq常见问题异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
}
