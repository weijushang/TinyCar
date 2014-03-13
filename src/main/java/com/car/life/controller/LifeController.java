package com.car.life.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.car.service.IFileInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 车生活
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class LifeController extends BaseController{

	
	private static Log log = LogFactory.getLog(LifeController.class);
	
	@Autowired
	private IFileInfoService fileInfoService;

	/**
	 * 车生活
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/car/life.htm")
	public String contact(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入车生活首页");
		
		List<FileInfo> image_list = getImages();
		if(image_list!=null&&image_list.size()>0){//根据序号排序
			Collections.sort(image_list, new SortSeqComparator());
		}
		request.setAttribute("image_list", image_list);
		return "/life/life";
	}

	/**
	 * 理财试算
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/life/help.htm")
	public String help(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入理财试算");
		
		return "/life/help";
	}
	
	@SuppressWarnings("rawtypes")
	private class SortSeqComparator implements Comparator {
		public int compare(Object a, Object b) {
			FileInfo fileA = (FileInfo)a;
			FileInfo fileB = (FileInfo)b;
			if(fileA.getFile_seq()!=null && fileB.getFile_seq()!=null)
				return fileA.getFile_seq()-fileB.getFile_seq();
			return -1;
		}
	}
	
	private List<FileInfo> getImages(){
		
		FileInfo fileInfo = new FileInfo();
		//图标
		fileInfo.setFile_type(Constant.FILE_TYPE_LIFE);
		return fileInfoService.selectByExample(fileInfo);
	}
	
	@SuppressWarnings("rawtypes")
	private class SortIdComparator implements Comparator {
		public int compare(Object a, Object b) {
			FileInfo fileA = (FileInfo)a;
			FileInfo fileB = (FileInfo)b;
			return fileA.getFile_id().compareTo(fileB.getFile_id());
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/manager/life/life_index.htm")
	public String list(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入车生活图标管理");
		//获取相关图片
		List<FileInfo> image_list = getImages();
		if(image_list!=null&&image_list.size()>0){//根据序号排序
			Collections.sort(image_list, new SortIdComparator());
		}
		request.setAttribute("image_list", image_list);
		return "/life/life_index";
	}
	
	/**
	 * 批量上传图片
	 * @param image_files
	 * @param file_alise
	 * @param outer_url
	 * @param file_seq
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/manager/life/uploadImages.htm")
	public String uploadImages(@RequestParam MultipartFile[] image_files, String[] file_alise, String[] outer_url, 
			Integer[] file_seq, HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入批量上传图片");
		
		request.setAttribute("err_div0", uploadFile(image_files, file_alise, outer_url, file_seq));
		//获取相关图片
		List<FileInfo> image_list = getImages();
		if(image_list!=null&&image_list.size()>0){//根据序号排序
			Collections.sort(image_list, new SortIdComparator());
		}
		request.setAttribute("image_list", image_list);
		
		return "/life/life_index";
	}
	
	/**
	 * 文件上传
	 * @param image_files
	 * @param file_alise
	 * @param outer_url
	 * @param file_seq
	 * @return
	 */
	private String uploadFile(MultipartFile[] image_files, String[] file_alise, 
			String[] outer_url, Integer[] file_seq){
		
		String err_msg = "图片保存成功";
		try{
			if(image_files == null || image_files.length==0){
				throw new CarException("100001", "参数不能为空");
			}
			
			if(!fileInfoService.saveFiles(image_files, file_alise, outer_url, file_seq)){
				err_msg = "图片保存失败";
			}
		}catch(CarException e){
			log.info("图片保存异常：", e);
			err_msg = e.getErrMsg();
		}catch(Exception e){
			log.info("图片保存异常：", e);
			err_msg = "系统异常";
		}
		return err_msg;
	}
	
	/**
	 * 修改数据
	 * @param file_id
	 * @param type
	 * @param value
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/life/updatefilevalue.htm")
	public void updatefilevalue(BigDecimal file_id, Integer type, String value, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入修改数据");
		String err_msg = "修改成功";
		try{
			if(file_id == null || value ==null || "".equals(value)){
				throw new CarException("100001", "参数不能为空");
			}
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFile_id(file_id);
			if(type == 0){//修改名称alise
				fileInfo.setFile_alise(value);
			}else if(type == 1){//修改外部链接
				fileInfo.setOuter_url(value);
			}else if(type == 2){//修改序号
				fileInfo.setFile_seq(Integer.valueOf(value));
			}
			boolean bool = fileInfoService.updateByPrimaryKeySelective(fileInfo);
			if(!bool){
				err_msg = "修改失败";
			}
		}catch(CarException e){
			log.info("修改数据异常：", e);
			err_msg = e.getErrMsg();
		}catch(Exception e){
			log.info("修改数据异常：", e);
			err_msg = "系统异常";
		}
		response.getWriter().write(err_msg);
	}
	
	
	/**
	 * 车生活首页
	 * @param fileInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/life/list.htm")
	public String list(FileInfo fileInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入保险列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = fileInfoService.getPageList(fileInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<FileInfo> list = null;
		if(count > 0){
			list = (List<FileInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<FileInfo>();
		}
		request.setAttribute("fileInfo", fileInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
	
		return "/life/life_list";
	}

}
