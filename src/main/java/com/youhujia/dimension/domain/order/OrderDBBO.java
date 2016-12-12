package com.youhujia.dimension.domain.order;

import com.youhujia.halo.owl.Owl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zxy on 2016/12/12.
 */
@Component
public class OrderDBBO {
    @Autowired
    private OrderDBServiceWrap orderDBServiceWrap;

    @Value("${mock}")
    Boolean mock;

    public Owl.Response getOrdersByStates(){
        if (mock){
            return getOrdersByStatesMock();
        }else {
            return orderDBServiceWrap.getOrdersByStates();
        }
    }

    private Owl.Response getOrdersByStatesMock(){
        Owl.Response.Builder ret = Owl.Response.newBuilder();
        Owl.Order.Builder order = Owl.Order.newBuilder();
        order.setOrderId(33);
        order.setStatus(3);
        order.setUpdatedAt(1481515717000L);
        ret.addOrder(order.build());
        return ret.build();
    }
}
