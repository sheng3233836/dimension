package com.youhujia.dimension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by zxy on 2016/12/10.
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.youhujia.dimension.domain"})
@EnableFeignClients
@EnableScheduling
public class DimensionApplication {

    public static void main(String[] args) {SpringApplication.run(DimensionApplication.class, args);}

}
