package com.github.vspro.pay.request.app;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.app.WxAppRefundPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 申请退款 Request [未测试!!]
 * https://api.mch.weixin.qq.com/secapi/pay/refund
 */
@Data
public class WxAppRefundPayRequest extends BaseWxPayRequest<WxAppRefundPayResponse> {


    @XStreamAlias("sign_type")
    private String signType;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("refund_fee")
    private Integer refundFee;

    @XStreamAlias("refund_fee_type")
    private String refundFeeType;

    @XStreamAlias("refund_desc")
    private String refundDesc;

    @XStreamAlias("refund_account")
    private String refundAccount;

    @XStreamAlias("notify_url")
    private String notifyUrl;



    @Override
    public Class<WxAppRefundPayResponse> getResponseClass() {
        return WxAppRefundPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_REFUND_URL;
    }
}
