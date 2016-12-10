package com.youhujia.dimension.domain.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
/**
 * Created by zxy on 2016/12/10.
 */
@Component
public class OrderScheduleController {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void scanDB(){
        System.out.println(new Date()+"aa");
    }
}
