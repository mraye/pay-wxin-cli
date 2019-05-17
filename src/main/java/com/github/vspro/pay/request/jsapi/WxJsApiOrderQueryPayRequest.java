package com.github.vspro.pay.request.jsapi;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.jsapi.WxJsApiOrderQueryPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * JsApi 查询订单 Request
 * https://api.mch.weixin.qq.com/pay/orderquery
 */
@Data
public class WxJsApiOrderQueryPayRequest extends BaseWxPayRequest<WxJsApiOrderQueryPayResponse> {


    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("sign_type")
    private String signType;



    @Override
    public Class<WxJsApiOrderQueryPayResponse> getResponseClass() {
        return WxJsApiOrderQueryPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_ORDERQUERY_URL;
    }
}
