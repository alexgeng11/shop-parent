package com.kaysen.shop.web.xunwu.service;

import com.kaysen.shop.web.xunwu.bean.House;
import com.kaysen.shop.web.xunwu.dto.HouseDTO;
import com.kaysen.shop.web.xunwu.form.HouseForm;

public interface HouseService{

    /**
     * 保存房源
     * @param houseForm
     * @return
     */
    HouseDTO save(HouseForm houseForm);
}
