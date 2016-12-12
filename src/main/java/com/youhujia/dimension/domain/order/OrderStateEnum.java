package com.youhujia.dimension.domain.order;

/**
 * Created by zxy on 2016/12/12.
 */
public enum OrderStateEnum {
    UNPAID(1,"待支付"),
    UNRECEIVED(2,"待接单"),
    HIGHUNRECEIVED(3,"高优先待接单"),
    REFUNDING(4,"待退款"),
    SEND(5,"派单待确定"),
    UNSERVICE(6,"待服务"),
    CLOSE(7,"关闭"),
    INSERVICE(8,"服务中"),
    SERVICETIMEOUT(9,"服务超时"),
    SERVICEEXCEPTIONAL(10,"服务异常"),
    APPLYREFUND(11,"退款申请中"),
    UNAPPRAISE(12,"服务结束/待评价"),
    SERVICEDISPUTE(13,"服务纠纷"),
    REFUNDEXCEPTIONAL(14,"退款异常"),
    RETURN(15,"返款中"),
    RETURNEXCEPTIONAL(16,"返款异常"),
    FINISHED(17,"订单结束"),
    FINISHEDDISPUTE(18,"订单结束后纠纷"),
    CLEARING(19,"结算");


    private Integer status;
    private String name;

    OrderStateEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public static OrderStateEnum getByStatus(Long status){
        Integer statusInt = (int)status.longValue();

        for (OrderStateEnum os:OrderStateEnum.values()){
            if (os.getStatus().intValue() == statusInt){
                return os;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getStatus() {
        return status;
    }
}
