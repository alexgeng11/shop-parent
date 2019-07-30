package com.kaysen.shop.utils.env;


import com.kaysen.shop.utils.io.PropertiesLoader;

/**
 * 配置文件相关属性
 *
 */
public class Environment {
    private static PropertiesLoader appconfig = null;
    private static PropertiesLoader sensitive = null;

    /**
     * 配置文件(appconfig.properties)
     */
    public static PropertiesLoader getAppConfig() {
    	if(appconfig == null){
    		appconfig = new PropertiesLoader("application-config.properties");
    	}
        return appconfig;
    }

    /**
     * 配置文件(sensitive.properties)
     */
    public static PropertiesLoader getSensitive() {
    	if(sensitive == null){
    		sensitive = new PropertiesLoader("sensitive.properties");
    	}
        return sensitive;
    }

    /**
     * jdbc url连接参数(默认:"").
     */
    public static String getJdbcUrl(){
    	return Environment.getAppConfig().getProperty("url","");
    }
    /**
     * 获取是否是开发模式(默认:false).
     */
    public static boolean isDevMode(){
    	return getAppConfig().getBoolean("dev.mode",false);
    }

	/**
	 * 获得上传表单域的名称
	 *
	 * @return
	 */
	public static final String getUploadFieldName() {
		return getAppConfig().getProperty("uploadFieldName", "filedata");
	}

	/**
	 * 获得上传文件的最大大小限制
	 * 弃用：已经在spring的配置文件里面限定了该参数  by：zhangsong
	 * @return
	 */
	@Deprecated
	public static final long getUploadFileMaxSize() {
		 String uploadFileMaxSize = getAppConfig().getProperty("uploadFileMaxSize", "20971520");
		 return Long.valueOf(uploadFileMaxSize);
	}

	/**
	 * 获得允许上传文件的扩展名
	 *
	 * @return
	 */
	public static final String getUploadFileExts() {
		return getAppConfig().getProperty("uploadFileExts","txt,rar,zip,doc,docx,xls,xlsx,jpg,jpeg,gif,png,swf,wmv,avi,wma,mp3,mid");
	}

	/**
	 * 获得上传文件要放到那个目录
	 *
	 * @return
	 */
	public static final String getUploadDirectory() {
		return getAppConfig().getProperty("upload.files.base.path", "appfiles");
	}

}
