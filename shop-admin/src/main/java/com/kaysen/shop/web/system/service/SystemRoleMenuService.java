package com.kaysen.shop.web.system.service;

import com.kaysen.shop.web.system.bean.SysRoleMenu;

import java.util.List;

/**
 * @Classname SystemRoleService
 * @Description TODO
 * @Date 2019/7/19 11:08
 * @Created by ks.xu
 */
public interface SystemRoleMenuService {
    List<SysRoleMenu> findMenusByRoleId(Integer id);
}
