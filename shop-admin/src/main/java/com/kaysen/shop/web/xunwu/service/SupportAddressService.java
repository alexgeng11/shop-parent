package com.kaysen.shop.web.xunwu.service;

import com.kaysen.shop.web.xunwu.bean.SupportAddress;

import java.util.List;

public interface SupportAddressService {

    /**
     * 查询所有的城市
     * @return
     */
    List<SupportAddress> findAllCities();

    /**
     * 查询支持的区域
     * @param cityEnName
     * @return
     */
    List<SupportAddress> findAllRegionsByCityName(String cityEnName);
}
