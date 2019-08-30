package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "house")
public class House implements Serializable {
    /**
     * house唯一标识
     */
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    /**
     * 价格
     */
    @Column(name = "price")
    private Integer price;

    /**
     * 面积
     */
    @Column(name = "area")
    private Integer area;

    /**
     * 卧室数量
     */
    @Column(name = "room")
    private Integer room;

    /**
     * 楼层
     */
    @Column(name = "`floor`")
    private Integer floor;

    /**
     * 总楼层
     */
    @Column(name = "total_floor")
    private Integer totalFloor;

    /**
     * 被看次数
     */
    @Column(name = "watch_times")
    private Integer watchTimes;

    /**
     * 建立年限
     */
    @Column(name = "build_year")
    private Integer buildYear;

    /**
     * 房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 城市标记缩写 如 北京bj
     */
    @Column(name = "city_en_name")
    private String cityEnName;

    /**
     * 区域标记缩写 如 朝阳区cyq
     */
    @Column(name = "region_en_name")
    private String regionEnName;

    /**
     * 封面
     */
    @Column(name = "cover")
    private String cover;

    /**
     * 朝向
     */
    @Column(name = "direction")
    private Integer direction;

    /**
     * 距地铁距离 默认-1 附近无地铁
     */
    @Column(name = "distance_to_subway")
    private Integer distanceToSubway;

    /**
     * 客厅数量
     */
    @Column(name = "parlour")
    private Integer parlour;

    /**
     * 所在小区
     */
    @Column(name = "district")
    private String district;

    /**
     * 所属管理员id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 卫生间数量
     */
    @Column(name = "bathroom")
    private Integer bathroom;

    /**
     * 街道
     */
    @Column(name = "street")
    private String street;

    private static final long serialVersionUID = 1L;

    /**
     * 获取house唯一标识
     *
     * @return id - house唯一标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置house唯一标识
     *
     * @param id house唯一标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取面积
     *
     * @return area - 面积
     */
    public Integer getArea() {
        return area;
    }

    /**
     * 设置面积
     *
     * @param area 面积
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 获取卧室数量
     *
     * @return room - 卧室数量
     */
    public Integer getRoom() {
        return room;
    }

    /**
     * 设置卧室数量
     *
     * @param room 卧室数量
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     * 获取楼层
     *
     * @return floor - 楼层
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 设置楼层
     *
     * @param floor 楼层
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * 获取总楼层
     *
     * @return total_floor - 总楼层
     */
    public Integer getTotalFloor() {
        return totalFloor;
    }

    /**
     * 设置总楼层
     *
     * @param totalFloor 总楼层
     */
    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    /**
     * 获取被看次数
     *
     * @return watch_times - 被看次数
     */
    public Integer getWatchTimes() {
        return watchTimes;
    }

    /**
     * 设置被看次数
     *
     * @param watchTimes 被看次数
     */
    public void setWatchTimes(Integer watchTimes) {
        this.watchTimes = watchTimes;
    }

    /**
     * 获取建立年限
     *
     * @return build_year - 建立年限
     */
    public Integer getBuildYear() {
        return buildYear;
    }

    /**
     * 设置建立年限
     *
     * @param buildYear 建立年限
     */
    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    /**
     * 获取房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     *
     * @return status - 房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     *
     * @param status 房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return last_update_time
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取城市标记缩写 如 北京bj
     *
     * @return city_en_name - 城市标记缩写 如 北京bj
     */
    public String getCityEnName() {
        return cityEnName;
    }

    /**
     * 设置城市标记缩写 如 北京bj
     *
     * @param cityEnName 城市标记缩写 如 北京bj
     */
    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

    /**
     * 获取区域标记缩写 如 朝阳区cyq
     *
     * @return region_en_name - 区域标记缩写 如 朝阳区cyq
     */
    public String getRegionEnName() {
        return regionEnName;
    }

    /**
     * 设置区域标记缩写 如 朝阳区cyq
     *
     * @param regionEnName 区域标记缩写 如 朝阳区cyq
     */
    public void setRegionEnName(String regionEnName) {
        this.regionEnName = regionEnName;
    }

    /**
     * 获取封面
     *
     * @return cover - 封面
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取朝向
     *
     * @return direction - 朝向
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置朝向
     *
     * @param direction 朝向
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * 获取距地铁距离 默认-1 附近无地铁
     *
     * @return distance_to_subway - 距地铁距离 默认-1 附近无地铁
     */
    public Integer getDistanceToSubway() {
        return distanceToSubway;
    }

    /**
     * 设置距地铁距离 默认-1 附近无地铁
     *
     * @param distanceToSubway 距地铁距离 默认-1 附近无地铁
     */
    public void setDistanceToSubway(Integer distanceToSubway) {
        this.distanceToSubway = distanceToSubway;
    }

    /**
     * 获取客厅数量
     *
     * @return parlour - 客厅数量
     */
    public Integer getParlour() {
        return parlour;
    }

    /**
     * 设置客厅数量
     *
     * @param parlour 客厅数量
     */
    public void setParlour(Integer parlour) {
        this.parlour = parlour;
    }

    /**
     * 获取所在小区
     *
     * @return district - 所在小区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置所在小区
     *
     * @param district 所在小区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取所属管理员id
     *
     * @return admin_id - 所属管理员id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置所属管理员id
     *
     * @param adminId 所属管理员id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取卫生间数量
     *
     * @return bathroom - 卫生间数量
     */
    public Integer getBathroom() {
        return bathroom;
    }

    /**
     * 设置卫生间数量
     *
     * @param bathroom 卫生间数量
     */
    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    /**
     * 获取街道
     *
     * @return street - 街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置街道
     *
     * @param street 街道
     */
    public void setStreet(String street) {
        this.street = street;
    }
}