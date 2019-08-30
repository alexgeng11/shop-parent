package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "house_picture")
public class HousePicture implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 所属房屋id
     */
    @Column(name = "house_id")
    private Integer houseId;

    /**
     * 图片路径
     */
    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    /**
     * 宽
     */
    @Column(name = "width")
    private Integer width;

    /**
     * 高
     */
    @Column(name = "height")
    private Integer height;

    /**
     * 所属房屋位置
     */
    @Column(name = "`location`")
    private String location;

    /**
     * 文件名
     */
    @Column(name = "`path`")
    private String path;

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
     * 获取所属房屋id
     *
     * @return house_id - 所属房屋id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置所属房屋id
     *
     * @param houseId 所属房屋id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取图片路径
     *
     * @return cdn_prefix - 图片路径
     */
    public String getCdnPrefix() {
        return cdnPrefix;
    }

    /**
     * 设置图片路径
     *
     * @param cdnPrefix 图片路径
     */
    public void setCdnPrefix(String cdnPrefix) {
        this.cdnPrefix = cdnPrefix;
    }

    /**
     * 获取宽
     *
     * @return width - 宽
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 设置宽
     *
     * @param width 宽
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 获取高
     *
     * @return height - 高
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置高
     *
     * @param height 高
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取所属房屋位置
     *
     * @return location - 所属房屋位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所属房屋位置
     *
     * @param location 所属房屋位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取文件名
     *
     * @return path - 文件名
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件名
     *
     * @param path 文件名
     */
    public void setPath(String path) {
        this.path = path;
    }
}