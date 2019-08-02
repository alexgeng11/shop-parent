package com.kaysen.shop.web.login.service;

import com.kaysen.shop.web.system.bean.SysUser;

/**
 * @Classname LoginService
 * @Description TODO
 * @Date 2019/7/29 11:16
 * @Created by ks.xu
 */
public interface LoginService {
    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName) throws Exception;
}
