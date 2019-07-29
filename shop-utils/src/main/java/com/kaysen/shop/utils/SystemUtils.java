package com.kaysen.shop.utils;

/**
 * @Classname SystemUtils
 * @Description TODO
 * @Date 2019/7/18 10:53
 * @Created by ks.xu
 */
public class SystemUtils {
    /**
     * 判断是否是Windows平台
     * @return
     */
    public static boolean isWindows(){
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }

    /**
     * 判断是否是Linux
     * @return
     */
    public static boolean isLinux(){
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("LINUX") != -1;
    }

    /**
     * 获取系统类型
     * @return
     */
    public static String getOSType(){
        return System.getProperties().getProperty("os.name");
    }
}
