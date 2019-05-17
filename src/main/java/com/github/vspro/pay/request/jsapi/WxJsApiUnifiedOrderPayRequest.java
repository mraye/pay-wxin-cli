package com.github.vspro.pay.request.jsapi;

import com.github.vspro.pay.constants.PayModelEnum;
import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.jsapi.WxJsApiUnifiedOrderPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;


@Data
public class WxJsApiUnifiedOrderPayRequest extends BaseWxPayRequest<WxJsApiUnifiedOrderPayResponse> {


    @XStreamAlias("device_info")
    private String device_info;

    @XStreamAlias("sign_type")
    private String signType;

    private String body;

    private String detail;

    private String attach;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    @XStreamAlias("time_start")
    private String timeStart;

    @XStreamAlias("time_expire")
    private String timeExpire;

    @XStreamAlias("goods_tag")
    private String goodsTag;

    @XStreamAlias("notify_url")
    private String notifyUrl;

    @XStreamAlias("trade_type")
    private String tradeType = PayModelEnum.JSAPI.getValue();

    @XStreamAlias("limit_pay")
    private String limitPay;

    private String receipt;

    //------ 比APP下单多的字段-------//
    private String openid;

    @XStreamAlias("scene_info")
    private String sceneInfo;


    @Data
    public static class SceneInfo {

        //需要转成带有下划线: store_info
        private StoreInfo storeInfo;

    }

    @Data
    public static class StoreInfo {

        private String id;

        private String name;

        //需要转成带有下划线: area_code
        private String areaCode;

        private String address;
    }



    @Override
    public Class<WxJsApiUnifiedOrderPayResponse> getResponseClass() {
        return WxJsApiUnifiedOrderPayResponse.class;
    }

    @Override
    public String getUrl() {
        return WxinPayConstants.APP_UNIFIEDORDER_URL;
    }

}
