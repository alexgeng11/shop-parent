package com.kaysen.shop.web.index.controller;

import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @RequiresPermissions("index")
    @RequestMapping("/system/main")
    public String index(){
//        SecurityUtils.getSubject().checkPermission("index111");
        List<SysUser> users=sysUserService.listAllUser();
        System.out.println(users.size());
        return "/common/index";
    }
    @RequiresPermissions("index")
    @RequestMapping("/system/index")
    public String systemIndex(){
        return "/index/index_v1";
    }
}

