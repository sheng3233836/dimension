package com.youhujia.dimension.domain.order;

import com.youhujia.halo.owl.Owl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxy on 2016/12/12.
 */
@Component
public class OrderStateBO {
    private final Logger logger = Logger.getLogger(getClass());
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    private OrderStateServiceWarp orderStateServiceWarp;

    @Value("${mock}")
    Boolean mock;

    public void OrderClose(Owl.Order order){
        if(mock){
            OrderCloseMock(order);
        }else{
            OrderCloseActual(order);
        }
    }

    private void OrderCloseMock(Owl.Order order){
        //取锁
        logger.info("{'orderId':"+order.getOrderId()+", 'statusStart':'"+OrderStateEnum.getByStatus(order.getStatus()).getName()+
                "', 'statusEnd':'"+OrderStateEnum.CLOSE.getName()+"', 'successTime':"+format.format(new Date()));
        //解锁
    }

    private void OrderCloseActual(Owl.Order order){
        //取锁
        Owl.Response ret = orderStateServiceWarp.OrderClose(order.getOrderId());
        if(ret.getResult().getSuccess()){
            logger.info("{'orderId':"+order.getOrderId()+", 'statusStart':'"+OrderStateEnum.getByStatus(order.getStatus()).getName()+
                    "', 'statusEnd':'"+OrderStateEnum.CLOSE.getName()+"', 'successTime':"+format.format(new Date()));
        }
        //解锁
    }
}
