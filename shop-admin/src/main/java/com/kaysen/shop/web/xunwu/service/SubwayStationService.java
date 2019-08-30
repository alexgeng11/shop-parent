package com.kaysen.shop.web.xunwu.service;

import com.kaysen.shop.web.xunwu.bean.SubwayStation;

import java.util.List;

public interface SubwayStationService{


    /**
     * 获取对应地铁线路所支持的地铁站点
     * @param subwayId
     * @return
     */
    List<SubwayStation> findAllStationBySubway(Long subwayId);
}
