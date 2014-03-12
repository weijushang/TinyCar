package com.car.news.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.car.base.BaseController;
import com.car.base.Page;
import com.car.domain.FileInfo;
import com.car.domain.NewsInfo;
import com.car.domain.TypeInfo;
import com.car.service.IFileInfoService;
import com.car.service.INewsInfoService;
import com.car.service.ITypeInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 公司新闻动态
 * @Title: NewsController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:27
 * @Description: 
 */
@Controller
public class NewsController extends BaseController{

	
	private static Log log = LogFactory.getLog(NewsController.class);

	@Autowired
	private INewsInfoService newsInfoService;
	@Autowired
	private IFileInfoService fileInfoService;
	@Autowired
	private ITypeInfoService typeInfoService;
	/**
	 * 新闻动态首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/news.htm")
	public String news(NewsInfo newsInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入新闻动态首页");

		getList(newsInfo, pageNum, pageSize, request, response);
		return "/news/news";
	}
	
	@RequestMapping("/car/news_detail.htm")
	public String news_detail(@RequestParam("news_id") BigDecimal news_id,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入产品详情");
		NewsInfo newsInfo = new NewsInfo();
		newsInfo.setNews_id(news_id);
		newsInfo = newsInfoService.selectByPrimaryKey(newsInfo);
		request.getSession().setAttribute("newsInfo", newsInfo);
		return "/news/news_detail";
	}
	
	/**
	 * 新闻列表
	 * @param newsInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/news/list.htm")
	public String list(NewsInfo newsInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入新闻列表");
		getList(newsInfo, pageNum, pageSize, request, response);
		return "/news/news_list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void getList(NewsInfo newsInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response){

		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = newsInfoService.getPageList(newsInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<NewsInfo> list = null;
		if(count > 0){
			list = (List<NewsInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<NewsInfo>();
		}
		request.setAttribute("newsInfo", newsInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
	}
	
	/**
	 * 删除新闻信息
	 * @param news
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/news/newsdel.htm")
	public void newsDel(@RequestParam("news_id") BigDecimal news_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入新闻信息删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(news_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				NewsInfo newsInfo = new NewsInfo();
				newsInfo.setNews_id(news_id);
				bool = newsInfoService.deleteByExample(newsInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除新闻异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改news新闻页面
	 * @param news_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/news/newsinfo.htm")
	public String newsinfo(BigDecimal news_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(news_id == null){
				log.info("进入新增news新闻页面");
				request.getSession().removeAttribute("newsInfo");
			}else{
				log.info("进入news新闻修改页面");
				NewsInfo newsInfo = new NewsInfo();
				newsInfo.setNews_id(news_id);
				newsInfo = newsInfoService.selectByPrimaryKey(newsInfo);
				//转化为字符串
				if(newsInfo!=null && newsInfo.getNews_content()!=null){
					newsInfo.setNews_content_str(new String(newsInfo.getNews_content(), "UTF-8"));
				}
				request.getSession().setAttribute("newsInfo", newsInfo);
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(news_id);//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_NEW);//类型
				List<FileInfo> files = fileInfoService.selectByExample(fileInfo);
				if(files!=null && files.size() > 0){
					newsInfo.setFileInfo(files.iterator().next());
				}
			}
			//新闻类型
			TypeInfo typeInfo = new TypeInfo();
			typeInfo.setType_classify(Constant.TYPE_CLASSIFY_NEWS);
			List<TypeInfo> types = typeInfoService.selectByExample(typeInfo);
			request.setAttribute("type_list", types);
		}
		return "/news/news_modify";
	}
	
	/**
	 * news新闻保存
	 * @param newsInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/news/newssave.htm")
	public String newsSave(NewsInfo newsInfo, MultipartFile image_file, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		String err_msg = null;
		newsInfo.setImage_file(image_file);
		//转化
		String news_content_str = newsInfo.getNews_content_str();
		if(news_content_str!=null && !"".equals(news_content_str)){
			newsInfo.setNews_content(news_content_str.getBytes());
		}
		if(newsInfo!=null && newsInfo.getNews_id()!=null){//修改
			String msg = modify(newsInfo, request, response);
			err_msg = msg==null?"修改成功":msg;
		}else{//否则新增favorable保险
			String msg = add(newsInfo, request, response);
			err_msg = msg==null?"新增成功":msg;
		}
		request.setAttribute("err_msg", err_msg);
		return "/news/news_modify";
	}
	
	/**
	 * 修改news新闻信息
	 * @param newsInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String modify(NewsInfo newsInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入news新闻修改");
		String message = null;
		try {
			boolean bool = newsInfoService.updateByPrimaryKeySelective(newsInfo);
			if(!bool){
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改news新闻信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
	/**
	 * news新闻新增
	 * @param newsInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String add(NewsInfo newsInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入news新闻新增");
		String message = null;
		try {
			newsInfo.setNews_id(new BigDecimal(Constant.HEADER_ID_NEWS+System.currentTimeMillis()));
			boolean bool = newsInfoService.insertSelective(newsInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增news新闻信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
}
