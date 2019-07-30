package com.kaysen.shop.web.system.service;

import com.kaysen.shop.bean.SysUser;

/**
 * @Classname SystemUserService
 * @Description TODO
 * @Date 2019/7/19 11:09
 * @Created by ks.xu
 */
public interface SystemUserService {
    SysUser findByUserName(String userName);
}
