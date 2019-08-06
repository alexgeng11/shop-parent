package com.kaysen.shop.web.api.login.controller;

import com.kaysen.shop.utils.env.AppConfig;
import com.kaysen.shop.utils.env.Constants;
import com.kaysen.shop.web.base.BaseController;
import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.env.SysConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019/7/17 10:13
 * @Created by ks.xu
 */
@Controller("apiLoginController")
@RequestMapping("/api")
public class LoginController extends BaseController {

    @RequestMapping("/test")
    @ResponseBody
    public String doLogin(HttpSession session) throws Exception {
        return "SessionId:"+ session.getId();

    }
    @RequestMapping("/noAuth")
    @ResponseBody
    public Object noAuth(HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isAccess", false);
        map.put("errMsg", "没有权限");
        return map;

    }
    /**
     * 登录操作
     *
     * @param sysUser
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object doLogin(SysUser sysUser, String code) throws Exception {
        HttpServletRequest request = this.getRequest();
        Map<String, Object> map = new HashMap<String, Object>();
        String USERNAME = sysUser.getUserName();
        String errInfo = "";
        String errMsg = "";
        //判断是否有用户名、密码参数，没有就直接返回
        if (sysUser != null && StringUtils.isNotBlank(sysUser.getUserName()) && StringUtils.isNotBlank(sysUser.getPassword())) {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            UsernamePasswordToken token = new UsernamePasswordToken(USERNAME, sysUser.getPassword());
            map.put("isAccess", false);
            try {
                subject.login(token);
                map.put("isAccess", true);
                map.put("token", session.getId());
                errMsg = "登录成功";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                errInfo = SysConstants.WEB_USER_ERROR[0];
                errMsg = SysConstants.WEB_USER_ERROR[1];
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                errInfo = SysConstants.WEB_USER_ERROR[0];
                errMsg = SysConstants.WEB_USER_ERROR[1];
            } catch (ExcessiveAttemptsException e) {
                e.printStackTrace();
                errInfo = SysConstants.WEB_EXCESSIVE_ATTEMPTS_ERROR[0];
                errMsg = SysConstants.WEB_EXCESSIVE_ATTEMPTS_ERROR[1];
            } catch (AuthenticationException e) {
                e.printStackTrace();
                errInfo = SysConstants.WEB_USER_ERROR[0];
                errMsg = SysConstants.WEB_USER_ERROR[1];
            }catch (Exception e){
                e.printStackTrace();
                errInfo = SysConstants.WEB_USER_ERROR[0];
                errMsg = SysConstants.WEB_USER_ERROR[1];
            }
            //验证是否登录成功
            if (subject.isAuthenticated()) {

            } else {

                token.clear();
                session.removeAttribute(Constants.ADMIN_USER);
            }
        } else {
            errInfo = SysConstants.WEB_PARAM_LACK_ERROR[0];            //缺少参数
            errMsg = SysConstants.WEB_PARAM_LACK_ERROR[1];
        }
        if (StringUtils.isEmpty(errInfo)) {
            errInfo = SysConstants.WEB_SUCCESS[0];                    //验证成功

        }
        map.put("result", errInfo);
        map.put("errMsg", errMsg);
        return map;
    }

    /**
     * 用户注销
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        ModelAndView mv = this.getModelAndView();
        try {
            //shiro销毁登录
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> pd = new HashMap<String, Object>();
        pd.put("SYSNAME", AppConfig.SYSNAME); //读取系统名称
        mv.setViewName("/login/login");
        mv.addObject("pd", pd);
        return mv;
    }
}
