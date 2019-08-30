package com.kaysen.shop.web.xunwu.service.impl;

import com.kaysen.shop.web.xunwu.bean.SupportAddress;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.SupportAddressMapper;
import com.kaysen.shop.web.xunwu.service.SupportAddressService;

import java.util.List;

@Service
public class SupportAddressServiceImpl implements SupportAddressService {

    @Resource
    private SupportAddressMapper supportAddressMapper;

    /**
     * 查询所有的城市
     * @return
     */
    @Override
    public List<SupportAddress> findAllCities() {
        SupportAddress supportAddress=new SupportAddress();
        supportAddress.setLevel("city");
        List<SupportAddress> addresses = supportAddressMapper.select(supportAddress);
        return addresses;
    }

    /**
     * 查询支持的区域
     * @param cityEnName
     * @return
     */
    @Override
    public List<SupportAddress> findAllRegionsByCityName(String cityEnName) {
        SupportAddress supportAddress=new SupportAddress();
        supportAddress.setLevel("region");
        supportAddress.setBelongTo(cityEnName);
        List<SupportAddress> addresses = supportAddressMapper.select(supportAddress);
        return addresses;
    }
}
