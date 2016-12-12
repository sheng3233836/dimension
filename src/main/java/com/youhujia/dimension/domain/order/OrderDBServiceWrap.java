package com.youhujia.dimension.domain.order;

import com.alibaba.fastjson.JSON;
import com.youhujia.dimension.domain.common.YHJException;
import com.youhujia.dimension.domain.common.YHJExceptionCode;
import com.youhujia.halo.owl.Owl;
import com.youhujia.halo.owl.OwlClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by zxy on 2016/12/12.
 */
@Component
public class OrderDBServiceWrap {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private OwlClient OwlClient;

    public Owl.Response getOrdersByStates(){
        Owl.Response ret;
        String where = "OrderDBServiceWrap -> getOrdersByStates";
        try{
            ret = OwlClient.getOrdersByStates();
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
