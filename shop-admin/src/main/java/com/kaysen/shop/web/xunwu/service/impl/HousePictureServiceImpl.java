package com.kaysen.shop.web.xunwu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.HousePictureMapper;
import com.kaysen.shop.web.xunwu.service.HousePictureService;
@Service
public class HousePictureServiceImpl implements HousePictureService{

    @Resource
    private HousePictureMapper housePictureMapper;

}
