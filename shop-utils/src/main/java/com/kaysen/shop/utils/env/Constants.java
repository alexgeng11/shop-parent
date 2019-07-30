package com.kaysen.shop.utils.env;

/**
 * 项目名称：
 * @author:heguifang
 * 修改日期：2015/11/2
*/
public class Constants {
	
	public static final String ADMIN_USER = "adminuser";//用户session保存对应的key

	public static final String MY_MARKETID = "account_inquiry_marketId";//用户session保存对应的key
	public static final String MY_SHOPID = "account__inquiry_shopId";//用户session保存对应的key

	public static final String ADMIN_USER_TYPE = "adminusertype";// 用户类型

	public static final String ADMIN_USER_TYPE_SYS = "sys";// 用户类型-系统用户

	public static final String ADMIN_USER_TYPE_LAWYER = "lawyer";// 用户类型-律师
	public static final String ADMIN_USER_TYPE_CPSM = "cpsm";// 用户类型-律师

	public static final String SUPER_USER_ROLE_ID="1";//超级管理员对应的角色CODE
	
	public static final String MANAGER_USER_ROLE_ID="2";//管理员对应的角色CODE
	
	
	public static final Long PAGE_SIZE = 10L;
	
	public static final String TONKEN_ID ="tokenId";
	
	public static final String LOGIN = "/system/login/login_toLogin.do";		
	
	public static final String ENTITY_DELETE = "1";//标识删除状态的实体
	public static final String ENTITY_NORMAL = "0";//标识正常状态的实体
	
	public static final String ENTITY_ENABLED = "1";//标识启用状态的实体
	public static final String ENTITY_UNABLED = "0";//标识禁用状态的实体

	public static final String WORD_FOLDER = "wordfile";
	
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";//验证码
	
	/// 上传文件存储基文件夹 
	public static final String UPLOAD_FOLDER = "uploadfile";
	public static final String UPLOAD_FOLDER_WEB = "web";
	public static final String UPLOAD_FOLDER_ANDRIOD = "andriod";
	public static final String UPLOAD_FOLDER_WEIXIN = "weixin";
	public static final String UPLOAD_FOLDER_IOS = "ios";
	public static final String PHONE_UPLOAD_FOLDER = "app";

	//部门ID
	public static final Integer OFFICE_DEPT_ID=47;//办公室部门Id
	public static final Integer LOGISTICS_DEPT_ID=46;//后勤保障部门Id
	public static final Integer ASSETOPERATION_DEPT_ID=45;//资产运营部部门Id
	//用户ID
	public static final Integer ANHRY_USER_ID=1;//超管Id
	public static final Integer ADMIN_USER_ID=2;//管理员Id
	//用户类型
	public static final Integer MARKET_CENTER_TYPE=1;//市场中心
	public static final Integer ASSET_OPERATION_TYPE=2;//资产运营部管理人员
	public static final Integer MARKET_MANAGEMENT_TYPE=3;//市场科管理人员
	//
	public static final Integer STOREMANAGER_DUTY_ID=21;//店长
	public static final Integer MANAGER_DUTY_ID=24;//管理经理
	public static final Integer SECTIONCHIEF_DUTY_ID=5;//管理经理
}
