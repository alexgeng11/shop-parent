package com.kaysen.shop.utils.env;


import com.kaysen.shop.utils.io.PropertiesLoader;

/**
 * 描叙：应用程序相关配置常量 
 * 创建人：HeGuifang
 * 创建时间：2016年5月23日 下午3:11:10
 */
public class AppConfig {

	private static PropertiesLoader appconfig = Environment.getAppConfig();
	
	/***系统管理使用***/
	public static String APP_FILE_BASE_URL  = null;  //上传附件访问路径
	public static String UPLOAD_FILE_BASE_PATH  = null;  //上传附件存储路径
	public static String FWATERM=null;		//文字水印配置
	public static String IWATERM=null;		//图片水印配置
	public static String SYSNAME=null;  //系统名称
	public static Integer ERROR_PASSWORD_NUM=null;  //系统名称
	public static Integer DEPT_JDCSC_ID=null;  //部门中的特殊市场（顺潮机动车市场）
	public static Double PRODUCT_IMAGE_1_W=null;  //图片缩放比率
	public static Double PRODUCT_IMAGE_2_W=null;  //图片缩放比率
	public static Integer SHIRO_CACHE_TIMEOUT=null;  //图片缩放比率
	public static Integer ATTENDANCE_START_DAY=null;  //考勤开始时间
	public static String DEPT_FUNCTION_CODE_MARKETMANAGE=null;	//部门功能编码（市场管理）
	/***收文发文系统使用***/
	public static String DEPT_FUNCTION_CODE_BGS=null;	//部门功能编码（办公室管理）

	public static String DEPT_FUNCTION_CODE_CAIWU=null;	//部门功能编码（财务管理）
	public static String DEPT_FUNCTION_CODE_HQBZ=null;	//部门功能编码（后勤保障管理）
	public static String DEPT_FUNCTION_CODE_JIJIAN=null;	//部门功能编码（基建管理）
	public static String DEPT_FUNCTION_CODE_WUYE=null;	//部门功能编码（物业管理）
	public static String DEPT_FUNCTION_CODE_RENSHI=null;	//部门功能编码（人事管理）
	public static String DEPT_FUNCTION_CODE_ZCYYB=null;	//部门功能编码（资产运营部）
	/***后勤保障系统使用***/
	public static Integer DEPT_CWK_ID=null;	//部门（财务科）
	public static Integer DEPT_HQBZB_ID=null;	//部门（后勤保障部）
	public static Integer DEPT_SCGH_ID=null;	//部门（市场规划管理科）
	
	public static Integer LEVEL_ZXJG_ID=null;	//组织层级（中心机关科室）
	public static Integer LEVEL_SCGL_ID=null;	//组织层级（市场管理）
	
	public static Integer MIN_FUND_LIMIT = null;	//资金申请最低限制

	public static Integer ADMINUSER_TYPE_LAWYER_ROLEID = null;	// 律师用户角色Id
	public static Integer ADMINUSER_TYPE_CPSM_ROLEID = null;	// 管理经理用户角色Id

	public static String APP_USER_TOKEN  = null;  //手机接口token

	public static String MOBILE_PERMISSION_DEPT_IDS  = null;  //手机端权限验证部门

	public static String[] FILE_ID_FIELD = null;
	static {
		FILE_ID_FIELD=appconfig.getPropertyByArr("file.id.field");
		MOBILE_PERMISSION_DEPT_IDS=appconfig.getProperty("mobile.permission.dept.ids");
		APP_FILE_BASE_URL= appconfig.getProperty("upload.files.base.url");
		UPLOAD_FILE_BASE_PATH= appconfig.getProperty("upload.files.base.path");
		FWATERM=appconfig.getProperty("fwaterm");
		IWATERM=appconfig.getProperty("iwaterm");
		SYSNAME=appconfig.getProperty("sysname");
		ERROR_PASSWORD_NUM=appconfig.getInteger("error.password.num");
		DEPT_JDCSC_ID=appconfig.getInteger("dept.jdcsc.id");
		PRODUCT_IMAGE_1_W=appconfig.getDouble("product_image_1_w");
		PRODUCT_IMAGE_2_W=appconfig.getDouble("product_image_2_w");
		SHIRO_CACHE_TIMEOUT=appconfig.getInteger("shiro.cache.timeout");
		ATTENDANCE_START_DAY=appconfig.getInteger("attendance.start.day");
		DEPT_FUNCTION_CODE_MARKETMANAGE=appconfig.getProperty("dept.function.code.marketManage");
		DEPT_FUNCTION_CODE_CAIWU=appconfig.getProperty("dept.function.code.caiwu");
		DEPT_FUNCTION_CODE_BGS=appconfig.getProperty("dept.function.code.bgs");
		DEPT_FUNCTION_CODE_HQBZ=appconfig.getProperty("dept.function.code.hqbz");
		DEPT_FUNCTION_CODE_JIJIAN=appconfig.getProperty("dept.function.code.jijian");
		DEPT_FUNCTION_CODE_WUYE=appconfig.getProperty("dept.function.code.wuye");
		DEPT_FUNCTION_CODE_RENSHI=appconfig.getProperty("dept.function.code.renshi");
		DEPT_FUNCTION_CODE_ZCYYB=appconfig.getProperty("dept.function.code.zcyyb");
		DEPT_CWK_ID=appconfig.getInteger("dept.cwk.id");
		DEPT_HQBZB_ID=appconfig.getInteger("dept.hqbzb.id");
		DEPT_SCGH_ID=appconfig.getInteger("dept.scgh.id");
		
		LEVEL_ZXJG_ID=appconfig.getInteger("level.zxjg.id");
		LEVEL_SCGL_ID=appconfig.getInteger("level.scgl.id");
		
		MIN_FUND_LIMIT=appconfig.getInteger("min.fund.limit");

		ADMINUSER_TYPE_LAWYER_ROLEID = appconfig.getInteger("adminuser_type_lawyer_roleId");
		ADMINUSER_TYPE_CPSM_ROLEID = appconfig.getInteger("adminuser_type_cpsm_roleId");

		APP_USER_TOKEN = appconfig.getProperty("mobile.user.token");
	}
	
}
