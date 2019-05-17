package com.github.vspro.pay.response.app;

import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 统一下单请求 Response
 */
@Data
public class WxAppUnifiedOrderPayResponse extends BaseWxPayResponse {

    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAlias("prepay_id")
    private String prepayId;

    @XStreamAlias("device_info")
    private String deviceInfo;

}
