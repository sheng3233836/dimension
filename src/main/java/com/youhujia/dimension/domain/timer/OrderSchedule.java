package com.youhujia.dimension.domain.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
/**
 * Created by zxy on 2016/12/10.
 */
@Component
public class OrderSchedule {
    @Autowired
    private OrderComputer orderComputer;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void scanDB(){
        orderComputer.OrderCompute();
//        System.out.println(new Date());
    }
}
