package com.car.insure.controller;

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
import com.car.domain.InsureInfo;
import com.car.service.IInsureInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 产品服务
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class InsureController extends BaseController{

	
	private static Log log = LogFactory.getLog(InsureController.class);
	
	@Autowired
	private IInsureInfoService insureInfoService;
	/**
	 * 产品服务首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/insure.htm")
	public String insure(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入产品服务首页");
		
		return "/insure/insure";
	}
	
	/**
	 * 保险列表
	 * @param insureInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/insure/list.htm")
	public String list(InsureInfo insureInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入保险列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = insureInfoService.getPageList(insureInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<InsureInfo> list = null;
		if(count > 0){
			list = (List<InsureInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<InsureInfo>();
		}
		request.setAttribute("insureInfo", insureInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/insure/insure_list";
	}
	
	/**
	 * 删除保险信息
	 * @param insure
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/insure/insuredel.htm")
	public void insureDel(@RequestParam("insure_id") BigDecimal insure_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入保险信息删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(insure_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				InsureInfo insureInfo = new InsureInfo();
				insureInfo.setInsure_id(insure_id);
				bool = insureInfoService.deleteByExample(insureInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除保险异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改insure保险页面
	 * @param insure_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/insure/insureinfo.htm")
	public String insureinfo(BigDecimal insure_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(insure_id == null){
				log.info("进入新增insure保险页面");
				request.getSession().removeAttribute("insureInfo");
			}else{
				log.info("进入insure保险修改页面");
				InsureInfo insureInfo = new InsureInfo();
				insureInfo.setInsure_id(insure_id);
				insureInfo = insureInfoService.selectByPrimaryKey(insureInfo);
				//转化为字符串
				if(insureInfo!=null && insureInfo.getInsure_detail()!=null){
					insureInfo.setInsure_detail_str(new String(insureInfo.getInsure_detail(), "UTF-8"));
				}
				request.getSession().setAttribute("insureInfo", insureInfo);
			}
		}
		return "/insure/insure_modify";
	}
	
	/**
	 * insure保险保存
	 * @param insureInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/insure/insuresave.htm")
	public void insureSave(InsureInfo insureInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		//转化为byte[]
		String insure_detail_str = insureInfo.getInsure_detail_str();
		if(insure_detail_str!=null && !"".equals(insure_detail_str)){
			insureInfo.setInsure_detail(insure_detail_str.getBytes());
		}
		if(insureInfo!=null && insureInfo.getInsure_id()!=null){//修改
			modify(insureInfo, request, response);
		}else{//否则新增insure保险
			add(insureInfo, request, response);
		}
	}
	
	/**
	 * 修改insure保险信息
	 * @param insureInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(InsureInfo insureInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入insure保险修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = insureInfoService.updateByPrimaryKeySelective(insureInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改insure保险信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * insure保险新增
	 * @param insureInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(InsureInfo insureInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入insure保险新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			insureInfo.setInsure_id(new BigDecimal(Constant.HEADER_ID_INSURE+System.currentTimeMillis()));
			bool = insureInfoService.insertSelective(insureInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增insure保险信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
}
