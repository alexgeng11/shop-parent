package com.kaysen.shop.web.system.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 头像
     */
    @Column(name = "HEAD_PORTRAIT")
    private String headPortrait;

    /**
     * 删除标识
     */
    @Column(name = "IS_DELE")
    private String isDele;

    /**
     * 启用标识
     */
    @Column(name = "ENABLED")
    private Boolean enabled;

    /**
     * 用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 真实名称
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * 密码
     */
    @Column(name = "`PASSWORD`")
    private String password;

    /**
     * 添加时间
     */
    @Column(name = "ADD_TIME")
    private Date addTime;

    /**
     * 添加用户ID
     */
    @Column(name = "ADD_USER_ID")
    private Integer addUserId;

    /**
     * 添加用户名称
     */
    @Column(name = "ADD_USER_NAME")
    private String addUserName;

    /**
     * 用户操作终端类型
     */
    @Column(name = "TERMINAL_TYPE")
    private String terminalType;

    /**
     * 排序
     */
    @Column(name = "LIST_SORT")
    private Integer listSort;

    /**
     * 人员类型
     */
    @Column(name = "USER_TYPE")
    private Integer userType;

    /**
     * 签字附件id
     */
    @Column(name = "CATALOG_ID")
    private String catalogId;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取头像
     *
     * @return HEAD_PORTRAIT - 头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 设置头像
     *
     * @param headPortrait 头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    /**
     * 获取删除标识
     *
     * @return IS_DELE - 删除标识
     */
    public String getIsDele() {
        return isDele;
    }

    /**
     * 设置删除标识
     *
     * @param isDele 删除标识
     */
    public void setIsDele(String isDele) {
        this.isDele = isDele;
    }

    /**
     * 获取启用标识
     *
     * @return ENABLED - 启用标识
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置启用标识
     *
     * @param enabled 启用标识
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取用户名
     *
     * @return USER_NAME - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取真实名称
     *
     * @return REAL_NAME - 真实名称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实名称
     *
     * @param realName 真实名称
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取添加时间
     *
     * @return ADD_TIME - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取添加用户ID
     *
     * @return ADD_USER_ID - 添加用户ID
     */
    public Integer getAddUserId() {
        return addUserId;
    }

    /**
     * 设置添加用户ID
     *
     * @param addUserId 添加用户ID
     */
    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }

    /**
     * 获取添加用户名称
     *
     * @return ADD_USER_NAME - 添加用户名称
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 设置添加用户名称
     *
     * @param addUserName 添加用户名称
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
     * 获取用户操作终端类型
     *
     * @return TERMINAL_TYPE - 用户操作终端类型
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置用户操作终端类型
     *
     * @param terminalType 用户操作终端类型
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    /**
     * 获取排序
     *
     * @return LIST_SORT - 排序
     */
    public Integer getListSort() {
        return listSort;
    }

    /**
     * 设置排序
     *
     * @param listSort 排序
     */
    public void setListSort(Integer listSort) {
        this.listSort = listSort;
    }

    /**
     * 获取人员类型
     *
     * @return USER_TYPE - 人员类型
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置人员类型
     *
     * @param userType 人员类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取签字附件id
     *
     * @return CATALOG_ID - 签字附件id
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * 设置签字附件id
     *
     * @param catalogId 签字附件id
     */
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}