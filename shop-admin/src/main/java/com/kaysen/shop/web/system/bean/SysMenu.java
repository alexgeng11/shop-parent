package com.kaysen.shop.web.system.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 删除标识
     */
    @Column(name = "IS_DELE")
    private String isDele;

    /**
     * 启用标识
     */
    @Column(name = "ENABLED")
    private String enabled;

    /**
     * 菜单名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 父级ID
     */
    @Column(name = "PARENT_ID")
    private Integer parentId;

    /**
     * 父级名称
     */
    @Column(name = "PARENT_NAME")
    private String parentName;

    /**
     * 访问路径
     */
    @Column(name = "URL")
    private String url;

    /**
     * 权限字符串
     */
    @Column(name = "PERMISSION")
    private String permission;

    /**
     * 菜单/按钮
     */
    @Column(name = "`STATE`")
    private String state;

    /**
     * 图标样式
     */
    @Column(name = "ICON_CLASS")
    private String iconClass;

    /**
     * 菜单级别
     */
    @Column(name = "`LEVEL`")
    private Integer level;

    /**
     * 是否叶节点
     */
    @Column(name = "IS_LEAF")
    private String isLeaf;

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

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
    public String getEnabled() {
        return enabled;
    }

    /**
     * 设置启用标识
     *
     * @param enabled 启用标识
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取菜单名称
     *
     * @return NAME - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父级ID
     *
     * @return PARENT_ID - 父级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级ID
     *
     * @param parentId 父级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父级名称
     *
     * @return PARENT_NAME - 父级名称
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置父级名称
     *
     * @param parentName 父级名称
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获取访问路径
     *
     * @return URL - 访问路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问路径
     *
     * @param url 访问路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限字符串
     *
     * @return PERMISSION - 权限字符串
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限字符串
     *
     * @param permission 权限字符串
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取菜单/按钮
     *
     * @return STATE - 菜单/按钮
     */
    public String getState() {
        return state;
    }

    /**
     * 设置菜单/按钮
     *
     * @param state 菜单/按钮
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取图标样式
     *
     * @return ICON_CLASS - 图标样式
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * 设置图标样式
     *
     * @param iconClass 图标样式
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    /**
     * 获取菜单级别
     *
     * @return LEVEL - 菜单级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置菜单级别
     *
     * @param level 菜单级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取是否叶节点
     *
     * @return IS_LEAF - 是否叶节点
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否叶节点
     *
     * @param isLeaf 是否叶节点
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
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


}