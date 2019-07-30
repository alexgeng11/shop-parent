package com.kaysen.shop.web.system.service.impl;

import com.kaysen.shop.bean.SysRoleMenu;
import com.kaysen.shop.web.system.service.SystemRoleMenuService;
import com.kaysen.shop.web.system.service.SystemRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SystemRoleService
 * @Description TODO
 * @Date 2019/7/19 11:08
 * @Created by ks.xu
 */
@Service("systemRoleMenuService")
public class SystemRoleMenuServiceImpl implements SystemRoleMenuService {
    @Override
    public List<SysRoleMenu> findMenusByRoleId(Integer id) {
        return null;
    }
}
