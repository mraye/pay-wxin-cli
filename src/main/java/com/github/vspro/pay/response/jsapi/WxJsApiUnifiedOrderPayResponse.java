package com.github.vspro.pay.response.jsapi;

import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 统一下单请求 Response
 */
@Data
public class WxJsApiUnifiedOrderPayResponse extends BaseWxPayResponse {

    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAlias("prepay_id")
    private String prepayId;

    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("code_url")
    private String codeUrl;

}
