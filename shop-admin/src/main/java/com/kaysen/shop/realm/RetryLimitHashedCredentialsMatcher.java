package com.kaysen.shop.realm;

import com.kaysen.shop.utils.env.AppConfig;
import com.kaysen.shop.web.system.env.SysConstants;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描叙：登录回调-判断密码错误次数
 * 如果错误多次，则锁定账号10分钟
 * 创建人：HeGuifang
 * 创建时间：2016年6月3日 上午9:56:54
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, String> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("shiroCacheImpl");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = SysConstants.CACHA_SHIRO_ERRORPASSWORD_NUM+(String) token.getPrincipal();
        // 从缓存中取数据
        String retryCountStr = passwordRetryCache.get(username);
        AtomicInteger retryCount = null;
        if (retryCountStr == null) {
            retryCount = new AtomicInteger(1);
        }else{
            retryCount = new AtomicInteger(Integer.parseInt(retryCountStr));
        	retryCount.incrementAndGet();
        }
        if (retryCount.intValue() > AppConfig.ERROR_PASSWORD_NUM) {   // 错误次数大于5次，就抛异常
            throw new ExcessiveAttemptsException();
        }
        byte[] tokenBytes =toBytes(token.getCredentials());
        byte[] accountBytes =toBytes(info.getCredentials());
        boolean matches = Arrays.equals(tokenBytes,accountBytes);
        if (matches) { // 密码正确了后自动移除缓存
            passwordRetryCache.remove(username);
        }else{
        	// 替换缓存中的数据
            passwordRetryCache.put(username, retryCount.toString());
        }
        return matches;
    }
}