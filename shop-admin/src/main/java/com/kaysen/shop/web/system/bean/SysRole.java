package com.kaysen.shop.web.system.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

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
     * 名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

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
     * 全拼
     */
    @Column(name = "FULL_SPELL")
    private String fullSpell;

    /**
     * 排序
     */
    @Column(name = "LIST_SORT")
    private Integer listSort;

    /**
     * 首字母
     */
    @Column(name = "ABBREVATION")
    private String abbrevation;

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
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取全拼
     *
     * @return FULL_SPELL - 全拼
     */
    public String getFullSpell() {
        return fullSpell;
    }

    /**
     * 设置全拼
     *
     * @param fullSpell 全拼
     */
    public void setFullSpell(String fullSpell) {
        this.fullSpell = fullSpell;
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
     * 获取首字母
     *
     * @return ABBREVATION - 首字母
     */
    public String getAbbrevation() {
        return abbrevation;
    }

    /**
     * 设置首字母
     *
     * @param abbrevation 首字母
     */
    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }
}