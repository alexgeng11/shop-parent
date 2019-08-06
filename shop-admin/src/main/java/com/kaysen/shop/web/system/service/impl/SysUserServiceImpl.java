package com.kaysen.shop.web.system.service.impl;

import com.kaysen.shop.web.system.service.SysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.system.dao.SysUserMapper;
import com.kaysen.shop.web.system.bean.SysUser;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public List<SysUser> listAllUser() {
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser findByUserName(String userName) {
        SysUser sysUser=new SysUser();
        sysUser.setUserName(userName);
        return sysUserMapper.selectOne(sysUser);

    }
}


