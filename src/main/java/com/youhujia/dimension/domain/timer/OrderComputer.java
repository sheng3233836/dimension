package com.youhujia.dimension.domain.timer;

import com.youhujia.dimension.domain.order.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.youhujia.halo.owl.Owl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zxy on 2016/12/10.
 */
@Component
public class OrderComputer {
    private final Logger logger = Logger.getLogger(getClass());
    private static final long MinuteLong = 1000*600;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    @Autowired
    private OrderDBBO orderDBBO;

    @Autowired
    private OrderStateBO orderStateBO;

    public void OrderCompute(){
        Owl.Response orders = orderDBBO.getOrdersByStates();
        orders.getOrderList().forEach(order -> {
            int state =(int)order.getStatus();
            switch (state){
                case 1:ComputeUnpaid(order);break;
                case 2:ComputeUnreceived(order);break;
                case 3:ComputeHighUnreceived(order);break;
                case 5:ComputeSend(order);break;
                case 8:ComputeInService(order);break;
                case 9:ComputeServiceTimeout(order);break;
                case 11:ComputeApplyRefund(order);break;
                case 12:ComputeUnappraise(order);break;
                case 17:ComputeFinished(order);break;
                default:
                    break;
            }
        });
    }

    private void ComputeUnpaid(Owl.Order order) {
        if(order.getStatus() == OrderStateEnum.UNPAID.getStatus().longValue()){
            return;
        }
        long specific = MinuteLong*15;
        long continueTime = order.getUpdatedAt()-new Date().getTime();
        if(continueTime > specific){
            orderStateBO.OrderClose(order);

            logger.info("{'orderId':"+order.getOrderId()+", 'statusStart':'"+OrderStateEnum.UNPAID.getName()+
                    "', 'statusEnd':'"+OrderStateEnum.CLOSE.getName()+"', 'operateTime':"+format.format(new Date()));
        }
    }

    private void ComputeUnreceived(Owl.Order order) {
    }

    private void ComputeHighUnreceived(Owl.Order order) {
    }

    private void ComputeSend(Owl.Order order) {
    }

    private void ComputeInService(Owl.Order order) {
    }

    private void ComputeServiceTimeout(Owl.Order order) {
    }

    private void ComputeApplyRefund(Owl.Order order) {
    }

    private void ComputeUnappraise(Owl.Order order) {
    }

    private void ComputeFinished(Owl.Order order) {
    }


}
