package com.kaysen.shop.web.index.controller;

import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.elasticsearch.client.RestClient;
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

    @Autowired
    private RestClient client;
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
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
    @RequiresPermissions("index111")
    @RequestMapping("/system/index")
    public String systemIndex(){
        return "/index/index_v1";
    }


}

