package com.kaysen.shop.utils.env;


import com.kaysen.shop.utils.io.PropertiesLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描叙：应用程序相关配置常量 
 * 创建人：HeGuifang
 * 创建时间：2016年5月23日 下午3:11:10
 */
@Component
public class AppConfig {


	/***系统管理使用***/
	public static String APP_FILE_BASE_URL  = null;  //上传附件访问路径
	public static String UPLOAD_FILE_BASE_PATH  = null;  //上传附件存储路径
	public static String FWATERM=null;		//文字水印配置
	public static String IWATERM=null;		//图片水印配置
	public static String SYSNAME=null;  //系统名称
	public static Integer ERROR_PASSWORD_NUM=null;  //系统名称

	public static String getAppFileBaseUrl() {
		return APP_FILE_BASE_URL;
	}

	public static void setAppFileBaseUrl(String appFileBaseUrl) {
		APP_FILE_BASE_URL = appFileBaseUrl;
	}

	public static String getUploadFileBasePath() {
		return UPLOAD_FILE_BASE_PATH;
	}

	public static void setUploadFileBasePath(String uploadFileBasePath) {
		UPLOAD_FILE_BASE_PATH = uploadFileBasePath;
	}

	public static String getFWATERM() {
		return FWATERM;
	}

	public static void setFWATERM(String FWATERM) {
		AppConfig.FWATERM = FWATERM;
	}

	public static String getIWATERM() {
		return IWATERM;
	}

	public static void setIWATERM(String IWATERM) {
		AppConfig.IWATERM = IWATERM;
	}

	public static String getSYSNAME() {
		return SYSNAME;
	}

	public static void setSYSNAME(String SYSNAME) {
		AppConfig.SYSNAME = SYSNAME;
	}

	public static Integer getErrorPasswordNum() {
		return ERROR_PASSWORD_NUM;
	}
	@Value("${system.properties.errpwdnum}")
	public void setErrorPasswordNum(Integer errorPasswordNum) {
		ERROR_PASSWORD_NUM = errorPasswordNum;
	}
}
