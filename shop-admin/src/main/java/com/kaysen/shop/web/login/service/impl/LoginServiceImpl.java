package com.kaysen.shop.web.login.service.impl;

import com.kaysen.shop.web.login.service.LoginService;
import com.kaysen.shop.web.system.bean.SysUser;
import org.springframework.stereotype.Service;

/**
 * @Classname LoginServiceImpl
 * @Description TODO
 * @Date 2019/7/29 11:16
 * @Created by ks.xu
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    @Override
    public SysUser findByUserName(String userName) throws Exception {
        return null;
    }
}
