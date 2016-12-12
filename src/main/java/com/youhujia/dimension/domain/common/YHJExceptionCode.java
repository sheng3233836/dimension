package com.youhujia.dimension.domain.common;

/**
 * Created by cman on 9/28/16.
 */
public enum YHJExceptionCode {

    THIRD_SERVICE_EXCEPTION(1, "third service exception", "系统内部错误，请稍后重试"),
    TASK_FORMAT_ERROR(2, "task format error", "系统内部错误，请稍后重试"),
    TASK_ROSTER_CONTENT_FORMAT_ERROR(3, "task roster content format error", "系统内部错误，请稍后重试"),
    TASK_QUERY_FORMAT_ERROR(4, "task query format error", "参数格式错误"),
    TASK_QUERY_NOT_HANDLE(5, "task query not handle", "参数没有被处理，请联系开发同学修复"),
    OPTION_FORMAT_ERROR(6, "query format error", "请求参数中非法"),
    TASK_QUERY_FORCE_CONDITION_NOT_MATCH(7, "query force condition not match", "参数中的基本查询要求不满足（三个基本查询条件不能全为空）"),


    UNKNOWN_ERROR(1024, "unknown error", "未知错误");

    private Integer code;
    private String message4Log;
    private String message4Show;

    YHJExceptionCode(Integer code, String message4Log, String message4Show) {
        this.code = code;
        this.message4Log = message4Log;
        this.message4Show = message4Show;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage4Log() {
        return message4Log;
    }

    public String getMessage4Show() {
        return message4Show;
    }
}
