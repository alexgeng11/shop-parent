package com.kaysen.shop.utils;

import tk.mybatis.mapper.entity.Example;

/**
 * @Classname TkUtils
 * @Description TODO
 * @Date 2019/8/28 15:42
 * @Created by ks.xu
 */
public class TkUtils {
    public static Example getExampleEq(Class T,Object eq){
        Example example=new Example(T);
        example.createCriteria().andEqualTo(eq);
        return example;
    }
    public static Example getExampleEqAll(Class T,Object eq){
        Example example=new Example(T);
        example.createCriteria().andAllEqualTo(eq);
        return example;
    }
}
