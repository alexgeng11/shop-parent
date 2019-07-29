package com.kaysen.shop.bean;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2019/7/19 11:50
 * @Created by ks.xu
 */
public class BaseEntity {
    private java.util.Date addTime;//   添加时间
    private Integer addUserId;//   添加用户ID
    private String addUserName;//   添加用户名称
    private String terminalType;//   用户操作终端类型
    public java.util.Date getAddTime() {
        return this.addTime;
    }
    public void setAddTime(java.util.Date addTime) {
        this.addTime=addTime;
    }
    public Integer getAddUserId() {
        return this.addUserId;
    }
    public void setAddUserId(Integer addUserId) {
        this.addUserId=addUserId;
    }
    public String getAddUserName() {
        return this.addUserName;
    }
    public void setAddUserName(String addUserName) {
        this.addUserName=addUserName;
    }
    public String getTerminalType() {
        return this.terminalType;
    }
    public void setTerminalType(String terminalType) {
        this.terminalType=terminalType;
    }
}
