package com.kaysen.shop.web.xunwu.service;

import com.kaysen.shop.web.xunwu.bean.Subway;
import com.kaysen.shop.web.xunwu.bean.SubwayStation;

import java.util.List;

public interface SubwayService{

    /**
     * 获取具体城市所支持的地铁线路
     * @param cityEnName
     * @return
     */
    List<Subway> findAllSubwayByCity(String cityEnName);


}
