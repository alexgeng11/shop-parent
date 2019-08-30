package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "house_tag")
public class HouseTag implements Serializable {
    /**
     * 标签id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 房屋id
     */
    @Column(name = "house_id")
    private Integer houseId;

    @Column(name = "`name`")
    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * 获取标签id
     *
     * @return id - 标签id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置标签id
     *
     * @param id 标签id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取房屋id
     *
     * @return house_id - 房屋id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置房屋id
     *
     * @param houseId 房屋id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}