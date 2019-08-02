package com.kaysen.shop.config;

import com.kaysen.shop.realm.RetryLimitHashedCredentialsMatcher;
import com.kaysen.shop.realm.ShiroLoginRealm;
import com.kaysen.shop.redis.cache.impl.ShiroCacheImpl;
import com.kaysen.shop.redis.cache.impl.ShiroCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ShiroConfiguration
 * @Description TODO
 * @Date 2019/7/29 13:42
 * @Created by ks.xu
 */
@Configuration
public class ShiroConfiguration {
    @Primary
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/code", "anon");
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/api/**", "anon");

        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/user/**", "authc");
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    /**
     * 权限管理器
     * @return
     */
    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        List<Realm> realms=new ArrayList<>();
        realms.add(getShiroLoginRealm());
        defaultSecurityManager.setRealms(realms);
        return defaultSecurityManager;
    }

    /**
     * shiro缓存工厂类
     * @return
     */
    @Bean(name="securityManager")
    public ShiroCacheManager getShiroCacheManager(){
        return new ShiroCacheManager();
    }

    /**
     * shiro缓存管理实现类
     * @return
     */
    @Bean(name="shiroCacheImpl")
    public ShiroCacheImpl getShiroCacheImpl(){
        return new ShiroCacheImpl();
    }

    /**
     * 凭证匹配器
     * @return
     */
    @Bean(name="credentialsMatcher")
    public RetryLimitHashedCredentialsMatcher getRetryLimitHashedCredentialsMatcher(){
        return new RetryLimitHashedCredentialsMatcher(getShiroCacheManager());
    }

    /**
     * 系统用户登录
     * @return
     */
    @Bean(name="shiroLoginRealm")
    public ShiroLoginRealm getShiroLoginRealm() {
        ShiroLoginRealm customRealm = new ShiroLoginRealm();
        customRealm.setCredentialsMatcher(getRetryLimitHashedCredentialsMatcher());
        return customRealm;
    }

}
