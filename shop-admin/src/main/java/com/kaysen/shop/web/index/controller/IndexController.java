package com.kaysen.shop.web.index.controller;

import com.kaysen.shop.utils.SystemUtils;
import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.service.SysUserService;
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
    @RequestMapping("/system/main")
    private String index(){
        List<SysUser> users=sysUserService.listAllUser();
        for (SysUser sysUser: users) {
            System.out.println(sysUser.getRealName());
        }
        return "/common/index";
    }

    @RequestMapping("/system/index")
    private String systemIndex(){
        return "/index/index_v1";
    }
}

