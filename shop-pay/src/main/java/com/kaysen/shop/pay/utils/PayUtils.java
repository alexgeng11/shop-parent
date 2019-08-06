package com.lfm.pay.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: Pay-Demo
 * @ClassName PayUtils
 * @description: TODO
 * @author: xks
 * @create: 2018-11-07 11:14
 **/
public class PayUtils {
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String getSdfTimes() {
        return sdfTimes.format(new Date());
    }
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
