package com.github.vspro.pay.constants;

public class WxinPayConstants {


    private WxinPayConstants() {

    }

    public static final String SIGN_TYPE_MD5 = "MD5";
    public static final String CHARSET = "UTF-8";


    //下单关地址
    public static final String _DOMAIN                  = "https://api.mch.weixin.qq.com";

    public static final String APP_UNIFIEDORDER_URL     = "/pay/unifiedorder";

    //查询订单
    public static final String APP_ORDERQUERY_URL       = "/pay/orderquery";

    //关闭订单
    public static final String APP_CLOSEORDER_URL       = "/pay/closeorder";

    //查询退款
    public static final String APP_REFUNDQUERY_URL      = "/pay/refundquery";

    //申请退款
    public static final String APP_REFUND_URL           = "/secapi/pay/refund";


}
