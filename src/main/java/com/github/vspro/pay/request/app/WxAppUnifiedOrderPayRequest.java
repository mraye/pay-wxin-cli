package com.github.vspro.pay.request.app;

import com.github.vspro.pay.constants.PayModelEnum;
import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.app.WxAppUnifiedOrderPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 统一下单请求 Request
 * https://api.mch.weixin.qq.com/pay/unifiedorder
 */

@Data
public class WxAppUnifiedOrderPayRequest extends BaseWxPayRequest<WxAppUnifiedOrderPayResponse> {

    @XStreamAlias("sign_type")
    private String signType;

    private String body;

    private String detail;

    private String attach;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    @XStreamAlias("time_start")
    private String timeStart;

    @XStreamAlias("time_expire")
    private String timeExpire;

    @XStreamAlias("goods_tag")
    private String goodsTag;

    @XStreamAlias("notify_url")
    private String notifyUrl;

    @XStreamAlias("trade_type")
    private String tradeType = PayModelEnum.APP.getValue();

    @XStreamAlias("limit_pay")
    private String limitPay;

    private String receipt;


    @Override
    public Class<WxAppUnifiedOrderPayResponse> getResponseClass() {
        return WxAppUnifiedOrderPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_UNIFIEDORDER_URL;
    }

}
