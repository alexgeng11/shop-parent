package com.kaysen.shop.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@PropertySource("classpath:application-es.properties")
public class RestConfig {
    @Value("${spring.data.elasticsearch.hostname}")
    private String hostName;
    @Value("${spring.data.elasticsearch.port}")
    private Integer port;
    @Bean
    public RestClient getClient(){
        try {
            // 如果有多个从节点可以持续在内部new多个HttpHost，参数1是ip,参数2是HTTP端口，参数3是通信协议
            RestClientBuilder clientBuilder = RestClient.builder(new HttpHost(hostName, port, "http"));
            // 添加其他配置，返回来的还是RestClientBuilder对象，这些配置都是可选的
            // clientBuilder.setXX()...

            // 最后配置好的clientBuilder再build一下即可得到真正的Client
            return clientBuilder.build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        InetSocketTransportAddress node=new InetSocketTransportAddress(InetAddress.getByName(hostName),9300);
        Settings settings=Settings.builder().put("cluster.name","shop-es").build();
        TransportClient client=new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;

    }
}
