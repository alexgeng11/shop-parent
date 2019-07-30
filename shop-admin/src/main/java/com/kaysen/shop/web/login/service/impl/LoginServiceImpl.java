package com.kaysen.shop.web.login.service.impl;

import com.kaysen.shop.bean.SysUser;
import com.kaysen.shop.dao.DaoSupport;
import com.kaysen.shop.web.login.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname LoginServiceImpl
 * @Description TODO
 * @Date 2019/7/29 11:16
 * @Created by ks.xu
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    @Override
    public SysUser findByUserName(String userName) throws Exception {
        return (SysUser)dao.findForObject("ContractExpertsMapper.findByUserName",userName);
    }
}
