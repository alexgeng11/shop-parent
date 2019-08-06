package com.kaysen.shop.filter;

import com.kaysen.shop.config.ShiroConfig;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogManager;

/**
 * @Classname ParamsFilter
 * @Description TODO
 * @Date 2019/7/29 16:51
 * @Created by ks.xu
 */
public class ParamsFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(ParamsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.debug("参数拦截器...................");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
