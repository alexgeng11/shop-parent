package com.kaysen.shop.config;

import com.kaysen.shop.filter.ApiAuthorizationFilter;
import com.kaysen.shop.realm.AccessTokenSessionManager;
import com.kaysen.shop.realm.RetryLimitHashedCredentialsMatcher;
import com.kaysen.shop.realm.ShiroLoginRealm;
import com.kaysen.shop.redis.cache.impl.ShiroCacheImpl;
import com.kaysen.shop.redis.cache.impl.ShiroCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname ShiroConfiguration
 * @Description shiro相关配置
 * @Date 2019/7/29 13:42
 * @Created by ks.xu
 */
@Configuration
public class ShiroConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ShiroConfig.class);
    /**
     * 系统用户登录
     * @return
     */
    @Bean
    public ShiroLoginRealm shiroLoginRealm() {

        LOG.info("初始化自定义ShiroRealm。。。。。。。。。。。。。");
        ShiroLoginRealm customRealm = new ShiroLoginRealm();
        customRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher());
        return customRealm;
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
     * 权限管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager  securityManager() {
        LOG.info("初始化安全管理器。。。。。。。。。。。。。");
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(shiroLoginRealm());
        defaultSecurityManager.setSessionManager(accessTokenSessionManager());
        return defaultSecurityManager;
    }

    /**
     * shiro过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        LOG.info("初始化shiro过滤器。。。。。。。。。。。。。");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("apiFilter",apiAuthorizationFilter());
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
        return shiroFilterFactoryBean;

    }

    /**
     * shiro接口过滤器
     * @return
     */
    @Bean
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

    /**
     * 凭证匹配器
     * @return
     */
    @Bean(name="credentialsMatcher")
    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(){
        LOG.info("初始化凭证匹配器。。。。。。。。。。。。。");
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(shiroCacheManager());
        return retryLimitHashedCredentialsMatcher;
    }


}
