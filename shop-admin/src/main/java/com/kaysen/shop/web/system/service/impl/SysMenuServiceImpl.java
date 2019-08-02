package com.kaysen.shop.web.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.system.dao.SysMenuMapper;
import com.kaysen.shop.web.system.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

}
