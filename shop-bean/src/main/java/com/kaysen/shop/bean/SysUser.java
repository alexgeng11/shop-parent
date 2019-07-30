package com.kaysen.shop.bean;

/**
 * @Classname SysUser
 * @Description TODO
 * @Date 2019/7/29 11:28
 * @Created by ks.xu
 */
public class SysUser {
    private Boolean enabled;//是否被禁用
    private String userName;//用户名
    private String password;//密码
    private String realName;//真是姓名

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {

        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
