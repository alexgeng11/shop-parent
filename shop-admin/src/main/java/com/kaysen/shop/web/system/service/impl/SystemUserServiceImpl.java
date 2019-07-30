package com.kaysen.shop.web.system.service.impl;

import com.kaysen.shop.bean.SysUser;
import com.kaysen.shop.web.system.service.SystemUserService;
import org.springframework.stereotype.Service;

/**
 * @Classname SystemUserService
 * @Description TODO
 * @Date 2019/7/19 11:09
 * @Created by ks.xu
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {
    @Override
    public SysUser findByUserName(String userName) {
        return null;
    }
}
