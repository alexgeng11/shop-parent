package com.kaysen.shop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Classname ParamsFilter
 * @Description TODO
 * @Date 2019/7/29 16:51
 * @Created by ks.xu
 */
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class ParamsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("参数拦截器");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
