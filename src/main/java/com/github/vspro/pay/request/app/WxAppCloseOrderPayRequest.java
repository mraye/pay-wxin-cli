package com.github.vspro.pay.request.app;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.app.WxAppCloseOrderPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 关闭订单 Request
 * https://api.mch.weixin.qq.com/pay/closeorder
 */
@Data
public class WxAppCloseOrderPayRequest extends BaseWxPayRequest<WxAppCloseOrderPayResponse> {


    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @Override
    public Class<WxAppCloseOrderPayResponse> getResponseClass() {
        return WxAppCloseOrderPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_CLOSEORDER_URL;
    }
}
