package com.kaysen.shop.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname AppErrorController
 * @Description WEb全局异常处理控制器
 * @Date 2019/8/21 13:36
 * @Created by ks.xu
 */
//@Controller
public class AppErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    /**
     * web错误处理
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "/error/403";
            case 404:
                return "/error/404";
            case 500:
                return "/error/500";
        }
        return "index";
    }

//    @RequestMapping(value = ERROR_PATH)
//    public String errorApiHandler(HttpServletRequest request) {
//        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
//        this.errorAttributes.getErrorAttributes((WebRequest) requestAttributes,false);
//        int status = getStatus(request);
//        return status+"";
//    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }
        return 500;
    }
}
