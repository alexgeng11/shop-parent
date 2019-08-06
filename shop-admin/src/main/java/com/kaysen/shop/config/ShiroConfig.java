package com.kaysen.shop.config;

import com.kaysen.shop.filter.ApiAuthorizationFilter;
import com.kaysen.shop.realm.RetryLimitHashedCredentialsMatcher;
import com.kaysen.shop.realm.ShiroLoginRealm;
import com.kaysen.shop.redis.cache.impl.ShiroCacheImpl;
import com.kaysen.shop.redis.cache.impl.ShiroCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname ShiroConfiguration
 * @Description TODO
 * @Date 2019/7/29 13:42
 * @Created by ks.xu
 */
@Configuration
public class ShiroConfig {
    /**
     * 系统用户登录
     * @return
     */
    @Bean
    public ShiroLoginRealm shiroLoginRealm() {
        System.out.println("初始化自定义ShiroRealm。。。。。。。。。。。。。");
        ShiroLoginRealm customRealm = new ShiroLoginRealm();
        customRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher());
        System.out.println("初始化自定义ShiroRealm完成。。。。。。。。。。。。。");
        return customRealm;
    }

    /**
     * 自定义session管理器
     * @return
     */
    @Bean
    public AccessTokenSessionManager accessTokenSessionManager(){
        System.out.println("初始化自定义session管理器。。。。。。。。。。。。。");
        AccessTokenSessionManager accessTokenSessionManager = new AccessTokenSessionManager();
        System.out.println("初始化自定义session管理器完成。。。。。。。。。。。。。");
        return accessTokenSessionManager;
    }
    /**
     * 权限管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager  securityManager() {
        System.out.println("初始化安全管理器。。。。。。。。。。。。。");
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        System.out.println("设置安全管理器的Realms。。。。。。。。。。。。。");
        defaultSecurityManager.setRealm(shiroLoginRealm());
        System.out.println("设置安全管理器的Session管理器。。。。。。。。。。。。。");
        defaultSecurityManager.setSessionManager(accessTokenSessionManager());
        System.out.println("初始化安全管理器完成。。。。。。。。。。。。。");
        return defaultSecurityManager;
    }

    /**
     * shiro过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        System.out.println("初始化shiro过滤器。。。。。。。。。。。。。");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("apiFilter",apiAuthorizationFilter());
        System.out.println("设置shiro过滤器的安全管理器。。。。。。。。。。。。。");
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/code", "anon");
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/user/**", "authc");
        filterChainDefinitionMap.put("/api/**", "apiFilter");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("初始化shiro过滤器完成。。。。。。。。。。。。。");
        return shiroFilterFactoryBean;

    }

    /**
     * shiro接口过滤器
     * @return
     */
    @Bean
    ApiAuthorizationFilter apiAuthorizationFilter(){
        System.out.println("初始化shiro接口过滤器。。。。。。。。。。。。。");
        ApiAuthorizationFilter apiAuthorizationFilter = new ApiAuthorizationFilter();
        System.out.println("初始化shiro接口过滤器的安全管理器。。。。。。。。。。。。。");
        apiAuthorizationFilter.setSecurityManager(securityManager());
        System.out.println("初始化shiro接口过滤器完成。。。。。。。。。。。。。");
        return apiAuthorizationFilter;
    }

    /**
     * 注册shiro接口过滤器
     * @return
     */
//    @Bean
//    public FilterRegistrationBean ParamsFilter2() {
//        System.out.println("注册shiro接口过滤器。。。。。。。。。。。。。");
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(apiAuthorizationFilter());
//        registration.addUrlPatterns("/api/*");
//        registration.setName("apiAuthorizationFilter");
//        registration.setOrder(1);
//        System.out.println("注册shiro接口过滤器完成。。。。。。。。。。。。。");
//        return registration;
//    }

    /**
     * shiro缓存工厂类
     * @return
     */
    @Bean
    public ShiroCacheManager shiroCacheManager(){
        System.out.println("初始化shiro缓存工厂类。。。。。。。。。。。。。");
        ShiroCacheManager shiroCacheManager = new ShiroCacheManager();
        System.out.println("初始化shiro缓存工厂类完成。。。。。。。。。。。。。");
        return shiroCacheManager;
    }

    /**
     * shiro缓存管理实现类
     * @return
     */
    @Bean(name="shiroCacheImpl")
    public ShiroCacheImpl shiroCacheImpl(){
        System.out.println("初始化shiro缓存管理实现类。。。。。。。。。。。。。");
        ShiroCacheImpl shiroCache = new ShiroCacheImpl();
        System.out.println("初始化shiro缓存管理实现类完成。。。。。。。。。。。。。");
        return shiroCache;
    }

    /**
     * 凭证匹配器
     * @return
     */
    @Bean(name="credentialsMatcher")
    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(){
        System.out.println("初始化凭证匹配器。。。。。。。。。。。。。");
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(shiroCacheManager());
        System.out.println("初始化凭证匹配器完成。。。。。。。。。。。。。");
        return retryLimitHashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);

        return defaultAdvisorAutoProxyCreator;
    }

}
