package com.kaysen.shop.web.system.env;
/**
 * 描叙：系统管理模块常量类
 * 创建人：HeGuifang
 * 创建时间：2016年4月11日 下午3:44:31
 */
public class SysConstants {
	
	/**
	 * 日志记录类型
	 */
	public static final String[] ACTION_LOG_OPERATION_TYPE_ADD={"0","添加"};//添加
	public static final String[] ACTION_LOG_OPERATION_TYPE_EDIT={"1","修改"};//修改
	public static final String[] ACTION_LOG_OPERATION_TYPE_DELETE={"2","删除"};//删除
			
	public static final String WEB_SUCCESS[] = {"100","请求操作成功!"};							//请求操作成功
	public static final String WEB_FAILURE[] = {"101","请求操作失败!"};							//请求操作失败
	public static final String WEB_USER_ERROR[] = {"201","用户名或密码有误!"};							//用户名或密码有误
	public static final String WEB_CODE_ERROR[] = {"202","验证码输入有误!"};							//验证码输入有误
	public static final String WEB_CODE_NULL_ERROR[] = {"203","效验码为空!"};							//效验码为空
	public static final String WEB_TOKEN_ERROR[] = {"204","客户端校验失败!"};							//客户端校验失败
	public static final String WEB_PARAM_LACK_ERROR[] = {"205","缺少参数!"};							//缺少参数
	public static final String WEB_EXCESSIVE_ATTEMPTS_ERROR[] = {"206","登录失败多次，账户已锁定!"};							//登录失败多次，账户锁定10分钟!
	public static final String WEB_OTHER_ERROR[] = {"207","其他错误!"};	//其他错误
	
	/**
	 * 缓存名称前缀
	 */
	public static final String CACHA_SHIRO_ERRORPASSWORD_NUM = "errorPasswordNum_";	
	public static final String CACHA_SHIRO_USER_PERMISSIONS = "userPermissions_";	
	
	/**
	 * 菜单类型
	 */
	public static final String SYS_FUN_STATE_MENU[] = {"0","菜单"};				
	public static final String SYS_FUN_STATE_BUTTON[] = {"1","按钮"};			
	
}
