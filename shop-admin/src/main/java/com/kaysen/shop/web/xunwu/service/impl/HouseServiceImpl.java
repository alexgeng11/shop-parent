package com.kaysen.shop.web.xunwu.service.impl;

import com.kaysen.shop.web.xunwu.bean.HouseDetail;
import com.kaysen.shop.web.xunwu.bean.Subway;
import com.kaysen.shop.web.xunwu.bean.SubwayStation;
import com.kaysen.shop.web.xunwu.dao.HouseMapper;
import com.kaysen.shop.web.xunwu.dao.SubwayMapper;
import com.kaysen.shop.web.xunwu.dao.SubwayStationMapper;
import com.kaysen.shop.web.xunwu.dto.HouseDTO;
import com.kaysen.shop.web.xunwu.form.HouseForm;
import com.kaysen.shop.web.xunwu.service.HouseService;
import com.kaysen.shop.web.xunwu.service.SubwayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HouseServiceImpl implements HouseService{

    @Resource
    private HouseMapper houseMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SubwayMapper subwayMapper;
    @Autowired
    private SubwayStationMapper subwayStationMapper;
    /**
     * 保存房源
     * @param houseForm
     * @return
     */
    @Override
    public HouseDTO save(HouseForm houseForm) {
        HouseDetail houseDetail = new HouseDetail();
        modelMapper.map(houseForm,houseDetail);
        Subway subway = subwayMapper.selectByPrimaryKey(houseForm.getSubwayLineId());
        if (subway == null) {
        }

        SubwayStation subwayStation = subwayStationMapper.selectByPrimaryKey(houseForm.getSubwayStationId());
        if (subwayStation == null || subway.getId() != subwayStation.getSubwayId()) {
        }
        houseDetail.setSubwayLineId(subway.getId());
        houseDetail.setSubwayLineName(subway.getName());

        houseDetail.setSubwayStationId(subwayStation.getId());
        houseDetail.setSubwayStationName(subwayStation.getName());
        return null;
    }
}
