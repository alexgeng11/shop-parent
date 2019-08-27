package com.kaysen.shop.web.system.service;

import com.kaysen.shop.web.system.bean.SysMenuVo;
import com.kaysen.shop.web.system.bean.SysUser;

import java.util.List;

public interface SysUserService{


    List<SysUser> listAllUser();

    SysUser findByUserName(String userName);

    List<SysMenuVo> searchSysFun(SysUser sysUser);

    void addUser(SysUser sysUser);
}
