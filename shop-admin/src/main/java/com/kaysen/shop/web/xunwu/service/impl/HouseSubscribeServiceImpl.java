package com.kaysen.shop.web.xunwu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.HouseSubscribeMapper;
import com.kaysen.shop.web.xunwu.service.HouseSubscribeService;
@Service
public class HouseSubscribeServiceImpl implements HouseSubscribeService{

    @Resource
    private HouseSubscribeMapper houseSubscribeMapper;

}
