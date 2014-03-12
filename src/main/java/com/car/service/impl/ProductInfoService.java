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
import com.car.dao.IProductInfoDAO;
import com.car.domain.FileInfo;
import com.car.domain.ProductInfo;
import com.car.service.IProductInfoService;
import com.car.utils.CarConfig;
import com.car.utils.CarException;
import com.car.utils.Constant;
import com.car.utils.FileUtil;
import com.car.utils.MD5;

/**
 * 产品service实现类
 * @Title: ProductInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class ProductInfoService implements IProductInfoService {

	private static Log log = LogFactory.getLog(ProductInfoService.class);

	@Autowired
	private IProductInfoDAO productInfoDAO;
	@Autowired
	private IFileInfoDAO fileInfoDAO;
	
	@Override
	public boolean insertSelective(ProductInfo productInfo) throws CarException {
		
		boolean bool = true;
		try{
			MultipartFile image_file = productInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				addImages(productInfo, new MultipartFile[]{image_file});//新增
			}
			productInfoDAO.insertSelective(productInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public ProductInfo selectByPrimaryKey(ProductInfo productInfo) {
		
		return productInfoDAO.selectByPrimaryKey(productInfo);
	}

	@Override
	public int countByExample(ProductInfo productInfo) {
		
		return productInfoDAO.countByExample(productInfo);
	}

	@Override
	public List<ProductInfo> selectByExample(ProductInfo productInfo) {
		
		return productInfoDAO.selectByExample(productInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(ProductInfo productInfo) throws CarException {
		
		try{
			MultipartFile image_file = productInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(productInfo.getProduct_id());//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_PRODUCT);//优惠类型
				List<FileInfo> files = fileInfoDAO.selectByExample(fileInfo);
				if(files == null || files.size() == 0){//不存在则新增纪录
					addImages(productInfo, new MultipartFile[]{image_file});//新增
				}else{//更新纪录
					updateImages(productInfo, files.iterator().next(), image_file);//新增
				}
			}
			return productInfoDAO.updateByPrimaryKeySelective(productInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	/**
	 * 新增图片信息
	 * @param productInfo
	 * @param image_files
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void addImages(ProductInfo productInfo, MultipartFile[] image_files) throws FileNotFoundException, IOException, Exception{
		
		for(int i=0; i<image_files.length; i++){
			
			MultipartFile file = image_files[i];
			
			FileInfo fileInfo = new FileInfo();
			String file_id = Constant.HEADER_ID_FILE+System.currentTimeMillis()+i;
			fileInfo.setFile_id(new BigDecimal(file_id));
			fileInfo.setParent_id(productInfo.getProduct_id());
			fileInfo.setFile_type(Constant.FILE_TYPE_PRODUCT);
			String ori_file_name = file.getOriginalFilename();
			String new_file_name = MD5.encrypt(file_id+System.currentTimeMillis()+ori_file_name);//
			String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
			StringBuffer path = new StringBuffer(CarConfig.getString(Constant.PRODUCT_IMAGE_PATH)).append(productInfo.getProduct_id()).append("/");
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
				productInfo.setFileInfo(fileInfo);//重新设置
				productInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//路径
			}
		}
	}
	
	/**
	 * 更新图片信息
	 * @param productInfo
	 * @param fileInfo
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void updateImages(ProductInfo productInfo, FileInfo fileInfo, MultipartFile file) throws FileNotFoundException, IOException, Exception{
		String ori_file_name = file.getOriginalFilename();
		String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
		StringBuffer path = new StringBuffer(CarConfig.getString(Constant.PRODUCT_IMAGE_PATH)).append(productInfo.getProduct_id()).append("/");
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
		
		productInfo.setFileInfo(fileInfo);//重新设置
		productInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//路径
	}
	
	@Override
	public boolean deleteByExample(ProductInfo productInfo) throws CarException {
		
		try{

			return productInfoDAO.deleteByExample(productInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(ProductInfo productInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = productInfoDAO.countByExample(productInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<ProductInfo> list = productInfoDAO.getPageList(productInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
