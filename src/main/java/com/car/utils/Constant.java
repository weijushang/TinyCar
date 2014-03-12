package com.car.utils;

public class Constant {
	
	//分页查询返回结果
	public static final String MAP_VALUE_COUNT = "count";
	public static final String MAP_VALUE_LIST = "result";
	
	//默认每页数量
	public static final int DEFAULT_PAGESIZE = 10;
	public static final int DEFAULT_PAGESIZE_PORTAL = 20;
	//默认页码
	public static final int DEFAULT_PAGENUM = 1;
	
	//用户session
	public static final String CAR_USER_SESSION = "car_user_session";
	
	//图片路径
	public static final String CORP_IMAGE_URL = "image_url";
	
	public static final String IMAGE_URL = "image.url";//图片url
	public static final String IMAGES_DIR = "images.dir";//图片文件夹
	public static final String FAVORABLE_IMAGE_PATH = "favorable.image.path";//头像图片存放路径
	public static final String PRODUCT_IMAGE_PATH = "product.image.path";//产品图片存放路径
	public static final String NEWS_IMAGE_PATH = "news.image.path";//新闻图片存放路径
	public static final String LIFE_IMAGE_PATH = "life.image.path";//车生活图标路径
	
	//----------error code----------//
	//系统异常
	public static final String SYS_EXCEPTION_CODE = "-100";//系统异常code
	public static final String SYS_EXCEPTION_MSG = "系统异常";//系统异常msg
	
	//id默认开头
	public static final String HEADER_ID_USER = "100";//用户id以100开头
	public static final String HEADER_ID_NEWS = "200";//新闻id以200开头
	public static final String HEADER_ID_NEWS_TYPE = "210";//新闻id类型以210开头
	public static final String HEADER_ID_INSURE = "300";//保险id以300开头
	public static final String HEADER_ID_ORDER = "400";//预约id以400开头
	public static final String HEADER_ID_FAVORABLE = "500";//优惠列表id以500开头
	public static final String HEADER_ID_FAVORABLE_EXPERT = "510";//优惠专家id以510开头
	public static final String HEADER_ID_FILE = "600";//文件id以600开头
	public static final String HEADER_ID_PRODUCT = "700";//产品id以700开头
	public static final String HEADER_ID_PRODUCT_EXPERT = "710";//贷款专家id以710开头
	public static final String HEADER_ID_FAQ = "800";//常见问题id以800开头头
	public static final String HEADER_ID_FAQ_TYPE = "810";//常见问题类型id以810开头头
	public static final String HEADER_ID_SETTLE = "900";//结清预约id以900开头头
	
	//图片类型00产品01优惠02新闻
	public static final String FILE_TYPE_PRODUCT = "00";//产品
	public static final String FILE_TYPE_FAVORABLE = "01";//优惠
	public static final String FILE_TYPE_NEW = "02";//新闻
	public static final String FILE_TYPE_FAVORABLE_AD = "03";//优惠广告图
	public static final String FILE_TYPE_PRODUCT_AD = "04";//产品广告图
	public static final String FILE_TYPE_LIFE = "05";//车生活图标

	//类型00新闻01faq
	public static final String TYPE_CLASSIFY_NEWS = "00";//类型00新闻
	public static final String TYPE_CLASSIFY_FAQ = "01";//类型01faq

	//预约状态
	public static final String STATE_PRODUCT_EXPERT_00 = "00";//未处理
	public static final String STATE_PRODUCT_EXPERT_01 = "01";//已处理
	//在线申请单状态
	public static final String STATE_ORDER_00 = "00";//未处理
	public static final String STATE_ORDER_01 = "01";//已处理
	//结清预约状态
	public static final String STATE_SETTLE_00 = "00";//未处理
	public static final String STATE_SETTLE_01 = "01";//已处理
	
	//false则不调用true则调用
	public static final String CAR_TYPE_SWITCH = "car.type.switch";
	public static final String CAR_TYPE_QUERY_URL = "car.type.query.url";
	public static final String CAR_TYPE_QUERY_SONS_URL = "car.type.query.sons.url";
}
