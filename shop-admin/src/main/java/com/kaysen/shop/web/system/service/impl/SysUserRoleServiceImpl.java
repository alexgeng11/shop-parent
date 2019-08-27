package com.kaysen.shop.web.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.system.dao.SysUserRoleMapper;
import com.kaysen.shop.web.system.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}
