package com.github.vspro.pay.request.jsapi;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.jsapi.WxJsApiRefundQueryPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 查询退款 Request
 * https://api.mch.weixin.qq.com/pay/refundquery
 */
@Data
public class WxJsApiRefundQueryPayRequest extends BaseWxPayRequest<WxJsApiRefundQueryPayResponse> {


    @XStreamAlias("sign_type")
    private String signType;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    @XStreamAlias("refundId")
    private String refundId;

    private int offset;

    @Override
    public Class<WxJsApiRefundQueryPayResponse> getResponseClass() {
        return WxJsApiRefundQueryPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_REFUNDQUERY_URL;
    }
}
