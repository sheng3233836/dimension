package com.youhujia.halo.owl;

import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * Created by cman on 9/25/16.
 */
@Configuration
public class OwlConfiguration {

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 8000);
        int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 250);

        return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
    }
}
