package com.kaysen.shop.web.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.system.dao.SysRoleMenuMapper;
import com.kaysen.shop.web.system.service.SysRoleMenuService;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

}
