package com.kaysen.shop.web.index.controller;

import com.kaysen.shop.utils.SystemUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title: IndexController
 * @description: TODO
 * @author: ks.xu
 * @date: 2019/5/9 15:49
 */
@Controller
public class IndexController {
    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/system/mian")
    private String index(){
        System.out.println(SystemUtils.getOSType());
        System.out.println(SystemUtils.isLinux());
        System.out.println(SystemUtils.isWindows());
        return "/common/index";
    }

    @RequestMapping("/system/index")
    private String systemIndex(){
        return "/index/index_v1";
    }
}

