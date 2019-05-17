package com.github.vspro.pay.request.app;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.app.WxAppRefundQueryPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 查询退款 Request
 * https://api.mch.weixin.qq.com/pay/refundquery
 */
@Data
public class WxAppRefundQueryPayRequest extends BaseWxPayRequest<WxAppRefundQueryPayResponse> {


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
    public Class<WxAppRefundQueryPayResponse> getResponseClass() {
        return WxAppRefundQueryPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_REFUNDQUERY_URL;
    }
}
