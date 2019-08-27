package com.kaysen.shop.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname ShiroConfiguration
 * @Description redis相关配置
 * @Date 2019/7/29 13:42
 * @Created by ks.xu
 */
@Configuration
@AutoConfigureBefore(org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class)
@PropertySource("classpath:application-redis.properties")
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String redisClusterAddress;

    @Bean
    public JedisCluster JedisClusterFactory() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        String[] nodes = redisClusterAddress.split(",");
        for (String address : nodes) {
            if (address!=null||address.contains(":")){
                String[] hosts = address.split(":");
                if (hosts.length>=2){
                    try {
                        jedisClusterNodes.add(new HostAndPort(hosts[0], Integer.parseInt(hosts[1])));
                        System.out.println("AddRedisClusterNode"+hosts[0]+":"+hosts[1]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        return jedisCluster;
    }
}
