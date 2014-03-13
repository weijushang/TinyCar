CREATE SCHEMA `tinycar` DEFAULT CHARACTER SET utf8 ;

CREATE  TABLE `tinycar`.`user_info` (
  `user_id` BIGINT NOT NULL COMMENT '用户id' ,
  `login_name` VARCHAR(60) NULL COMMENT '登录名' ,
  `login_pwd` VARCHAR(32) NULL COMMENT '登录密码（md5加密）' ,
  `user_name` VARCHAR(100) NULL COMMENT '用户名称' ,
  `user_email` VARCHAR(60) NULL COMMENT 'email' ,
  `user_phone` VARCHAR(11) NULL COMMENT '手机号码' ,
  `user_post` VARCHAR(6) NULL COMMENT '邮编' ,
  `user_address` VARCHAR(200) NULL COMMENT '地址' ,
  `user_remark` VARCHAR(512) NULL COMMENT '备注说明' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间yyyy-mm-dd HH:mm:ss' ,
  `update_time` VARCHAR(19) NULL COMMENT '修改时间yyyy-mm-dd HH:mm:ss' ,
  `last_time` VARCHAR(19) NULL COMMENT '上一次登录时间' ,
  `last_ip` VARCHAR(15) NULL COMMENT '上一次登录ip' ,
  PRIMARY KEY (`user_id`) )
COMMENT = '用户信息';

INSERT INTO `tinycar`.`user_info` (`user_id`, `login_name`, `login_pwd`, `user_name`, `user_email`, `user_phone`, `user_post`, `user_address`, `create_time`, `update_time`) VALUES ('0', 'admin', '21232f297a57a5a743894a0e4a801fc3', '超级管理员', 'admin@email.com', '13888888888', '320000', '浙江杭州', '2014-02-20 11:12:13', '2014-02-20 11:12:13');

CREATE  TABLE `tinycar`.`news_info` (
  `news_id` BIGINT NOT NULL COMMENT '新闻编码' ,
  `news_title` VARCHAR(200) NULL COMMENT '新闻标题' ,
  `news_type` VARCHAR(2) NULL COMMENT '新闻类型00公司新闻01行业动态02软文' ,
  `news_content` VARCHAR(2000) NULL COMMENT '新闻内容' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`news_id`) )
COMMENT = '新闻信息';

CREATE  TABLE `tinycar`.`insure_info` (
  `insure_id` BIGINT NOT NULL COMMENT '保险id' ,
  `insure_title` VARCHAR(200) NULL COMMENT '保险标题' ,
  `insure_intro` VARCHAR(250) NULL COMMENT '保险简介' ,
  `insure_detail` VARCHAR(2000) NULL COMMENT '保险详情' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`insure_id`) )
COMMENT = '保险信息';

CREATE  TABLE `tinycar`.`order_info` (
  `order_id` BIGINT NOT NULL COMMENT '预约id' ,
  `insure_id` BIGINT NULL COMMENT '保险id' ,
  `insure_title` VARCHAR(100) NULL COMMENT '保险名称' ,
  `cust_name` VARCHAR(60) NULL COMMENT '客户名称' ,
  `cust_phone` VARCHAR(11) NULL COMMENT '客户手机号码' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`order_id`) )
COMMENT = '预约信息';

ALTER TABLE `tinycar`.`order_info` ADD COLUMN `order_state` VARCHAR(2) NULL COMMENT '订单状态00未处理01已处理'  AFTER `update_time` ;
ALTER TABLE `tinycar`.`order_info` CHANGE COLUMN `order_state` `order_state` VARCHAR(2) NULL DEFAULT NULL COMMENT '订单状态00未处理01已处理'  AFTER `insure_title` ;

CREATE  TABLE `tinycar`.`favorable_info` (
  `favor_id` BIGINT NOT NULL ,
  `favor_title` VARCHAR(100) NULL COMMENT '优惠标题' ,
  `favor_intro` VARCHAR(200) NULL COMMENT '优惠简介' ,
  `favor_detail` VARCHAR(3000) NULL COMMENT '优惠详情' ,
  `favor_counselor` VARCHAR(30) NULL COMMENT '顾问' ,
  `favor_phone` VARCHAR(30) NULL COMMENT '电话' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`favor_id`) )
COMMENT = '优惠信息';

CREATE  TABLE `tinycar`.`file_info` (
  `file_id` BIGINT NOT NULL COMMENT '主键id' ,
  `parent_id` BIGINT NULL COMMENT '父id' ,
  `file_type` VARCHAR(2) NULL COMMENT '文件类型' ,
  `file_name` VARCHAR(80) NULL COMMENT '文件名称' ,
  `file_path` VARCHAR(100) NULL COMMENT '文件相对路径' ,
  `file_suffix` VARCHAR(10) NULL COMMENT '文件后缀' ,
  `file_ori_name` VARCHAR(80) NULL COMMENT '文件原名称' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建日期' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新日期' ,
  PRIMARY KEY (`file_id`) )
COMMENT = '文件信息';

CREATE  TABLE `tinycar`.`product_info` (
  `product_id` BIGINT NOT NULL COMMENT '产品id' ,
  `product_title` VARCHAR(200) NULL COMMENT '产品标题' ,
  `product_detail` VARCHAR(4000) NULL COMMENT '产品详情' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`product_id`) )
COMMENT = '产品信息';

CREATE  TABLE `tinycar`.`faq_info` (
  `faq_id` BIGINT NOT NULL COMMENT 'id' ,
  `faq_request` VARCHAR(200) NULL COMMENT '问题' ,
  `faq_answer` VARCHAR(4000) NULL COMMENT '答案' ,
  `faq_seq` INT NULL COMMENT '序号，排序' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`faq_id`) )
COMMENT = '常见问题';

ALTER TABLE `tinycar`.`faq_info` CHANGE COLUMN `faq_answer` `faq_answer` VARCHAR(4000) NULL DEFAULT NULL COMMENT '答案'  ;
ALTER TABLE `tinycar`.`product_info` CHANGE COLUMN `product_detail` `product_detail` VARCHAR(4000) NULL DEFAULT NULL COMMENT '产品详情'  ;
ALTER TABLE `tinycar`.`news_info` CHANGE COLUMN `news_content` `news_content` VARCHAR(4000) NULL DEFAULT NULL COMMENT '新闻内容'  ;
ALTER TABLE `tinycar`.`product_info` CHANGE COLUMN `product_title` `product_title` VARCHAR(200) NULL DEFAULT NULL COMMENT '产品标题'  ;
ALTER TABLE `tinycar`.`news_info` CHANGE COLUMN `news_title` `news_title` VARCHAR(200) NULL DEFAULT NULL COMMENT '新闻标题'  ;

ALTER TABLE `tinycar`.`favorable_info` CHANGE COLUMN `favor_title` `favor_title` VARCHAR(200) NULL DEFAULT NULL COMMENT '优惠标题'  , CHANGE COLUMN `favor_intro` `favor_intro` VARCHAR(500) NULL DEFAULT NULL COMMENT '优惠简介'  , CHANGE COLUMN `favor_detail` `favor_detail` VARCHAR(3000) NULL DEFAULT NULL COMMENT '优惠详情'  ;
ALTER TABLE `tinycar`.`product_info` ADD COLUMN `p_counselor` VARCHAR(30) NULL COMMENT '顾问'  AFTER `product_detail` , ADD COLUMN `phone_call` VARCHAR(30) NULL COMMENT '电话'  AFTER `p_counselor` , ADD COLUMN `hot_line` VARCHAR(20) NULL COMMENT '咨询电话'  AFTER `phone_call` ;
ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `hot_line` VARCHAR(20) NULL COMMENT '咨询电话'  AFTER `favor_phone` ;

ALTER TABLE `tinycar`.`news_info` ADD COLUMN `outer_url` VARCHAR(150) NULL COMMENT '外部链接'  AFTER `news_type` ;
ALTER TABLE `tinycar`.`order_info` CHANGE COLUMN `insure_id` `product_id` BIGINT NULL DEFAULT NULL COMMENT '产品id'  , CHANGE COLUMN `insure_title` `product_title` VARCHAR(200) NULL DEFAULT NULL COMMENT '产品名称'  ;

ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `file_path` VARCHAR(150) NULL  AFTER `hot_line` ;
ALTER TABLE `tinycar`.`product_info` ADD COLUMN `file_path` VARCHAR(150) NULL  AFTER `hot_line` ;
ALTER TABLE `tinycar`.`news_info` ADD COLUMN `file_path` VARCHAR(150) NULL  AFTER `news_content` ;
ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `car_type` VARCHAR(30) NULL  AFTER `file_path` ;

CREATE  TABLE `tinycar`.`favor_expert_info` (
  `expert_id` BIGINT NOT NULL COMMENT 'id' ,
  `favor_id` BIGINT NULL COMMENT '优惠id' ,
  `favor_title` VARCHAR(200) NULL COMMENT '优惠标题' ,
  `car_type` VARCHAR(30) NULL COMMENT '车型' ,
  `cust_name` VARCHAR(60) NULL COMMENT '推荐人姓名' ,
  `cust_phone` VARCHAR(20) NULL COMMENT '推荐人手机号码' ,
  `presentee_name` VARCHAR(60) NULL COMMENT '被推荐人名称' ,
  `presentee_phone` VARCHAR(20) NULL COMMENT '被推荐人手机' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`expert_id`) ,
  UNIQUE INDEX `fav_exp_idx` (`favor_id` ASC, `car_type` ASC, `presentee_name` ASC, `presentee_phone` ASC) )
COMMENT = '优惠专家';

CREATE  TABLE `tinycar`.`credit_expert_info` (
  `expert_id` BIGINT NOT NULL ,
  `product_id` BIGINT NULL ,
  `product_title` VARCHAR(200) NULL ,
  `car_price` VARCHAR(15) NULL COMMENT '车价' ,
  `cust_name` VARCHAR(60) NULL COMMENT '客户姓名' ,
  `cust_phone` VARCHAR(20) NULL COMMENT '客户手机号码' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`expert_id`) )
COMMENT = '贷款专家';

ALTER TABLE `tinycar`.`credit_expert_info` ADD COLUMN `expert_state` VARCHAR(2) NULL COMMENT '状态00未处理01已处理'  AFTER `product_title` ;

drop table `tinycar`.`order_info`;

CREATE  TABLE `tinycar`.`order_info` (
  `order_id` BIGINT(20) NOT NULL COMMENT '预约id' ,
  `cust_name` VARCHAR(60) NULL DEFAULT NULL COMMENT '客户名称' ,
  `cust_phone` VARCHAR(11) NULL DEFAULT NULL COMMENT '客户手机号码' ,
  `cust_sex` VARCHAR(2) NULL COMMENT '客户性别00女01男' ,
  `cust_card` VARCHAR(20) NULL COMMENT '身份证号码' ,
  `province_id` VARCHAR(10) NULL COMMENT '省份id' ,
  `city_id` VARCHAR(10) NULL COMMENT '城市id' ,
  `car_price` VARCHAR(15) NULL COMMENT '车价' ,
  `car_type` VARCHAR(20) NULL COMMENT '车型／品牌' ,
  `car_type_name` VARCHAR(200) NULL COMMENT '品牌名称' ,
  `order_state` VARCHAR(2) NULL DEFAULT NULL COMMENT '申请状态00未处理01已处理' ,
  `create_time` VARCHAR(19) NULL DEFAULT NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL DEFAULT NULL COMMENT '更新时间' ,
  PRIMARY KEY (`order_id`) )
COMMENT = '在线申请';
ALTER TABLE `tinycar`.`order_info` ADD COLUMN `expert_id` BIGINT NULL COMMENT '推荐人信息'  AFTER `order_state` ;

ALTER TABLE `tinycar`.`file_info` ADD COLUMN `file_seq` INT NULL COMMENT '次序'  AFTER `file_ori_name` , ADD COLUMN `file_alise` VARCHAR(100) NULL COMMENT '别名'  AFTER `file_seq` ;
ALTER TABLE `tinycar`.`file_info` ADD COLUMN `outer_url` VARCHAR(200) NULL  AFTER `file_alise` ;

CREATE  TABLE `tinycar`.`settle_info` (
  `settle_id` BIGINT NOT NULL COMMENT 'id' ,
  `settle_name` VARCHAR(100) NULL COMMENT '姓名' ,
  `settle_phone` VARCHAR(20) NULL COMMENT '手机' ,
  `settle_state` VARCHAR(2) NULL COMMENT '状态00未处理01已处理' ,
  `settle_remark` VARCHAR(500) NULL COMMENT '备注说明' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`settle_id`) )
COMMENT = '结清预约';

ALTER TABLE `tinycar`.`favorable_info` CHANGE COLUMN `car_type` `car_type` INT NULL DEFAULT NULL  , ADD COLUMN `car_type_son` INT NULL  AFTER `car_type` ;
ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `car_type_name` VARCHAR(200) NULL COMMENT '车系名称'  AFTER `car_type_son` ;
ALTER TABLE `tinycar`.`order_info` CHANGE COLUMN `car_type` `car_type` INT NULL DEFAULT NULL COMMENT '车型／品牌'  , ADD COLUMN `car_type_son` INT NULL COMMENT '车系'  AFTER `car_type` ;
ALTER TABLE `tinycar`.`favor_expert_info` CHANGE COLUMN `car_type` `car_type` INT NULL DEFAULT NULL COMMENT '车型/品牌'  , ADD COLUMN `car_type_son` INT NULL COMMENT '车系'  AFTER `car_type` , ADD COLUMN `car_type_name` VARCHAR(200) NULL COMMENT '车系名称'  AFTER `car_type_son` ;

ALTER TABLE `tinycar`.`favor_expert_info` 
DROP INDEX `fav_exp_idx` 
, ADD UNIQUE INDEX `fav_exp_idx` (`favor_id` ASC, `car_type` ASC, `presentee_name` ASC, `presentee_phone` ASC, `car_type_son` ASC) ;


ALTER TABLE `tinycar`.`favorable_info` CHANGE COLUMN `favor_detail` `favor_detail` BLOB NULL DEFAULT NULL COMMENT '优惠详情'  ;
ALTER TABLE `tinycar`.`faq_info` CHANGE COLUMN `faq_answer` `faq_answer` BLOB NULL DEFAULT NULL COMMENT '答案'  ;
ALTER TABLE `tinycar`.`insure_info` CHANGE COLUMN `insure_detail` `insure_detail` BLOB NULL DEFAULT NULL COMMENT '保险详情'  ;
ALTER TABLE `tinycar`.`news_info` CHANGE COLUMN `news_content` `news_content` BLOB NULL DEFAULT NULL COMMENT '新闻内容'  ;
ALTER TABLE `tinycar`.`product_info` CHANGE COLUMN `product_detail` `product_detail` BLOB NULL DEFAULT NULL COMMENT '产品详情'  ;
CREATE  TABLE `tinycar`.`type_info` (
  `type_id` BIGINT NOT NULL COMMENT '类别id' ,
  `type_name` VARCHAR(60) NULL COMMENT '类别名称' ,
  `type_classify` VARCHAR(2) NULL COMMENT '类别类型' ,
  `create_time` VARCHAR(19) NULL COMMENT '创建时间' ,
  `update_time` VARCHAR(19) NULL COMMENT '更新时间' ,
  PRIMARY KEY (`type_id`) )
COMMENT = '类别处理';
ALTER TABLE `tinycar`.`type_info` ADD COLUMN `type_remark` VARCHAR(256) NULL COMMENT '备注说明'  AFTER `update_time` ;

ALTER TABLE `tinycar`.`news_info` DROP COLUMN `news_type` , ADD COLUMN `type_id` BIGINT NULL COMMENT '类型id'  AFTER `news_title` ;
ALTER TABLE `tinycar`.`faq_info` ADD COLUMN `type_id` BIGINT NULL  AFTER `faq_id` ;
ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `favor_bdate` VARCHAR(19) NULL COMMENT '优惠开始时间'  AFTER `update_time` , ADD COLUMN `favor_edate` VARCHAR(19) NULL COMMENT '优惠结束时间'  AFTER `favor_bdate` ;
ALTER TABLE `tinycar`.`order_info` ADD COLUMN `favor_id` BIGINT NULL  AFTER `update_time` ;

ALTER TABLE `tinycar`.`favor_expert_info` 
DROP INDEX `fav_exp_idx` 
, ADD UNIQUE INDEX `fav_exp_idx` (`favor_id` ASC, `presentee_name` ASC, `presentee_phone` ASC) ;
ALTER TABLE `tinycar`.`favorable_info` ADD COLUMN `favor_state` VARCHAR(1) NULL COMMENT '0启用1停用'  AFTER `favor_edate` ;

