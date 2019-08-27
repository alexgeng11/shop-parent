package com.kaysen.shop.config;

import com.kaysen.shop.filter.ApiAuthorizationFilter;
import com.kaysen.shop.realm.AccessTokenSessionManager;
import com.kaysen.shop.realm.RetryLimitHashedCredentialsMatcher;
import com.kaysen.shop.realm.ShiroLoginRealm;
import com.kaysen.shop.redis.cache.impl.ShiroCacheImpl;
import com.kaysen.shop.redis.cache.impl.ShiroCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Classname ShiroConfiguration
 * @Description shiro相关配置
 * @Date 2019/7/29 13:42
 * @Created by ks.xu
 */
@Configuration
public class ShiroConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ShiroConfig.class);

    // 下面两个方法对 注解权限起作用有很大的关系，请把这两个方法，放在配置的最上面
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    /**
     * shiro过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        LOG.info("初始化shiro过滤器。。。。。。。。。。。。。");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
//        filterChainDefinitionMap.put("/api/**", "apiFilter");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     * @return
     */
    @Bean
    public RetryLimitHashedCredentialsMatcher hashedCredentialsMatcher(){
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(shiroCacheManager());
        return credentialsMatcher;
    }

    /**
     * 登录realms
     * @return
     */
    @Bean
    public ShiroLoginRealm shiroLoginRealm(){
        LOG.info("初始化自定义ShiroRealm。。。。。。。。。。。。。");
        ShiroLoginRealm myShiroRealm = new ShiroLoginRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroLoginRealm());
        return securityManager;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 自定义session管理器
     * @return
     */
    @Bean
    public AccessTokenSessionManager accessTokenSessionManager(){
        LOG.info("初始化自定义session管理器。。。。。。。。。。。。。");
        AccessTokenSessionManager accessTokenSessionManager = new AccessTokenSessionManager();
        return accessTokenSessionManager;
    }
    /**
     * shiro接口过滤器
     * @return
     */
//    @Bean
    ApiAuthorizationFilter apiAuthorizationFilter(){
        LOG.info("初始化shiro接口过滤器。。。。。。。。。。。。。");
        ApiAuthorizationFilter apiAuthorizationFilter = new ApiAuthorizationFilter();
        return apiAuthorizationFilter;
    }

    /**
     * shiro缓存工厂类
     * @return
     */
    @Bean
    public ShiroCacheManager shiroCacheManager(){
        LOG.info("初始化shiro缓存工厂类。。。。。。。。。。。。。");
        ShiroCacheManager shiroCacheManager = new ShiroCacheManager();
        return shiroCacheManager;
    }

    /**
     * shiro缓存管理实现类
     * @return
     */
    @Bean(name="shiroCacheImpl")
    public ShiroCacheImpl shiroCacheImpl(){
        LOG.info("初始化shiro缓存管理实现类。。。。。。。。。。。。。");
        ShiroCacheImpl shiroCache = new ShiroCacheImpl();
        return shiroCache;
    }


}

