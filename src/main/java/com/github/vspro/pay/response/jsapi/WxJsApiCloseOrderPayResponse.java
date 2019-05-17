package com.github.vspro.pay.response.jsapi;

import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


/**
 * 关闭订单 Response
 */
@Data
public class WxJsApiCloseOrderPayResponse extends BaseWxPayResponse {


    @XStreamAlias("result_msg")
    private String resultMsg;

    /**
     * 坑爹，文档中没有这个字段
     */
    @XStreamAlias("sub_mch_id")
    private String subMchId;

}
