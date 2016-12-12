package com.youhujia.dimension.domain.common;

import com.youhujia.halo.owl.Owl;
import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cman on 10/21/16.
 */
@ControllerAdvice
public class YHJExceptionController {

    final Logger logger = Logger.getLogger(getClass());

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public COMMON.Result handleException(Exception e) {
//
//        logger.error(YHJExceptionCode.UNKNOWN_ERROR.getMessage4Log(), e);
//
//        return COMMON.Result.newBuilder()
//                .setCode(YHJExceptionCode.UNKNOWN_ERROR.getCode())
//                .setSuccess(false)
//                .setMsg(e.getMessage())
//                .setDisplaymsg(YHJExceptionCode.UNKNOWN_ERROR.getMessage4Show()).build();
//    }
//
//    @ExceptionHandler(value = YHJException.class)
//    @ResponseBody
//    public COMMON.Result handleRedCoastException(YHJException re) {
//        return COMMON.Result.newBuilder()
//                .setCode(re.getCode())
//                .setSuccess(false)
//                .setMsg(re.getMessage4Log())
//                .setDisplaymsg(re.getMessage4Show()).build();
//    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public Owl.Result handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        return Owl.Result.newBuilder()
                .setCode(YHJExceptionCode.OPTION_FORMAT_ERROR.getCode().longValue())
                .setSuccess(false)
                .setMsg(e.getMessage())
                .setDisplayMsg(YHJExceptionCode.OPTION_FORMAT_ERROR.getMessage4Show() + " " + e.getMessage()).build();
    }
}