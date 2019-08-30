package com.kaysen.shop.web.xunwu.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "subway_station")
public class SubwayStation implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 所属地铁线id
     */
    @Column(name = "subway_id")
    private Long subwayId;

    /**
     * 站点名称
     */
    @Column(name = "`name`")
    private String name;

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
     * 获取所属地铁线id
     *
     * @return subway_id - 所属地铁线id
     */
    public Long getSubwayId() {
        return subwayId;
    }

    /**
     * 设置所属地铁线id
     *
     * @param subwayId 所属地铁线id
     */
    public void setSubwayId(Long subwayId) {
        this.subwayId = subwayId;
    }

    /**
     * 获取站点名称
     *
     * @return name - 站点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置站点名称
     *
     * @param name 站点名称
     */
    public void setName(String name) {
        this.name = name;
    }
}