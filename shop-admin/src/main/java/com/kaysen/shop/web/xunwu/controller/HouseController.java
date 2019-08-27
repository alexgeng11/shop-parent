package com.kaysen.shop.web.xunwu.controller;

import com.kaysen.shop.base.ApiResponse;
import com.kaysen.shop.base.service.ServiceMultiResult;
import com.kaysen.shop.web.xunwu.bean.SupportAddress;
import com.kaysen.shop.web.xunwu.service.SupportAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname HouseController
 * @Description TODO
 * @Date 2019/8/26 14:05
 * @Created by ks.xu
 */
@Controller
public class HouseController {
    @Autowired
    private SupportAddressService supportAddressService;
    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities() {
        List<SupportAddress> addresses = supportAddressService.findAllCities();
        return ApiResponse.success(addresses);
    }

    @RequestMapping("/map")
    public String getMap(){
        return "/xunwu/baidu_map";
    }
}
