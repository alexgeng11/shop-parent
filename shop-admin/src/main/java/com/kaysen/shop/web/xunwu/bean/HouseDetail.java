package com.kaysen.shop.web.xunwu.bean;

import sun.rmi.runtime.Log;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "house_detail")
public class HouseDetail implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 详细描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 户型介绍
     */
    @Column(name = "layout_desc")
    private String layoutDesc;

    /**
     * 交通出行
     */
    @Column(name = "traffic")
    private String traffic;

    /**
     * 周边配套
     */
    @Column(name = "round_service")
    private String roundService;

    /**
     * 租赁方式
     */
    @Column(name = "rent_way")
    private Integer rentWay;

    /**
     * 详细地址 
     */
    @Column(name = "address")
    private String address;

    /**
     * 附近地铁线id
     */
    @Column(name = "subway_line_id")
    private Long subwayLineId;

    /**
     * 附近地铁线名称
     */
    @Column(name = "subway_line_name")
    private String subwayLineName;

    /**
     * 地铁站id
     */
    @Column(name = "subway_station_id")
    private Integer subwayStationId;

    /**
     * 地铁站名
     */
    @Column(name = "subway_station_name")
    private String subwayStationName;

    /**
     * 对应house的id
     */
    @Column(name = "house_id")
    private Integer houseId;

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
     * 获取详细描述
     *
     * @return description - 详细描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置详细描述
     *
     * @param description 详细描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取户型介绍
     *
     * @return layout_desc - 户型介绍
     */
    public String getLayoutDesc() {
        return layoutDesc;
    }

    /**
     * 设置户型介绍
     *
     * @param layoutDesc 户型介绍
     */
    public void setLayoutDesc(String layoutDesc) {
        this.layoutDesc = layoutDesc;
    }

    /**
     * 获取交通出行
     *
     * @return traffic - 交通出行
     */
    public String getTraffic() {
        return traffic;
    }

    /**
     * 设置交通出行
     *
     * @param traffic 交通出行
     */
    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    /**
     * 获取周边配套
     *
     * @return round_service - 周边配套
     */
    public String getRoundService() {
        return roundService;
    }

    /**
     * 设置周边配套
     *
     * @param roundService 周边配套
     */
    public void setRoundService(String roundService) {
        this.roundService = roundService;
    }

    /**
     * 获取租赁方式
     *
     * @return rent_way - 租赁方式
     */
    public Integer getRentWay() {
        return rentWay;
    }

    /**
     * 设置租赁方式
     *
     * @param rentWay 租赁方式
     */
    public void setRentWay(Integer rentWay) {
        this.rentWay = rentWay;
    }

    /**
     * 获取详细地址 
     *
     * @return address - 详细地址 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址 
     *
     * @param address 详细地址 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取附近地铁线id
     *
     * @return subway_line_id - 附近地铁线id
     */
    public Long getSubwayLineId() {
        return subwayLineId;
    }

    /**
     * 设置附近地铁线id
     *
     * @param subwayLineId 附近地铁线id
     */
    public void setSubwayLineId(Long subwayLineId) {
        this.subwayLineId = subwayLineId;
    }

    /**
     * 获取附近地铁线名称
     *
     * @return subway_line_name - 附近地铁线名称
     */
    public String getSubwayLineName() {
        return subwayLineName;
    }

    /**
     * 设置附近地铁线名称
     *
     * @param subwayLineName 附近地铁线名称
     */
    public void setSubwayLineName(String subwayLineName) {
        this.subwayLineName = subwayLineName;
    }

    /**
     * 获取地铁站id
     *
     * @return subway_station_id - 地铁站id
     */
    public Integer getSubwayStationId() {
        return subwayStationId;
    }

    /**
     * 设置地铁站id
     *
     * @param subwayStationId 地铁站id
     */
    public void setSubwayStationId(Integer subwayStationId) {
        this.subwayStationId = subwayStationId;
    }

    /**
     * 获取地铁站名
     *
     * @return subway_station_name - 地铁站名
     */
    public String getSubwayStationName() {
        return subwayStationName;
    }

    /**
     * 设置地铁站名
     *
     * @param subwayStationName 地铁站名
     */
    public void setSubwayStationName(String subwayStationName) {
        this.subwayStationName = subwayStationName;
    }

    /**
     * 获取对应house的id
     *
     * @return house_id - 对应house的id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置对应house的id
     *
     * @param houseId 对应house的id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}