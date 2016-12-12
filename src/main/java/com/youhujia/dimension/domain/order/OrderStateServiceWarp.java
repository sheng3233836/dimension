package com.youhujia.dimension.domain.order;

import com.youhujia.dimension.domain.common.YHJException;
import com.youhujia.dimension.domain.common.YHJExceptionCode;
import com.youhujia.halo.owl.Owl;
import com.youhujia.halo.owl.OwlClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxy on 2016/12/10.
 */
@Component
public class OrderStateServiceWarp {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private OwlClient OwlClient;
    public Owl.Response OrderClose(long orderId) {
        Owl.Response ret;
        String where = "OrderDBServiceWrap -> getOrdersByStates";
        try{
            ret = OwlClient.OrderTimeout(orderId);
        }catch (Exception e){
            logger.error(YHJExceptionCode.THIRD_SERVICE_EXCEPTION.getMessage4Log(), e);
            throw new YHJException(YHJExceptionCode.THIRD_SERVICE_EXCEPTION, "OwlClient getOrdersByStates api unknown Exception");
        }

        if (!ret.hasResult()) {
            logger.error(YHJExceptionCode.THIRD_SERVICE_EXCEPTION.getMessage4Log() + where );
            throw new YHJException(YHJExceptionCode.THIRD_SERVICE_EXCEPTION, where + "result empty");
        }

        if (!ret.getResult().getSuccess()) {
            logger.error(YHJExceptionCode.THIRD_SERVICE_EXCEPTION.getMessage4Log() + where );
            throw new YHJException(YHJExceptionCode.THIRD_SERVICE_EXCEPTION, where + " Not Success  Msg: " + ret.getResult().getDisplayMsg());
        }
        return ret;
    }
}
