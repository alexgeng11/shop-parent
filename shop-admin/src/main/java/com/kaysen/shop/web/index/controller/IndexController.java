package com.kaysen.shop.web.index.controller;

import com.kaysen.shop.utils.env.Constants;
import com.kaysen.shop.web.system.bean.SysMenu;
import com.kaysen.shop.web.system.bean.SysMenuVo;
import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @title: IndexController
 * @description: TODO
 * @author: ks.xu
 * @date: 2019/5/9 15:49
 */
@Controller
public class IndexController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 后台首页
     * @return
     */
//    @RequiresPermissions("index")
    @RequestMapping("/system/main")
    public String index(){
        SysUser sysUser=new SysUser();
        sysUser.setUserName("张三");
        sysUserService.addUser(sysUser);
//        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.ADMIN_USER);
//        List<SysMenuVo> sysMenus=sysUserService.searchSysFun(sysUser);
//        List<SysUser> users=sysUserService.listAllUser();
//        System.out.println(users.size());
        return "/common/index";
    }
//    @RequiresPermissions("index111")
    @RequestMapping("/system/index")
    public String systemIndex(){
        return "/index/index_v1";
    }


}

