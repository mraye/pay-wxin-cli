package com.github.vspro.pay.request.app;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.app.WxAppOrderQueryPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 查询订单 Request
 * https://api.mch.weixin.qq.com/pay/orderquery
 */
@Data
public class WxAppOrderQueryPayRequest extends BaseWxPayRequest<WxAppOrderQueryPayResponse> {


    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;



    @Override
    public Class<WxAppOrderQueryPayResponse> getResponseClass() {
        return WxAppOrderQueryPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_ORDERQUERY_URL;
    }
}
