package com.kaysen.shop.web.xunwu.service.impl;

import com.kaysen.shop.web.xunwu.bean.SubwayStation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.SubwayStationMapper;
import com.kaysen.shop.web.xunwu.service.SubwayStationService;

import java.util.List;

@Service
public class SubwayStationServiceImpl implements SubwayStationService{

    @Resource
    private SubwayStationMapper subwayStationMapper;

    /**
     * 获取对应地铁线路所支持的地铁站点
     * @param subwayId
     * @return
     */
    @Override
    public List<SubwayStation> findAllStationBySubway(Long subwayId) {
        SubwayStation subwayStation=new SubwayStation();
        subwayStation.setSubwayId(subwayId);
        List<SubwayStation> subways = subwayStationMapper.select(subwayStation);
        return subways;
    }
}
