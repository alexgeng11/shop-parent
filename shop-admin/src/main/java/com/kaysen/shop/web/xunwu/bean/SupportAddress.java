package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "support_address")
public class SupportAddress implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 上一级行政单位
     */
    @Column(name = "belong_to")
    private String belongTo;

    /**
     * 英文名
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 中文名
     */
    @Column(name = "cn_name")
    private String cnName;

    /**
     * 级别
     */
    @Column(name = "`level`")
    private String level;

    /**
     * 经度
     */
    @Column(name = "baidu_map_lng")
    private Double baiduMapLng;

    /**
     * 纬度
     */
    @Column(name = "baidu_map_lat")
    private Double baiduMapLat;

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
     * 获取上一级行政单位
     *
     * @return belong_to - 上一级行政单位
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     * 设置上一级行政单位
     *
     * @param belongTo 上一级行政单位
     */
    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    /**
     * 获取英文名
     *
     * @return en_name - 英文名
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文名
     *
     * @param enName 英文名
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * 获取中文名
     *
     * @return cn_name - 中文名
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 设置中文名
     *
     * @param cnName 中文名
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * 获取级别
     *
     * @return level - 级别
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置级别
     *
     * @param level 级别
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取经度
     *
     * @return baidu_map_lng - 经度
     */
    public Double getBaiduMapLng() {
        return baiduMapLng;
    }

    /**
     * 设置经度
     *
     * @param baiduMapLng 经度
     */
    public void setBaiduMapLng(Double baiduMapLng) {
        this.baiduMapLng = baiduMapLng;
    }

    /**
     * 获取纬度
     *
     * @return baidu_map_lat - 纬度
     */
    public Double getBaiduMapLat() {
        return baiduMapLat;
    }

    /**
     * 设置纬度
     *
     * @param baiduMapLat 纬度
     */
    public void setBaiduMapLat(Double baiduMapLat) {
        this.baiduMapLat = baiduMapLat;
    }
}