package com.youhujia.dimension.domain.common;

/**
 * Created by cman on 9/28/16.
 */
public class YHJException extends RuntimeException {

    private YHJExceptionCode YHJExceptionCode;
    private String otherMsg;

    public YHJException(YHJExceptionCode YHJExceptionCode, String otherMsg) {
        super(YHJExceptionCode.getMessage4Show()+" " + otherMsg);
        this.YHJExceptionCode = YHJExceptionCode;
        this.otherMsg = otherMsg;
    }

    public YHJException(YHJExceptionCode YHJExceptionCode) {
        super();
        this.YHJExceptionCode = YHJExceptionCode;
        this.otherMsg = "";
    }

    public String getMessage4Show(){
        return YHJExceptionCode.getMessage4Show() + " Info:" + this.otherMsg;
    }

    public String getMessage4Log() {
        return YHJExceptionCode.getMessage4Log() + " Info:" + this.otherMsg;
    }

    public Integer getCode(){
        return this.YHJExceptionCode.getCode();
    }
}
