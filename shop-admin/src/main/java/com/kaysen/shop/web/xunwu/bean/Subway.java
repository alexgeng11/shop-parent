package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import javax.persistence.*;

public class Subway implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 线路名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 所属城市英文名缩写
     */
    @Column(name = "city_en_name")
    private String cityEnName;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取线路名
     *
     * @return name - 线路名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置线路名
     *
     * @param name 线路名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属城市英文名缩写
     *
     * @return city_en_name - 所属城市英文名缩写
     */
    public String getCityEnName() {
        return cityEnName;
    }

    /**
     * 设置所属城市英文名缩写
     *
     * @param cityEnName 所属城市英文名缩写
     */
    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }
}