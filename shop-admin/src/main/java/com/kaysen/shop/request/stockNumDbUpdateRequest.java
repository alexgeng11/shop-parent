package com.kaysen.shop.request;

import com.kaysen.shop.redis.cache.RedisDAO;

/**
 * @Classname stockNumDbUpdateRequest
 * @Description 修改库存请求
 * 删除缓存
 * 更细数据库
 * @Date 2019/8/12 10:17
 * @Created by ks.xu
 */
public class stockNumDbUpdateRequest implements Request {
    //商品id
    private Integer productId;
    //库存数量
    private Long stockNum;


    @Override
    public void processor() {
        //删除redis缓存
        //更新数据库库存
    }

    public stockNumDbUpdateRequest(Integer productId, Long stockNum) {
        this.productId = productId;
        this.stockNum = stockNum;
    }
}
