package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "house_subscribe")
public class HouseSubscribe implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 房源id
     */
    @Column(name = "house_id")
    private Integer houseId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户描述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 数据创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 记录更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 预约时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 联系电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 房源发布者id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
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
     * 获取房源id
     *
     * @return house_id - 房源id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置房源id
     *
     * @param houseId 房源id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户描述
     *
     * @return desc - 用户描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置用户描述
     *
     * @param desc 用户描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     *
     * @return status - 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     *
     * @param status 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取数据创建时间
     *
     * @return create_time - 数据创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置数据创建时间
     *
     * @param createTime 数据创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取记录更新时间
     *
     * @return last_update_time - 记录更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置记录更新时间
     *
     * @param lastUpdateTime 记录更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取预约时间
     *
     * @return order_time - 预约时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置预约时间
     *
     * @param orderTime 预约时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取联系电话
     *
     * @return telephone - 联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置联系电话
     *
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取房源发布者id
     *
     * @return admin_id - 房源发布者id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置房源发布者id
     *
     * @param adminId 房源发布者id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}