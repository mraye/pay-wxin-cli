package com.github.vspro.pay.request.jsapi;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.jsapi.WxJsApiCloseOrderPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 关闭订单 Request
 * https://api.mch.weixin.qq.com/pay/closeorder
 */
@Data
public class WxJsApiCloseOrderPayRequest extends BaseWxPayRequest<WxJsApiCloseOrderPayResponse> {


    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("sign_type")
    private String signType;

    @Override
    public Class<WxJsApiCloseOrderPayResponse> getResponseClass() {
        return WxJsApiCloseOrderPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_CLOSEORDER_URL;
    }
}
