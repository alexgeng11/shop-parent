package com.kaysen.shop.web.xunwu.service.impl;

import com.kaysen.shop.web.xunwu.bean.Subway;
import com.kaysen.shop.web.xunwu.bean.SubwayStation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.SubwayMapper;
import com.kaysen.shop.web.xunwu.service.SubwayService;

import java.util.List;

@Service
public class SubwayServiceImpl implements SubwayService{

    @Resource
    private SubwayMapper subwayMapper;

    /**
     * 获取具体城市所支持的地铁线路
     * @param cityEnName
     * @return
     */
    @Override
    public List<Subway> findAllSubwayByCity(String cityEnName) {
        Subway subway=new Subway();
        subway.setCityEnName(cityEnName);
        List<Subway> subways = subwayMapper.select(subway);
        return subways;
    }


}
