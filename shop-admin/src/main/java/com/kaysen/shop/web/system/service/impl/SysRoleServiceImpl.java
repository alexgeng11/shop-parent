package com.kaysen.shop.web.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.system.dao.SysRoleMapper;
import com.kaysen.shop.web.system.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}

