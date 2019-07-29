package com.kaysen.shop.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019/7/17 10:13
 * @Created by ks.xu
 */
@Controller
public class LoginController{

    @RequestMapping("/login")
    public ModelAndView toLogin()throws Exception{
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }
    @RequestMapping("/")
    public ModelAndView toLogin2()throws Exception{
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }
}
