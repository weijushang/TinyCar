package com.car.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.car.dao.IFileInfoDAO;
import com.car.dao.INewsInfoDAO;
import com.car.domain.FileInfo;
import com.car.domain.NewsInfo;
import com.car.service.INewsInfoService;
import com.car.utils.CarConfig;
import com.car.utils.CarException;
import com.car.utils.Constant;
import com.car.utils.FileUtil;
import com.car.utils.MD5;

/**
 * 新闻service实现类
 * @Title: NewsInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class NewsInfoService implements INewsInfoService {

	private static Log log = LogFactory.getLog(NewsInfoService.class);

	@Autowired
	private INewsInfoDAO newsInfoDAO;
	@Autowired
	private IFileInfoDAO fileInfoDAO;
	
	@Override
	public boolean insertSelective(NewsInfo newsInfo) throws CarException {
		
		boolean bool = true;
		try{
			MultipartFile image_file = newsInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				addImages(newsInfo, new MultipartFile[]{image_file});//新增
			}
			newsInfoDAO.insertSelective(newsInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public NewsInfo selectByPrimaryKey(NewsInfo newsInfo) {
		
		return newsInfoDAO.selectByPrimaryKey(newsInfo);
	}

	@Override
	public int countByExample(NewsInfo newsInfo) {
		
		return newsInfoDAO.countByExample(newsInfo);
	}

	@Override
	public List<NewsInfo> selectByExample(NewsInfo newsInfo) {
		
		return newsInfoDAO.selectByExample(newsInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(NewsInfo newsInfo) throws CarException {
		
		try{
			MultipartFile image_file = newsInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(newsInfo.getNews_id());//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_NEW);//优惠类型
				List<FileInfo> files = fileInfoDAO.selectByExample(fileInfo);
				if(files == null || files.size() == 0){//不存在则新增纪录
					addImages(newsInfo, new MultipartFile[]{image_file});//新增
				}else{//更新纪录
					updateImages(newsInfo, files.iterator().next(), image_file);//新增
				}
			}
			return newsInfoDAO.updateByPrimaryKeySelective(newsInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	/**
	 * 新增图片信息
	 * @param newsInfo
	 * @param image_files
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void addImages(NewsInfo newsInfo, MultipartFile[] image_files) throws FileNotFoundException, IOException, Exception{
		
		for(int i=0; i<image_files.length; i++){
			
			MultipartFile file = image_files[i];
			
			FileInfo fileInfo = new FileInfo();
			String file_id = Constant.HEADER_ID_FILE+System.currentTimeMillis()+i;
			fileInfo.setFile_id(new BigDecimal(file_id));
			fileInfo.setParent_id(newsInfo.getNews_id());
			fileInfo.setFile_type(Constant.FILE_TYPE_NEW);
			String ori_file_name = file.getOriginalFilename();
			String new_file_name = MD5.encrypt(file_id+System.currentTimeMillis()+ori_file_name);//
			String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
			StringBuffer path = new StringBuffer(CarConfig.getString(Constant.NEWS_IMAGE_PATH)).append(newsInfo.getNews_id()).append("/");
			String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path.toString();
			if(!new File(savePath).isDirectory()){
				new File(savePath).mkdirs();
			}
			//文件生成
			FileUtil.saveFile(file.getInputStream(), savePath, new_file_name+"."+suffix);
			
			fileInfo.setFile_name(new_file_name+"."+suffix);
			fileInfo.setFile_ori_name(ori_file_name);
			fileInfo.setFile_suffix(suffix);
			fileInfo.setFile_path(path.toString());//路径
			fileInfoDAO.insertSelective(fileInfo);
			
			if(image_files.length == 1){
				newsInfo.setFileInfo(fileInfo);//重新设置
				newsInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//路径
			}
		}
	}
	
	/**
	 * 更新图片信息
	 * @param newsInfo
	 * @param fileInfo
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void updateImages(NewsInfo newsInfo, FileInfo fileInfo, MultipartFile file) throws FileNotFoundException, IOException, Exception{
		String ori_file_name = file.getOriginalFilename();
		String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
		StringBuffer path = new StringBuffer(CarConfig.getString(Constant.NEWS_IMAGE_PATH)).append(newsInfo.getNews_id()).append("/");
		String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path.toString();
		if(!new File(savePath).isDirectory()){
			new File(savePath).mkdirs();
		}
		StringBuffer filePath = new StringBuffer(CarConfig.getString(Constant.IMAGES_DIR)).append(fileInfo.getFile_path());

		String new_file_name = fileInfo.getFile_name().substring(0, 33)+suffix;//
		FileUtil.deleteFile(filePath.toString()+fileInfo.getFile_name());//删除原文件
		//文件生成
		FileUtil.saveFile(file.getInputStream(), savePath, new_file_name);
		//更新原文件名
		fileInfo.setFile_ori_name(ori_file_name);
		//更新后缀名
		fileInfo.setFile_suffix(suffix);
		fileInfo.setFile_name(new_file_name);
		fileInfoDAO.updateByPrimaryKeySelective(fileInfo);
		
		newsInfo.setFileInfo(fileInfo);//重新设置
		newsInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//路径
	}

	@Override
	public boolean deleteByExample(NewsInfo newsInfo) throws CarException {
		
		try{

			return newsInfoDAO.deleteByExample(newsInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(NewsInfo newsInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = newsInfoDAO.countByExample(newsInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<NewsInfo> list = newsInfoDAO.getPageList(newsInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
