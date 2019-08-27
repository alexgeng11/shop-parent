package com.kaysen.shop.web.xunwu.service.impl;

import com.kaysen.shop.base.service.ServiceMultiResult;
import com.kaysen.shop.web.xunwu.bean.SupportAddress;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaysen.shop.web.xunwu.dao.SupportAddressMapper;
import com.kaysen.shop.web.xunwu.service.SupportAddressService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupportAddressServiceImpl implements SupportAddressService{

    @Resource
    private SupportAddressMapper supportAddressMapper;

    /**
     * 查询所有的城市
     * @return
     */
    @Override
    public List<SupportAddress> findAllCities() {
        SupportAddress supportAddress=new SupportAddress();
        List<SupportAddress> addresses = supportAddressMapper.selectByExample(supportAddress);
        List<SupportAddress> addressDTOS = new ArrayList<>();
//        for (SupportAddress supportAddress : addresses) {
//            SupportAddress target = modelMapper.map(supportAddress, SupportAddress.class);
//            addressDTOS.add(target);
//        }

        return addressDTOS;
    }
}
