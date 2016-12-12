package com.youhujia.halo.owl;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Map;

/**
 * Created by zxy on 2016/12/12.
 */
@FeignClient(name = "owl",configuration=OwlConfiguration.class)
public interface OwlClient {

    @RequestLine("GET /api/owl/admin/orders/summary?state=unpaid,in-service,")
    Owl.Response getOrdersByStates();

    @RequestLine("POST /api/owl/orders/{id}/timeout")
    Owl.Response OrderTimeout(@Param("id") Long orderId);
}
