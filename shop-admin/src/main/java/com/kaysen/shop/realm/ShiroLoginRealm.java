package com.kaysen.shop.realm;


import com.kaysen.shop.utils.env.Constants;
import com.kaysen.shop.utils.log.Logs;
import com.kaysen.shop.web.system.bean.SysUser;
import com.kaysen.shop.web.system.service.SysRoleService;
import com.kaysen.shop.web.system.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


/**
 * 描叙：登录回调，权限判断
 * 创建人：ZangTianQi
 * 创建时间：2017年11月7日 下午14:11:17
 */
public class ShiroLoginRealm extends AuthorizingRealm {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;

    /**
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = (String) token.getUsername();                //得到用户名
        SysUser sysUser;
        try {
            sysUser = sysUserService.findByUserName(userName);
            if (sysUser != null) {
                setSession(Constants.ADMIN_USER, sysUser);
                setSession(Constants.ADMIN_USER_TYPE, Constants.ADMIN_USER_TYPE_SYS);
                // 判断帐号是否锁定
                if (Boolean.FALSE.equals(sysUser.getEnabled())) {
                    // 抛出 帐号锁定异常
                    throw new LockedAccountException();
                }
                // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配 (token中的凭证与数据库中的比较)
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser.getUserName(), sysUser.getPassword(), sysUser.getRealName());
                return authenticationInfo;
            } else {
                throw new UnknownAccountException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logs.error(e.getMessage());
        }
        return null;
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            Set<String> permissions = new HashSet<String>();
            permissions.add("index");
            SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.ADMIN_USER);
//            if (user != null) {
//                String roleIds = "";
//                if (!StringUtils.isEmpty(roleIds)) {
//                    SysRole role = null;
//                    String[] roleIdArray = roleIds.split(",");
//                    for (String roleId : roleIdArray) {
//                        role = this.systemRoleService.findById(Integer.valueOf(roleId));
//                        List<SysRoleMenu> roleMenus = systemRoleMenuService.findMenusByRoleId(role.getId());
//                        for (SysRoleMenu roleMenu : roleMenus) {
//                            if (!StringUtils.isEmpty(roleMenu.getPermission())) {
//                                permissions.add(roleMenu.getPermission());
//                            }
//                        }
//                    }
//                } else {
//                    throw new AuthorizationException();
//                }
//            } else {
//                throw new AuthorizationException();
//            }
            //给当前用户设置权限
            info.addStringPermissions(permissions);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return info;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            Logs.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }


}
