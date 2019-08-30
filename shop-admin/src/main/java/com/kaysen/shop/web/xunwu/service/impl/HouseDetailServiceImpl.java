package com.kaysen.shop.web.xunwu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.HouseDetailMapper;
import com.kaysen.shop.web.xunwu.service.HouseDetailService;
@Service
public class HouseDetailServiceImpl implements HouseDetailService{

    @Resource
    private HouseDetailMapper houseDetailMapper;

}
