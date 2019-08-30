package com.kaysen.shop.web.xunwu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.HouseTagMapper;
import com.kaysen.shop.web.xunwu.service.HouseTagService;
@Service
public class HouseTagServiceImpl implements HouseTagService{

    @Resource
    private HouseTagMapper houseTagMapper;

}
