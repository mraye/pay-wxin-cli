package com.github.vspro.pay.request;

import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;


@Data
public abstract class BaseWxPayRequest<T extends BaseWxPayResponse> implements Serializable {

    private String appid;

    @XStreamAlias("mch_id")
    private String mchId;

    @XStreamAlias("nonce_str")
    private String nonceStr;

    private String sign;


    public abstract Class<T> getResponseClass();

    public abstract String getUrl();

}
