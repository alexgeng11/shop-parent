package com.kaysen.shop.web.xunwu.controller;

import com.kaysen.shop.base.ApiResponse;
import com.kaysen.shop.web.xunwu.bean.House;
import com.kaysen.shop.web.xunwu.bean.Subway;
import com.kaysen.shop.web.xunwu.bean.SubwayStation;
import com.kaysen.shop.web.xunwu.bean.SupportAddress;
import com.kaysen.shop.web.xunwu.dto.HouseDTO;
import com.kaysen.shop.web.xunwu.form.HouseForm;
import com.kaysen.shop.web.xunwu.service.HouseService;
import com.kaysen.shop.web.xunwu.service.SubwayService;
import com.kaysen.shop.web.xunwu.service.SubwayStationService;
import com.kaysen.shop.web.xunwu.service.SupportAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SubwayService subwayService;
    @Autowired
    private SubwayStationService subwayStationService;
    @Autowired
    private HouseService houseService;
    @RequestMapping("/map")
    public String getMap(){
        List<SupportAddress> allCities = supportAddressService.findAllCities();

        return "/xunwu/baidu_map";
    }

    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities() {
        List<SupportAddress> allCities = supportAddressService.findAllCities();
        return ApiResponse.success(allCities);
    }

    /**
     * 获取对应城市支持区域列表
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/regions")
    @ResponseBody
    public ApiResponse getSupportRegions(@RequestParam(name = "city_name") String cityEnName) {
        List<SupportAddress> addressResult = supportAddressService.findAllRegionsByCityName(cityEnName);
        return ApiResponse.success(addressResult);
    }

    /**
     * 获取具体城市所支持的地铁线路
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/subway/line")
    @ResponseBody
    public ApiResponse getSupportSubwayLine(@RequestParam(name = "city_name") String cityEnName) {
        List<Subway> subways = subwayService.findAllSubwayByCity(cityEnName);
        return ApiResponse.success(subways);
    }

    /**
     * 获取对应地铁线路所支持的地铁站点
     * @param subwayId
     * @return
     */
    @GetMapping("address/support/subway/station")
    @ResponseBody
    public ApiResponse getSupportSubwayStation(@RequestParam(name = "subway_id") Long subwayId) {
        List<SubwayStation> stations = subwayStationService.findAllStationBySubway(subwayId);
        return ApiResponse.success(stations);
    }

    @PostMapping("house/add")
    @ResponseBody
    public ApiResponse addHouse(@Valid @ModelAttribute("form-house-add") HouseForm houseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResponse.paramsError(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        if (houseForm.getPhotos() == null || houseForm.getCover() == null) {
            return ApiResponse.paramsError("必须上传图片");
        }

        HouseDTO houseDTO = houseService.save(houseForm);

        return ApiResponse.success();
    }
}
