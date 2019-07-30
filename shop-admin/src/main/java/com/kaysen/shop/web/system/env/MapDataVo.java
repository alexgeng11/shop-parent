package com.kaysen.shop.web.system.env;/**
 * Created by Administrator on 2019/1/25.
 */

/**
 * @ClassName MapDataVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/25 12:33
 * @Version 1.0.0
 */
public class MapDataVo {
    private Integer id;
    private String name;
    private String type;
    private String lng;
    private String lat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
